package de.uka.ipd.sdq.pcm.dialogs.stoex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.errorhandling.IIssue;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.MyPCMStoExLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.MyPCMStoExParser;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExLexer;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.exceptions.ExpectedTypeMismatchIssue;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.NonProbabilisticExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeCheckVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class StochasticExpressionEditDialog extends
		AbstractGrammerBasedEditDialog {

	private TypeEnum expectedType;

	public StochasticExpressionEditDialog(Shell parent, TypeEnum expectedType) {
		super(parent);
		this.expectedType = expectedType;
	}

	public StochasticExpressionEditDialog(Shell parent, TypeEnum expectedType, Variable[] context) {
		super(parent,context);
		this.expectedType = expectedType;
	}

	/**
	 * @param parent The parent shell
	 * @param expectedType The type of the expression to be entered
	 * @param contextObject An EObject from which a parameter context is derived by
	 * 		searching for its parent SEFF and taking this SEFFs signature into account
	 */
	public StochasticExpressionEditDialog(Shell parent, TypeEnum expectedType, EObject contextObject) {
		super(parent);
		this.expectedType = expectedType;
		this.context = getContext(contextObject);
	}
	
	public void setInitialExpression(RandomVariable ex) {
		newText = ex.getSpecification();
	}

	@Override
	public Expression getResult() {
		return (Expression)super.getResult();
	}

	@Override
	public String getResultText() {
		return super.getResultText();
	}

	@Override
	protected String getInitialText() {
		return "";
	}

	@Override
	protected Lexer getLexer(String text) {
		return new MyPCMStoExLexer(new ANTLRStringStream(text));
	}

	@Override
	protected String getTitle() {
		return "Edit stochastic expression";
	}

	@Override
	protected EObject parse(Lexer lexer) throws RecognitionException, StoExParserException {
		MyPCMStoExParser parser = new MyPCMStoExParser(new CommonTokenStream(lexer));
		EObject result = parser.expression();
		ArrayList<IIssue> errorList = new ArrayList<IIssue>();
		errorList.addAll(((MyPCMStoExLexer)lexer).getErrors());
		errorList.addAll(parser.getErrors());
		
		if (errorList.size() == 0) {
			NonProbabilisticExpressionInferTypeVisitor typeVisitor = new NonProbabilisticExpressionInferTypeVisitor();
			typeVisitor.doSwitch(result);
			errorList.addAll(checkTypes(result,typeVisitor));
			errorList.addAll(assertType(result,typeVisitor,expectedType));
		}
		if (errorList.size() > 0)
			throw new StoExParserException(errorList);
		return result;
	}

	private Collection<? extends IIssue> assertType(EObject result,
			ExpressionInferTypeVisitor typeVisitor, TypeEnum expectedType) {
		if (!TypeCheckVisitor.typesCompatible(expectedType,typeVisitor.getType((Expression)result))){
			return Collections.singletonList(new ExpectedTypeMismatchIssue(
					expectedType,
					typeVisitor.getType((Expression)result)));
		}
		return Collections.emptyList();
	}

	private Collection<IIssue> checkTypes(EObject result,
			NonProbabilisticExpressionInferTypeVisitor typeVisitor) {
		TypeCheckVisitor typeChecker = new TypeCheckVisitor(typeVisitor);
		typeChecker.doSwitch(result);
		TreeIterator<EObject> iterator = result.eAllContents(); 
		for(;iterator.hasNext();){
			EObject treeNode = iterator.next(); 
			typeChecker.doSwitch(treeNode);
		}
		return typeChecker.getIssues();
	}

	@Override
	protected Class<PCMStoExLexer> getLexerClass() {
		return PCMStoExLexer.class;
	}

	@Override
	protected ITokenMapper getTokenMapper() {
		return new StoExTokenMapper();
	}
	
	public static TypeEnum getTypeFromVariableCharacterisation(VariableSetter ch){

		if(ch.getVariableCharacteristic__VariableSetter().getCharacterisationDefinition__VariableCharacteristic().equals(VariableCharacterisationType.BYTESIZE) || /* FIXME: use type ids from the characterisation repository */
				ch.getVariableCharacteristic__VariableSetter().getCharacterisationDefinition__VariableCharacteristic().equals(VariableCharacterisationType.NUMBER_OF_ELEMENTS)){

			return TypeEnum.INT;
		}
		return TypeEnum.ANY;
 	}
	
	private Variable[] getContext(EObject rv) {
		Variable[] parameters = new Variable[]{};

		ResourceDemandingSEFF seff = getSEFF(
				rv);

		if (seff != null && seff.getDescribedService__SEFF() != null && seff.getDescribedService__SEFF() instanceof OperationSignature && ((OperationSignature)seff.getDescribedService__SEFF()).getParameters__OperationSignature() != null) {
			parameters = (Variable[]) ((OperationSignature)seff.getDescribedService__SEFF()).getParameters__OperationSignature().toArray();
			ExternalCallAction eca = getParentCallAction(rv);
			if (eca != null && isOutputCharacterisation(eca,rv) && eca.getCalledService_ExternalService() != null &&
					eca.getCalledService_ExternalService().getReturntype__OperationSignature() != null) {
				Variable[] parametersWithReturn = new Variable[parameters.length+1];
				System.arraycopy(parameters,0,parametersWithReturn,0,parameters.length);
				parametersWithReturn[parameters.length] = ParameterFactory.eINSTANCE.createVariable();
				// FIXME after decision you to use return values
				//parametersWithReturn[parameters.length].setDataType__Variable(eca.getCalledService_ExternalService().getReturntype__OperationSignature());
				parametersWithReturn[parameters.length].setEntityName("RETURN");
				parameters = parametersWithReturn;
			}
		}
		return parameters;
	}

	private boolean isOutputCharacterisation(ExternalCallAction eca, EObject rv) {
		//FIXME: commented out
//		for (VariableSetter vu : eca.getSetVariableReturns__CallReturnAction()){
//			if (vu.getVariableCharacterisation__SetVariable().contains(rv))
//				return true;
//		}
		return false;
	}

	private ResourceDemandingSEFF getSEFF(EObject a) {
		EObject container = a;
		while (container != null && !(container instanceof ResourceDemandingSEFF))
			container = container.eContainer();
		if (container == null || !(container instanceof ResourceDemandingSEFF)) 
			return null;
		ResourceDemandingSEFF seff = (ResourceDemandingSEFF) container;
		return seff;
	}

	private ExternalCallAction getParentCallAction(EObject a) {
		EObject container = a;
		while (!(container instanceof ResourceDemandingSEFF) && !(container instanceof ExternalCallAction))
			container = container.eContainer();
		if (!(container instanceof ExternalCallAction)) 
			return null;
		ExternalCallAction call = (ExternalCallAction) container;
		return call;
	}
	
}
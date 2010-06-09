package de.uka.ipd.sdq.pcm.dialogs.parameters;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.dialogs.Messages;
import de.uka.ipd.sdq.pcm.dialogs.datatype.PalladioDataTypeDialog;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;

/**
 * The Class place the validate methods for CompositeDataType and
 * Parameters(Signature) editor area. The methods are used for validating of
 * InnerDeclaration of CompositeDataType and signature parameters. Validating
 * passes each Action (Delete, Up, Down) with call.
 * 
 * @author Roman Andrej
 */
public class UpDownButtonsValidator {

	private static UpDownButtonsValidator singelton = null;
	private CreateEditorContents contents;
	
	private UpDownButtonsValidator() {
	}
	
	public void validate(int elementIndex, int maxIndex) {
		Assert.isNotNull(contents); 
		
		contents.setDownItemsEnabled(true);
		contents.setUpItemsEnabled(true);
		
		if (elementIndex == 0)
			contents.setUpItemsEnabled(false);
		if (elementIndex == maxIndex - 1)
			contents.setDownItemsEnabled(false);
	}

	/** Validate selection from table viewer */
	public void validateSelection(Object selection) {
		if (selection == null) {
			contents.setDeleteItemsEnabled(false);
			contents.setDownItemsEnabled(false);
			contents.setUpItemsEnabled(false);
		} else if (selection instanceof Variable) {
			Variable parameter = (Variable) selection;
			UpDownButtonsValidator.getSingelton().validateParameter(parameter);
			contents.setDeleteItemsEnabled(true);
		} else if (selection instanceof Variable) {
			Variable declaration = (Variable) selection;
			UpDownButtonsValidator.getSingelton().validateInnerDeclaration(
					declaration);
			contents.setDeleteItemsEnabled(true);
		}
	}
	
	/**
	 * Validate (Enabled/Unenabled) up-, down-button in the ParameterDialog.
	 * Call if selection instanceof Parameter.
	 */
	public void validateParameter(Variable parameter) {
		OperationSignature signature = parameter.getOperationSignature__Variable();
		EList<Variable> parameters = signature.getParameters__OperationSignature();
		validate(parameters.indexOf(parameter), parameters.size());
	}
	
	/**
	 * Validate (Enabled/Unenabled) up-, down-button in the DataTypeDialog. Call
	 * if selection instanceof InnerDeclaration.
	 */
	public void validateInnerDeclaration(Variable declaration) {
		if (declaration.eContainer() instanceof CompositeDataType) {
			CompositeDataType dataType = (CompositeDataType) declaration
					.eContainer();
			EList<Variable> declarations = dataType
					.getMembers__CompositeDataType();
			validate(declarations.indexOf(declaration), declarations.size());
		}
	}
	
	public boolean validdateDeclarationInnerDataType(Variable declaration, PalladioDataTypeDialog dialog){
		if (declaration.getDataType__Variable() == null) {
			dialog.setErrorMessage(Messages.DataTypeDialog_ErrorMsgInnerName);
			return false;
		}
		if (declaration.getEntityName().equals("")) {
			dialog.setErrorMessage(Messages.DataTypeDialog_ErrorMsgInnerName);
			return false;
		}
		return true;
	}
	
	public static UpDownButtonsValidator getSingelton() {
		if (singelton == null)
			singelton = new UpDownButtonsValidator();
		return singelton;
	}

	public void setContents(CreateEditorContents contents) {
		this.contents = contents;
	}
}
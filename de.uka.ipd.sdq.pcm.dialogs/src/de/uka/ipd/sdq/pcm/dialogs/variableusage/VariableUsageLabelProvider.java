/**
 * 
 */
package de.uka.ipd.sdq.pcm.dialogs.variableusage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.dialogs.datatype.DataTypeContainer;
import de.uka.ipd.sdq.pcm.dialogs.datatype.InnerDeclarationContainer;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;

/**
 * @author admin
 *
 */
public class VariableUsageLabelProvider extends ItemProviderDecorator implements
 IItemLabelProvider {

	public VariableUsageLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getImage(Object object) {
		
		if (object instanceof DataTypeContainer) {
			DataTypeContainer treeType = (DataTypeContainer) object;
			return super.getImage(treeType.getObject());
		}
		
		if (object instanceof InnerDeclarationContainer) {
			InnerDeclarationContainer treeDeclaration = (InnerDeclarationContainer) object;
			return super.getImage(treeDeclaration.getObject());
		}

		return super.getImage(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object object) {
		
		if (object instanceof Variable) {
			Variable p = (Variable) object;
			String result = p.getEntityName();
			if (p.getDataType__Variable() != null) {
				result += ": " + super.getText(p.getDataType__Variable());
			}
			return result;
		}
		
		if (object instanceof DataTypeContainer) {
			DataType dataType = getTreeTypeObject(object);
			return "INNER: " + getNameDataType(dataType);
		}
		
		if (object instanceof InnerDeclarationContainer) {
			Variable declaration = getTreeDeclarationObject(object);
			DataType dataType = declaration.getDataType__Variable();
			
			String typeName = "";

			if (dataType instanceof CollectionDataType) {
				CollectionDataType collType = (CollectionDataType) dataType;
				typeName = collType.getEntityName();
			}
			if (dataType instanceof CompositeDataType) {
				CompositeDataType compType = (CompositeDataType) dataType;
				typeName = compType.getEntityName();
			}
			if (dataType instanceof PrimitiveDataType) {
				PrimitiveDataType primType = (PrimitiveDataType) dataType;
				typeName = primType.getEntityName();
			}
			
			return declaration.getEntityName() + ": " + typeName;
		}
		return super.getText(object);
	}

	/**
	 * @return - return the DdataType from TreeType-Object
	 */
	private DataType getTreeTypeObject(Object object){
		DataTypeContainer treeType = (DataTypeContainer)object;
		return (DataType) treeType.getObject();
	}
	
	/**
	 * @return - return the InnerDeclaration from TreeDeclaration-Object
	 */
	private Variable getTreeDeclarationObject(Object object) {
		InnerDeclarationContainer treeDeclaration = (InnerDeclarationContainer) object;
		return (Variable) treeDeclaration.getObject();
	}
	
	private String getNameDataType(DataType dataType) {
		if (dataType != null)
			return super.getText(dataType);
		return "null";
	}
}

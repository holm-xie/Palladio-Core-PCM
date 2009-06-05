package de.uka.ipd.sdq.dialogs.datatype;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;

/** @author roman */
public class DataTypeCommand {
	
	/** The transactional editing domain which is used to get the commands */
	TransactionalEditingDomain editingDomain;
	
	public DataTypeCommand(TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCollectionDataType()
	 */
	public void createCollectionDataType(final Repository repository,
			final DataType dataType, final DataType innerDataType,
			final String entityName) {

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				CollectionDataType collectionDataType;

				if (dataType != null) {
					// Edite existet DataType
					collectionDataType = (CollectionDataType) dataType;
					String typeName = collectionDataType.getEntityName();
					DataType innerType = collectionDataType
							.getInnerType_CollectionDataType();

					if ((entityName != null) && (!typeName.equals(entityName)))
						collectionDataType.setEntityName(entityName);

					if ((innerDataType != null)
							&& (!innerType.equals(innerDataType)))
						collectionDataType
								.setInnerType_CollectionDataType(innerDataType);
				} else {
					// Create new DataType
					collectionDataType = RepositoryFactory.eINSTANCE
							.createCollectionDataType();
					collectionDataType.setRepository_DataType(repository);

					Assert.isNotNull(collectionDataType);
					Assert.isNotNull(innerDataType);
					Assert.isNotNull(entityName);

					collectionDataType.setEntityName(entityName);
					collectionDataType
							.setInnerType_CollectionDataType(innerDataType);
				}
			}
		};
		recCommand.setDescription("Add new/Edite CollectionDataType");
		editingDomain.getCommandStack().execute(recCommand);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.dialogs.CreateDataTypeDialog#createCompositeDataType()
	 */
	public void createCompositeDataType(final Repository repository,
			final CompositeDataType compositeDataType, final String entityName) {

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				Assert.isNotNull(compositeDataType);

				if ((entityName != null)
						&& (!compositeDataType.getEntityName().equals(
								entityName)))
					compositeDataType.setEntityName(entityName);

				if (repository != null)
					compositeDataType.setRepository_DataType(repository);
			}
		};

		recCommand.setDescription("Add new CompositeDataType");
		editingDomain.getCommandStack().execute(recCommand);
	}
}

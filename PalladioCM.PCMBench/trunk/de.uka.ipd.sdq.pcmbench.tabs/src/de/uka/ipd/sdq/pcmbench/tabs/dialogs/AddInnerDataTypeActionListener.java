package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;

/**
 * @author roman
 * 
 */
public class AddInnerDataTypeActionListener extends SelectionAdapter {

	/**
	 * TODO
	 */
	CompositeDataType compositeDataType;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */

	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {

				if (compositeDataType == null)
					compositeDataType = RepositoryFactory.eINSTANCE
							.createCompositeDataType();
				InnerDeclaration declaration = RepositoryFactory.eINSTANCE
						.createInnerDeclaration();
				// delete leter
				declaration
						.setEntityName("DeclarationName"
								+ (compositeDataType
										.getInnerDeclaration_CompositeDataType()
										.size() + 1));

				compositeDataType.getInnerDeclaration_CompositeDataType().add(
						declaration);
			}
		};

		recCommand.setDescription("Add new CompositeDataTYpe");
		editingDomain.getCommandStack().execute(recCommand);

		// Set input for TableViewer
		OperationsTabResources.getParametersViewer()
				.setInput(compositeDataType);
		
		OperationsTabResources.setNewCompositeDataType(compositeDataType);
	}
}

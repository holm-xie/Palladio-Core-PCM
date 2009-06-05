package de.uka.ipd.sdq.pcm.dialogs.parameters;

import java.util.ArrayList;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import de.uka.ipd.sdq.pcm.dialogs.datatype.CallDataTypeDialog;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;

/**
 * The class defines a CellEditor, for which the call of DataTypeDialog makes
 * possible.
 * 
 * @author Roman Andrej
 */
public class TypeDialogCellEditor extends DialogCellEditor {

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */

	private TransactionalEditingDomain editingDomain = null;

	/*
	 * @See org.eclipse.jface.viewers.DialogCellEditor#DialogCellEditor(org.eclipse.swt.widgets.Control
	 *      parent)
	 */
	public TypeDialogCellEditor(Composite parent, TransactionalEditingDomain editingDomain) {
		super(parent);
		this.editingDomain = editingDomain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
	 */
	@Override
	protected Object openDialogBox(Control cellEditorWindow) {

		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(Repository.class);
		filterList.add(DataType.class);
		ArrayList<Object> additionalReferences = new ArrayList<Object>();

		CallDataTypeDialog dialog = new CallDataTypeDialog(cellEditorWindow
				.getShell(), filterList, additionalReferences, editingDomain
				.getResourceSet());
		dialog.setProvidedService(DataType.class);
		dialog.open();

		if (!(dialog.getResult() instanceof DataType))
			return null;

		return dialog.getResult();
	}
}

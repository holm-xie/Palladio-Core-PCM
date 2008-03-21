package de.uka.ipd.sdq.pcmbench.tabs.operations;


import java.util.ArrayList;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import de.uka.ipd.sdq.pcm.dialogs.datatype.CallDataTypeDialog;
import de.uka.ipd.sdq.pcm.dialogs.parameters.ParametersDialog;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection;

public class OperationsEditorSection extends EditorSection{

	public static final int ICON_COLUMN_INDEX = 0;
	public static final int RETURNTYPE_COLUMN_INDEX = 1;
	public static final int SIGNATURENAME_COLUMN_INDEX = 2;
	public static final int PARAMETER_COLUMN_INDEX = 3;
	public static final int EXCEPTIONS_COLUMN_INDEX = 4;
	
	/**
	 * Columns of a table, which is used into operations table
	 */
	public final static String OPERATIONS_ICON_COLUMN	= "";
	public final static String OWNEDPARAMETER_COLUMN 	= "OwnedParameters";
	public final static String RETURNTYPE_COLUMN 		= "ReturnType";
	public final static String SERVICENAME_COLUMN 		= "ServiceName";
	public final static String EXEPTIONTYPE_COLUM		= "ExeptionType";
	
	//	 Set column names of Tabele
	public static String[] columnNames = new String[] { OPERATIONS_ICON_COLUMN,RETURNTYPE_COLUMN,
			SERVICENAME_COLUMN, OWNEDPARAMETER_COLUMN, EXEPTIONTYPE_COLUM };
	
	/** Define the Add-Button listener. Listener must by later initialized. */
	private AddActionListener addButtonListener;

	/** Constructor */
	public OperationsEditorSection(Composite composite) {
		super(composite);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createViewerCellEditors(org.eclipse.swt.widgets.Table)
	 */
	@Override
	protected CellEditor[] createViewerCellEditors(Table table) {
		CellEditor[] editors = new CellEditor[columnNames.length];

		editors[SIGNATURENAME_COLUMN_INDEX] = new TextCellEditor(table);

		// create 'DeleteCellValueListener' and as SelectionListener to the 'TableVewer'
		DeleteCellValueListener cellValueListener = new DeleteCellValueListener(viewer);
		viewer.addSelectionChangedListener(cellValueListener);

		editors[RETURNTYPE_COLUMN_INDEX] = new TypeDialogCellEditor(table,
				cellValueListener) {
			
			/* (non-Javadoc)
			 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
			 */
			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				TransactionalEditingDomain editingDomain = TransactionUtil
						.getEditingDomain(getSelectedSignature());

				ArrayList<Object> filterList = new ArrayList<Object>();
				filterList.add(DataType.class);
				filterList.add(Repository.class);
				ArrayList<Object> additionalReferences = new ArrayList<Object>();

				CallDataTypeDialog dialog = new CallDataTypeDialog(
						cellEditorWindow.getShell(), filterList,
						additionalReferences, editingDomain.getResourceSet());
				dialog.setProvidedService(DataType.class);
				dialog.open();

				if (!(dialog.getResult() instanceof DataType))
					return null;

				return dialog.getResult();
			}
		};

		editors[PARAMETER_COLUMN_INDEX] = new DialogCellEditor(table) {
			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				ParametersDialog dialog = new ParametersDialog(cellEditorWindow
						.getShell(), getSelectedSignature());
				if (dialog.open() == Dialog.OK)
					viewer.refresh();
				return null;
			}
		};

		return editors;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createViewerCellModifier()
	 */
	@Override
	protected ICellModifier createViewerCellModifier() {
		OperationsCellModifier cellModifier = new OperationsCellModifier();
		// Add EditorSection as Observer to cellModifier
		cellModifier.addObserver(this);
		return cellModifier;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createTableColumns(org.eclipse.swt.widgets.Table)
	 */
	@Override
	protected void createTableColumns(Table table) {
		// 1st column
		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("");
		column.setWidth(25);

		for (int i = 1; i < columnNames.length; i++) {
			// n-te column with task Description
			column = new TableColumn(table, SWT.LEFT, i);
			column.setText((String) columnNames[i]);
			column.setWidth(140);
		}
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createAddButtonActionListener()
	 */
	@Override
	protected SelectionListener createAddButtonActionListener() {
		// the value must by initialized! (don't return new AddActionListener()) 
		this.addButtonListener = new AddActionListener();
		
		return addButtonListener;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#createDeleteButtonListener()
	 */
	@Override
	protected SelectionListener createDeleteButtonListener() {
		return new DeleteActionListener();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcmbench.tabs.generic.EditorSection#getViewerColumnProperties()
	 */
	@Override
	protected String[] getTableColumnNames() {
		return columnNames;
	}

	public Signature getSelectedSignature() {
		return (Signature) getSelectedObject();
	}

	/**
	 * @return the addButtonListener
	 */
	public AddActionListener getAddButtonListener() {
		return addButtonListener;
	}
}

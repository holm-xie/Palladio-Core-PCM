/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.dialogs;


import org.eclipse.jface.viewers.ICellModifier;

import de.uka.ipd.sdq.codegen.simudatavisualization.birt.RunEntry;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

/**
 * @author admin
 *
 */
public class SensorsDialogCellModifier implements ICellModifier {
	
	private RunEntry entry;
	private Sensor selectedSensor;
	
	public SensorsDialogCellModifier(RunEntry entry) {
		this.entry = entry;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean canModify(Object element, String property) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
	 */
	@Override
	public Object getValue(Object element, String property) {
	     selectedSensor = (Sensor) element;
	     return new Boolean(entry.isSensorChecked(selectedSensor));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
	 */
	@Override
	public void modify(Object element, String property, Object value) {
		boolean checked = (((Boolean) value).booleanValue());
	     
	     if (checked)
	    	 entry.setSensorChecked(selectedSensor);
	     if (!checked)
	    	 entry.setSensorUnchecked(selectedSensor);
	}

}

/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.tabs;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.codegen.simudatavisualization.birt.ReportCongiguration;

/**
 * @author admin
 *
 */
public class SensorsTabContentProvider implements IStructuredContentProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		if (inputElement instanceof ReportCongiguration) {
			ReportCongiguration configuration = (ReportCongiguration) inputElement;
			return configuration.getRunEntrys().toArray();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * TODO Delete --> Geht nicht!!!
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput != null)
            ((ReportCongiguration) newInput).addChangeListener(this);
        if (oldInput != null)
            ((ReportCongiguration) oldInput).removeChangeListener(this);


	}

}

package de.uka.ipd.sdq.codegen.runconfig.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import de.uka.ipd.sdq.codegen.runconfig.RunConfigImages;

/**
 * The class defines a tab, where the specific characteristics for the
 * simulation can be set.
 * 
 * @author Roman Andrej
 */
public class FeatureOptionsTab extends AbstractLaunchConfigurationTab {

	private Button simulateLinkingResourcesButton;
	private Combo lookupOptions;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		
		final ModifyListener modifyListener = new ModifyListener(){

			public void modifyText(ModifyEvent e) {
				FeatureOptionsTab.this.setDirty(true);
				FeatureOptionsTab.this.updateLaunchConfigurationDialog();
			}
		};
		final SelectionListener selectionListener = new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
				FeatureOptionsTab.this.setDirty(true);
				FeatureOptionsTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				FeatureOptionsTab.this.setDirty(true);
				FeatureOptionsTab.this.updateLaunchConfigurationDialog();
			}
		};		
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		final Group networkingGroup = new Group(container, SWT.NONE);
		networkingGroup.setText("Networking");
		final GridData gd_networkingGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		networkingGroup.setLayoutData(gd_networkingGroup);
		networkingGroup.setLayout(new GridLayout());

		simulateLinkingResourcesButton = new Button(networkingGroup, SWT.CHECK);
		final GridData gd_simulateLinkingResourcesButton = new GridData(SWT.FILL, SWT.CENTER, true, false);
		simulateLinkingResourcesButton.setLayoutData(gd_simulateLinkingResourcesButton);
		simulateLinkingResourcesButton.setText("Simulate Linking Resources");
		simulateLinkingResourcesButton.addSelectionListener(selectionListener);

		final Group communicationsGroup = new Group(container, SWT.NONE);
		communicationsGroup.setText("Communication Options");
		final GridData gd_communicationsGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		communicationsGroup.setLayoutData(gd_communicationsGroup);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		communicationsGroup.setLayout(gridLayout);

		final Label serverLookupLabel = new Label(communicationsGroup, SWT.NONE);
		serverLookupLabel.setText("Component Lookup:");

		lookupOptions = new Combo(communicationsGroup, SWT.NONE);
		final GridData gd_lookupOptions = new GridData(SWT.FILL, SWT.CENTER, true, false);
		lookupOptions.setLayoutData(gd_lookupOptions);
		lookupOptions.addModifyListener(modifyListener);
		for (ComponentLookupEnum value : ComponentLookupEnum.values())
			lookupOptions.add(value.name());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Feature Settings";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return RunConfigImages.getFeaturTabImage();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			simulateLinkingResourcesButton.setSelection(configuration.getAttribute(
					ConstantsContainer.SIMULATE_LINKING_RESOURCES, true));
		} catch (CoreException e) {
			simulateLinkingResourcesButton.setSelection(true);
		}
		try {
			int index = configuration.getAttribute(
					ConstantsContainer.COMPONENT_LOOKUP,0);
			index = index < 0 ? 0 : index;
			lookupOptions.select(index);
		} catch (CoreException e) {
			lookupOptions.setText(ComponentLookupEnum.values()[0].name());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.SIMULATE_LINKING_RESOURCES,
				this.simulateLinkingResourcesButton.getSelection());
		configuration.setAttribute(ConstantsContainer.COMPONENT_LOOKUP,
				lookupOptions.getSelectionIndex());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.SIMULATE_LINKING_RESOURCES,
				true);
		configuration.setAttribute(ConstantsContainer.COMPONENT_LOOKUP,
				ComponentLookupEnum.DEPENDENCY_INJECTION.ordinal());
	}
	
	
}

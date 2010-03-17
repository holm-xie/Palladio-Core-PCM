/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.ConfigurationTab;

/**
 * The class extends ConfigurationTab by CheckBox. User can decide whether that
 * generated instance of Palladio Component Model after simulating must be
 * deleted.
 * 
 * @see de.uka.ipd.sdq.workflow.launchconfig.tabs.ConfigurationTab
 * 
 * @author Roman Andrej
 */
public class SimuConfigurationTab extends ConfigurationTab {
	
	private Button clearButton;
	private Text variableText;
	private Text minimumText;
	private Text maximumText;
	private Text stepWidthText;
	private ArrayList<String> modelFiles = new ArrayList<String>();
	private Button fixedSeedButton;
	private Text[] seedText;
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.tabs.ConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				SimuConfigurationTab.this.setDirty(true);
				SimuConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		
		Composite container = (Composite) getControl();

		/** Clear group*/
		final Group clearGroup = new Group(container, SWT.NONE);
		clearGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		clearGroup.setText("Generated code");
		clearGroup.setLayout(new GridLayout());
		clearButton = new Button(clearGroup,
				SWT.CHECK);
		clearButton.setLayoutData( new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));
		clearButton.setText("Delete generated code at simulation end");
		clearButton.setSelection(true);
		clearButton.addSelectionListener(new SelectionAdapter() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				SimuConfigurationTab.this.setDirty(true);
				SimuConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		});
		
		final Group sensitivityAnalysisParametersGroup = new Group(container, SWT.NONE);
		sensitivityAnalysisParametersGroup.setText("Sensitivity Analysis Parameters");
		final GridData gd_sensitivityAnalysisParametersGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		sensitivityAnalysisParametersGroup.setLayoutData(gd_sensitivityAnalysisParametersGroup);
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 3;
		sensitivityAnalysisParametersGroup.setLayout(gridLayout_1);

		final Label variableToAdaptLabel = new Label(sensitivityAnalysisParametersGroup, SWT.NONE);
		final GridData gd_variableToAdaptLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		variableToAdaptLabel.setLayoutData(gd_variableToAdaptLabel);
		variableToAdaptLabel.setText("Variable:");

		variableText = new Text(sensitivityAnalysisParametersGroup, SWT.BORDER);
		variableText.setEnabled(true);
		variableText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		variableText.addModifyListener(modifyListener);
		
		final Button selectVariableButton = new Button(sensitivityAnalysisParametersGroup, SWT.NONE);
		selectVariableButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				selectVariable();
			}
		});
		selectVariableButton.setText("Select Variable...");

		final Group composite = new Group(container, SWT.NONE);
		composite.setText("Sensitivity Analysis");
		final GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
		composite.setLayoutData(gd_composite);
		final GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.numColumns = 6;
		composite.setLayout(gridLayout_2);

		final Label minimumLabel = new Label(composite, SWT.NONE);
		minimumLabel.setText("Minimum:");

		minimumText = new Text(composite, SWT.BORDER);
		minimumText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		minimumText.addModifyListener(modifyListener);
		
		final Label maximumLabel = new Label(composite, SWT.NONE);
		maximumLabel.setText("Maximum:");

		maximumText = new Text(composite, SWT.BORDER);
		maximumText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		maximumText.addModifyListener(modifyListener);
		
		final Label stepWidthLabel = new Label(composite, SWT.NONE);
		stepWidthLabel.setText("Step Width:");

		stepWidthText = new Text(composite, SWT.BORDER);
		stepWidthText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		stepWidthText.addModifyListener(modifyListener);

		final Group randomNumberGeneratorParametersGroup = new Group(container, SWT.NONE);
		randomNumberGeneratorParametersGroup.setText("Random Number Generator Seed");
		final GridData gd_randomNumberGeneratorParametersGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		randomNumberGeneratorParametersGroup.setLayoutData(gd_randomNumberGeneratorParametersGroup);
		final GridLayout gridLayout_3 = new GridLayout();
		gridLayout_3.numColumns = 12;
		randomNumberGeneratorParametersGroup.setLayout(gridLayout_3);
		
		fixedSeedButton = new Button(randomNumberGeneratorParametersGroup,
				SWT.CHECK);
		fixedSeedButton.setLayoutData( new GridData(SWT.LEFT, SWT.CENTER, false, false, 12, 1));
		fixedSeedButton.setText("Use a fixed seed in simulation run");
		fixedSeedButton.setSelection(false);
		fixedSeedButton.addSelectionListener(new SelectionAdapter() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				SimuConfigurationTab.this.setDirty(true);
				SimuConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		});

		seedText = new Text[6]; Label[] seedLabel = new Label[6];
		for (int i = 0; i < 6; i++) {
			seedLabel[i] = new Label(randomNumberGeneratorParametersGroup,SWT.NONE);
			seedLabel[i].setText("Seed "+i);
			seedText[i] = new Text(randomNumberGeneratorParametersGroup,SWT.BORDER);
			seedText[i].setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			seedText[i].addModifyListener(modifyListener);
			seedText[i].setText(i+"");
		}
	}

	
	protected void selectVariable() {
		ResourceSet rs = new ResourceSetImpl();
		ArrayList<Object> filter = new ArrayList<Object>();
		filter.add(EObject.class);
		for (String file : modelFiles) {
			try {
				rs.getResource(URI.createURI(file), true);
			} catch (Exception ex) {
				rs.getResource(URI.createFileURI(file), true);
			}
		}
		EcoreUtil.resolveAll(rs);
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog
			(this.getShell(),
			 filter,
			 rs);
		if (dialog.open() == org.eclipse.jface.dialogs.Dialog.OK) {
			variableText.setText(EcoreUtil.getURI(dialog.getResult()).toString());
		}
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.tabs.ConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);

		try {
			clearButton.setSelection(configuration.getAttribute(
					ConstantsContainer.DELETE_PLUGIN, true));
		} catch (CoreException e) {
			clearButton.setSelection(true);
		}
		
		try {
			fixedSeedButton.setSelection(configuration.getAttribute(
					SimuComConfig.USE_FIXED_SEED, false));
		} catch (CoreException e) {
			fixedSeedButton.setSelection(false);
		}

		for (int i=0; i<6; i++) {
			try {
				seedText[i].setText(configuration.getAttribute(
						SimuComConfig.FIXED_SEED_PREFIX+i, i+""));
			} catch (CoreException e) {
				seedText[i].setText(i+"");
			}
		}
		
		try {
			variableText.setText(configuration.getAttribute(
					ConstantsContainer.VARIABLE_TEXT, ""));
		} catch (CoreException e) {
			variableText.setText("");
		}

		try {
			minimumText.setText(configuration.getAttribute(
					ConstantsContainer.MINIMUM_TEXT, ""));
		} catch (CoreException e) {
			minimumText.setText("");
		}
		
		try {
			maximumText.setText(configuration.getAttribute(
					ConstantsContainer.MAXIMUM_TEXT, ""));
		} catch (CoreException e) {
			maximumText.setText("");
		}
		
		try {
			stepWidthText.setText(configuration.getAttribute(
					ConstantsContainer.STEP_WIDTH_TEXT, ""));
		} catch (CoreException e) {
			stepWidthText.setText("");
		}
		
		try {
			modelFiles.clear();
			modelFiles.add(configuration.getAttribute(
					ConstantsContainer.REPOSITORY_FILE, ""));
			modelFiles.add(configuration.getAttribute(
					ConstantsContainer.SYSTEM_FILE, ""));
			modelFiles.add(configuration.getAttribute(
					ConstantsContainer.ALLOCATION_FILE, ""));
			modelFiles.add(configuration.getAttribute(
					ConstantsContainer.USAGE_FILE, ""));
		} catch (CoreException e) {
			stepWidthText.setText("");
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.tabs.ConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);

		configuration.setAttribute(ConstantsContainer.DELETE_PLUGIN,
				clearButton.getSelection());		
		configuration.setAttribute(SimuComConfig.USE_FIXED_SEED,
				fixedSeedButton.getSelection());
		for (int i=0; i<6; i++){
			configuration.setAttribute(SimuComConfig.FIXED_SEED_PREFIX+i, 
					seedText[i].getText());
		}
		configuration.setAttribute(ConstantsContainer.VARIABLE_TEXT,
				variableText.getText());
		configuration.setAttribute(ConstantsContainer.MINIMUM_TEXT,
				minimumText.getText());
		configuration.setAttribute(ConstantsContainer.MAXIMUM_TEXT,
				maximumText.getText());
		configuration.setAttribute(ConstantsContainer.STEP_WIDTH_TEXT,
				stepWidthText.getText());
		
	}
}
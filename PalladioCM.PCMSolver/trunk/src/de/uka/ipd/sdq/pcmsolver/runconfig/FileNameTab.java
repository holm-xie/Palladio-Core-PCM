package de.uka.ipd.sdq.pcmsolver.runconfig;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FileNameTab extends AbstractLaunchConfigurationTab {

	private Text textInputFolder;
	private Text textInputPrefix;
	private Text textAllocation;
	private Text textRepository;
	private Text textResourceEnvironment;
	private Text textResourceType;
	private Text textSystem;
	private Text textUsage;
	private Text textOutput;
	
	private final String BUTTON_FILES = "Files...";
	private final String BUTTON_FOLDER = "Folder...";
	
	private boolean isSelectAll = false;
	
	private FileNameTabListener listener = new FileNameTabListener();
	
	private class FileNameTabListener extends SelectionAdapter implements ModifyListener {
		@Override
		public void modifyText(ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}
	}
	
	
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
		final GridLayout glGroup = new GridLayout();
		glGroup.numColumns = 3;
		
		final Group inputFilesGroup = new Group(container, SWT.NONE);
		inputFilesGroup.setLayout(glGroup);
		inputFilesGroup.setText("Input");
		inputFilesGroup.setLayoutData(new GridData(500, SWT.DEFAULT));
		createSelectInputFolder(inputFilesGroup);
		createSelectIndividualFiles(container, inputFilesGroup);
		
		final Group outputFilesGroup = new Group(container, SWT.NONE);
		outputFilesGroup.setLayout(glGroup);
		outputFilesGroup.setText("Output");
		outputFilesGroup.setLayoutData(new GridData(500, SWT.DEFAULT));
		createSelectOutputFolder(outputFilesGroup);
		
	}

	private void createSelectOutputFolder(final Group outputFilesGroup) {
		Label outputFolderLabel = new Label(outputFilesGroup, SWT.NONE);
		outputFolderLabel.setText("Output Folder:");
		outputFolderLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		textOutput = new Text(outputFilesGroup, SWT.SINGLE | SWT.BORDER);
		textOutput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textOutput.addModifyListener(listener);
		
		final Button buttonBrowseOutput = new Button(outputFilesGroup,	SWT.NONE);
		buttonBrowseOutput.setText(BUTTON_FOLDER);
		buttonBrowseOutput.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				textOutput.setText(openDirectoryDialog(e));
			}
		});
	}

	private void createSelectIndividualFiles(Composite container,
			final Group inputFilesGroup) {
		final Button selectSingle = new Button(inputFilesGroup, SWT.RADIO);
		selectSingle.setText("Select individual files");
		selectSingle.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				Control[] children = inputFilesGroup.getChildren();
				for (int i=0; i<children.length; i++) {
					Control child = children [i];
					if (i>0 && i<6)	child.setEnabled(false);
					else child.setEnabled(true);
				}
				isSelectAll = false;
			}
		});
		selectSingle.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		
		textAllocation = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textAllocation, "Allocation:", "allocation");
		textRepository = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textRepository, "Repository:", "repository");
		textResourceEnvironment = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textResourceEnvironment, "Resource Environment:", "resourcenvironment");
		textResourceType = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textResourceType, "Resource Type:", "resourcetype");
		textSystem = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textSystem, "System:", "system");
		textUsage = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textUsage, "Usage Model:", "usage");
	}

	private void createSelectInputFolder(final Group inputFilesGroup) {
		final Button selectAll = new Button(inputFilesGroup, SWT.RADIO);
		selectAll.setText("Select a folder");
		selectAll.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				Control[] children = inputFilesGroup.getChildren();
				for (int i=0; i<children.length; i++) {
					Control child = children [i];
					if (i>6) child.setEnabled(false);
					else child.setEnabled(true);
				}
				isSelectAll = true;
			}
		});
		selectAll.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		
		Label folderLabel = new Label(inputFilesGroup, SWT.NONE);
		folderLabel.setText("Input Folder:");
		folderLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		textInputFolder = new Text(inputFilesGroup, SWT.SINGLE | SWT.BORDER);
		textInputFolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textInputFolder.addModifyListener(listener);
		
		final Button buttonBrowse = new Button(inputFilesGroup,	SWT.NONE);
		buttonBrowse.setText(BUTTON_FOLDER);
		buttonBrowse.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				textInputFolder.setText(openDirectoryDialog(e));
			}
		});
		
		Label fileNamePrefix = new Label(inputFilesGroup, SWT.NONE);
		fileNamePrefix.setText("Filename Prefix:");
		fileNamePrefix.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		textInputPrefix = new Text(inputFilesGroup, SWT.SINGLE | SWT.BORDER);
		textInputPrefix.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textInputPrefix.addModifyListener(listener);
	}

	private void createFolderSelector(final Group inputFilesGroup, final Text text, String label, final String extension) {
		Label singleLabel = new Label(inputFilesGroup, SWT.NONE);
		singleLabel.setText(label);
		singleLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		text.setParent(inputFilesGroup);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.addModifyListener(listener);
		
		final Button button = new Button(inputFilesGroup,	SWT.NONE);
		button.setText(BUTTON_FILES);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				text.setText(openFileDialog(e, new String[]{"*."+extension}));
			}
		});
	}


	@Override
	public String getName() {
		return "File Names";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try{
			textAllocation.setText(configuration.getAttribute("inputAllocation", "n/a"));
		} catch(CoreException e){
			textAllocation.setText("n/a");
		}
		try{
			textRepository.setText(configuration.getAttribute("inputRepository", "n/a"));
		} catch(CoreException e){
			textRepository.setText("n/a");
		}
		try{
			textResourceEnvironment.setText(configuration.getAttribute("inputResourceEnvironment", "n/a"));
		} catch(CoreException e){
			textResourceEnvironment.setText("n/a");
		}
		try{
			textResourceType.setText(configuration.getAttribute("inputResourceType", "n/a"));
		} catch(CoreException e){
			textResourceType.setText("n/a");
		}
		try{
			textSystem.setText(configuration.getAttribute("inputSystem", "n/a"));
		} catch(CoreException e){
			textSystem.setText("n/a");
		}
		try{
			textUsage.setText(configuration.getAttribute("inputUsage", "n/a"));
		} catch(CoreException e){
			textUsage.setText("n/a");
		}

		try{
			textOutput.setText(configuration.getAttribute("outputPath", "n/a"));
		} catch(CoreException e){
			textOutput.setText("n/a");
		}
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		if (isSelectAll){
			String prefix = textInputFolder.getText() + "\\" + textInputPrefix.getText()+"."; 
			configuration.setAttribute("inputAllocation", prefix+"allocation");
			configuration.setAttribute("inputRepository", prefix+"repository");
			configuration.setAttribute("inputResourceEnvironment", prefix+"resourceenvironment");
			configuration.setAttribute("inputResourceType", prefix+"resourcetype");
			configuration.setAttribute("inputSystem", prefix+"system");
			configuration.setAttribute("inputUsage", prefix+"usagemodel");
		} else {
			configuration.setAttribute("inputAllocation", textAllocation.getText());
			configuration.setAttribute("inputRepository", textRepository.getText());
			configuration.setAttribute("inputResourceEnvironment", textResourceEnvironment.getText());
			configuration.setAttribute("inputResourceType", textResourceType.getText());
			configuration.setAttribute("inputSystem", textSystem.getText());
			configuration.setAttribute("inputUsage", textUsage.getText());
		}
		configuration.setAttribute("outputPath", textOutput.getText());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		isSelectAll = true;
	}
	
	
	/**
	 * The function calls the FileDialog and give back absolute path on the file as String
	 * 
	 * @param shell which will be the parent of the new instance
	 * @param extensions which the dialog will use to filter the files it shows to the argument
	 * @return absolute path to a file
	 */
	private String openFileDialog(SelectionEvent e, String[] extensions) {

		Shell shell = e.display.getActiveShell();
		String filename = "";

		FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		dialog.setFilterExtensions(extensions);
		dialog.setText("Select file");

		if (dialog.open() != null) {
			String root = dialog.getFilterPath() + File.separatorChar;
			filename = root + dialog.getFileName();
		}
		return filename;
	}
	
	private String openDirectoryDialog(SelectionEvent e){
		String dirname ="";
		Shell shell = e.display.getActiveShell();
		DirectoryDialog dialog = new DirectoryDialog(shell, SWT.OPEN);
		dialog.setText("Select folder");
		if (dialog.open() != null){
			dirname = dialog.getFilterPath();
		}
		return dirname;
	}

	
	public boolean isValid(ILaunchConfiguration launchConfig) {
	    setErrorMessage(null);
	    if (textOutput.getText().equals("")){
	    	setErrorMessage("Output path is missing!");
	    	return false;
	    }
	    // TODO
	    return true;
	}
	
}

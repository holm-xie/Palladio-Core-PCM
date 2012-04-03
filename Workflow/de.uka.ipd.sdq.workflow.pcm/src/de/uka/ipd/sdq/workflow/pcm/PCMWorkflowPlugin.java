package de.uka.ipd.sdq.workflow.pcm;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class PCMWorkflowPlugin extends AbstractUIPlugin {
	
	// The plug-in ID
		public static final String PLUGIN_ID = "de.uka.ipd.sdq.workflow.pcm";

		// The shared instance
		private static PCMWorkflowPlugin plugin;
	
	/**
	 * The constructor
	 */
	public PCMWorkflowPlugin() {
		plugin = this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 */
	public static PCMWorkflowPlugin getDefault() {
		return plugin;
	}

}
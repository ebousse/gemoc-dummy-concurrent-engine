package org.eclipse.gemoc.execution.concurrent.dummyengine;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID = "dummyengine"; //$NON-NLS-1$
	
	public static void error(String msg, CoreException e) {
		Activator.getDefault().getLog().log(new Status(Status.ERROR, PLUGIN_ID,
                Status.OK, 
                msg, 
                e));
	}

	public static Activator getDefault() {
		return plugin;
	}

	
	// The shared instance
	private static Activator plugin;
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		// start the messagin system ui plugin to load default settings.
		org.eclipse.gemoc.commons.eclipse.messagingsystem.ui.Activator.getDefault();
	}
	
	
}

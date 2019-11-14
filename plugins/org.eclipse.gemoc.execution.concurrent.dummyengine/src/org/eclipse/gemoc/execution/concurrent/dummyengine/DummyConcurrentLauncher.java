package org.eclipse.gemoc.execution.concurrent.dummyengine;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.launcher.AbstractConcurrentLauncher;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.executionframework.engine.commons.EngineContextException;
import org.eclipse.gemoc.xdsmlframework.api.core.ExecutionMode;

public class DummyConcurrentLauncher extends 
AbstractConcurrentLauncher
<DummyConcurrentRunConfiguration, DummyConcurrentExecutionContext>

{

	@Override
	protected AbstractConcurrentExecutionEngine<DummyConcurrentExecutionContext, DummyConcurrentRunConfiguration> createEngine(
			DummyConcurrentRunConfiguration runConfiguration, ExecutionMode executionMode)
			throws EngineContextException, CoreException {
		
		DummyConcurrentExecutionContext context = new DummyConcurrentExecutionContext(runConfiguration, executionMode);
		
		
		context.initializeResourceModel();
		
		return new DummyConcurrentEngine(context);
	}

	@Override
	protected DummyConcurrentRunConfiguration createRunConfiguration(ILaunchConfiguration launchConfiguration)
			throws CoreException {
		return new DummyConcurrentRunConfiguration(launchConfiguration);
	}

	@Override
	protected Set<String> getAdditionalViewsIDs() {
		return new HashSet<String>();
	}

}

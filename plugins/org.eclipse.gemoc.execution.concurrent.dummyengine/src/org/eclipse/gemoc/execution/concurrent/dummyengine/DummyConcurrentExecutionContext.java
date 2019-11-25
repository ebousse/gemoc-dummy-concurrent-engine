package org.eclipse.gemoc.execution.concurrent.dummyengine;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.BaseConcurrentModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.ConcurrentRunConfiguration;
import org.eclipse.gemoc.executionframework.engine.commons.DefaultExecutionPlatform;
import org.eclipse.gemoc.executionframework.engine.commons.EngineContextException;
import org.eclipse.gemoc.xdsmlframework.api.core.ExecutionMode;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionPlatform;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtension;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtensionPoint;

public class DummyConcurrentExecutionContext extends
		BaseConcurrentModelExecutionContext<ConcurrentRunConfiguration, IExecutionPlatform, LanguageDefinitionExtension> {

	public DummyConcurrentExecutionContext(ConcurrentRunConfiguration runConfiguration, ExecutionMode executionMode)
			throws EngineContextException {
		super(runConfiguration, executionMode);
	}

	@Override
	protected IExecutionPlatform createExecutionPlatform() throws CoreException {
		return new DefaultExecutionPlatform(_languageDefinition, _runConfiguration);
	}

	@Override
	protected String getDefaultRunDeciderName() {
		return "Random decider";
	}

	@Override
	protected LanguageDefinitionExtension getLanguageDefinitionExtension(String arg0) throws EngineContextException {
		// TODO Auto-generated method stub
		return LanguageDefinitionExtensionPoint.findDefinition(this._runConfiguration.getLanguageName());

	}

}

package dummyengine;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.gemoc.execution.concurrent.ccsljavaengine.commons.BaseConcurrentModelExecutionContext;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.ILogicalStepDecider;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.deciders.DeciderSpecificationExtension;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.extensions.deciders.DeciderSpecificationExtensionPoint;
import org.eclipse.gemoc.execution.sequential.javaxdsml.api.extensions.languages.SequentialLanguageDefinitionExtensionPoint;
import org.eclipse.gemoc.executionframework.engine.commons.DefaultExecutionPlatform;
import org.eclipse.gemoc.executionframework.engine.commons.EngineContextException;
import org.eclipse.gemoc.xdsmlframework.api.core.ExecutionMode;
import org.eclipse.gemoc.xdsmlframework.api.core.IExecutionPlatform;
import org.eclipse.gemoc.xdsmlframework.api.extensions.languages.LanguageDefinitionExtension;

public class DummyConcurrentExecutionContext extends BaseConcurrentModelExecutionContext
<DummyConcurrentRunConfiguration, 
IExecutionPlatform, 
LanguageDefinitionExtension> {

	public DummyConcurrentExecutionContext(DummyConcurrentRunConfiguration runConfiguration, ExecutionMode executionMode)
			throws EngineContextException {
		super(runConfiguration, executionMode);
	}

	@Override
	protected IExecutionPlatform createExecutionPlatform() throws CoreException, EngineContextException {
		return new DefaultExecutionPlatform(_languageDefinition, _runConfiguration);
	}

	@Override
	protected LanguageDefinitionExtension getLanguageDefinition(String languageName) throws EngineContextException {
		return SequentialLanguageDefinitionExtensionPoint.findDefinition(this._runConfiguration.getLanguageName());
	}

	@Override
	protected ILogicalStepDecider createRunDecider() throws CoreException {
		DeciderSpecificationExtension extension = DeciderSpecificationExtensionPoint.findDefinition("Random decider");
		return  extension.instanciateDecider();
	}


}

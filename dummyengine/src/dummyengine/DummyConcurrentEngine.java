package dummyengine;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.core.AbstractConcurrentExecutionEngine;
import org.eclipse.gemoc.execution.concurrent.ccsljavaxdsml.api.dsa.executors.CodeExecutionException;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericParallelStep;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenericSmallStep;
import org.eclipse.gemoc.trace.commons.model.generictrace.GenerictraceFactory;
import org.eclipse.gemoc.trace.commons.model.trace.MSE;
import org.eclipse.gemoc.trace.commons.model.trace.MSEOccurrence;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;
import org.eclipse.gemoc.trace.commons.model.trace.TraceFactory;

public class DummyConcurrentEngine
		extends AbstractConcurrentExecutionEngine<DummyConcurrentExecutionContext, DummyConcurrentRunConfiguration> {

	private int dummyCounter = 0;

	public DummyConcurrentEngine(DummyConcurrentExecutionContext executionContext) {
		initialize(executionContext);
	}

	@Override
	public String engineKindName() {
		return "Dummy Engine";
	}

	@Override
	protected List<Step<?>> computePossibleLogicalSteps() {
		ArrayList<Step<?>> result = new ArrayList<Step<?>>();
		if (dummyCounter < 10) {
			GenericParallelStep pstep = GenerictraceFactory.eINSTANCE.createGenericParallelStep();
			GenericSmallStep sstep = GenerictraceFactory.eINSTANCE.createGenericSmallStep();
			MSEOccurrence mseocc = TraceFactory.eINSTANCE.createMSEOccurrence();
			MSE mse = TraceFactory.eINSTANCE.createGenericMSE();
			mse.setName("DummyMSE");
			mseocc.setMse(mse);
			sstep.setMseoccurrence(mseocc);
			pstep.getSubSteps().add(sstep);
			result.add(pstep);
			dummyCounter++;
		}
		return result;
	}

	@Override
	protected void doAfterLogicalStepExecution(Step<?> logicalStep) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void executeSmallStep(SmallStep<?> smallStep) throws CodeExecutionException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void performInitialize(DummyConcurrentExecutionContext executionContext) {
		this.changeLogicalStepDecider(executionContext.getLogicalStepDecider());
	}

	@Override
	protected void finishDispose() {
		// TODO Auto-generated method stub

	}

}

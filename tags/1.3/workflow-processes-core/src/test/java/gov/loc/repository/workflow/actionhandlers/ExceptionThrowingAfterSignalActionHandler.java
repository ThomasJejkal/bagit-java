package gov.loc.repository.workflow.actionhandlers;

public class ExceptionThrowingAfterSignalActionHandler extends BaseActionHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void execute() throws Exception {
		this.executionContext.leaveNode("continue2");		
		throw new Exception("Oops.  An exception occurred.");
	}

}

package jpizz.controller;

import jpizz.model.DecisionLinesEvent;
import jpizz.view.MainGUI;
import junit.framework.TestCase;

public class TestStartRoundsController extends TestCase {
	StartRoundsController controller;
	MainGUI app;
	
	@Override
	protected void setUp(){
		DecisionLinesEvent event = new DecisionLinesEvent(3,3);
		app = new MainGUI(event);
		controller = new StartRoundsController(event, app);
	}
	
	@Override
	protected void tearDown(){
		app.dispose();
	}
	
	public void testController(){
		setUp();
		controller.actionPerformed(null);
		tearDown();
	}
}

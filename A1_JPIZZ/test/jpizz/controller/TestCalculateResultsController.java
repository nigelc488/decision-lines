package jpizz.controller;

import jpizz.model.DecisionLinesEvent;
import jpizz.view.MainGUI;
import junit.framework.TestCase;

public class TestCalculateResultsController extends TestCase {
	CalculateResultsController controller;
	MainGUI app;
	
	@Override
	protected void setUp(){
		DecisionLinesEvent event = new DecisionLinesEvent(3,3);
		event.getLines()[0].setChoice("One");
		event.getLines()[1].setChoice("Two");
		event.getLines()[2].setChoice("Three");		
		event.addEdge(100, 0, 1);
		app = new MainGUI(event);
		controller = new CalculateResultsController(event, app);
	}
	
	@Override
	protected void tearDown(){
		app.dispose();
	}
	
	public void testController(){
		setUp();
		controller.actionPerformed(null);
		assertTrue(controller.app.getMessageText().getText().equals("Results!    1: Two   2: One   3: Three   "));
		tearDown();
	}

}

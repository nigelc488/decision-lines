package ncochran.controller;

import junit.framework.TestCase;
import ncochran.model.DecisionLinesEvent;
import ncochran.view.DecisionLinesGUI;

public class TestStartButtonController extends TestCase {

	DecisionLinesEvent event;
	DecisionLinesGUI gui;
	
	@Override
	protected void tearDown(){
		gui.dispose();
	}
	
	@Override
	protected void setUp(){
		event = new DecisionLinesEvent();
		event.setNumChoices(5);
		event.setNumRounds(3);
		gui = new DecisionLinesGUI(event);
	}
	
	public void testStartButtonController(){
		StartButtonController controller = new StartButtonController(gui);
		assertEquals(50, controller.gui.getSizeChoice().height);
	}
	
	public void testRunStartButtonController(){
		StartButtonController controller = new StartButtonController(gui);
		controller.runStartButtonController();
		assertFalse(gui.getStartButton().isVisible());
	}
	
}

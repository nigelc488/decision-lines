package ncochran.controller;

import junit.framework.TestCase;
import ncochran.model.DecisionLinesEvent;
import ncochran.view.DecisionLinesGUI;

/**
 * This class is used to test the StartButtonController.
 * @author Nigel Cochran
 *
 */
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
	
	/**
	 * This method is used to test the constructor.
	 */
	public void testStartButtonController(){
		StartButtonController controller = new StartButtonController(gui);
		assertEquals(50, controller.gui.getSizeChoice().height);
	}
	
	/**
	 * This method is sued to test that the controller works correctly and the StartButton is invisible once the controller is run.
	 */
	public void testRunStartButtonController(){
		StartButtonController controller = new StartButtonController(gui);
		controller.runStartButtonController();
		assertFalse(gui.getStartButton().isVisible());
	}
	
}

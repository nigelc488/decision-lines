package ncochran.controller;

import junit.framework.TestCase;
import ncochran.model.DecisionLinesEvent;

/**
 * This class is used to test the ConsoleController.
 * @author Nigel Cochran
 *
 */
public class TestConsoleController extends TestCase{
	
	/**
	 * This method is used to test that only valid choices are accepted.
	 */
	public void testReadChoices(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		ConsoleController controller = new ConsoleController(event);
		controller.readChoices(5);
		assertEquals(5, event.getNumChoices());
		controller.readChoices(2);
		assertEquals(5, event.getNumChoices());
		controller.readChoices(9);
		assertEquals(5, event.getNumChoices());
	}
	
	/**
	 * This method is used to test that only valid rounds are accepted.
	 */
	public void testReadRounds(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		ConsoleController controller = new ConsoleController(event);
		controller.readRounds(5);
		assertEquals(5, event.getNumRounds());
		controller.readRounds(2);
		assertEquals(5, event.getNumRounds());
		controller.readRounds(9);
		assertEquals(5, event.getNumRounds());
	}
	
//	public void testreadConsole(){
//		DecisionLinesEvent event = new DecisionLinesEvent();
//		ConsoleController controller = new ConsoleController(event);
//		controller.readConsole();
//		
//	}
	
	
}



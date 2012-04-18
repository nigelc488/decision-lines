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
		controller.choices = 5;
		controller.readChoices();
		assertEquals(5, event.getNumChoices());
		controller.choices = 2;
		controller.readChoices();
		assertEquals(5, event.getNumChoices());
		controller.choices = 9;
		controller.readChoices();
		assertEquals(5, event.getNumChoices());
	}
	
	/**
	 * This method is used to test that only valid rounds are accepted.
	 */
	public void testReadRounds(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		ConsoleController controller = new ConsoleController(event);
		controller.rounds = 5;
		controller.readRounds();
		assertEquals(5, event.getNumRounds());
		controller.rounds = 2;
		controller.readRounds();
		assertEquals(5, event.getNumRounds());
		controller.rounds = 9;
		controller.readRounds();
		assertEquals(5, event.getNumRounds());
	}
	
//	public void testreadConsole(){
//		DecisionLinesEvent event = new DecisionLinesEvent();
//		ConsoleController controller = new ConsoleController(event);
//		controller.readConsole();
//		
//	}
	
	
}



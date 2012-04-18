package ncochran.controller;

import junit.framework.TestCase;
import ncochran.model.DecisionLinesEvent;

public class TestConsoleController extends TestCase{
	
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



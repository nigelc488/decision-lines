package ncochran.controller;

import java.awt.Point;

import junit.framework.TestCase;
import ncochran.model.DecisionLinesEvent;
import ncochran.view.DecisionLinesGUI;

/**
 * This Class is used to test the AddEdgeController class.
 * @author Nigel Cochran
 *
 */
public class TestAddEdgeController extends TestCase {
	
	DecisionLinesEvent event;
	DecisionLinesGUI gui;
	
	@Override
	protected void tearDown(){
		gui.dispose();
	}
	
	@Override
	protected void setUp(){
		event = new DecisionLinesEvent();
		event.setNumChoices(3);
		event.setNumRounds(3);
		gui = new DecisionLinesGUI(event);
	}
	
	/**
	 * This method is used to test the constructor.
	 */
	public void testAddEdgeController(){
		AddEdgeController controller = new AddEdgeController(event);
		assertEquals(3, controller.event.getNumChoices());
	}
	
	/**
	 * This method is used to test that only valid edges can be added.
	 */
	public void testRunEdgeController(){
		AddEdgeController controller = new AddEdgeController(event, gui);
		
		//too far left
		controller.runEdgeController(new Point(50, 102));
		assertFalse(controller.validEdge);
		
		//too far right
		controller.runEdgeController(new Point(820, 102));
		assertFalse(controller.validEdge);
		
		//valid
		controller.runEdgeController(new Point(500, 102));
		assertTrue(controller.validEdge);
		
		//too close low and to the right
		controller.runEdgeController(new Point(500, 107));
		assertFalse(controller.validEdge);
		
		//too close high and to the left
		controller.runEdgeController(new Point(300, 98));
		assertFalse(controller.validEdge);
	}
	
	/**
	 * This method is used to test the situation where the edge added is the last required edge.
	 */
	public void testFull(){
		AddEdgeController controller = new AddEdgeController(event, gui);
		event.setCurrentEdges(8);
		controller.runEdgeController(new Point(500, 102));
		assertTrue(controller.validEdge);
		assertTrue(event.checkEdgesFull());
	}

}

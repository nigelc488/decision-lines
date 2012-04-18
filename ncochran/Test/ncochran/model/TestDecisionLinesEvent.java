package ncochran.model;

import junit.framework.TestCase;

/**
 * This class is used to test the DecisionLinesEvent.
 * @author ncochran
 *
 */
public class TestDecisionLinesEvent extends TestCase {

	/**
	 * This class checks to see if a string is already a choice.  
	 * Tests when there are no existing choices (null choices).
	 */
	public void testUnique(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		assertTrue(event.checkUnique("test"));
	}
	
	/**
	 * This method tests when you pass it an empty string.
	 */
	public void testEmptyUnique(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		assertFalse(event.checkUnique(""));
	}
	
	/**
	 * This method tests if unique when have stored choices and already have this choice.
	 */
	public void testChoice(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.addLine(new Line("test"));
		event.addLine(new Line ("stuff"));
		event.addLine(new Line("sklj"));
		assertFalse(event.checkUnique("test"));
	}
	/**
	 * This method tests letter case. 
	 * It also checks that the for loop is looking through the whole list.
	 */
	public void testCaseChoice(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.addLine(new Line("car"));
		event.addLine(new Line ("thiathoiafsd"));
		event.addLine(new Line("test"));
		assertFalse(event.checkUnique("TeSt"));
	}
	
	/**
	 * This method tests to see if all of the choices are full when they should be.
	 */
	public void testFull(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.addLine(new Line("car"));
		event.addLine(new Line ("thiathoiafsd"));
		event.addLine(new Line("test"));
		assertTrue(event.checkChoicesFull());
	}
	
	/**
	 * This method test to see if all of the edges have been added when they should not have.
	 */
	public void testEdgesNotFull(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.setNumChoices(3);
		event.setNumRounds(5);
		event.setCurrentEdges(7);
		assertFalse(event.checkEdgesFull());
	}
	
	/**
	 * This method tests the getter and setter for the current number of edges.
	 */
	public void testGetSetCurrentNumEdges(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.setNumChoices(3);
		event.setNumRounds(5);
		event.setCurrentEdges(7);
		assertEquals(7, event.getCurrentEdges());
	}
	
	/**
	 * This method tests the getter and setter for the total number of edges.
	 */
	public void testGetSetTotalNumEdges(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.setNumChoices(3);
		event.setNumRounds(5);
		event.setCurrentEdges(7);
		assertEquals(15, event.getTotalEdges());
	}
	
	/**
	 * This method tests to see if all of the edges are full when they should be.
	 */
	public void testEdgesFull(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.setNumChoices(3);
		event.setNumRounds(5);
		event.setCurrentEdges(15);
		assertTrue(event.checkEdgesFull());
	}
	
	/**
	 * This method tests to see if the decision is full when it should be.
	 */
	public void testFullFirst(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.addLine(new Line(50));
		event.addLine(new Line("car"));
		event.addLine(new Line ("thiathoiafsd"));
		event.addLine(new Line("test"));
		assertFalse(event.checkChoicesFull());
	}
	
	/**
	 * This method tests to see if the decision is full when it should not be.
	 */
	public void testFullLast(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.addLine(new Line("car"));
		event.addLine(new Line ("thiathoiafsd"));
		event.addLine(new Line("test"));
		event.addLine(new Line(50));
		assertFalse(event.checkChoicesFull());
	}
	
	/**
	 * This method tests the getter and setter for the number of rounds.
	 */
	public void testGetSetNumRounds(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.setNumRounds(5);
		assertEquals(5, event.getNumRounds());
	}
	
	/**
	 * This method tests the getter and setter for the number of choices.
	 */
	public void testGetSetNumChoices(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		event.setNumChoices(3);
		assertEquals(3, event.getNumChoices());
	}
	
	
	/**
	 * This method tests the getter and setter for a line.
	 */
	public void testAddtSetLine(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		Line line = new Line(40);
		event.addLine(line);
		assertEquals(line, event.getLine(0));
		Line line2 = new Line(50);
		event.setLine(0, line2);
		assertEquals(50, event.getLine(0).getxPosition());
	}
	
	/**
	 * 	This method tests the getter and setter for an edge.
	 */
	public void testGetSetEdge(){
		DecisionLinesEvent event = new DecisionLinesEvent();
		Edge edge = new Edge(54);
		event.addEdge(edge);
		assertEquals(edge,event.getEdge(0));
	}
}

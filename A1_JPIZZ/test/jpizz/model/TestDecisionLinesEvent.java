package jpizz.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestDecisionLinesEvent extends TestCase{

	DecisionLinesEvent eventToTest;
	int rounds = 3;
	int choices = 4;
	
	@Override
	protected void setUp(){
		eventToTest = new DecisionLinesEvent(rounds, choices);
	}
	
	public void testEventSetUp(){
		eventToTest = new DecisionLinesEvent();
		eventToTest.setNumRounds(rounds);
		eventToTest.setNumChoices(choices);
		assertEquals(choices, eventToTest.getNumChoices());
		assertEquals((rounds*choices), eventToTest.getTotalEdges());
	}
	
	public void testLinesAndEdges(){
		setUp();
		Line[] testLines = new Line[choices];
		for (int i = 0; i < choices; i++){
			testLines[i] = new Line(i); 
		}
		assertFalse(eventToTest.choicesComplete());
		
		for (int i = 0; i < choices; i++){
			Integer name = i;
			testLines[i].setChoice(name.toString());
		}
		for (int i = 0; i < choices; i++){
			Integer name = i;
			eventToTest.getLines()[i].setChoice(name.toString());
		}
		assertTrue(eventToTest.choicesComplete());
		
		int edge1Height = 100;
		int edge1Left = 1;
		int edge1Right = 2;
		int edge2Height = 200;
		int edge2Left = 0;
		int edge2Right = 1;		
		Edge edge1 = new Edge(edge1Height, edge1Left, edge1Right);
		Edge edge2 = new Edge(edge2Height, edge2Left, edge2Right);
		
		eventToTest.addEdge(edge1Height, edge1Left, edge1Right);
		eventToTest.addEdge(edge2Height, edge2Left, edge2Right);
		assertEquals(2, eventToTest.getNumEdges());
		
		ArrayList<Integer> heights = new ArrayList<Integer>();
		heights.add(edge1Height);
		heights.add(edge2Height);
		heights.add(edge1Height);
		assertEquals(heights, eventToTest.getEdgeHeights(edge1Left, edge1Right));
		
	}
	
	
}

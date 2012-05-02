package jpizz.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestLine extends TestCase{
	
	Line lineToTest;
	
	@Override
	protected void setUp(){
		lineToTest = new Line(1);
	}
	
	public void testChoiceText(){
		setUp();
		String text = "Testing";
		lineToTest.setChoice(text);
		assertEquals(text, lineToTest.getChoice());
	}
	
	public void testChoiceEdges(){
		setUp();
		Edge edge1 = new Edge(100, 1, 2);
		Edge edge2 = new Edge(200, 0, 1);
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(edge1);
		edges.add(edge2);
		lineToTest.addEdge(edge1);
		lineToTest.addEdge(edge2);
		assertEquals(edges, lineToTest.getEdges());
	}
	
	

}

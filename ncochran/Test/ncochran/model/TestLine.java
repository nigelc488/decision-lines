package ncochran.model;

import junit.framework.TestCase;

public class TestLine extends TestCase {
	
	/**
	 * check if storing correct
	 */
	public void testStorage(){
		Line test = new Line(50);
		assertEquals(50, test.xPosition);
	}
	
	/**
	 * test getter for position
	 */
	public void testGetX(){
		Line test = new Line(2);
		assertEquals(2, test.getxPosition());
	}
	
	/**
	 * test setter for position
	 */
	public void testSetX(){
		Line test = new Line(6);
		test.setxPosition(44);
		assertEquals(44, test.xPosition);
	}
	/**
	 * test setter for choice
	 */
	public void testSetChoice(){
		Line test = new Line(45);
		test.setChoice("test");
		assertEquals("test", test.choice);
	}
	/**
	 * test getter for choice
	 */
	public void testGetChoice(){
		Line test = new Line(45);
		test.setChoice("test");
		assertEquals("test", test.getChoice());
	}
	/**
	 * test if Case matching
	 */
	public void testCase(){
		Line test = new Line(45);
		test.setChoice("TeSt");
		assertEquals("TeSt", test.getChoice());
	}
	/**
	 * test adding an edge
	 */
	public void testAddEdge(){
			Line test = new Line(45);
			test.addEdge(new Edge(50));
			assertEquals(1, test.edges.size());
	}
	
	/**
	 * test getting edges
	 */
	public void testGetEdges(){
		Line test = new Line(666);
		test.addEdge(new Edge(1));
		test.addEdge(new Edge(34));
		test.addEdge(new Edge(55));
		assertEquals(3, test.getEdges().size());
		assertEquals(34, test.getEdge(1).getHeight());
	}
	
	//test construct with string
	public void testConstructString(){
		Line line = new Line("test");
		assertEquals("test", line.getChoice());
	}
	
	//test if requested edge is too close
	public void testCloseEdge(){
		Line line = new Line(45);
		line.addEdge(new Edge(12));
		assertFalse(line.checkCloseEdge(12+8));
		assertFalse(line.checkCloseEdge(12-8));
		assertTrue(line.checkCloseEdge(12+7));
		assertTrue(line.checkCloseEdge(12-7));
	}
	
	//test comparing two lines
	public void testCompareTo(){
		Line line1 = new Line(10);
		Line line2 = new Line(5);
		assertEquals(5, line1.compareTo(line2));
	}
	
	
/*	public void TestSort(){
		Line test = new Line(50);
		Line test2 = new Line(40);
		test.addEdge(new Edge(2, test, test2));
		test.addEdge(new Edge(10));
		test.addEdge(new Edge(8));
		test.addEdge(new Edge(5));
		
		Line sorted = new Line(60);
		sorted.addEdge(new Edge(2, test, test2));
		sorted.addEdge(new Edge(5));
		sorted.addEdge(new Edge(8));
		sorted.addEdge(new Edge(10));
		
		assertEquals(sorted, test);

	}*/

}

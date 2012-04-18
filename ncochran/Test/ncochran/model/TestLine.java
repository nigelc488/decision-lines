package ncochran.model;

import junit.framework.TestCase;

/**
 * This class is used to test the Line entity.
 * @author Nigel Cochran
 *
 */
public class TestLine extends TestCase {
	
	/**
	 * This method tests the constructor and storage of the horizontal position.
	 */
	public void testStorage(){
		Line test = new Line(50);
		assertEquals(50, test.xPosition);
	}
	
	/**
	 * This method tests the getter for position.
	 */
	public void testGetX(){
		Line test = new Line(2);
		assertEquals(2, test.getxPosition());
	}
	
	/**
	 * This method tests the setter for position.
	 */
	public void testSetX(){
		Line test = new Line(6);
		test.setxPosition(44);
		assertEquals(44, test.xPosition);
	}
	/**
	 * This method tests the setter for choice.
	 */
	public void testSetChoice(){
		Line test = new Line(45);
		test.setChoice("test");
		assertEquals("test", test.choice);
	}
	/**
	 * This method tests the getter for choice.
	 */
	public void testGetChoice(){
		Line test = new Line(45);
		test.setChoice("test");
		assertEquals("test", test.getChoice());
	}
	/**
	 * This method tests the case of the choice.
	 */
	public void testCase(){
		Line test = new Line(45);
		test.setChoice("TeSt");
		assertEquals("TeSt", test.getChoice());
	}
	/**
	 * This method tests adding a new edge.
	 */
	public void testAddEdge(){
			Line test = new Line(45);
			test.addEdge(new Edge(50));
			assertEquals(1, test.edges.size());
	}
	
	/**
	 * This method tests the getter for edges.
	 */
	public void testGetEdges(){
		Line test = new Line(666);
		test.addEdge(new Edge(1));
		test.addEdge(new Edge(34));
		test.addEdge(new Edge(55));
		assertEquals(3, test.getEdges().size());
		assertEquals(34, test.getEdge(1).getHeight());
	}
	
	/**
	 * This method tests the constructor using a string.
	 */
	public void testConstructString(){
		Line line = new Line("test");
		assertEquals("test", line.getChoice());
	}
	
	/**
	 * This method tests the adding of an edge too close to an existing edge.
	 */
	public void testCloseEdge(){
		Line line = new Line(45);
		line.addEdge(new Edge(12));
		assertFalse(line.checkCloseEdge(12+8));
		assertFalse(line.checkCloseEdge(12-8));
		assertTrue(line.checkCloseEdge(12+7));
		assertTrue(line.checkCloseEdge(12-7));
	}
	
	/**
	 * This method tests comparing two lines.
	 */
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

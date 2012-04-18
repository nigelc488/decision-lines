package ncochran.model;

import junit.framework.TestCase;

/**
 * This class is used to test the Edge entity.
 * @author Nigel Cochran
 *
 */
public class TestEdge extends TestCase{

	/**
	 * This method test the constructor which only uses a height.
	 */
	public void testEdgeConstructor(){
		Edge test = new Edge(50);
		assertEquals(50, test.height);
	}
	
	/**
	 * This method tests the constructor which takes in a height and lines.
	 */
	public void testEdgeConstructorLarge(){
		Line line1 = new Line(25);
		Line line2 = new Line(12);
		Edge test = new Edge(25, line1, line2);
		assertEquals(25, test.height);
		assertEquals(line1, test.leftLine);
		assertEquals(line2, test.rightLine);
	}
	
	/**
	 * This method test the getter for height.
	 */
	public void testGetHeight(){
		Edge test = new Edge(57);
		assertEquals(57, test.getHeight());
	}
	
	/**
	 * This method tests the setter for height.
	 */
	public void testSetHeight(){
		Edge test = new Edge(44);
		test.setHeight(47);
		assertEquals(47, test.height);
	}
	
	/**
	 * This method tests the getter for a line.
	 */
	public void testGetLine(){
		Line line1 = new Line(25);
		Line line2 = new Line(12);
		Edge test = new Edge(75, line1, line2);
		assertEquals(line1, test.getLeftLine());
		assertEquals(line2, test.getRightLine());
	}
	
	/**
	 * This method tests the setter for a line.
	 */
	public void testSetLine(){
		Line line1 = new Line(25);
		Line line2 = new Line(12);
		Line line11 = new Line(87);
		Line line22 = new Line(900);
		Edge test = new Edge(75, line1, line2);
		test.setLeftLine(line11);
		test.setRightLine(line22);
		assertEquals(line11, test.getLeftLine());
		assertEquals(line22, test.getRightLine());
	}
	
	/**
	 * This method test the getter for the other line of the edge when given an edge.
	 */
	public void testGetOtherLine(){
		Line line1 = new Line(25);
		Line line2 = new Line(12);
		Edge edge = new Edge(50, line1, line2);
		assertEquals(line2, edge.getOtherLine(line1));
		assertEquals(line1, edge.getOtherLine(line2));
	}
	
	/**
	 * This method tests the comparison of two edges.
	 */
	public void testCompareTo(){
		Edge edge1 = new Edge(10);
		Edge edge2 = new Edge(5);
		assertEquals(5, edge1.compareTo(edge2));
	}
	
}

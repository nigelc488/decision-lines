package jpizz.model;

import junit.framework.TestCase;

public class TestEdge extends TestCase {
	
	Edge edgeToTest;
	
	@Override
	protected void setUp(){
		edgeToTest = new Edge(100, 1, 2);
	}
	
	public void testGetHeight(){
		setUp();
		assertEquals(100, edgeToTest.getHeight());
	}

	public void testGetLeft(){
		setUp();
		assertEquals(1, edgeToTest.getLeft());
	}
	
	public void testGetRight(){
		setUp();
		assertEquals(2, edgeToTest.getRight());
	}
	
	public void testIsEqual(){
		setUp();
		Edge badEdge = new Edge(90, 1, 2);
		Edge goodEdge = new Edge(100, 1, 2);
		assertFalse(edgeToTest.isEqual(badEdge));
		assertTrue(edgeToTest.isEqual(goodEdge));
	}
}

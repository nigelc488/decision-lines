package jpizz.controller;

import java.util.ArrayList;

import jpizz.model.DecisionLinesEvent;
import jpizz.view.MainGUI;
import junit.framework.TestCase;

public class TestAddEdgesController extends TestCase {
	
	AddEdgesController controller;
	MainGUI app;
	
	@Override
	protected void setUp(){
		DecisionLinesEvent event = new DecisionLinesEvent(3,3);
		app = new MainGUI(event);
		controller = new AddEdgesController(event, app);
	}
	
	@Override
	protected void tearDown(){
		app.dispose();
	}
	
	public void testController(){
		setUp();
		controller.addEdgesControls(100, 50);
		controller.addEdgesControls(100, 100);
		controller.addEdgesControls(100, 140);
		controller.addEdgesControls(40, 100);
		ArrayList<Integer> heights = new ArrayList<Integer>();
		heights.add(100);
		heights.add(40);
		assertEquals(heights,controller.event.getEdgeHeights(1, 2));
		controller.addEdgesControls(50, 100);
		controller.addEdgesControls(60, 100);
		controller.addEdgesControls(70, 100);
		controller.addEdgesControls(80, 100);
		controller.addEdgesControls(90, 100);
		controller.addEdgesControls(110, 100);
		assertEquals(8, controller.event.getNumEdges());
		controller.addEdgesControls(120, 100);
		tearDown();
	}
	
}

package jpizz.controller;

import jpizz.model.DecisionLinesEvent;
import jpizz.view.MainGUI;
import junit.framework.TestCase;

public class TestChoiceController extends TestCase{
	
	ChoiceController controller;
	MainGUI app;
	DecisionLinesEvent event;
	
	@Override
	protected void setUp(){
		event = new DecisionLinesEvent(3,3);
		app = new MainGUI(event);
		controller = new ChoiceController(1, event, app);
	}
	
	@Override
	protected void tearDown(){
		app.dispose();
	}
	
	public void testController(){
		setUp();
		controller.actionPerformed(null);
		event.getLines()[0].setChoice("Test1");
		event.getLines()[2].setChoice("Test3");
		app.getChoices()[1].setText("Test1");
		controller.actionPerformed(null);
		assertEquals("",controller.event.getLines()[1].getChoice());
		app.getChoices()[1].setText("Test2");
		controller.actionPerformed(null);
		System.out.println(controller.event.getLines()[1].getChoice());
		assertTrue(controller.event.getLines()[1].getChoice().equals("Test2"));
		tearDown();
	}
}

package ncochran.controller;

import javax.swing.JTextField;

import ncochran.model.DecisionLinesEvent;
import ncochran.model.Line;
import ncochran.view.DecisionLinesGUI;
import junit.framework.TestCase;

/**
 * This class is used to test the ChoiceController.
 * @author Nigel Cochran
 *
 */
public class TestChoiceController extends TestCase {
	
	DecisionLinesGUI gui;
	DecisionLinesEvent event;
	ChoiceController controller;
	
	@Override
	protected void tearDown(){
		gui.dispose();
	}
	
	@Override
	protected void setUp(){
		event = new DecisionLinesEvent();
		event.setNumChoices(5);
		event.setNumRounds(3);
		event.setTotalEdges();
		gui = new DecisionLinesGUI(event);
		gui.setVisible(true);
	}
	
	/**
	 * This method is used to test the constructor.
	 */
	public void testChoiceController(){
		controller = new ChoiceController(event, new Line(36), new JTextField("test"));
		assertEquals(5, event.getNumChoices());
		assertEquals(36, controller.line.getxPosition());
		assertEquals("test", controller.text.getText());
	}
	
	/**
	 * This method is used to test the constructor which takes in an array of text fields.
	 */
	public void testChoiceControllerArray(){
		event.addLine(new Line(11));
		event.addLine(new Line(22));
		event.addLine(new Line(33));
		event.sortLines();
		
		JTextField[] textChoices = new JTextField[3];
		textChoices[0] = new JTextField("one");
		textChoices[1] = new JTextField("two");
		textChoices[2] = new JTextField("three");
		controller = new ChoiceController(event, textChoices, 2);
		assertEquals(5, event.getNumChoices());
		assertEquals(33, controller.line.getxPosition());
		assertEquals("three", controller.text.getText());
		
	}
	
	/**
	 * This method is used to test retrieving the text from a text field and setting it to a line.
	 */
	public void testRunChoiceController(){
		controller = new ChoiceController(event, gui, new JTextField("test"));
		event.addLine(new Line(36));
		controller.line = new Line(36);
		controller.runChoiceController();
		assertEquals("test", controller.choice);
	}
	
	/**
	 * This method is used to test that a non-unique choice cannot be added.
	 */
	public void testNotRunChoiceController(){
		event.addLine(new Line("test"));
		controller = new ChoiceController(event, gui, new JTextField("test"));
		event.addLine(new Line(36));
		controller.line = new Line(36);
		controller.runChoiceController();
		assertEquals(null, controller.line.getChoice());
	}
	
	/**
	 * This method is used to test that once all of the choices are valid, it acknowledges that all of choices are full.
	 */
	public void testFull(){
		controller = new ChoiceController(event, gui, 4);
		gui.getChoice(0).setText("one");
		gui.getChoice(1).setText("two");
		gui.getChoice(2).setText("three");
		gui.getChoice(3).setText("four");
		gui.getChoice(4).setText("toy");
		for (int i = 0; i < gui.getChoices().length; i++) {
			controller.choices[i] = gui.getChoice(i);
			event.getLine(i).setChoice(gui.getChoice(i).getText());
		}
		controller.line = event.getLine(4);
		controller.text.setText("five");
		controller.runChoiceController();
		assertTrue(event.checkChoicesFull());
	}
	
}

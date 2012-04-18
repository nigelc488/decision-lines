package ncochran.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;

import junit.framework.TestCase;
import ncochran.model.DecisionLinesEvent;
/**
 * This class is used to test the DecisionLinesGUI
 * @author Nigel Cochran
 *
 */
public class TestDecisionLinesGUI extends TestCase {
	DecisionLinesEvent event;
	DecisionLinesGUI gui;
	
	@Override
	protected void tearDown(){
		gui.dispose();
	}
	
	@Override
	protected void setUp(){
		event = new DecisionLinesEvent();
		event.setNumChoices(8);
		event.setNumRounds(8);
		gui = new DecisionLinesGUI(event);
	}
	
	/**
	 * This method is used to test setting the size of the choices panel.
	 */
	public void testSetSizeChoice(){
		gui.setSizeChoice(new Dimension(50, 100));
		assertEquals(50, gui.getSizeChoice().width);
		assertEquals(100, gui.getSizeChoice().height);
	}
	
	/**
	 * This method is used to test setting the size of the lines panel.
	 */
	public void testSetSizeLines(){
		gui.setSizeLines(new Dimension(100, 50));
		assertEquals(100, gui.getSizeLines().width);
		assertEquals(50, gui.getSizeLines().height);
	}
	
	/**
	 * This method is sued to test setting the choices.
	 */
	public void testSetChoices(){
		JTextField[] array = new JTextField[3];
		array[0] = new JTextField("one");
		array[1] = new JTextField("two");
		array[2] = new JTextField("three");
		gui.setChoices(array);
		assertEquals("two", gui.getChoice(1).getText());
	}
	
	/**
	 * This method is used to test setting the StartButton.
	 */
	public void testStartButton(){
		gui.setStartButton(new JButton("start"));
		assertEquals("start", gui.getStartButton().getText());
	}
}

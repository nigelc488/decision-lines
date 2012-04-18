package ncochran.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;

import junit.framework.TestCase;
import ncochran.model.DecisionLinesEvent;

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
	
	public void testSetSizeChoice(){
		gui.setSizeChoice(new Dimension(50, 100));
		assertEquals(50, gui.getSizeChoice().width);
		assertEquals(100, gui.getSizeChoice().height);
	}
	
	public void testSetSizeLines(){
		gui.setSizeLines(new Dimension(100, 50));
		assertEquals(100, gui.getSizeLines().width);
		assertEquals(50, gui.getSizeLines().height);
	}
	
	public void testSetChoices(){
		JTextField[] array = new JTextField[3];
		array[0] = new JTextField("one");
		array[1] = new JTextField("two");
		array[2] = new JTextField("three");
		gui.setChoices(array);
		assertEquals("two", gui.getChoice(1).getText());
	}
	
	public void testStartButton(){
		gui.setStartButton(new JButton("start"));
		assertEquals("start", gui.getStartButton().getText());
	}
}

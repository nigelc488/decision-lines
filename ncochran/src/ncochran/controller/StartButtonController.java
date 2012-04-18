package ncochran.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import ncochran.model.DecisionLinesEvent;
import ncochran.view.DecisionLinesGUI;

/**
 * This class monitors the Start button and when pressed, allows the User to begin adding Edges and disables the ability to change the Choices.
 * The Start button also disappears after use.
 * @author Nigel Cochran
 *
 */
public class StartButtonController implements ActionListener {
	
	DecisionLinesEvent event;
	DecisionLinesGUI gui;
	//JTextField[] choices;
	
	/**
	 * This method creates a StartButtonController using a Gui.
	 * @param gui DecisionLinesGUI The Gui which contains the start button
	 */
	public StartButtonController(DecisionLinesGUI gui){
		this.gui = gui;
	}
	
	/**
	 * This method creates a StartButtonController using a Gui.
	 * @param event DecisionLinesEvent The DecisionLinesEvent which will start having Edges added to it
	 * @param gui DecisionLinesGUI The Gui which contains the start button
	 */
	public StartButtonController(DecisionLinesEvent event, DecisionLinesGUI gui){
		this.event = event;
		this.gui = gui;
	}

	/**
	 * This method makes makes it so the User cannot change the Choices and gains the ability to add Edges via mouse click.
	 * It also hides the Start button.
	 */
	
	public void runStartButtonController(){
		gui.fixChoices();
		gui.getLinesPanel().addMouseListener(new AddEdgeController(event, gui));
		gui.getStartButton().setVisible(false);
		gui.getTextDisplay().setText("Click the mouse between two Lines to add an Edge.");
	}
	
	/**
	 * This method calls the runStartButtonController method when the User presses the Start button.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		runStartButtonController();
/*			gui.fixChoices();
			gui.getLinesPanel().addMouseListener(new AddEdgeController(event, gui));
			gui.getStartButton().setVisible(false);*/
	}
	
	
	

}

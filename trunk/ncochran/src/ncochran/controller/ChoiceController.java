package ncochran.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import ncochran.model.DecisionLinesEvent;
import ncochran.model.Line;
import ncochran.view.DecisionLinesGUI;

/**
 * This class handles setting valid Choices based upon User input via text fields.
 * Choices are valid if they are unique and not empty.  Case is ignored.
 * @author Nigel Cochran
 *
 */
public class ChoiceController implements ActionListener {
	DecisionLinesEvent event;
	Line line;
	JTextField text;
	JTextField[] choices;
	String choice;
	
	DecisionLinesGUI gui;

	/**
	 * This method creates a new ChoiceController.
	 * @param event DecisionLinesEvent The DecisionLinesEvent the controller will update
	 * @param line Line the Line this ChoiceController is associated with
	 * @param text JTextField The text field this controller is associated with
	 */
	public ChoiceController(DecisionLinesEvent event, Line line, JTextField text){
		this.event = event;
		this.line = line;
		this.text = text;
	}
	
	/**
	 * This method creates a new ChoiceController.
	 * @param event DecisionLinesEvent The DecisionLinesEvent the controller will update
	 * @param choices JTextField[] An array of text fields
	 * @param index int The location in the array of text fields which the controller will be added to
	 */
	public ChoiceController(DecisionLinesEvent event, JTextField[] choices, int index){
		this.event = event;
		this.choices = choices;
		
		this.line = event.getLine(index);
		this.text = choices[index];
		
	}
	
	/**
	 * This method creates a ChoiceController.
	 * @param event DecisionLinesEvent The DecisionLinesEvent the controller will update
	 * @param gui DecisionLinesGUI The Gui which contains text fields this controller can be associated with
	 * @param index int The number associated with a JTextField in an array
	 */
	public ChoiceController(DecisionLinesEvent event, DecisionLinesGUI gui, int index){
		this.event = event;
		this.gui = gui;
		this.choices = gui.getChoices();
		
		this.line = event.getLine(index);
		this.text = choices[index];
		
	}
	
	/**
	 * When the User presses return, this method records the text from the text box, checks to see if it is different from all other choices, then sets the choice and informs the user.
	 * If the choice is invalid (null or the same as another choice, then it clears the text field and the choice and informs the user.
	 */
	
	public void runChoiceController(){
		choice = text.getText();
		if(event.checkUnique(choice)){
			line.setChoice(choice);
			text.setBackground(Color.green);
		}
		else{
			text.setText(null);
			text.setBackground(Color.pink);
			line.setChoice(null);
			System.out.println("choice is null or the same as another choice");
		}
		
		if(event.checkChoicesFull()){
			for (int i = 0; i < choices.length; i++) {
				//choices[i].setEditable(false);
				gui.getStartButton().setVisible(true);
				
			}
		}
		
	}
	/**
	 * This method is called when the user presses return in the text box and it then calls the runChoiceController method which performs the processing of this request.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
/*		choice = text.getText();
		if(event.checkUnique(choice)){
			line.setChoice(choice);
			text.setBackground(Color.green);
		}
		else{
			text.setText(null);
			text.setBackground(Color.pink);
			line.setChoice(null);
			System.out.println("choice is null or the same as another choice");
		}
		
		if(event.checkChoicesFull()){
			for (int i = 0; i < choices.length; i++) {
				//choices[i].setEditable(false);
				gui.getStartButton().setVisible(true);
				
			}
		}*/
		runChoiceController();
	}

}

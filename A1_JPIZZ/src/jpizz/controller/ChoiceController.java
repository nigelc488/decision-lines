package jpizz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jpizz.model.DecisionLinesEvent;
import jpizz.view.MainGUI;

/**
 * The class represents the controller that updates the text for the choices
 * @author jpizz
 *
 */
public class ChoiceController implements ActionListener {
	
	/** The model object */
	DecisionLinesEvent event;
	/** The boundary object */
	MainGUI app;
	/** The index of the choice being modified */
	int pos;
	
	/**
	 * Constructs an ChoiceController for a given event, e, and MainGUI, a
	 * @param e the DecisionLinesEvent for the controller
	 * @param a the MainGUI for the controller
	 */
	public ChoiceController(int p, DecisionLinesEvent e, MainGUI a){
		event = e;
		app = a;
		pos = p;
	}
	
	/**
	 * Upon pressing return in a text box, update the text for the corresponding choice to the value of of the text box if valid
	 * Valid text values do not match any current choice text values and are not empty
	 * When all choices have valid text, enable the functionality to start rounds with the StartRoundsController
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		app.getMessageText().setText("Enter choices above.");
		String proposedChoice = app.getChoices()[pos].getText();
		for (int i = 0; i < event.getNumChoices(); i++){
			if (proposedChoice.isEmpty()){
				app.getChoices()[pos].setText(event.getLines()[pos].getChoice());
				System.out.println("Empty string!");
				app.getMessageText().setText("The Choice cannot be empty!");
				return;
			} else if ((event.getLines()[i].getChoice().equals(proposedChoice)) && pos != i){
				app.getChoices()[pos].setText(event.getLines()[pos].getChoice());
				System.out.println("Choice already used!");
				app.getMessageText().setText("Two choices cannot have the same name!");
				return;
			}
		}
		event.getLines()[pos].setChoice(proposedChoice);
		System.out.println("Choice " + pos + " set to " + proposedChoice);
		app.getMessageText().setText("Choice " + pos + " set to " + proposedChoice + "! Enter choices above.");
		if (event.choicesComplete()){
			app.getButton().setText("Begin Rounds");
			app.getButton().setVisible(true);
		}
	}

}

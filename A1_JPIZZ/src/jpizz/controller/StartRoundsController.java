package jpizz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jpizz.model.DecisionLinesEvent;
import jpizz.view.MainGUI;

/**
 * The class represents the controller that disables the ability to edit choices and enables the ability to add edges
 * @author jpizz
 *
 */
public class StartRoundsController implements ActionListener {

	/** The model object */
	DecisionLinesEvent event;
	/** The boundary object */
	MainGUI app;
	
	/**
	 * Constructs an StartRoundsController for a given event, e, and MainGUI, a
	 * @param e the DecisionLinesEvent for the controller
	 * @param a the MainGUI for the controller
	 */
	public StartRoundsController(DecisionLinesEvent e, MainGUI a) {
		event = e;
		app = a;
	}

	/**
	 * Start the edge entering phase of the Event
	 * Disable the ability to modify choice text
	 * Enable the ability to add edges by calling the AddEdgesController
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		app.getMessageText().setText("Start Entering Edges");
		app.getButton().setVisible(false);
		for (int i = 0; i<event.getNumChoices(); i++){
			app.getChoices()[i].setEditable(false);
		}
		app.getButton().removeActionListener(this);
		app.getLinesPanel().addMouseListener(new AddEdgesController(event,app));
	}
}

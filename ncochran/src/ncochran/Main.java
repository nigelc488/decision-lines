package ncochran;

import ncochran.controller.ConsoleController;

import ncochran.model.*;
import ncochran.view.DecisionLinesGUI;

/**
 * This is the Main class which runs the DecisionLines code.
 * @author Nigel Cochran
 *
 */
public class Main {
	
	/**
	 * The main method creates an event, reads values from the console, and then launches the Gui.
	 * @param args
	 */
	public static void main(String[] args) {
		
		//creates a new event
		DecisionLinesEvent event = new DecisionLinesEvent();

		//gets values from console
		new ConsoleController().readConsole(event);
		
		//creates a new gui and waits for user
		DecisionLinesGUI gui = new DecisionLinesGUI (event);
		gui.setVisible(true);

	}
}
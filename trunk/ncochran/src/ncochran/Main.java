package ncochran;

import java.util.Scanner;

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
		ConsoleController console = new ConsoleController(event);
		
Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run){
			// prompts user for input
			System.out.println("Enter number of choices");
		try{
			run = !console.readChoices(sc.nextInt());
		}
		// if the user did not enter a number then they will be prompted
		// to try again
		catch (Exception e) {
			String wrong = sc.nextLine();
			System.out.println("you entered in " + wrong
					+ " which is not a number. Please try again.");
		}
		}
		
		run = true;
		while(run){
		// prompts user for input
		System.out.println("Enter number of rounds");
		
		// reads in what user typed
		try {
			run = !console.readRounds(sc.nextInt());
		}
		catch (Exception e) {
			String wrong = sc.nextLine();
			System.out.println("you entered in " + wrong
					+ " which is not a number. Please try again.");

		}
		
		event.setTotalEdges();
		}
		
		//creates a new gui and waits for user
		DecisionLinesGUI gui = new DecisionLinesGUI (event);
		gui.setVisible(true);

	}
}
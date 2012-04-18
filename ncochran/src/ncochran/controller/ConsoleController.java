package ncochran.controller;


import java.util.Scanner;
import ncochran.model.DecisionLinesEvent;

;

/**
 * This class is used to get the number of Choices and number of Rounds from the User through the console.
 * @author Nigel Cochran
 *
 */
public class ConsoleController {

	DecisionLinesEvent event;
	boolean run = true;
	int rounds;
	int choices;
	
	/**
	 * This method creates a ConsoleController using a DecisionLinesEvent.
	 * @param event DecisionLinesEvent The event this controller will update
	 */
	
	public ConsoleController(DecisionLinesEvent event){
		this.event = event;
	}

	/**
	 * This method reads the number of Choices and number of Rounds from the console and then sets these values for a DecisionLinesEvent.
	 * @param event DecisionLinesEvent The DecisionLinesEvent that will have its values updated
	 */
	public void readConsole() {

		Scanner sc = new Scanner(System.in);
		
		
		while(run){
			// prompts user for input
			System.out.println("Enter number of choices");
		try{
			choices = sc.nextInt();
			readChoices();
		}
		// if the user did not enter a number then they will be prompted
		// to try again
		catch (Exception e) {
			String wrong = sc.nextLine();
			System.out.println("you entered in " + wrong
					+ "which is not a number. Please try again.");
		}
		}
		
		run = true;
		while(run){
		// prompts user for input
		System.out.println("Enter number of rounds");
		
		// reads in what user typed
		try {
			rounds = sc.nextInt();
			readRounds();
		}
		catch (Exception e) {
			String wrong = sc.nextLine();
			System.out.println("you entered in " + wrong
					+ " which is not a number. Please try again.");

		}
		}
		
		
		
		/*while (run) {

			// prompts user for input
			System.out.println("Enter number of choices");

			// reads in what user typed
			try {
				choices = sc.nextInt();

				// tests to see if outside range
				if (choices < 3 || choices > 8) {
					System.out.println("you entered in " + choices);
					System.out
							.println("The value must be between 3 and 8 inclusively");
				} 
				// if everything is good, sets the number of rounds
				else {
					event.setNumChoices(choices);
					run = false;
				}
			} 
			// if the user did not enter a number then they will be prompted
			// to try again
			catch (Exception e) {
				String wrong = sc.nextLine();
				System.out.println("you entered in " + wrong
						+ "which is not a number. Please try again.");
			}
		}*/

		// runs the same logic as before but for the number of decisions
		/*run = true;

		while (run) {

			// prompts user for input
			System.out.println("Enter number of rounds");

			// reads in what user typed
			try {
				rounds = sc.nextInt();

				// tests to see if outside range
				if (rounds < 3 || rounds > 8) {
					System.out.println("you entered in " + rounds);
					System.out
							.println("The value must be between 3 and 8 inclusively");
				}
				// if everything is good, sets the number of rounds
				else {
					event.setNumRounds(rounds);
					run = false;
				}

				// if the user did not enter a number then they will be prompted
				// to try again
			} catch (Exception e) {
				String wrong = sc.nextLine();
				System.out.println("you entered in " + wrong
						+ " which is not a number. Please try again.");

			}

		}*/
		
		event.setTotalEdges();

	}
	
	void readChoices(){
			// reads in what user typed
				// tests to see if outside range
				if (choices < 3 || choices > 8) {
					System.out.println("you entered in " + choices);
					System.out
							.println("The value must be between 3 and 8 inclusively");
				} 
				// if everything is good, sets the number of rounds
				else {
					event.setNumChoices(choices);
					run = false;
				}
	}
	
	
	void readRounds(){
				// tests to see if outside range
				if (rounds < 3 || rounds > 8) {
					System.out.println("you entered in " + rounds);
					System.out
							.println("The value must be between 3 and 8 inclusively");
				}
				// if everything is good, sets the number of rounds
				else {
					event.setNumRounds(rounds);
					run = false;
				}

				// if the user did not enter a number then they will be prompted
				// to try again
	}
	
	
}
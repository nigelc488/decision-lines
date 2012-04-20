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
	
	/**
	 * This method creates a ConsoleController using a DecisionLinesEvent.
	 * @param event DecisionLinesEvent The event this controller will update
	 */
	
	public ConsoleController(DecisionLinesEvent event){
		this.event = event;
	}
	
	/**
	 * This method is used to read the choice input.
	 * @return boolean If it successfully read in a number of choices it returns true
	 */
	public boolean readChoices( int choices){
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
					return true;
				}
				
				return false;
	}
	
	/**
	 * This method is used to read the round input.
	 * @return boolean If it successfully read in a number of rounds it returns true
	 */
	public boolean readRounds(int rounds){
				// tests to see if outside range
				if (rounds < 3 || rounds > 8) {
					System.out.println("you entered in " + rounds);
					System.out
							.println("The value must be between 3 and 8 inclusively");
				}
				// if everything is good, sets the number of rounds
				else {
					event.setNumRounds(rounds);
					return true;
				}
				
				return false;

				// if the user did not enter a number then they will be prompted
				// to try again
	}


	
	
	
	
}
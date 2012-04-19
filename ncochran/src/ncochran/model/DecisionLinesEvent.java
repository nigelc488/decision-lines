package ncochran.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * This class holds all of the information required for a Decision Lines Event.
 * A Decision Lines Event is composed of lines and edges.  The number of Choices, number of Rounds, 
 * number of current Edges are all used to help determine the needed number of lines and edges.  These are then used to calculate the results.
 * @author Nigel Cochran
 *
 */

public class DecisionLinesEvent {

	int numRounds;
	int numChoices;
	int totalEdges;
	int currentEdges;
	ArrayList<Line> lines;
	ArrayList<Edge> edges;
	ArrayList<String> results;
	
	/**
	 * This constructor does not take in any variables but instantiates the lines, edges, results, number of rounds, and number of choices.
	 */
	public DecisionLinesEvent(){
		lines = new ArrayList<Line>();
		edges = new ArrayList<Edge>();
		results = new ArrayList<String>();
		numRounds = 0;
		numChoices = 0;
	}
	
	/**
	 * This method checks to see if the given string is unique (not empty and not already a choice).
	 * @param choice The string to be checked.
	 * @return boolean If the string does not match any of the current choices then this method returns true.  If it is the same as another choice then it returns false.
	 */

	public boolean checkUnique(String choice){
		boolean currentCheck = false;
		
		// checks to see if the passed string is null
		if(choice.equals("")){
			return false;
		}
		
		//converts the choice to lower case for consistancy
		choice = choice.toLowerCase();
		
		//this for loop first checks to see if the string in the line is null, if not, it compares to see if the two are equal
		for (int i = 0; i < lines.size(); i++) {
			if(lines.get(i).choice != null){
				currentCheck = lines.get(i).getChoice().toLowerCase().equals(choice);
			}
			//if the two strings are equal, then it is an invalid choice and it stops checking
			if(currentCheck) break;
			
		}		
		
		//if the two are equal then it is bad and therefore false
		if(currentCheck) return false;
		
		//if the string is unique then returns true
		else return true;
	}
	
	

	 // this method checks to see if all of the choices are specified.


	/**
	 * This method checks to see if all of the choices have been entered successfully.
	 * @return boolean Returns true if all choices are full.  If they are not, returns false.
	 */
	public boolean checkChoicesFull(){
		boolean full = false;
		for (int i = 0; i < lines.size(); i++) {
			if(lines.get(i).choice == null){
				full = false;
				break;
			}
			else full = true;
		}
		return full;
	}
	
	/**
	 * This method checks to see if all of the edges have been added, where the total number of edges is the number of choices multiplied by the number of rounds.
	 * @return boolean Returns true if all of the edges have been added.  If not, false.
	 */
	public boolean checkEdgesFull(){
		boolean full = false;
		if(currentEdges > totalEdges){
			throw new IllegalArgumentException("There are more edges than the toal allows");
		}
		if(currentEdges == totalEdges) full = true;
		return full;
	}
	
	/**
	 * This method sorts all of the lines in the event.  It sorts them based on horizontal position (xPosition) from low to high.
	 */
	public void sortLines(){
		Collections.sort(lines);
		for (int i = 0; i < lines.size(); i++) {
		}
	}
	
	/**
	 * This method determines the order of the specified Choices based upon the added Edges.
	 * The algorithm determines the order by descending each Vertical Line until it encounters a horizontal Edge.  It then follows this Edge to the next vertical Line.
	 * It then descends this Line to the next Edge, following this pattern until there are no more Edges to be traveled.  The position of the Line it ends on is the final result
	 * for that Choice.  It does this for each Choice.  The results are displayed in the console.
	 */
	public void calculateResults(){
		
		//make sure the lines are sorted
		sortLines();
		
		//make sure the edges of the lines are sorted
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).sortEdges();
			results.add("empty");
			//System.out.println("Line: " + i +" " + lines.get(i).getChoice());
			//lines.get(i).printEdges();
		}
		
		//calculate the position of each choice
		for (int i = 0; i < lines.size(); i++) {
			int currentHeight = 0; //the height you are at right now
			boolean run = true; //control the while loop
			Line line = lines.get(i);
			
			//algorithm to determine results
			while(run){
				
				//iterate through the edges of this line to determine the next highest edge
				for (int j = 0; j < line.getEdges().size(); j++) {
					
					//find out what is the next edge
					Edge edge = line.getEdge(j);
					if(edge.getHeight() > currentHeight){
						
						// the line being checked is now the other line of that edge
						line = edge.getOtherLine(line);
						//System.out.println("Int " + i + " Next Line: " + line.getChoice());
						
						//the height is updated
						currentHeight = edge.getHeight();
						break;
					}
				}
				//if it reaches this then it is at the bottom
				//check if there are no edges
				if(line.getEdges().size() == 0){
					results.set(lines.indexOf(line), lines.get(i).getChoice());
					//System.out.println("Result Added " + lines.get(i).getChoice());
					run = false;
				}
				
				else if(line.getEdge(line.getEdges().size() - 1).getHeight() <= currentHeight){
					results.set(lines.indexOf(line), lines.get(i).getChoice());
					//System.out.println("Result Added " + lines.get(i).getChoice());
					run = false;
				}
			}
		}
		//System.out.println("The Final Results are: " + results);
		
	}

	/**
	 * This method returns the number of rounds.
	 * @return int Number of Rounds.
	 */
	public int getNumRounds() {
		return numRounds;
	}

	/**
	 * This method sets the number of rounds.
	 * @param rounds int Number of rounds. 
	 */
	public void setNumRounds(int rounds) {
		this.numRounds = rounds;
		setTotalEdges();
	}

	/**
	 * This method returns the number of choices.
	 * @return int Number of choices
	 */
	public int getNumChoices() {
		return numChoices;
	}

	/**
	 * This method sets the number of choices.
	 * @param choices int Number of choices
	 */
	public void setNumChoices(int choices) {
		this.numChoices = choices;
		setTotalEdges();
	}
	
	/**
	 * This method returns the total number of edges.  This value is the number of edges multiplied by the number of rounds.
	 * @return int Total number of edges
	 */
	public int getTotalEdges() {
		return totalEdges;
	}
	
	/**
	 * This method sets the total number of edges.
	 * It calculates the total number of edges to be the number of rounds multiplied by the number of choices.
	 */
	public void setTotalEdges(){
		if(numChoices != 0 && numRounds != 0)
		totalEdges = numChoices*numRounds;
	}

	/**
	 * This method returns the current number of edges.
	 * @return int Current number of edges added to the event
	 */
	public int getCurrentEdges() {
		return currentEdges;
	}

	/**
	 * This method sets the current number of edges added to the event.
	 * @param currentEdges int The current number of edges
	 */
	public void setCurrentEdges(int currentEdges) {
		this.currentEdges = currentEdges;
	}

	/**
	 * This method adds a line to the event.
	 * @param line Line Adds the desired Line to the event.
	 */
	public void addLine(Line line){
		this.lines.add(line);
	}
	
	/**
	 * This method returns the Line at the desired index from the event.
	 * @param index int The position of the desired Line
	 * @return Line The desired Line
	 */
	public Line getLine(int index){
		return lines.get(index);
	}
	
	/**
	 * This method adds a line to a specified location in the event.
	 * @param index int The desired location.
	 * @param line Line The desired Line to be added.
	 */
	public void setLine(int index, Line line){
		lines.set(index, line);
	}
	
	/**
	 * This method returns the list of all of the Lines in the event.
	 * @return ArrayList<Line> The list of all of the lines.
	 */
	public ArrayList<Line> getLines(){
		return lines;
	}
	
	/**
	 * This method adds an edge to the event.
	 * @param edge Edge The desired Edge to be added.
	 */
	public void addEdge(Edge edge){
		edges.add(edge);
	}
	
	/**
	 * This method returns the Edge stored at the desired location.
	 * @param i int The location of the desired Edge
	 * @return Edge The edge at the desired location
	 */
	public Edge getEdge(int i){
		return edges.get(i);
	}
	
	/**
	 * This method returns the list of the Edges in the event.
	 * @return ArrayList<Edge> The list of all of the Edges
	 */
	public ArrayList<Edge> getEdges(){
		return edges;
	}

	/**
	 * This method returns the list of the results as a single string;
	 * @return String The ordered results.
	 */
	public String getResults() {
		String theResults = new String("The Ordered Results are: ");
		for (int i = 0; i < results.size(); i++) {
			theResults += (i+1) + ". " + results.get(i) + " ";
		}
		return theResults;
	}
	
}

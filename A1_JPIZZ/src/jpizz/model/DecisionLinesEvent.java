package jpizz.model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class represents the entire decision lines event
 * @author jpizz
 *
 */
public class DecisionLinesEvent {
	
	/** the number of edges drawn for each choice */
	int numRounds;
	/** the set of lines corresponding to choices */
	Line[] lines;
	
	/**
	 * Construct an event without the number of rounds or number of choices specified
	 */
	public DecisionLinesEvent(){
	}
	
	/**
	 * Construct an event with the given number of rounds, numR, and number of choices, numC
	 * @param numR
	 * @param numC
	 */
	public DecisionLinesEvent(int numR, int numC){
		numRounds = numR;
		lines = new Line[numC];
		for (int i = 0; i<numC; i++){
			lines[i] = new Line(i);
		}
	}
	
	/**
	 * Set the number of rounds in an event
	 * @param numR number of rounds
	 */
	public void setNumRounds(int numR){
		numRounds = numR;
	}
	
	/**
	 * Set the number of choices in an event and create the empty array of Lines corresponding to those choices
	 * @param numC number of choices
	 */
	public void setNumChoices(int numC){
		lines = new Line[numC];
		for (int i = 0; i<numC; i++){
			lines[i] = new Line(i);
		}
	}
		
	/**
	 * Retrieve the number of choices specified for an event
	 * @return an integer representing the number of choices in an event
	 */
	public int getNumChoices(){
		return lines.length;
	}

	/**
	 * Getter for the array of Lines in the Event
	 * @return Array containing all of the lines
	 */
	public Line[] getLines(){
		return lines;
	}
	
	/**
	 * Getter for the total number of edges allowed in the event
	 * @return int representing the total edges possible in the event
	 */
	public int getTotalEdges(){
		return this.numRounds*this.lines.length;
	}
	
	/**
	 * Getter for the number of Edges in an Event
	 * @return int representing the number of edges
	 */
	public int getNumEdges(){
		ArrayList<Edge> allEdges = this.getEdges();
		HashSet<Edge> edgesNoDoubles = new HashSet<Edge>();
		edgesNoDoubles.addAll(allEdges);
		return edgesNoDoubles.size();
	}

	/**
	 * Determines if all choices have valid (non-empty and non-repeating) values
	 * @return true if all choices have valid text, false otherwise
	 */
	public boolean choicesComplete(){
		for (int i = 0; i<lines.length; i++){
			if (lines[i].getChoice().isEmpty()) return false;
		}
		return true;
	}
	
	/**
	 * Add an Edge to the appropriate Lines
	 * @param height int for the height of the edge
	 * @param leftLinePos int for the position of the line to the left of the edge
	 * @param rightLinePos int for the position of the line to the right of the edge
	 */
	public void addEdge(int height, int leftLinePos, int rightLinePos){
		Edge e = new Edge(height, leftLinePos, rightLinePos);
		lines[leftLinePos].addEdge(e);
		lines[rightLinePos].addEdge(e);
	}
	
	/**
	 * Getter for a complete ArrayList containing all of the Edges in an Event
	 * @return the ArrayList of all the Event's Edges
	 */
	public ArrayList<Edge> getEdges(){
		ArrayList<Edge> allEdges = new ArrayList<Edge>(); 
		for (int i = 0; i<lines.length; i++){
			allEdges.addAll(lines[i].getEdges());
		}
	    return allEdges;
	}
	
	/**
	 * Getter for an ArrayList containing all of the Edges for a given Line
	 * @param linePos the position of the Line containing the desired Edges
	 * @return an ArrayList of all of the Edges connected to the given Line
	 */
	public ArrayList<Edge> getEdges(int linePos){
		ArrayList<Edge> allEdges = new ArrayList<Edge>(); 
		allEdges.addAll(lines[linePos].getEdges());
	    return allEdges;
	}
	
	/**
	 * Retrieve a list of the heights of all edges connected to two Lines
	 * @param leftLinePos the position of the left line
	 * @param rightLinePos the position of the right line
	 * @return an ArrayList containing integers of the heights of all of the edges connected to the two given lines
	 */
	public ArrayList<Integer> getEdgeHeights(int leftLinePos, int rightLinePos){
		ArrayList<Integer> heights = new ArrayList<Integer>();
		ArrayList<Edge> allEdges = this.getEdges(leftLinePos);
		allEdges.addAll(this.getEdges(rightLinePos));
		for (int i = 0; i < allEdges.size(); i++){
			  heights.add(allEdges.get(i).getHeight());
		}
		return heights;
	}
	

}

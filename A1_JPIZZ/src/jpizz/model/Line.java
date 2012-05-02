package jpizz.model;

import java.util.ArrayList;

/**
 * This class represents the lines (corresponding to choices) in a DecisionLinesEvent
 * @author jpizz
 *
 */
public class Line {
	/** text label for the choice */
	String choice;
	/** position in the the set of edges */
	final int position;
	/** the edges connected to the line */
	ArrayList<Edge> edges;
	
	/** 
	 * Construct a Line for the given position, p
	 * @param p position in the set of edges
	 */
	public Line(int p){
		position = p;
		edges = new ArrayList<Edge>();
		choice = "";
	}
	
	/**
	 * Set the text for choice for the line
	 * @param text String containing the choice text
	 */
	public void setChoice(String text){
		choice = text;
	}
	
	/**
	 * Add an edge to the arraylist of edges
	 * @param e edge to be added
	 */
	public void addEdge(Edge e){
		edges.add(e);
	}

	/**
	 * Getter for the text of the choice
	 * @return String containing the choices text
	 */
	public String getChoice() {
		return choice;
	}
	
	/**
	 * Getter for the ArrayList of Edges connected to the line
	 * @return the ArrayList of Edges
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
}

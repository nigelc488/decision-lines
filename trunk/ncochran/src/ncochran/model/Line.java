package ncochran.model;

import java.util.ArrayList;
import java.util.Collections;


/**
 * The Line class contains a choice, a horizontal position, and the edges associated with this Line and is used to determine the rankings of the Choices.
 * @author Nigel Cochran
 *
 */
public class Line implements Comparable<Line> {

	static int BUFFER = 7;
	int xPosition;
	String choice;
	ArrayList<Edge> edges;
	int index;
	
	/**
	 *This method creates a new Line based upon a horizontal location.
	 * @param xPosition The horizontal location of the desired Line
	 */
	public Line(int xPosition){
		this.xPosition = xPosition;
		edges = new ArrayList<Edge>();
		
	}
	
	/**
	 * This method creates a new Line with only a choice.
	 * This method is used to make test cases easier to write.
	 * @param choice String The desired Choice
	 */
	public Line(String choice){
		this.choice = choice;
	}
	
	/**
	 * This method returns the horizontal location of the Line.
	 * @return int The horizontal location (xPositon) of the Line
	 */
	public int getxPosition() {
		return xPosition;
	}

	/**
	 * This method sets the horizontal location of the Line.
	 * @param xPosition int The desired horizontal location (xPosition) of the Line
	 */
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * This method returns the Choice for this Line.
	 * @return String The Choice associated with this Line
	 */
	public String getChoice() {
		return choice;
	}

	/**
	 * This method sets the Choice associated with this Line.
	 * @param choice String The desired Choice.
	 */
	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	/**
	 * This method adds an Edge to the Line.
	 * @param edge Edge The desired Edge to be added to the Line
	 */
	public void addEdge(Edge edge){
		edges.add(edge);
		//System.out.println("edge added");
		}
	
	/**
	 * This method sorts the Edges from lowest to highest based upon height.
	 */
	public void sortEdges(){
		Collections.sort(edges);
	}
	
	/**
	 * This method checks to see if a height of an Edge is too close to the Edges already associated with the Line.
	 * @param height int The height of an Edge.
	 * @return boolean Returns true if the height is too close to an existing Edge.  False if it is a valid Edge and is not too close.
	 */
	public boolean checkCloseEdge(int height){
		sortEdges();
		for (int i = 0; i < edges.size(); i++) {
			if (Math.abs((edges.get(i).getHeight() - height)) <= BUFFER){
				return true; //too close
			}
			
		}
		return false;
	}
	
	/**
	 * This method returns the Edge stored at the desired location of the Line.
	 * @param i int The desired location
	 * @return Edge The Edge at the desired location
	 */
	public Edge getEdge(int i){
		return edges.get(i);
	}
	
	/**
	 * This method returns all of the Edges associated with this Line.
	 * @return ArrayList<Edge> The array list of all of the Edges
	 */
	public ArrayList<Edge> getEdges(){
		return edges;
	}
	
	/**
	 * This method returns the location of this line in the ArrayList of Lines.
	 * @return int The index of the line.
	 */
	public int getIndex(){
		return this.index;
	}
	
	/**
	 * This method sets the know location of this line in the ArrayList.
	 * @param int The index of this line.
	 */
	public void setIndex(int index){
		this.index = index;
	}
	
	
	  //prints all of the Edges associated with this line.  Displays their height to the console.
/*	public void printEdges(){
		for (int i = 0; i < edges.size(); i++) {
			System.out.println(edges.get(i).height);
		}
	}
*/
	/**
	 * This method is for sorting and compares a desired Line to this Line and returns the difference of the horizontal locations.
	 * @param o Line The Line to have its horizontal location compared to this Line
	 * @return int The difference between the two Lines (this Line minus the desired Line)
	 */
	@Override
	public int compareTo(Line o) {
		return  this.xPosition - o.xPosition;
	}
}

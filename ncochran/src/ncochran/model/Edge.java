package ncochran.model;

/**
 *A horizontal Edge is used to transition between vertical Lines and contains a height, a leftLine, and a rightLine.
 * @author Nigel Cochran
 *
 */
public class Edge implements Comparable<Edge> {
	
	int height;
	Line leftLine;
	Line rightLine;
	
	/**
	 * This Edge constructor is used to create an Edge and requires all of the parameters.
	 * @param height int The vertical location of the Edge
	 * @param leftLine Line The line which is the left end point of the Edge.
	 * @param rightLine Line The line which is the right end point of the Edge.
	 */
	public Edge(int height, Line leftLine, Line rightLine){
		this.height = height;
		this.leftLine = leftLine;
		this.rightLine = rightLine;
		//System.out.println("new edge" + " height: " + height + " left: " + leftLine.getxPosition() + " right: " + rightLine.getxPosition());
	}
	
	/**
	 * This Edge constructor only requires the height.
	 * @param height int The vertical locatation of the Edge
	 */
	public Edge(int height){
		this.height = height;
		this.leftLine = null;
		this.rightLine = null;
	}
	
	/**
	 * This method returns the vertical height of the Edge.
	 * @return int The height of the Edge
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * This method sets the height of the Edge.
	 * @param height int The desired height of the Edge
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * This method returns the Line which is the left end point of the Edge.
	 * @return Line The Line to the left of the Edge
	 */
	public Line getLeftLine() {
		return leftLine;
	}

	/**
	 * This method sets the Line which is the left end point of the Edge.
	 * @param leftLine Line the desired Line to the left of the Edge
	 */
	public void setLeftLine(Line leftLine) {
		this.leftLine = leftLine;
	}

	/**
	 * This method returns the Line which is the right end point of the Edge.
	 * @return Line The line to the right of the edge
	 */
	public Line getRightLine() {
		return rightLine;
	}

	/**
	 * This method sets the Line which is the right end point of the Edge.
	 * @param rightLine Line The desired line to the right of the edge
	 */
	public void setRightLine(Line rightLine) {
		this.rightLine = rightLine;
	}

	/**
	 * This method returns the Line of the Edge which is not specified.
	 * @param line Line The line which is known/specified.
	 * @return Line The line which is unknown/requested.
	 */
	public Line getOtherLine(Line line){
		if(line.equals(leftLine)) return rightLine;
		else if(line.equals(rightLine)) return leftLine;
		else throw new IllegalArgumentException("This is not one of the lines of this edge.");
	}
	
	/**
	 * This method makes it so that two Edges can be compared based on their height
	 * It modifies the existing compareTo method from the Comparable interface.
	 * @param o Edge The Edge to be compared to this Edge
	 * @return int The difference between the heights (this Edge minus specified Edge)
	 */
	@Override
	public int compareTo(Edge o) {
		return this.height - o.height;
	}
}

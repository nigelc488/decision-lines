package jpizz.model;

/**
 * This class represents the edge a user selects between two lines
 * @author jpizz
 *
 */
public class Edge {
	/** the height of the edge*/
	final int height;
	/** the number corresponding to the line to the left of the edge */
	final int left;
	/** the number corresponding to the line to the right of the edge */
	final int right;
	
	/**
	 * Construct an edge for the given height, h, between the two given lines, l and r
	 * @param h height
	 * @param l left
	 * @param r right
	 */
	public Edge(int h, int l, int r){
		height = h;
		left = l;
		right = r;
	}
	
	/**
	 * Determine if an edge is the same as another
	 * @param e Edge to compare to the current object
	 * @return true if all values of an Edge are equal, false otherwise
	 */
	public boolean isEqual(Edge e){
		if ((this.getHeight() == e.getHeight()) && (this.getLeft() == e.getLeft()) && (this.getRight() == e.getRight())){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Getter for the height of the Edge
	 * @return int for the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Getter for the position of the left Line connected to the Edge
	 * @return int for the position of the left Line
	 */
	public int getLeft() {
		return left;
	}

	/**
	 * Getter for the position of the right Line connected to the Edge
	 * @return int for the position of the right Line
	 */
	public int getRight() {
		return right;
	}
	
}

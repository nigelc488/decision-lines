package jpizz.view;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import jpizz.model.DecisionLinesEvent;
import jpizz.model.Edge;

/**
 * The class represents the canvas used to draw the lines and edges of the decision lines event
 * @author jpizz
 *
 */
public class LinesCanvas extends JPanel {

	/** The pixel location of the left most line */
	final int leftMostLinePos = 80;
	/** The pixel location of the right most line */
	final int rightMostLinePos;
	/** The pixel position of the top of the lines */
	final int topOfLinesPos = 20;
	/** The pixel position of the bottom of the lines */
	final int bottomOfLinesPos = 400;
	/** The number of pixels between lines */
	final int lineSpacing = 96;
	
	/** Event drawn on canvas */
	DecisionLinesEvent event;
	
	/**
	 * Constructs a line canvas for the given event, e
	 * @param e the DecisionLinesEvent to be shown on the canvas
	 */
	public LinesCanvas(DecisionLinesEvent e){
		event = e;
		rightMostLinePos = leftMostLinePos+((e.getNumChoices()-1)*lineSpacing);
	}
	
	/**
	 * Paints the lines on the canvas
	 */
	@Override
	public void paint(Graphics g){
		for (int i=0; i<event.getNumChoices(); i++){
			g.drawLine((leftMostLinePos+(i*lineSpacing)), topOfLinesPos, (leftMostLinePos+(i*lineSpacing)), bottomOfLinesPos);
		}
		ArrayList<Edge> allEdges = event.getEdges();
		for (int i = 0; i < allEdges.size(); i++){
			g.drawLine((leftMostLinePos+(allEdges.get(i).getLeft()*lineSpacing)), 
					  allEdges.get(i).getHeight(), 
					  (leftMostLinePos+(allEdges.get(i).getRight()*lineSpacing)), 
					  allEdges.get(i).getHeight());
		}
	}

	/**
	 * Getter for the position of the left most line
	 * @return int of the x pixel location of the left most line
	 */
	public int getLeftMostLinePos() {
		return leftMostLinePos;
	}

	/**
	 * Getter for the position of the right most line
	 * @return int of the x pixel location of the right most line
	 */
	public int getRightMostLinePos() {
		return rightMostLinePos;
	}

	/**
	 * Getter for the position of the top of the lines
	 * @return int of the y pixel location of the top of the lines
	 */
	public int getTopOfLinesPos() {
		return topOfLinesPos;
	}

	/**
	 * Getter for the position of the bottom of the lines
	 * @return int of the y pixel location of the bottom of the lines
	 */
	public int getBottomOfLinesPos() {
		return bottomOfLinesPos;
	}

	/**
	 * Getter for the spacing between each line
	 * @return int of the y pixel left between lines
	 */
	public int getLineSpacing() {
		return lineSpacing;
	}
	
}

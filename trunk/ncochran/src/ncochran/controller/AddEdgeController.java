package ncochran.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ncochran.model.DecisionLinesEvent;
import ncochran.model.Edge;
import ncochran.model.Line;
import ncochran.view.DecisionLinesGUI;

/**
 * The AddEdgeController is a MouseListener used to add a valid Edge to the Decision Lines Event at the location a user releases their mouse.
 * The Edge must be within the assigned workspace and cannot be too close to other Edges.
 * @author Nigel Cochran
 *
 */
public class AddEdgeController implements MouseListener {

	// Point mousePosition;
	DecisionLinesEvent event;
	DecisionLinesGUI gui;
	Edge edge;
	boolean validEdge;

	/**
	 * This method creates an AddEdgeController using a Decision Lines Event.
	 * @param event DecisionLinesEvent the DecisionLinesEvent which this controller is added to
	 */
	public AddEdgeController(DecisionLinesEvent event) {
		this.event = event;
	}

	/**
	 * This method creates an AddEdgeController using both a DecisionLinesEvent and a DecisionLinesGUI
	 * @param event DecisionLinesEvent The DecisionLinesEvent this listener is a part of
	 * @param gui DecisionLinesGUI The DecisionLinesGUI this listener is assoicated with
	 */
	public AddEdgeController(DecisionLinesEvent event, DecisionLinesGUI gui) {
		this.event = event;
		this.gui = gui;
	}
	
	/**
	 This method adds a valid Edge to the DecisionLinesEvent when the User releases a mouse click.
	 * If it is an invalid Edge, then the Edge is not added and the User is notified via the console.
	 * The method first determines the Lines at the end points of the edge which also validates the Edge.  It then redraws the Gui with this Edge
	 * then checks to see if this was the last Edge.  If it was the last Edge, it disables the User's ability to add Edges and has the DecisionLinesEvent calculate the 
	 * results.
	 * @param point Point An x,y point which is where the mouse was released
	 */
	public void runEdgeController(Point point){
		//System.out.println("x: " + e.getPoint().x + " y: " + e.getPoint().y);
		
		//figures out if valid edge and where to put it
		validEdge = determineLines(point);
		
		//redraw with the new edge
		gui.getLinesPanel().repaint();
		
		//checks to see if that is the last edge
		if (event.checkEdgesFull()) {
			gui.getLinesPanel().removeMouseListener(this);
			//gui.getLinesPanel().repaint();
			//new ResultsController(event);
			event.calculateResults();
			gui.getTextDisplay().setText(event.getResults());
		}
	}

	/**
	 * This method is required to implement MouseListener but is not used for this controller so does nothing.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is required to implement MouseListener but is not used for this controller so does nothing.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called when a mouse click is released calls the runEdgeController method which does the processing of the click.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

		runEdgeController(e.getPoint());
		
		/*		//System.out.println("x: " + e.getPoint().x + " y: " + e.getPoint().y);
		
		//figures out if valid edge and where to put it
		determineLines(e.getPoint());
		
		//redraw with the new edge
		gui.getLinesPanel().repaint();
		
		//checks to see if that is the last edge
		if (event.checkEdgesFull()) {
			gui.getLinesPanel().removeMouseListener(this);
			//gui.getLinesPanel().repaint();
			//new ResultsController(event);
			event.calculateResults();
		}*/

	}

	/**
	 * This method is required to implement MouseListener but is not used for this controller so does nothing.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is required to implement MouseListener but is not used for this controller so does nothing.
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method determines if the Edge is in a valid location and finds the lines at the end points of the Edge.
	 * If the Edge is valid, it adds it to the Lines and to the DecisionLinesEvent.  If invalid, it is not added and the User is informed
	 * via the console.
	 * @param mousePosition Point The x,y position of the pointer when the mouse was released.
	 */
	boolean determineLines(Point mousePosition) {
		for (int i = 0; i < event.getLines().size(); i++) {
			
			//iterate through the lines (left to right) until find the line to the right of the mouse click
			if ((event.getLine(i).getxPosition() > (int) mousePosition.x)) {
				
				//too far left
				if (i == 0) {
					//System.out.println("The Edge you are trying to add is outside of the DecisionLines.");
					gui.getTextDisplay().setText("The Edge you are trying to add is too far to the left of the DecisionLines.");
					return false;
				
					//too close to an edge on the left line
				} else if (event.getLine(i - 1).checkCloseEdge(mousePosition.y)) {
					//System.out.println("The Edge is too close to another Edge and cannot be added.");
					gui.getTextDisplay().setText("The Edge you are trying to add is too close to another Edge.");
					return false;
					
					//too close to an edge on the right line
				} else if (event.getLine(i).checkCloseEdge(mousePosition.y)) {
					gui.getTextDisplay().setText("The Edge you are trying to add is too close to another Edge.");
					return false;
					
				//add the edge
				} else {
					edge = new Edge(mousePosition.y, event.getLine(i - 1),
							event.getLine(i));
					// System.out.println("add right edge:");
					event.getLine(i - 1).addEdge(edge);
					// System.out.println("add left edge: ");
					event.getLine(i).addEdge(edge);
					event.addEdge(edge);
					event.setCurrentEdges(event.getCurrentEdges() + 1);
					//System.out.println("current edges: " + event.getCurrentEdges() + " total edges: " + event.getTotalEdges());
					gui.getTextDisplay().setText("current edges: " + event.getCurrentEdges() + " total edges: " + event.getTotalEdges());
					return true;
				}
			}
		}
		//too far to the right
		if (event.getLine(event.getLines().size() - 1).getxPosition() < mousePosition
				.getX()) {
			//System.out.println("The Edge you are trying to add is outside of the DecisionLines.");
			gui.getTextDisplay().setText("The Edge you are trying to add is too far to the right of the DecisionLines.");
			return false;
		}
		else return true;
	}

}

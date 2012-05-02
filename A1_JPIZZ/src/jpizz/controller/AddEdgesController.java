package jpizz.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import jpizz.model.DecisionLinesEvent;
import jpizz.view.MainGUI;

/**
 * The class represents the controller for adding edges to an event
 * @author jpizz
 *
 */
public class AddEdgesController implements MouseListener {
	
	/** The model object */
	DecisionLinesEvent event;
	/** The boundary object */
	MainGUI app;
	
	/**
	 * Constructs an AddEdgesController for a given event, e, and MainGUI, a
	 * @param e the DecisionLinesEvent for the controller
	 * @param a the MainGUI for the controller
	 */
	public AddEdgesController(DecisionLinesEvent e, MainGUI a) {
		event = e;
		app = a;
	}

	/**
	 * Add an Edge, if it is valid, at the given location of the mouse release
	 * Valid if it is between two neighboring lines and not adjacent to any other edges
	 * When the maximum number of edges are created, run the CalculateResultsController
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		int height = me.getY();
		int xPos = me.getX();
		addEdgesControls(height, xPos);
	}
	
	public void addEdgesControls(int height, int xPos){
		int left;
		int right;
		if ((event.getTotalEdges()-event.getNumEdges()) > 0) {
			if ((xPos <= app.getLinesPanel().getLeftMostLinePos()) 
					|| (xPos >= app.getLinesPanel().getRightMostLinePos()) 
					|| (height < app.getLinesPanel().getTopOfLinesPos()) 
					|| (height > app.getLinesPanel().getBottomOfLinesPos())){
				System.out.println("Not a Valid Edge: Not Between Neighboring Lines");
				app.getMessageText().setText("Edge not added: Must be between two lines");
			}else{
				for (int i = 0; i<event.getNumChoices(); i++){
					if ((xPos > (app.getLinesPanel().getLeftMostLinePos()+((i-1)*app.getLinesPanel().getLineSpacing())))
							&& (xPos < (app.getLinesPanel().getLeftMostLinePos()+(i*app.getLinesPanel().getLineSpacing())))){
						left = i-1;
						right = i;
						if ((event.getEdgeHeights(left, right).contains(height))
								|| (event.getEdgeHeights(left, right).contains(height+1))
								|| (event.getEdgeHeights(left, right).contains(height+2))
								|| (event.getEdgeHeights(left, right).contains(height+3))
								|| (event.getEdgeHeights(left, right).contains(height+4))
								|| (event.getEdgeHeights(left, right).contains(height+5))
								|| (event.getEdgeHeights(left, right).contains(height-1))
								|| (event.getEdgeHeights(left, right).contains(height-2))
								|| (event.getEdgeHeights(left, right).contains(height-3))
								|| (event.getEdgeHeights(left, right).contains(height-4))
								|| (event.getEdgeHeights(left, right).contains(height-5))){
							System.out.println("Not a Valid Edge: Adjacent to another edge");
							app.getMessageText().setText("Edge not added: Must not be at the same height as an adjacent edge");
						}else{
							event.addEdge(height, left, right);
							System.out.println("Edge added at " + height + " between lines " + left + " and " + right);
							int edgesRemaining = event.getTotalEdges()-event.getNumEdges();
							app.getMessageText().setText("Added an Edge! " + edgesRemaining + " Edges left to add!");
							app.getLinesPanel().repaint();
							app.getContentPane().repaint();
							if (edgesRemaining == 0){
								app.getLinesPanel().removeMouseListener(this);
								app.getButton().setText("View Results");
								app.getButton().addActionListener(new CalculateResultsController(event, app));
								app.getButton().setVisible(true);
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	

}

package ncochran.view;

import ncochran.model.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import ncochran.model.DecisionLinesEvent;

/**
 * This class is a specific type of JPanel which is where the Lines and Edges are drawn.
 * @author Nigel Cochran
 *
 */
public class LinesPanel extends JPanel {

	DecisionLinesEvent event;
	DecisionLinesGUI gui;
	int numLines;
	int spacing;
	int offset;
	Dimension size;

	/**
	 * This method creates a LinesPanel with both a DecisionLinesEvent and a DecisionLinesGUI.
	 * @param event DecisionLinesEvent The DecisionLinesEvent which contains the Lines and Edges
	 * @param gui DecisionLinesGUI The DecisionLinesGUI which displays the information
	 */
	public LinesPanel(DecisionLinesEvent event, DecisionLinesGUI gui) {
		this.event = event;
		this.gui = gui;
		this.size = gui.getSizeLines();
		calculateSpacing();
	}

	/**
	 * This method calculates the spacing between Lines.
	 * It calculates the width by taking in the width of the panel and equally dividing that width by the number of
	 * choices. It then adds an offset to center the lines.
	 */
	void calculateSpacing() {

		numLines = event.getNumChoices();
		spacing = size.width / numLines;
		offset = spacing / 2;
		for (int i = 0; i < numLines; i++) {
			event.addLine(new Line(offset + spacing * i));
		}
	}

	/**
	 * This method draws the Lines and Edges.
	 * Lines are drawn based upon their horizontal position (xPosition) and the length of the panel.
	 * Edges are drawn based upon their Line end points and vertical position (height)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < numLines; i++) {
			// g.drawLine(offset + spacing*(i), 0, offset + spacing*(i),
			// size.height);
			g.drawLine(event.getLine(i).getxPosition(), 0, event.getLine(i)
					.getxPosition(), size.height);
		}

		if (event.getEdges() != null) {
			for (int i = 0; i < event.getEdges().size(); i++) {
				 g.drawLine(event.getEdge(i).getLeftLine().getxPosition(),
				 event.getEdge(i).getHeight(),
				 event.getEdge(i).getRightLine().getxPosition(),
				 event.getEdge(i).getHeight());
			}
		}
	}

}

package jpizz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jpizz.model.DecisionLinesEvent;
import jpizz.view.MainGUI;

/**
 * The class represents the controller to calculate the results of the DecisionLines Event
 * @author jpizz
 *
 */
public class CalculateResultsController implements ActionListener{

	/** The model object */
	DecisionLinesEvent event;
	/** The boundary object */
	MainGUI app;
	
	/**
	 * Constructs an CalculateResultsController for a given event, e, and MainGUI, a
	 * @param e the DecisionLinesEvent for the controller
	 * @param a the MainGUI for the controller
	 */
	public CalculateResultsController(DecisionLinesEvent e, MainGUI a) {
		event = e;
		app = a;
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		app.getButton().setVisible(false);
		String[] results = new String[event.getNumChoices()];
		int startLine; int finishLine; int currentLine;
		for (int i = 0; i < event.getNumChoices(); i++){
			startLine = i;
			currentLine = startLine;
			for (int height = app.getLinesPanel().getTopOfLinesPos(); height <= app.getLinesPanel().getBottomOfLinesPos(); height++){
				int found = 0;
				for (int j = 0; ((j < event.getLines()[currentLine].getEdges().size())&&(found == 0)); j++){
					if (event.getLines()[currentLine].getEdges().get(j).getHeight() == height){
						if (event.getLines()[currentLine].getEdges().get(j).getLeft() == currentLine){
							currentLine = event.getLines()[currentLine].getEdges().get(j).getRight();
							found = 1;
						}else if (event.getLines()[currentLine].getEdges().get(j).getRight() == currentLine){
							currentLine = event.getLines()[currentLine].getEdges().get(j).getLeft();
							found = 1;
						}
					}
				}
			}
			finishLine = currentLine;
			results[finishLine] = event.getLines()[startLine].getChoice();
		}
		
		String resultsString = "Results!    ";
		int num;
		for (int i = 0; i < event.getNumChoices(); i++){
			num = i+1;
			resultsString = resultsString + num +": " + results[i] + "   ";
		}
		System.out.println(resultsString);
		app.getMessageText().setText(resultsString);
	}
}

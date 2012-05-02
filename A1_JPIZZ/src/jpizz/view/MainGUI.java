package jpizz.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import jpizz.controller.AddEdgesController;
import jpizz.controller.ChoiceController;
import jpizz.controller.StartRoundsController;
import jpizz.model.DecisionLinesEvent;

/**
 * This class represents the main GUI for the decision lines event, which contains the text boxes for the choices and the lines
 * @author jpizz
 *
 */
public class MainGUI extends JFrame{

	DecisionLinesEvent event;
	JPanel contentPane;
	JPanel choicePanel;
	LinesCanvas linesPanel;
	JPanel resultsPanel;
	JTextField[] choices;
	JButton button;
	JLabel messageText;

	/**
	 * Create the frame for the given event
	 * @param e Decision Lines event displayed in GUI
	 */
	public MainGUI(DecisionLinesEvent e) {
		this.event = e;
		
		setTitle("Decision Lines");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, ((event.getNumChoices()*97)+80), 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		choicePanel = new JPanel();
		contentPane.add(choicePanel, BorderLayout.NORTH);
		choices = new JTextField[event.getNumChoices()];
		for (int i=0; i<event.getNumChoices(); i++){
			choices[i] = new JTextField();
			choicePanel.add(choices[i]);
			choices[i].setColumns(8);
			choices[i].addActionListener(new ChoiceController(i, event, MainGUI.this));
		}
		
		linesPanel = new LinesCanvas(event);
		contentPane.add(linesPanel, BorderLayout.CENTER);
		
		resultsPanel = new JPanel();
		button = new JButton("A Button!");
		button.setVisible(false);
		button.addActionListener(new StartRoundsController(event, MainGUI.this));
		resultsPanel.add(button);
		messageText = new JLabel("Welcome to DecisionLines! Start entering choices above.");
		resultsPanel.add(messageText);
		contentPane.add(resultsPanel, BorderLayout.SOUTH);
		
		linesPanel.repaint();

	}

	/**
	 * Getter for the LinesCanvas containing the drawing of the lines and edges
	 * @return LinesCanvas for lines and edge
	 */
	public LinesCanvas getLinesPanel() {
		return linesPanel;
	}

	/**
	 * Getter for the array of JTextFields containing the texts for the choices
	 * @return array of JTextFields for all choices
	 */
	public JTextField[] getChoices() {
		return choices;
	}

	/**
	 * Getter for the button on the results panel at the bottom of the window
	 * @return JButton for starting rounds
	 */
	public JButton getButton() {
		return button;
	}

	/**
	 * Getter for the JLabel for messages in the results panel at the bottom of the window
	 * @return JLabel for user messages
	 */
	public JLabel getMessageText() {
		return messageText;
	}
	
	
}

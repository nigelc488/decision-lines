package jpizz;

import java.util.Scanner;

import jpizz.model.DecisionLinesEvent;
import jpizz.view.MainGUI;

/**
 * The class contains the main method to launch the application
 * @author jpizz
 *
 */
public class Main {
	/**
	 * Main method to start the application
	 */
	public static void main(String[] args) {
		
		int r = consoleScan("rounds");
        int c = consoleScan("choices");

        //launch the GUI
		MainGUI app = new MainGUI(new DecisionLinesEvent(r, c));
		app.setVisible(true);
	}
	
	public static int consoleScan(String prompt){
		Scanner sc = new Scanner (System.in);
        String s = "";
        
        int r = 0;
        while (r == 0) {
            try {
        		System.out.println("Enter the number of "+prompt+" [3-8]:");
            	s = sc.nextLine();
                r = Integer.valueOf(s);
                if (r<3 || r>8){
                	r = 0;
                	System.out.println("The number of "+prompt+" must be from 3-8");
                }
            } catch (Exception e) {
                System.out.println (s + " is an invalid integer.");
            }
        }
        return r;
	}

}

package lab02;

import java.awt.event.ActionEvent;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/** DialogViewer.java
 * 
 * - command line argument entered by user determines dialog type (aka in console user enters)
 * f : displays instance of JFileChooser, if user chooses files displays name of file & message
 * c: display confirm dialog with message "Are you sure?" & after dismissed dsiplays button type user pressed
 * m: display a message dialog with name in box
 * 
 * 
 * @author Allen Jagoda java lab02
 *
 */

public class DialogViewer extends JFrame{
		
	public static void main(String[] args) {
		
		new DialogViewer().run();
		

	}//main method
	
	public void run() throws InputMismatchException{
		
		Scanner s = new Scanner(System.in);//scanner for user input
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);

	    
		//display message requesting input
		System.out.println("Enter f, c, or m: ");
		String entry = s.next();	
		if (entry.equals("f"))
			openFileMessage();
		else if (entry.equals("c"))
			displayAreYouSure();
		else if (entry.equals("m"))
			displayMyName();
		else
			System.out.println("Incorrect input value!");
		
	}//run method
	
	/** GUI for opening file message created
	 * 
	 */
	public void openFileMessage(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showOpenDialog(fileChooser);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	String opened = "You chose to open this file: " +
		    		   fileChooser.getSelectedFile().getName();
	       System.out.println(opened);
	    }
	    
	    JOptionPane.showMessageDialog(null, "Opened this file: " + fileChooser.getSelectedFile().getName());

    }//when user enters f in console
	
	public void displayAreYouSure(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
				
		Object[] options = {"Cancel", "No", "Yes"};
		int choice = JOptionPane.showOptionDialog(null, "Are you sure?\n\n", "",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		switch (choice){
			case JOptionPane.CANCEL_OPTION: System.out.println("You chose Yes");
				break;
			case JOptionPane.NO_OPTION: 
				System.out.println("You chose No");
				break;
			case JOptionPane.YES_OPTION:
				System.out.println("You chose Cancel");
				break;
			default:
				System.out.println("You did not choose an option");
				break;
		}			
	    
	}//when user enters c
	
	public void displayMyName(){
		JOptionPane.showMessageDialog(null, "Allen Jagoda");
	}//when user enters m

	/** an action performed by user
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		
	} 

		 
}

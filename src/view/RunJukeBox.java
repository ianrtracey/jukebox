/*=============================================================================
 |   Assignment:  Project 4 : Cashless Jukebox Iteration 2
 |      Authors:  Ian Tracey and Steven Eiselen
 |
 |       Course:  CSC 335
 |   Instructor:  Rick Mercer
 |     Due Date:  10/5/15 10:00PM MST
 |
 |  Description:  Implements the JukeBox via the spec. 
 |
 |     Language:  Java 8 (Because of Time Imports / Tools)
 |                
 | Deficiencies:  None. This program operates in accordance to specification
 *===========================================================================*/
package view;

import java.io.File;

import javax.swing.JOptionPane;

import model.JukeBox;

public class RunJukeBox {
	public static void main(String[] args) {
		String dataDir = System.getProperty("user.dir")
		  	      + System.getProperty("file.separator") + "data"
		  	      + System.getProperty("file.separator");
		
		boolean dataLoad = false;
		File data = new File(dataDir);
		if (data.list().length > 0)  {
			int dialogButtons = JOptionPane.YES_NO_OPTION;
			int decision = JOptionPane.showConfirmDialog(null,"Do you want to load the saved data?", "Load Data",  dialogButtons);
			if (decision == JOptionPane.YES_OPTION) {
				dataLoad = true;
			} else {
				dataLoad = false;
			}
		}
		JukeBox jukeBox = new JukeBox(dataLoad);
				
		GUIManager gui = new GUIManager(jukeBox);
		gui.setVisible(true);
	} // Ends Main Method
} // Ends Class RunJukeBox
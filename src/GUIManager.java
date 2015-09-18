import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.ArrayList;
import java.util.Collections;

import java.awt.color.*;

public class GUIManager extends JFrame {
		
	//private ArrayList<String> songs = 
	
	private JLabel headerMessage = new JLabel("Select a Song from this Jukebox!!!");
	
	private DefaultListModel<String> availableSongs;
	
	public GUIManager(SongCollection allSongs){
		
		//this.songLib = allSongs;

		setUpWindow();
		

		
	}
	
	
	private void setUpWindow(){
		
		this.setSize(600, 600);
		
		headerMessage.setForeground(Color.BLUE);
		headerMessage.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(headerMessage, BorderLayout.NORTH);
		
	}
	
	private void setUpVisibleSongList(){
		
		//for(Song s : songLib){
			
			
			
		//}
		
		
		
		
	}
	
	
	

}

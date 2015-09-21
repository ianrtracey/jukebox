package model;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class GUIManager extends JFrame {
	
	public static void main(String[] args) {
		SongCollection allSongs = new SongCollection();
		GUIManager GUI = new GUIManager(allSongs);
		GUI.setVisible(true);
	} // Ends Main
			
	private JLabel headerMessage = new JLabel("Select a Song from this Jukebox!!!");
	private JTable myTable;
	
	public GUIManager(SongCollection allSongs){	
		setUpTable(allSongs);
		setUpWindow();
	} // Ends Constructor
	
	private void setUpTable(SongCollection songs){
		String[] colNames = {"Artist" , "Title" , "Seconds"};
		int listSize = songs.getSize();
		HashMap<String, Song> yolo = songs.songs;
		Set<Entry<String, Song>> mySet = yolo.entrySet();
		String info[][] = new String[listSize][3]; 
		
		int i = 0;
		for ( Entry<String, Song> e : mySet){
			Song s = e.getValue();
			info[i][0] = s.getArtist();
			info[i][1] = s.getTitle();
			info[i][2] = "" + s.getDurationOfSong();
			i++;
		}
		myTable = new JTable(info, colNames);
	} // Ends Method setUpTable
	
	private void setUpWindow(){
		this.setSize(600, 600);
		headerMessage.setForeground(Color.BLUE);
		headerMessage.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(headerMessage, BorderLayout.NORTH);
		this.add(new JScrollPane(myTable));
	} // Ends Method setUpWindow
	

} // Ends Class GUIManager

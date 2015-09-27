package model;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
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
	private SongDisplayList mySongList;
	private JScrollPane myScrollPane;
	
	public GUIManager(SongCollection allSongs){	
		setUpGUI(allSongs);
	} // Ends Constructor
		
	private void setUpGUI(SongCollection songs){
		// Set Window Sizes
		this.setSize(600, 540);
		this.setLocation(120, 60);
		// Set Closing Process
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set up the Header
		headerMessage.setForeground(Color.BLUE);
		headerMessage.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(headerMessage, BorderLayout.NORTH);
		// Set up the model, the table, the scrollpane and add it!
		mySongList = new SongDisplayList(songs);
		myTable = new JTable(mySongList);
		myScrollPane = new JScrollPane(myTable);
		this.add(myScrollPane);
	} // Ends Method setUpGUI
	
} // Ends Class GUIManager

class SongDisplayList implements TableModel{
	
	private ArrayList<Song> allSongs = new ArrayList<Song>(); // holds the songList in ArrayList Form
	
	public SongDisplayList(SongCollection songs) {
		setUpList(songs);
	} // Ends Constructor
	
	private void setUpList(SongCollection songs){
		HashMap<String, Song> yolo = songs.songs;
		Set<Entry<String, Song>> mySet = yolo.entrySet();

		int i = 0;
		for ( Entry<String, Song> e : mySet){
			allSongs.add(e.getValue());
		}
	} // Ends Method setUpTable
	
	@Override
	public int getRowCount() {
		return allSongs.size();
	} // Ends Method getRowCount
	
	@Override
	public int getColumnCount() {
		return 3;
	} // Ends Method getColumnCount
	
	@Override
	public String getColumnName(int colNum) {
		switch(colNum){
		case 0:	return "Artist";
		case 1: return "Title";
		case 2: return "Seconds";
		default: return "ERROR";
		}
	} // Ends Method getColumnName
	
	@Override
	public Class<?> getColumnClass(int colNum) {
		switch(colNum){
		case 0:	return String.class;
		case 1: return String.class;
		case 2: return Integer.class;
		default: return Object.class;
		}
	} // Ends Method getColumnClass
	
	@Override
	public Object getValueAt(int r, int c) {
		Song aSong = allSongs.get(r);
		switch(c){
		case 0:	return aSong.getArtist();
		case 1: return aSong.getTitle();
		case 2: return aSong.getDurationOfSong();
		default: return "ERROR";
		}
	} // Ends Method getValueAt
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}
} // Ends Class SongDisplayList

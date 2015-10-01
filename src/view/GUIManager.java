/*+----------------------------------------------------------------------
 ||
 ||  Class GUIManager
 ||
 ||        Purpose:  Manages the UI for a Jukebox window displaying a list
 ||                  of songs from a SongCollection Object
 ||
 ||  Inherits From:  JFrame
 ||
 ||     Interfaces:  Subclass SongDisplayList implements TableModel
 ||
 |+-----------------------------------------------------------------------
 ||
 ||        Methods: public static void main(String[] args)
 ||                 public GUIManager(SongCollection allSongs)
 ||					private void setUpGUI(SongCollection songs)
 ||
 ++-----------------------------------------------------------------------*/
package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.JukeBox;
import model.PlayList;
import model.Song;
import model.SongCollection;
import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class GUIManager extends JFrame {
	
	// Main Method to render the GUI
	public static void main(String[] args) {
//		SongCollection allSongs = new SongCollection();
//		GUIManager GUI = new GUIManager(allSongs);
//		GUI.setVisible(true);
	} // Ends Main
			
	// Class Objects / State
	private JLabel headerMessage;
	private JTable myTable;
	private SongDisplayList mySongList;
	private JScrollPane myScrollPane;
	private JButton addToPlayQueueButton;
	private JScrollPane playQueue;
	private JukeBox jukeBox = new JukeBox();
	
	public GUIManager(SongCollection allSongs, Student user){
		setUpGUI(allSongs, user);
		registerListeners();
	} // Ends Constructor
		
	private void setUpGUI(SongCollection songs, Student user){
		// Set Window Sizes
		this.setSize(600, 540);
		this.setLocation(120, 60);
		// Set Closing Process
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		// Set up the Header
		headerMessage= new JLabel("Welcome, " + user.getId());
		headerMessage.setForeground(Color.BLUE);
		headerMessage.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(headerMessage, BorderLayout.NORTH);
		
		// Set up the model, the table, the scrollpane and add it!
		mySongList = new SongDisplayList(songs);
		myTable = new JTable(mySongList);
		myScrollPane = new JScrollPane(myTable);
		playQueue = new JScrollPane(new JTable( new PlayQueueModel(jukeBox.getPlayList())) );
		this.add(myScrollPane, BorderLayout.EAST);
		this.add(playQueue,    BorderLayout.WEST);
		addToPlayQueueButton = new JButton("Add To Play Queue");
		this.getContentPane().add(addToPlayQueueButton, BorderLayout.SOUTH);
//		this.add(addToPlaylist);
		
	} // Ends Method setUpGUI
	
	private void registerListeners() {
		
		addToPlayQueueButton.addActionListener(new AddToPlayQueueButtonListener());
		
	}
	
	private class AddToPlayQueueButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println( myTable.getSelectedRow() );
			System.out.println( myTable.getSelectedColumns()[1] );
		}
		
	}
	
	
} // Ends Class GUIManager

/*+----------------------------------------------------------------------
||
||  Class SongDisplayList
||
||        Purpose:	Creates a TableModel interface implementation for use
||                  with the Jukebox
||
||     Interfaces:  Implements TableModel
||
|+-----------------------------------------------------------------------
||
||        Methods:  public SongDisplayList(SongCollection songs)
||                  private void setUpList(SongCollection songs)
||                  public int getRowCount()
||                  public int getColumnCount()
||                  public String getColumnName(int colNum)
||                  public Class<?> getColumnClass(int colNum)
||					public Object getValueAt(int r, int c)
||					public void addTableModelListener(TableModelListener arg0)
||					public boolean isCellEditable(int arg0, int arg1)
||					public void removeTableModelListener(TableModelListener arg0)
||					public void setValueAt(Object arg0, int arg1, int arg2)
++-----------------------------------------------------------------------*/
class SongDisplayList implements TableModel{
	// Will hold the songList in ArrayList Form
	private ArrayList<Song> allSongs = new ArrayList<Song>();
	
	public SongDisplayList(SongCollection songs) {
		setUpList(songs); // set up the song list
	} // Ends Constructor
	
	private void setUpList(SongCollection songs){
		HashMap<String, Song> yolo = songs.getSongsMap(); // Get the Hash Map
		Set<Entry<String, Song>> mySet = yolo.entrySet(); // Get the entries

		// For each entry, get the song and append to the songs ArrayList
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




class PlayQueueModel implements TableModel {
	
	private ArrayList<Song> playQueueSongs;
	
	public PlayQueueModel(ArrayList<Song> playQueueSongs) {
		
		this.playQueueSongs = playQueueSongs;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
}

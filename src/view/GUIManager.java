/*+----------------------------------------------------------------------
 ||
 ||  Class GUIManager
 ||
 ||        Purpose: Contains the View and Controllers for the Jukebox
 ||
 |+-----------------------------------------------------------------------
 ||
 ||        Methods: 	public GUIManager()
 ||						public void layoutGUI()
 ||						public JukeBox getJukeBox()
 ||						public void registerListeners()	
 ||
 ||    Sub Classes:
 ||						private class LoginButtonListener implements ActionListener
 ||						private class AddToPlayQueueButtonListener implements ActionListener
 ||
 ||						class SongDisplayList implements TableModel
 ||
 ++-----------------------------------------------------------------------*/
package view;
import model.JukeBox;
import model.Serializer;
import model.Song;
import model.SongCollection;
import model.Student;
import songplayer.ObjectWaitingForSongToEnd;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class GUIManager extends JFrame {
	
	//**********************************|
	// ---    OBJECT DECLARATIONS    ---|
	//**********************************|	
	private JukeBox myJukeBox = new JukeBox();
	
	//**********************************|
	// --- UI COMPONENT DECLARATIONS ---|
	//**********************************|
	private JPanel 			rootPanel;	
	private JPanel   		topPanelWithThe2SongLists;
	private JScrollPane 	queuedSongs;
	private JScrollPane 	allSongs;
	private SongDisplayList mySongList;
	private DefaultListModel<String> playQueueModel;
	private JList<String>	playQueue;
	private JTable          allSongsTable;
	RowSorter<TableModel> songSorter;
	private JPanel   		midPanelWithUserLoginAndQueueSong;
	private JLabel      	usernameLabel;
	private JTextField  	usernameField;
	private JLabel      	passwordLabel;
	private JTextField  	passwordField;
	private JButton     	queueSongButton;
	private JButton 		playButton;
	private JPanel   		bottomPanelWithUserInfoAndExitProgram;
	private JPanel      	userInfoSubPanel;
	private JPanel      	exitProgramSubPanel;
	private JButton    		loginLogout;
	private JLabel     	 	loggedInAsAndWelcome;
	private JLabel     	 	timeRemaining;
	private JLabel     	 	songsPlayedToday;

	boolean userIsLoggedIn;
	Student loggedInStudent;
	
	public GUIManager(){
		this.layoutGUI();
		this.registerListeners();
	} // Ends Constructor
	
	public void layoutGUI(){
		
		// Basic settings for entire JFrame
		this.setSize(720, 420);
		this.setLocation(300, 100);
		this.setTitle("Super Turbo Jukebox 4 !!!");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener( new JukeBoxWindowClosing());
		
		// Settings for song lists panel
		playQueueModel = new DefaultListModel<String>();
		if (myJukeBox.getPlaylist().getSize() > 0) {
			for (Song playQueueSong : myJukeBox.getPlaylist().getPlayQueue()) {
				playQueueModel.addElement(playQueueSong.toString());
			}
		}
		playQueue = new JList<String>(playQueueModel);
		queuedSongs = new JScrollPane(playQueue);
		queuedSongs.setPreferredSize(new Dimension(360, 300));
		mySongList = new SongDisplayList(myJukeBox.getSongCollection());
		allSongsTable = new JTable(mySongList);
		allSongs = new JScrollPane(allSongsTable);
		songSorter = new TableRowSorter<TableModel>(mySongList);
		allSongsTable.setRowSorter(songSorter);
		allSongs.setPreferredSize(new Dimension(360, 300));
		topPanelWithThe2SongLists = new JPanel(new GridLayout(1, 2));
		topPanelWithThe2SongLists.add(queuedSongs);
		topPanelWithThe2SongLists.add(allSongs);
				
		// Settings for the user login panel
		usernameLabel = new JLabel("User name");
		usernameField = new JTextField(5);
		passwordLabel = new JLabel("Password");
		passwordField = new JTextField(5);
		loginLogout   = new JButton("Login");
		queueSongButton = new JButton("Add");
		midPanelWithUserLoginAndQueueSong = new JPanel();
		midPanelWithUserLoginAndQueueSong.setLayout(new FlowLayout(FlowLayout.LEFT));
		midPanelWithUserLoginAndQueueSong.add(usernameLabel);
		midPanelWithUserLoginAndQueueSong.add(usernameField);
		midPanelWithUserLoginAndQueueSong.add(passwordLabel);
		midPanelWithUserLoginAndQueueSong.add(passwordField);
		midPanelWithUserLoginAndQueueSong.add(loginLogout);
		midPanelWithUserLoginAndQueueSong.add(new JLabel("                                                                           "));
		midPanelWithUserLoginAndQueueSong.add(queueSongButton);
		playButton = new JButton("Play");
		midPanelWithUserLoginAndQueueSong.add(playButton);
		
		// Settings for user info / exit
		userInfoSubPanel = new JPanel(new GridLayout(3, 1));
		loggedInAsAndWelcome = new JLabel("   No Student currently logged in");
		timeRemaining = new JLabel("   1500 free minutes per student!");
		songsPlayedToday = new JLabel("   Student can play 3 songs a day!");
		userInfoSubPanel.add(loggedInAsAndWelcome);
		userInfoSubPanel.add(timeRemaining);
		userInfoSubPanel.add(songsPlayedToday);
		exitProgramSubPanel = new JPanel(new BorderLayout());
		bottomPanelWithUserInfoAndExitProgram = new JPanel();
		bottomPanelWithUserInfoAndExitProgram.setLayout(new BorderLayout());
		bottomPanelWithUserInfoAndExitProgram.add(userInfoSubPanel, BorderLayout.WEST);
		bottomPanelWithUserInfoAndExitProgram.add(exitProgramSubPanel, BorderLayout.EAST);

		// Settings for the final root panel containing all the above
		rootPanel = new JPanel(new BorderLayout() );
		rootPanel.add(topPanelWithThe2SongLists, BorderLayout.NORTH);
		rootPanel.add(midPanelWithUserLoginAndQueueSong, BorderLayout.CENTER);
		rootPanel.add(bottomPanelWithUserInfoAndExitProgram, BorderLayout.SOUTH);
		this.add(rootPanel);	
	} // Ends Method LayoutGUI
	
	public JukeBox getJukeBox() {
		return myJukeBox;
	} // Ends Method getJukeBox
	
	public void registerListeners(){	
		loginLogout.addActionListener( new LoginButtonListener() );
		queueSongButton.addActionListener(new AddToPlayQueueButtonListener());
		playButton.addActionListener(new PlayJukeBoxButtonListener() );
		ObjectWaitingForSongToEnd waiter = new ObjectWaitingForSongToEnd(myJukeBox.getPlaylist());
		waiter.registerJList(playQueueModel);
		myJukeBox.getPlaylist().registerWaiter(waiter);
		waiter.registerPlayButton(playButton);
	} // Ends Method registerListeners
		
	private class LoginButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {		
			if(loginLogout.getText().equals("Logout")){
				loggedInStudent = null;
				loginLogout.setText("Login");
				loggedInAsAndWelcome.setText("   No Student currently logged in");
				timeRemaining.setText("   1500 free minutes per student!");
				songsPlayedToday.setText("   Student can play 3 songs a day!");
				return;
			}
			
			String username  = usernameField.getText();
			String password  = passwordField.getText();
			usernameField.setText("");
			passwordField.setText("");
			
			boolean success = myJukeBox.login(username, password);
			
			if (success)  {
				loggedInStudent = myJukeBox.getStudentCollection().get(username);
				
				int secsTemp = loggedInStudent.getLifetimeSecondsRemaining();
				int minsTemp = secsTemp / 60;
				secsTemp = secsTemp % 60;
				
				loggedInAsAndWelcome.setText("   Welcome to the Jukebox " + username + "!!!");
				
				timeRemaining.setText("   Your Time Remaining: " + minsTemp + " Minutes, " + secsTemp + " Seconds");
				
				int songPlaysTemp = 3 - loggedInStudent.getNumOfSongsPlayedToday();
				
				songsPlayedToday.setText("   You can play " + songPlaysTemp + " more songs today" );
	
				loginLogout.setText("Logout");
				
			} else {
				JOptionPane.showMessageDialog(null, "username or password incorrect", "Incorrect Login", JOptionPane.ERROR_MESSAGE);
				loggedInStudent = null;
				loggedInAsAndWelcome.setText  ("   No Student currently logged in");
				timeRemaining.setText         ("   1500 free minutes per student!");
				songsPlayedToday.setText      ("   Student can play 3 songs a day!");
			}
		}
	} // Ends Private SubClass LoginButtonListener
	
	private class AddToPlayQueueButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(loggedInStudent == null){
				JOptionPane.showMessageDialog(null, "Not Logged In!", "Please login", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// The try catch handles the user not selecting a song, usually on first login
			Song songToAddToPlayQueue;
			try{
				songToAddToPlayQueue = mySongList.get(allSongsTable.convertRowIndexToModel(allSongsTable.getSelectedRow()));
			}catch(Exception ex) {
				return;
			}

			if (loggedInStudent.canPlaySong(songToAddToPlayQueue.getDurationOfSong())) {
				if (songToAddToPlayQueue.canPlay()) {
				loggedInStudent.selectSong(songToAddToPlayQueue);
				songToAddToPlayQueue.selectSong();
				playQueueModel.addElement(songToAddToPlayQueue.toString());
				myJukeBox.queue(songToAddToPlayQueue);				
				timeRemaining.setText("Minutes: "+ Integer.toString(loggedInStudent.getLifetimeSecondsRemaining() / 60) + " " +
					   "Seconds: "+ Integer.toString(loggedInStudent.getLifetimeSecondsRemaining() % 60));
				songsPlayedToday.setText("Songs Played Today: " + Integer.toString(loggedInStudent.getNumOfSongsPlayedToday()));
				} else {
					JOptionPane.showMessageDialog(null, "This song has been played 3 times today", "Song Unavailable", JOptionPane.ERROR_MESSAGE);

				}	
			} else {
				JOptionPane.showMessageDialog(null, "You cannot play anymore songs today", "Your Limit has been Reached", JOptionPane.ERROR_MESSAGE);
			}
		}
	} // Ends Private SubClass AddToPlayQueueButtonListener
	
	private class PlayJukeBoxButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(myJukeBox.getPlaylist().getSize()==0){return;}	
			playButton.setEnabled(false);	
			myJukeBox.getPlaylist().play();	
		}	
	} // Ends Private SubClass PlayJukeBoxButtonListener
	
	public class JukeBoxWindowClosing implements WindowListener {
		@Override
		public void windowClosing(WindowEvent e) {			
			int dialogButtons = JOptionPane.YES_NO_CANCEL_OPTION;
			int decision = JOptionPane.showConfirmDialog(null,"Do you want to save your data?", "Save Data",  dialogButtons);
			if (decision == JOptionPane.YES_OPTION) {
				Serializer.serializePlayQueue(myJukeBox.getPlaylist());
				Serializer.serializeStudentCollection(myJukeBox.getStudentCollection());
				Serializer.serializeSongCollection(myJukeBox.getSongCollection());
				setVisible(false); 
				dispose(); 			
			} else if (decision == JOptionPane.NO_OPTION) {			
				setVisible(false); 
				dispose(); 	
			} else {		
				// do nothing if cancel
			}
		}
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub		
		}
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub		
		}
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub		
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub	
		}	
	} // Ends Private SubClass JukeBoxWindowClosing 
} // Ends Class NewGUIManager

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
	
	public Song get(int row) {
		return allSongs.get(row);
	}
	
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

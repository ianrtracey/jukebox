package view;
import model.JukeBox;
import model.SongCollection;
import model.Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
import javax.swing.ListModel;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.Border;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






public class NewGUIManager extends JFrame {
	
	public static void main(String[] args) {
		NewGUIManager TEMPGUI = new NewGUIManager();
		TEMPGUI.setVisible(true);
	}
	
	//**********************************|
	// ---    OBJECT DECLARATIONS    ---|
	//**********************************|	
	private JukeBox myJukeBox = new JukeBox();
	
	
	
	
	
	
	//**********************************|
	// --- UI COMPONENT DECLARATIONS ---|
	//**********************************|
	
	private JPanel rootPanel;
		
	private JPanel   topPanelWithThe2SongLists;
	private JScrollPane queuedSongs;
	private JScrollPane allSongs;
	
	private JPanel   midPanelWithUserLoginAndQueueSong;
	private JLabel      usernameLabel;
	private JTextField  usernameField;
	private JLabel      passwordLabel;
	private JTextField  passwordField;
	private JButton     queueSong;	
	
	private JPanel   bottomPanelWithUserInfoAndExitProgram;
	private JPanel      userInfoSubPanel;
	private JPanel      exitProgramSubPanel;
	private JButton     loginLogout;
	private JButton     exitProgram;
	private JLabel      loggedInAsAndWelcome;
	private JLabel      timeRemaining;
	private JLabel      songsPlayedToday;
	
	boolean userIsLoggedIn;
	Student loggedInStudent;
	
	public NewGUIManager(){
		this.layoutGUI();
		this.registerListeners();
	}
	
	public void layoutGUI(){
		
		// Basic settings for entire JFrame
		this.setSize(600, 420);
		this.setLocation(300, 100);
		this.setTitle("Super Turbo Jukebox 4 !!!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Settings for song lists panel
		queuedSongs = new JScrollPane();
		queuedSongs.setPreferredSize(new Dimension(300, 300));
		allSongs = new JScrollPane();
		allSongs.setPreferredSize(new Dimension(300, 300));
		topPanelWithThe2SongLists = new JPanel(new BorderLayout());
		topPanelWithThe2SongLists.add(queuedSongs, BorderLayout.WEST);
		topPanelWithThe2SongLists.add(allSongs, BorderLayout.EAST);
				
		// Settings for the user login panel
		usernameLabel = new JLabel("User name");
		usernameField = new JTextField(5);
		passwordLabel = new JLabel("Password");
		passwordField = new JTextField(5);
		loginLogout   = new JButton("Login");
		queueSong = new JButton("Add Song to Queue");
		midPanelWithUserLoginAndQueueSong = new JPanel();
		midPanelWithUserLoginAndQueueSong.setLayout(new FlowLayout(FlowLayout.LEFT));
		midPanelWithUserLoginAndQueueSong.add(usernameLabel);
		midPanelWithUserLoginAndQueueSong.add(usernameField);
		midPanelWithUserLoginAndQueueSong.add(passwordLabel);
		midPanelWithUserLoginAndQueueSong.add(passwordField);
		midPanelWithUserLoginAndQueueSong.add(loginLogout);
		midPanelWithUserLoginAndQueueSong.add(new JLabel("                             "));
		midPanelWithUserLoginAndQueueSong.add(queueSong);
		
		// Settings for user info / exit
		userInfoSubPanel = new JPanel(new GridLayout(3, 1));
		loggedInAsAndWelcome = new JLabel("   No Student currently logged in");
		timeRemaining = new JLabel("   1500 free minutes per student!");
		songsPlayedToday = new JLabel("   Student can play 3 songs a day!");
		userInfoSubPanel.add(loggedInAsAndWelcome);
		userInfoSubPanel.add(timeRemaining);
		userInfoSubPanel.add(songsPlayedToday);
		exitProgram = new JButton("Exit Jukebox Program");
		exitProgramSubPanel = new JPanel(new BorderLayout());
		exitProgramSubPanel.add(exitProgram, BorderLayout.SOUTH);
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
	
	public void registerListeners(){
		
		loginLogout.addActionListener( new LoginButtonListener() );
		
		
	} // Ends Method registerListeners
	
	
	
	
	
	private class LoginButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
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
	
				//new GUIManager(new SongCollection(), loggedInStudent).setVisible(true);
				
			} else {
				JOptionPane.showMessageDialog(null, "username or password incorrect", "Incorrect Login", JOptionPane.ERROR_MESSAGE);
				loggedInStudent = null;
				loggedInAsAndWelcome.setText  ("   No Student currently logged in");
				timeRemaining.setText         ("   1500 free minutes per student!");
				songsPlayedToday.setText      ("   Student can play 3 songs a day!");
			}
			
		}
		

	} // Ends Private SubClass LoginButtonListener

	
	
	
	
	
	
	
	

} // Ends Class NewGUIManager
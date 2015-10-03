package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.JukeBox;
import model.SongCollection;
import model.Student;

public class GUILogin extends JFrame {
	
	private JTextField usernameField;
	private JTextField passwordField;
	private JButton    loginButton;
	private JukeBox jukeBoxModel = new JukeBox();
	
	public static void main(String[] args) {
	  new GUILogin().setVisible(true);
	}
	
	public GUILogin() {
		
		layoutGUI();
		registerListeners();

	}
	
	private void layoutGUI() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setLocation(300,300);
		
		JPanel pane = new JPanel(new FlowLayout());
		add(pane);
		
		pane.add(new JLabel("Username", JLabel.LEFT));
		usernameField = new JTextField(5);
		pane.add(usernameField);
		pane.add(new JLabel("Username", JLabel.LEFT));
		passwordField = new JTextField(5);
		pane.add(passwordField);
		
		loginButton = new JButton("Login");
		pane.add(loginButton);
		
		
	}
	
	private void registerListeners() {
		
		loginButton.addActionListener( new LoginButtonListener() );
		
	}
	
	private class LoginButtonListener implements ActionListener {
		
		LoginButtonListener() {}

		@Override
		public void actionPerformed(ActionEvent e) {
			String username  = usernameField.getText();
			String password  = passwordField.getText();
			usernameField.setText("");
			passwordField.setText("");
			
			boolean success = jukeBoxModel.login(username, password);
			
			if (success)  {
				Student user = jukeBoxModel.getStudentCollection().get(username);
				new GUIManager(new SongCollection(), user).setVisible(true);
				
			} else {
			JOptionPane.showMessageDialog(null, "username or password incorrect", "Incorrect Login", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		

	} // Ends Private SubClass LoginButtonListener

}

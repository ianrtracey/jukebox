
/** 
 * This class implements ActionListener twice 
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FtoCGUI extends JFrame {

  public static void main(String[] args) {
    JFrame window = new FtoCGUI();
    window.setVisible(true);
  }

  private JLabel prompt = new JLabel("  Fahrenheit?");
  private JTextField inputField = new JTextField(10);
  private JLabel outputLabel = new JLabel("Celcius");

  public FtoCGUI() {
    this.setSize(260, 60);
    this.setLocation(100, 50);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(1, 3));
    this.add(prompt);
    this.add(inputField);
    this.add(outputLabel);

    // TODO 3: add an ActionListener
    inputField.addActionListener(new FTextListener());
    
  }

  private int f2c(int f) {
    return (int) (5.0 / 9.0 * (f - 32));
  }

  // TODO 1: Add an inner class here that implements ActionListener
  public static class FTextListener implements ActionListener {
  	
  	public void actionPerformed() {
  		int far = Integer.parseInt(getText);
  	}
  }

  // TODO 2: Use getText, Integer.parseInt, and setText to get the C equivalent in outputLabel

}

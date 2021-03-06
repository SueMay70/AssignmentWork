import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

/**
 * User Interfaces - Checkpoint 5: Implementation
 * 
 * <p>
 * mainWindow.java
 * <p>
 * 
 * mainWindow is the main menu of the driverless car interface. It will link
 * to all other corresponding screens. The screens that should be linked
 * to from the main menu are:
 * <ul>
 * <li>screen 1</li>
 * </ul>
 * <p>
 * 
 * @author Sue Mayer, Michael Bird, Liam Murphy, Anthony Defazio, Sean Stach
 * @version 1.0
 * @date 12/10/2014
 */
public class DriverlessCar {

	/*
	 * Class member declarations
	 * Include all panel classes here
	*/
	
	// content pane
	private JPanel contentPane;
	
	// login screen
	private LoginScreen loginScreenPanel;
	
	// main menu
	private MainMenu mainMenuPanel;
	
	// menu bar - ie. date, time and a home button
	private JPanel statusBar;
	
	private void GUIdisplay(){
		
		// This is the window that all of our panes will be stored in
		JFrame frame = new JFrame("TEST MODE: Driverless Ambulance Interface v.1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		contentPane.setLayout(new CardLayout());
		
		
		
		// screen initializations
		loginScreenPanel = new LoginScreen(contentPane, this);
		mainMenuPanel = new MainMenu(contentPane,this);
		
		// add each screen to the contentPane
		contentPane.add(loginScreenPanel,  "Login");
		contentPane.add(mainMenuPanel, "Main Menu");
		
		
		
		// Create a time label that automatically updates
		final JLabel timeLabel = new JLabel();
		Font font = new Font("Arial", Font.BOLD, 24);
		timeLabel.setFont(font);
		final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		ActionListener timerListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Date date = new Date();
				String time = timeFormat.format(date);
				timeLabel.setText(time);
			}
		};
		Timer timer = new Timer(1000, timerListener);
		timer.setInitialDelay(0);
		timer.start();
		
		
		// create status(menu) bar and the time and any other icons to it
		statusBar = new JPanel();
		statusBar.add(timeLabel,BorderLayout.CENTER);

		
		
		frame.getContentPane().add(statusBar, BorderLayout.PAGE_START);
		frame.getContentPane().add(contentPane, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setSize(900,900);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	
	
	// main method
	public static void main(String[] args) {	
	SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new DriverlessCar().GUIdisplay();
			}
		});
	}
}


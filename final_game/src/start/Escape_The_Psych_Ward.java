package start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Core.GameManager;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

/**
 * Escape_The_Psych_Ward class
 */
public class Escape_The_Psych_Ward 
{
	// Using the singleton pattern in order to prevent the application from creating multiple Window Instances.
	private static final Escape_The_Psych_Ward windowInstance = new Escape_The_Psych_Ward();
	private static final GameManager Session = new GameManager();
	private static JFrame frmEscapeThePsych;
	private static JButton enterCommandButton;
	private static JTextField userInput;
	private static JTextArea logOutput;
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) 
	{		
		// Start Session
	}
	
	/**
	* Create the application.
	* @wbp.parser.entryPoint
	*/
	Escape_The_Psych_Ward() 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			@SuppressWarnings("static-access")
			public void run() 
			{
				try 
				{
					windowInstance.frmEscapeThePsych.setVisible(true);
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		// Initialize window objects.
		initialize();
		
		// Load / Define window events.
		loadEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmEscapeThePsych = new JFrame();
		frmEscapeThePsych.setTitle("Escape The Psych Ward");
		frmEscapeThePsych.setBounds(100, 100, 925, 550);
		frmEscapeThePsych.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		enterCommandButton = new JButton("Enter!");
		userInput = new JTextField();
		userInput.setColumns(10);
		logOutput = new JTextArea();
		logOutput.setFont(new Font("Monospaced", Font.PLAIN, 14));
		logOutput.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(frmEscapeThePsych.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(logOutput, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(userInput, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(enterCommandButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(logOutput, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(userInput)
						.addComponent(enterCommandButton, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(9))
		);
		frmEscapeThePsych.getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * Defines all of our gui Events.
	 */
	private void loadEvents()
	{
		// Events for the enterCommandButton (Simulates enter key)
		enterCommandButton.addActionListener(new ActionListener() 
		{	
			// Click event.
			public void actionPerformed(ActionEvent e) 
			{
				String uI = userInput.getText();
				Session.input(uI);
				userInput.setText("");
			}
		});
		
		// Events for the userInput text box.
		userInput.addKeyListener(new KeyAdapter() 
		{
			
			// Key released event.
			@Override
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					String uI = userInput.getText();
					Session.input(uI);
					userInput.setText("");
					// Debug text box.
					//JOptionPane.showMessageDialog(null, "Key Released", "Notice!", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
	}
	
	/**
	 * Prints a string to the console.
	 * @param s is the string.
	 */
	public static void iPrintLn (String s)
	{
		String startLog = logOutput.getText();
		
		// More object comparison using equals.
		logOutput.setText(!startLog.equals("") ? logOutput.getText() + '\n' + s : s);
	}
	
	/**
	 * Clears the entire log.
	 */
	public static void clearLn()
	{
		logOutput.setText("");
	}
}

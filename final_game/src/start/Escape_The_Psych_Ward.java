package start;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Escape_The_Psych_Ward 
{

	private JFrame frame;
	private JTextField textUserInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Escape_The_Psych_Ward window = new Escape_The_Psych_Ward();
					window.frame.setVisible(true);
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Escape_The_Psych_Ward() 
	{
		initialize();
		loadEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textUserInput = new JTextField();
		textUserInput.setColumns(10);
		
		JLabel titleLabel = new JLabel("Escaple The Psych Ward");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textUserInput, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(61)
							.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
							.addGap(56))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(159)
					.addComponent(textUserInput, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void loadEvents()
	{
		textUserInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				e.getActionCommand();
			}
		});
	}
}

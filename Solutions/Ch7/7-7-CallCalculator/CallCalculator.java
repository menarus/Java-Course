package call_calculator;

// Required imports for GUI objects
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Formatting of the output
import java.text.DecimalFormat;

/**
 * This class implements a GUI application that allows a user to calculate the cost of a telephone call.
 * This class demonstrates the ability to implement a basic GUI application, handle ActionEvents,and perform basic arithmetic.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class CallCalculator extends JFrame
{
	// Fields ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Panels to hold the two groups
	private JPanel radioChoice;
	private JPanel userInput;
	
	// Radio buttons and a button group
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private ButtonGroup radioButtonGroup;
	
	// User input content
	private JLabel prompt;
	private JTextField inputBox;
	private JButton calcButton;
	
	// Constants for pricing
	public final double DAY_RATE = 0.07;
	public final double EVE_RATE = 0.12;
	public final double OFF_RATE = 0.05;
	
	// Constructor ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * No-Arg constructor that creates the JFrame content
	 */
	public CallCalculator()
	{
		// Set the basic frame properties
		setTitle("Call Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// Create the panels to be added to the frame's content panel
		radioChoice = new JPanel();
		userInput = new JPanel();
		
		
		
		// Build the radioChoice panel///////////////////////////////////////////////////
		radioChoice.setLayout(new GridLayout(3, 1));
		radioChoice.setBorder(BorderFactory.createTitledBorder("Rate Category"));
		
		// Create the radio buttons and group them
		rb1 = new JRadioButton("Daytime (6:00 A.M. - 5:59 P.M.)", true); //default case
		rb2 = new JRadioButton("Evening (6:00 P.M. - 11:59 P.M.)");
		rb3 = new JRadioButton("Off-Peak (12:00 A.M. - 5:59 A.M.)");
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(rb1);
		radioButtonGroup.add(rb2);
		radioButtonGroup.add(rb3);
		
		// Add the radio buttons to the radioChoice panel
		radioChoice.add(rb1);
		radioChoice.add(rb2);
		radioChoice.add(rb3);
		
		// Add the completed radioChoice panel to the frame's content panel
		add(radioChoice);
		
		
		
		// Build the userInput panel/////////////////////////////////////////////////////
		userInput.setLayout(new GridLayout(3, 1));
		userInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		
		// Create the components of the panel
		prompt = new JLabel("-Enter the number of minutes-");
		inputBox = new JTextField();
		calcButton = new JButton("Calculate");
		
		// Register the actionEvent listener to calcButton
		calcButton.addActionListener(new calcListener());
		
		// Add the components to the userInput panel
		userInput.add(prompt);
		userInput.add(inputBox);
		userInput.add(calcButton);
		
		// Add the completed userInput panel to the frame's content panel
		add(userInput);
		
		// Auto size and make visible
		pack();
		setVisible(true);
	}
	
	/**
	 * Inner Class that implements ActionListener for use on the calculate button.
	 * @author Mohammad Al-Husseini
	 * @version 1.0.0
	 */
	public class calcListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			DecimalFormat formatter = new DecimalFormat("0.00");
			
			double total;
			double minutes;
			
			// Fetch text box data and verify non-empty
			if(inputBox.getText().isEmpty())
				minutes = 0;
			else
				minutes = Double.parseDouble(inputBox.getText());
			
			// Determine which radioButton is selected and calculate total
			if(rb1.isSelected())
			{
				total = minutes * DAY_RATE;
			}
			else if(rb2.isSelected())
			{
				total = minutes * EVE_RATE;
			}
			else if(rb3.isSelected())
			{
				total = minutes * OFF_RATE;
			}
			else // Shouldn't occur
			{
				total = 0;
			}
			
			// Display total to JOptionPane
			JOptionPane.showMessageDialog(null, "Your total is: $" + formatter.format(total) + ".\nThank you!");
		}
	}
}

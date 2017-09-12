package word_game;
import javax.swing.JOptionPane;

/**
 * This class creates a program that plays a word game using the JOptionPane Dialog Box.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class Main 
{
	/**
	 * The main method which serves as the program's starting point.
	 * @param args Default Parameter
	 */
	public static void main(String[] args) 
	{
		// Strings for user input from the Input Dialog
		String name, age, city, college, job, animal, pet;
		
		// Get User Input
		name = JOptionPane.showInputDialog("Enter a name.");
		age = JOptionPane.showInputDialog("Enter a numerical age between 1 and 99.");
		city = JOptionPane.showInputDialog("Enter a city.");
		college = JOptionPane.showInputDialog("Enter a college.");
		job = JOptionPane.showInputDialog("Enter a profession.");
		animal = JOptionPane.showInputDialog("Enter an animal.");
		pet = JOptionPane.showInputDialog("Enter a pet name.");

		// Validate and Format Input before performing Output
		if(isData(name) && isData(age) && isData(city) && isData(college) && isData(job) && isData(animal) && isData(pet))
		{
			// Convert User Input into uppercase
			name = name.toUpperCase();
			city = city.toUpperCase();
			college = college.toUpperCase();
			job = job.toUpperCase();
			animal = animal.toUpperCase();
			pet = pet.toUpperCase();
			
			// Attempt to create output with the possibility of failing to parse the age string
			try
			{
				// Parse the string age into an integer in order to validate and perform arithmetic
				int tempAge = Integer.parseInt(age);
				
				// Validate and throw an exception if invalid
				if(tempAge < 1 || tempAge > 99)
				{
					// Exit to invalid age message
					throw new NumberFormatException();
				}
					
				// Output the word game
				JOptionPane.showMessageDialog(null, "There once was a person named " + name +
						" who lived in " + city + ". At the age of " + age + ", " + name + 
						" went to college at " + college + ". " + name + " graduated and went to work as a(n) " +
						job + ". Then, at the age of " + (tempAge + 5) + ", " + name +
						" adopted a(n) " + animal + " named " + pet + ". They both lived happily ever after!");
			} 
			// Age is a non-numeric string
			catch (NumberFormatException ex) 
			{
				// Invalid Age Error Message
				JOptionPane.showMessageDialog(null, "Sorry, you did not enter a valid age (e.g. 18).");
			}
		}
		else
		{
			// Missing Data Error Message
			JOptionPane.showMessageDialog(null, "Sorry, you did not enter all of the information.");
		}
	}
	
	/**
	 * A helper validation method which verifies that a string is non-empty.
	 * @param s The string to be checked.
	 * @return true - If the string contains data. false - If the string does not.
	 */
	public static boolean isData(String s)
	{
		if(s != null && s.length() > 0)
			return true;
		else
			return false;
	}
}

package speed_of_sound;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This program displays the speed of sound through air, water, and steel. It then determines how long it will take
 * to travel through one of these mediums based on user input.
 * This program demonstrates the ability to use a DecimalFormat object to format output, 
 * basic arithmetic, declaration of constants, and switch conditional structure.
 * This program requires 1.7 compiler compliance.
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
		// Constants to hold the speed of sound in air, water, and steel (feet per second)
		final double air = 1100, water = 4900, steel = 16400;
		
		// Variables to hold user input
		String medium;
		double distance;
		
		// Create scanner object for user input
		Scanner keyboard = new Scanner(System.in);
		
		// Prompt the user for input and fetch
		System.out.print("Please enter the medium that sound with travel through (Air, Water, or Steel): ");
		medium = keyboard.nextLine();
		
		System.out.print("Please enter the distance that the sound will travel through that medium: ");
		distance = keyboard.nextDouble();
		
		// Close the scanner object
		keyboard.close();
		
		// Verify that distance is non-zero and positive. Then continue the program.
		if(distance <= 0)
		{
			System.out.println("Please enter a positive non-zero distance.");
		}
		else
		{
			// Format the medium's case in order to simplify the switch comparison
			medium = medium.toLowerCase();
			
			// Create a DecimalFormat object to format the distance output
			DecimalFormat formatter = new DecimalFormat("#0.00");
			
			// Determine the medium entered by the user and calculate / output
			switch (medium)
			{
				case "air":
					System.out.println("The time it will take sound to travel " + formatter.format(distance) + 
							" feet through air is " + formatter.format(distance / air) + " second(s).");
					break;
				case "water":
					System.out.println("The time it will take sound to travel " + formatter.format(distance) + 
							" feet through water is " + formatter.format(distance / water) + " second(s).");
					break;
				case "steel":
					System.out.println("The time it will take sound to travel " + formatter.format(distance) + 
							" feet through steel is " + formatter.format(distance / steel) + " second(s).");
					break;
				default:
					System.out.println("Invalid medium selected. Please select either air, water, or steel.");
					break;
			}	
		}
	}

}

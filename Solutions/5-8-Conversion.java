package conversion;

import java.util.Scanner;

/**
 * This program ask the user to input a distance in meters and offers a menu to convert said distance to kilometers, inches, or feet.
 * This program demonstrates the ability to create a menu driven program and utilize methods.
 * Input Validation Requirements: Distance should be non-negative and menu choice should be valid
 * Requires complier compliance level 1.5 or higher.
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
		// Variables and a Scanner object to store user input for distance and choice
		double distance;
		int choice;
		Scanner keyboard = new Scanner(System.in);
		
		// Initial user prompt for distance and validate
		do
		{
			System.out.print("Please enter a non-negative distance in meters: ");
			distance = keyboard.nextDouble();
		} while(distance < 0);
		
		// Drive the program
		do
		{
			displayMenu();
			choice = keyboard.nextInt();
			
			// Validate menu choice
			while(choice < 1 || choice > 4)
			{
				System.out.println("Invalid Selection");
				displayMenu();
				choice = keyboard.nextInt();
			}
			
			// Drive the menu
			displayMath(choice, distance);
		} while(choice != 4);
		
		// Close the Scanner object
		keyboard.close();
	}

	/**
	 * A method for displaying the main menu.
	 */
	private static void displayMenu()
	{
		System.out.println("\n1. Convert to kilometers");
		System.out.println("2. Convert to inches");
		System.out.println("3. Convert to feet");
		System.out.println("4. Quit the program");
		System.out.print("Please enter your choice (1-4): ");
	}
	
	/**
	 * A method for displaying the result of the math based on the user's choice.
	 * Calls helper methods for the calculation
	 * @param choice integer representing the user's menu choice
	 * 					required 1-3 for kilometers, inches, and feet respectively
	 * @param distance double representing meters of distance, required non-negative
	 */
	private static void displayMath(int choice, double distance)
	{
		switch(choice)
		{
			case 1:
				System.out.printf("\nThe distance %,#.2fm in kilometers is %,#.2fkm.\n", distance, toKilometer(distance));
				break;
			case 2:
				System.out.printf("\nThe distance %,#.2fm in inches is %,#.2fin.\n", distance, toInch(distance));
				break;
			case 3:
				System.out.printf("\nThe distance %,#.2fm in feet is %,#.2ft.\n", distance, toFeet(distance));
				break;
			default:
				System.out.println("\nThank you for using the converter.\n");
		}
	}
	
	/**
	 * A method that converts meters to kilometers
	 * @param distance double representing meters of distance, required non-negative
	 * @return The distance converted to kilometers
	 */
	private static double toKilometer(double distance)
	{
		return distance * 0.001;
	}
	
	/**
	 * A method that converts meters to inches
	 * @param distance double representing meters of distance, required non-negative
	 * @return The distance converted to inches
	 */
	private static double toInch(double distance)
	{
		return distance * 39.37;
	}
	
	/**
	 * A method that converts meters to feet
	 * @param distance double representing meters of distance, required non-negative
	 * @return The distance converted to feet
	 */
	private static double toFeet(double distance)
	{
		return distance * 3.281;
	}
}

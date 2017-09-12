package mpg;
import java.util.Scanner;

/**
 * This class creates a program that calculates MPG.
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
		// Variables of type double to store the inputs
		double miles, gallons;
		
		// Scanner for keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		// Request user input
		System.out.print("Enter the number of miles driven: ");
		miles = keyboard.nextDouble();
		
		System.out.print("\nEnter the number of gallons used: ");
		gallons = keyboard.nextDouble();
		
		// Calculate result and display
		System.out.println("\nYour MPG was " + (miles / gallons) + " miles per gallon.");
		
		// Close the scanner object
		keyboard.close();
	}
}

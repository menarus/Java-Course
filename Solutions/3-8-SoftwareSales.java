package software_sale;

import java.util.Scanner;

/**
 * This class calculates and displays the pricing of a software sale with discounts available for bulk purchases.
 * This program demonstrates the ability to use printf method functionality to format output, 
 * basic arithmetic, declaration of constants, and conditional decision structure.
 * This program requires 1.5 compiler compliance.
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
		// Constants to hold the discount amounts based on the amount of software purchased and the cost of the software.
		final double discount1 = 0.2, discount2 = 0.3, discount3 = 0.4, discount4 = 0.5, price = 99;
		
		// Create a scanner object for user input.
		Scanner keyboard = new Scanner(System.in);
		
		// Variable to store user input.
		int qty;
		
		// Prompt the user to input the purchase quantity.
		System.out.print("Please enter the quantity of software purchased: ");
		qty = keyboard.nextInt();
		
		// Temporary variable for price calculation
		double temp = price * qty;
		
		// Conditional structure to determine discount and partially verify input.
		if(qty > 99)
		{
			System.out.printf("You recieved a %.0f%% discount, which saved you $%,.2f. This brings your total to $%,.2f.\n", 
					discount4 * 100, temp * discount4, temp * (1- discount4));
		}
		else if (qty > 49)
		{
			System.out.printf("You recieved a %.0f%% discount, which saved you $%,.2f. This brings your total to $%,.2f.\n", 
					discount3 * 100, temp * discount3, temp * (1- discount3));
		}
		else if (qty > 19)
		{
			System.out.printf("You recieved a %.0f%% discount, which saved you $%,.2f. This brings your total to $%,.2f.\n", 
					discount2 * 100, temp * discount2, temp * (1- discount2));
		}
		else if (qty > 9)
		{
			System.out.printf("You recieved a %.0f%% discount, which saved you $%,.2f. This brings your total to $%,.2f.\n", 
					discount1 * 100, temp * discount1, temp * (1- discount1));
		}
		else if (qty > 0)
		{
			System.out.printf("Your total is $%,.2f.\n", temp);
		}
		else
		{
			System.out.printf("You've entered an invalid value.");
		}
		
		// Close the scanner object.
		keyboard.close();
	}

}

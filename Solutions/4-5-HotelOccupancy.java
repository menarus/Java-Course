package hotel_occupancy;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * This class asks the user to enter the number of rooms occupied and otherwise for a hotel.
 * Displays the total number of rooms, occupied rooms, vacant rooms, and occupancy rate.
 * This program demonstrates the ability to use nested loops and basic input validation.
 * Demonstrates input validation in two ways, with a while implementation and a do/while implementation.
 * Input Validation Requirements: At least one floor, at least ten rooms per floor, 
 * occupied rooms cannot exceed total rooms, and occupied rooms cannot be negative.
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
		// Variable to hold the user input and serve the loop structure
		int floors;
		
		// Scanner object for user input
		Scanner keyboard = new Scanner(System.in);
		
		// Accumulator variables for the rooms occupied and total. Temps required for while loop input validation.
		int occupied = 0, total = 0, tempFloor = 0, tempOccupied = 0;
		
		// Welcome message
		System.out.println("~Welcome to the Java Hotel Room Manager~\n");

		// Initial user input prompt, which allows the user to define the loop condition. Validate floors > 0
		do
		{
			System.out.print("Please enter the number of floors: ");
			floors = keyboard.nextInt();
		} while(floors < 1);
		
		// Create the loop based on the user floor definition
		for(int i = 1; i <= floors; i++)
		{
			// Prompt the user to input the room information for each floor
			System.out.print("\nFloor #" + i + ": Enter the total number of rooms on this floor: ");
			tempFloor = keyboard.nextInt();
			
			// Validate
			while(tempFloor < 10)
			{
				System.out.print("You must enter at least 10 rooms: ");
				tempFloor = keyboard.nextInt();
			}
			
			// Accumulate
			total += tempFloor;
			
			System.out.print("Floor #" + i + ": Enter the number of occupied rooms on this floor: ");
			tempOccupied = keyboard.nextInt();
			
			// Validate that the number of occupied rooms does not exceed the number of rooms on the floor and is non-negative
			while(tempOccupied > tempFloor || tempOccupied < 0)
			{
				if(tempOccupied > tempFloor)
					System.out.print("You cannot have more than " + tempFloor + " occupied rooms on this floor, please renter: ");
				else
					System.out.print("You cannot have a negative number of occupied rooms, please renter: ");
				
				tempOccupied = keyboard.nextInt();	
			}
			
			// Accumulate
			occupied += tempOccupied;
		}
		
		// Close the Scanner object
		keyboard.close();
		
		// Create a DecimalFormat object to format the occupancy rate
		DecimalFormat formatter = new DecimalFormat("##0");
		
		// Display totals
		System.out.println("\nThe total number of rooms in the hotel is: " + total);
		System.out.println("The total number of occupied rooms in the hotel is: " + occupied);
		System.out.println("The total number of vacant rooms in the hotel is: " + (total - occupied));
		System.out.println("The occupancy rate of the hotel is: " + formatter.format(occupied / (double)total * 100) + "%");
	}

}
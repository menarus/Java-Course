package carpet_calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This program calculates the cost to carpet a room.
 * This program demonstrates the ability to work with enumerated data types, object aggregation, arrays, and classes.
 * Requires compiler compatibility of 1.5 or higher.
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
		Scanner keyboard = new Scanner(System.in);
		double length, width;
		RoomCarpet.CType choice;
		RoomCarpet room;
		DecimalFormat formatter = new DecimalFormat("0.00");
		
		System.out.print("Enter the length of the room: ");
		length = keyboard.nextDouble();
		System.out.print("Enter the width of the room: ");
		width = keyboard.nextDouble();
		keyboard.nextLine();
		
		System.out.println("\nEnter one of the following carpet types: ");
		for(RoomCarpet.CType temp : RoomCarpet.CType.values())
		{
			System.out.print(temp + " | ");
		}
		System.out.print("\n\nSelection: ");
		choice = RoomCarpet.CType.valueOf(keyboard.nextLine().toUpperCase());
		
		room = new RoomCarpet(length, width, choice);
		
		System.out.println("\nTo carpet this room with " + choice + " carpet will cost $" + formatter.format(room.getCost()) + ".");
		keyboard.close();
	}
}

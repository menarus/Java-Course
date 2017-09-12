package two_d_array;

/**
 * This program implements a TwoDArray class and a main to drive it.
 * This program demonstrates the ability to create a two dimensional array class, 
 * pass arrays by reference, and utilize class methods.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class Main 
{

	/**
	 * The main method which serves as the program's starting point.
	 * @param args Default Parameters.
	 */
	public static void main(String[] args) 
	{
		// Describe the array
		final int rows = 2, cols = 3;
		
		// Utilize the class to create the array
		TwoDArray myArray = new TwoDArray(rows, cols); 
		
		// Initialize the array with some data, leaving some elements empty
		// { 0,  14,  6 }
		// { 0, -9, -1 }
		myArray.getArray()[0][1] = 14;
		myArray.getArray()[0][2] = 6;
		myArray.getArray()[1][1] = -9;
		myArray.getArray()[1][2] = -1;
		
		// Test the methods
		System.out.println("The total of the array is: " + myArray.getTotal());
		System.out.println("The average of the array is: " + myArray.getAverage());
		System.out.println("\nThe total of row 1 is: " + myArray.getRowTotal(0));
		System.out.println("The total of row 2 is: " + myArray.getRowTotal(1));
		System.out.println("\nThe total of column 1 is: " + myArray.getColTotal(0));
		System.out.println("The total of column 2 is: " + myArray.getColTotal(1));
		System.out.println("The total of column 3 is: " + myArray.getColTotal(2));
		System.out.println("\nThe highest number in row 1 is: " + myArray.getHighestInRow(0));
		System.out.println("The highest number in row 2 is: " + myArray.getHighestInRow(1));
		System.out.println("\nThe lowest number in row 1 is: " + myArray.getLowestInRow(0));
		System.out.println("The lowest number in row 2 is: " + myArray.getLowestInRow(1));
	}

}

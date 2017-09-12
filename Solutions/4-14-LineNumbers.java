package line_numbers;

import java.io.*;
import java.util.Scanner;

/**
 * This class asks the user for a file name and displays the contents with number lines.
 * This program demonstrates the ability to perform basic file operations and basic loop structure utilizing the counter.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class Main 
{

	/**
	 * The main method which serves as the program's starting point.
	 * @param args Default Parameter
	 * @throws IOException Basic exception handling for files. E.G. File not found.
	 */
	public static void main(String[] args) throws IOException
	{
		// Create Scanner objects to read from the input file and keyboard
		Scanner keyboard = new Scanner(System.in);
		Scanner inFile;
		
		// Variables to hold the name of the file and the line number
		String fileName;
		int line = 0;
		
		// Prompt the user to enter the file name
		System.out.print("Please enter the file name: ");
		fileName = keyboard.nextLine();
		
		// Create the file and verify its existence
		File userFile = new File(fileName);
		
		if(!userFile.exists())
		{
			System.out.println("The file \"" + fileName + "\" was not found.");
			System.exit(-1);
		}
		
		// Link the file to the scanner object to facilitate reading the file
		inFile = new Scanner(userFile);
		
		// Read from file and display contents with line numbers
		while(inFile.hasNextLine())
		{
			line++;
			
			System.out.println(line + ": " + inFile.nextLine());
		}
		
		// Close the file and the scanner objects
		inFile.close();
		keyboard.close();
	}

}

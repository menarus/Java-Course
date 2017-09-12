package test_scores;

import java.io.*;
import java.util.Scanner;

/**
 * This program creates a test scores class that holds an array of 5 test scores and returns the average of them.
 * The user will enter the scores into the test scores object, it will then be serialized, written to a file, read from a file and then deserialized.
 * If any test score in the array is negative or greater than 100, an InvalidTestScore exception will be thrown.
 * This program demonstrates the ability to create classes, exceptions, throw exceptions, try/catch exceptions, and write/read objects to/from file.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class Main 
{

	/**
	 * The main method which serves as the program's starting point.
	 * @param args Default Parameter 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		final int SIZE = 5;
		
		TestScores scores = new TestScores(SIZE);
		Scanner keyboard = new Scanner(System.in);
		
		// Fill the array in the TestScores object
		for(int i = 1; i <= SIZE; i++)
		{
			fillArray(i, scores, keyboard);
		}

		System.out.println("\nThe average of these test scores is: " + scores.average() + "\n");
		
		// Write to file //////////////////////////////////////////////////////////////////
		
		final String fileName = "testscores.dat";
		
		FileOutputStream outStream = new FileOutputStream(fileName);
		ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream);
		
		objectOutputFile.writeObject(scores);
		objectOutputFile.close();
		
		// Read from file /////////////////////////////////////////////////////////////////
		
		TestScores fileScores = new TestScores(SIZE);
		
		FileInputStream inStream = new FileInputStream(fileName);
		ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
		
		fileScores = (TestScores) objectInputFile.readObject();
		objectInputFile.close();
		
		// Verify read from file //////////////////////////////////////////////////////////
		
		/* getScore method disabled, utilize the toString instead
		for(int i = 1; i <= SIZE; i++)
		{
			System.out.println("File test score #" + i + ": " + fileScores.getScore(i - 1));
		}
		*/ 
		
		System.out.println(fileScores);
		
		System.out.println("\nThe average of these test scores is: " + fileScores.average() + "\n");
		
		keyboard.close();
	}

	/**
	 * Helper method to fill the TestScores object.
	 * @param i Integer representing the index of the array in TestScores to be set.
	 * @param scores TestScores object reference to the object to be set.
	 * @param keyboard Scanner object reference to the input.
	 */
	public static void fillArray(int i, TestScores scores, Scanner keyboard)
	{
		int score;
		
		System.out.print("Enter test score #" + i + ": ");
		score = keyboard.nextInt();
		
		try
		{
			scores.setScore((i - 1), score);
		}
		catch(InvalidTestScore e)
		{
			System.out.println("\n" + e.getMessage() + "\n");
			fillArray(i, scores, keyboard);
		}
	}
}

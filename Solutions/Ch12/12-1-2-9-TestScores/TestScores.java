package test_scores;

import java.io.Serializable;

/**
 * This class holds an array of integers and throws an InvalidTestScore exception if any scores are negative or above 100.
 * Requires compiler compliance of 1.5 or greater.
 * @implements Serializable to allow object to be written to or read from a file.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */

public class TestScores implements Serializable
{
	private static final long serialVersionUID = 8755876158743314636L;
	
	//////////////////////////////////////////////Fields////////////////////////////////////////////////
	
	public int[] scores;
	
	///////////////////////////////////////////Constructors/////////////////////////////////////////////
	
	/**
	 * Single arg constructor initializing the array.
	 * @param s Integer representing the size of the array.
	 */
	public TestScores(int s)
	{
			scores = new int[s];
	}
	
	/////////////////////////////////////////////Mutators///////////////////////////////////////////////
	
	/**
	 * Mutator for setting a single score in the array.
	 * @param i Integer representing the index of the array to be set.
	 * @param s Integer representing the value to be stored in the array.
	 * @throws InvalidTestScore Custom exception class if value is negative or exceeds 100.
	 */
	public void setScore(int i, int s) throws InvalidTestScore
	{
		if(s > 100 || s < 0)
			throw new InvalidTestScore(s);
		else
			scores[i] = s;
	}
	
	/////////////////////////////////////////////Accessors//////////////////////////////////////////////
	
	/**
	 * Accessor returning a single score in the array.
	 * Currently disabled.
	 * @param i Integer representing the index of the array to be returned.
	 * @return Integer value stored in the array at parameter i.
	 */
	/*
	public int getScore(int i)
	{
		return scores[i];
	}
	*/

	//////////////////////////////////////////////Methods///////////////////////////////////////////////
	
	/**
	 * Calculates and returns the average of the values in the array.
	 * @return Double representing the average of the values in the array.
	 */
	public double average()
	{
		int total = 0;
		
		for(int i : scores)
		{
			total += i;
		}
		
		return ((double)total) / scores.length;
	}
	
	/**
	 * Overrides the object's toString method 
	 * @return String in the form of "The test scores are: 1, 2, 3, 4, and 5."
	 */
	public String toString()
	{
		String strScores = "The test scores are: ";
		
		for(int i = 0; i < scores.length; i++)
		{
			if(scores.length - 1 == i)
				strScores += "and " + scores[i] + ".";
			else
				strScores += scores[i] + ", ";
		}
		
		return strScores;
	}
}

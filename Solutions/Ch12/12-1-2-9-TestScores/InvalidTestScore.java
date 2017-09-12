package test_scores;

/**
 * InvalidTestScore exceptions are thrown by the TestScores class when a 
 * negative or greater than 100 score is passed to the setScore method.
 * @extends Exception to create the custom InvalidTestScore exception.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class InvalidTestScore extends Exception
{
	private static final long serialVersionUID = -4102738686366467952L;

	/**
	 * No-Arg constructor for exception class
	 */
	public InvalidTestScore()
	{
		super("Error: Negative or greater than 100 score entered.");
	}
	
	/**
	 * Single arg constructor for exception class
	 * @param s Integer representing the number causing the exception to be thrown
	 */
	public InvalidTestScore(int s)
	{
		super("Error: " + ((s > 100) ? "Score exceeding 100 entered." : "Negative score entered."));
	}
}

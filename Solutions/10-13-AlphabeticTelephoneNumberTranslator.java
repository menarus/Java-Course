package alpha_num_trans;

import java.util.Scanner;

/**
 * This class implements a converter to change telephone numbers with alpha characters into fully numeric numbers.
 * E.G. 555-GET-FOOD becomes 555-438-3663
 * This program demonstrates the ability to use Character and String member methods, utilize tokenizers,and perform complex and recursive input validation. 
 * Requires compiler compliance level 1.5 or higher.
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class Main 
{

	/**
	 * The main method which serves as the program's starting point.
	 * @param args Default parameter
	 */
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		String alphaNum;
		
		System.out.print("Enter a telephone number in the form of XXX-XXX-XXXX: ");
		alphaNum = keyboard.nextLine();
		
		// Two stage verification
		// Validate formatting with the verifyF method
		// Which will then verify that the number is alphanumeric via the recursive verifyAN method call
		alphaNum = verifyF(alphaNum);
		
		// Tokenize the number using the String class's split member method
		String[] alphaNums = alphaNum.split("-");
		
		// Reconstruct the string
		String numbers = "\nThe telephone number is: ";
		
		int i = 0; // '-' flag
		
		// For each character in the string, convert it to numeric
		for(String n : alphaNums)
		{
			numbers += toNumeric(n);
			
			i++;
			
			if(i < 3)
				numbers += '-'; // Reinclude the delimiter
		}
		
		System.out.println(numbers);
		
		keyboard.close();
	}
	
	/**
	 * Helper method that verifies the format of the string and recursively calls the verifyAN helper method.
	 * @param s String to be verified.
	 * @return s String that has been verified.
	 */
	@SuppressWarnings("resource")
	public static String verifyF(String s)
	{
		Scanner keyboard = new Scanner(System.in);
		
		while(s.length() != 12 || s.charAt(3) != '-' || s.charAt(7) != '-')
		{
			System.out.print("\nInvalid - Reenter a telephone number in the form of XXX-XXX-XXXX: ");
			s = keyboard.nextLine();	
		}
		
		s = verifyAN(s);
		
		return s;
	}
	
	/**
	 * Helper method that verifies that the string is alphanumeric and recursively calls the verifyF helper method.
	 * @param s String to be verified.
	 * @return s String that has been verified.
	 */
	@SuppressWarnings("resource")
	private static String verifyAN(String s)
	{
		Scanner keyboard = new Scanner(System.in);
		
		for(int i = 0; i < s.length(); i++)
		{
			if( i != 3 && i != 7 && !Character.isLetterOrDigit(s.charAt(i))) // Skip the '-' delimiter
			{
				System.out.print("\nInvalid - Reenter a telephone number with only alphanumeric characters: ");
				s = keyboard.nextLine();
				verifyF(s);
			}
		}
		
		return s;
	}

	/**
	 * Helper method that converts a string into a telephone numerical equivalent.
	 * @param n String to be converted.
	 * @return temp String that has been converted
	 */
	public static String toNumeric(String n)
	{
		String temp = "";
		
		for(int i = 0; i < n.length(); i++)
		{
			if(Character.isLetter(n.charAt(i))) // Do not convert numbers
			{
				temp += convAlpha(n.charAt(i));
			}
			else
			{
				temp += n.charAt(i); // Leave as is
			}
		}
		
		return temp;
	}
	
	/**
	 * Helper method that converts a character into its telephone numeric equivalent.
	 * @param c Character to be converted.
	 * @return Character literal representation of the telephone numeric equivalent.
	 */
	private static char convAlpha(char c)
	{
		c = Character.toUpperCase(c);
		
		// Convert via ASCII values
		if(c < 68 && c > 64)
		{
			return '2';
		}
		if(c < 71 && c > 67)
		{
			return '3';
		}
		if(c < 74 && c > 70)
		{
			return '4';
		}
		if(c < 77 && c > 73)
		{
			return '5';
		}
		if(c < 80 && c > 76)
		{
			return '6';
		}
		if(c < 84 && c > 79)
		{
			return '7';
		}
		if(c < 87 && c > 83)
		{
			return '8';
		}
		if(c < 91 && c > 86)
		{
			return '9';
		}
		
		return '!'; // Error flag, shouldn't be reached
	}
}

package savings_account;

import java.util.Scanner;
import java.util.Date;
import java.io.*;

/**
 * The savings account class handles deposit and withdraw transactions, 
 * calculates monthly interest, and  saves/reads to/from a file.
 * This class demonstrates the ability to implement a class, handle file operations, and basic arithmetic.
 * Input Validation: non-negative balance, rate, and deposit amount. non-negative withdraw not exceeding balance
 * @throws IOException
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class SavingsAccount 
{
	// SavingsAccount Fields
	private double balance;
	private double rate;
	private String fileName;
	
	// Output File Operations
	private PrintWriter outFile;
	
	/////////////////////////////////////////////Constructors/////////////////////////////////////////////
	
	/**
	 * No-Arg constructor to overwrite the default
	 * @throws FileNotFoundException 
	 */
	public SavingsAccount() throws IOException
	{
		balance = 0;
		rate = 0;
		fileName = "newaccount.txt";
	}
	
	/**
	 * Two parameter constructor for setting up a new account with an initial balance and rate
	 * @param bal A double containing the initial account balance
	 * @param r A double containing the monthly interest rate
	 * @throws FileNotFoundException 
	 */
	public SavingsAccount(double bal, double r) throws IOException
	{
		this.setBal(bal);
		this.setRate(r);;
		
		Date d = new Date(); // fetch the current date and time for the file name
		fileName = d.toString();
		fileName = fileName.replace(':', ' ');
		fileName = "newaccount_" + fileName + ".txt";
		
		outFile = new PrintWriter(fileName);
	}
	
	/**
	 * One parameter constructor for opening an existing account
	 * @param str A String object containing the file name of an existing account
	 * @throws FileNotFoundException 
	 */
	public SavingsAccount(String str) throws IOException
	{
		// Calls the helper method
		openFile(str);
	}

	/////////////////////////////////////////////Accessors/////////////////////////////////////////////
	
	/**
	 * Accessor for the balance field.
	 * @return balance Double containing the balance
	 */
	public double getBal()
	{
		return balance;
	}
	
	/**
	 * Accessor for the rate field.
	 * @return rate Double containing the rate
	 */
	public double getRate()
	{
		return rate;
	}
	
	/////////////////////////////////////////////Mutators/////////////////////////////////////////////	
	
	/**
	 * Mutator for the balance field.
	 * @param b Double containing the new balance, will be non-negative validated
	 */
	public void setBal(double b)
	{
		Scanner keyboard = new Scanner(System.in);
		
		while(b < 0)
		{
			System.out.print("Invalid balance, enter a non-negative balance: $");
			b = keyboard.nextDouble();
		}
		
		balance = b;
		
		//keyboard.close();
	}
	
	/**
	 * Mutator for the rate field.
	 * @param r Double containing the new rate, will be non-negative validated
	 */
	public void setRate(double r)
	{
		Scanner keyboard = new Scanner(System.in);
		
		while(r < 0)
		{
			System.out.print("Invalid rate, enter a non-negative rate: ");
			r = keyboard.nextDouble();
		}
		
		rate = r;
		
		//keyboard.close();
	}
	
	/////////////////////////////////////////////Operational Methods/////////////////////////////////////////////
	
	/**
	 * A method for withdrawing funds. This operation subtracts the withdraw amount for the current balance.
	 * @param amt Double containing the amount to be withdrawn, 
	 *            will be validated non-negative and not larger than current balance.
	 * @return double The validated withdraw amount.          
	 */
	public double withdraw(double amt)
	{
		Scanner keyboard = new Scanner(System.in);
		
		while(amt < 0 || amt > balance)
		{
			if(amt < 0)
				System.out.print("Invalid withdraw amount, enter a non-negative amount: $");
			else
				System.out.print("Invalid withdraw amount, enter an amount less than $" + balance + ": ");
			
			amt = keyboard.nextDouble();
		}
		
		balance -= amt;
		
		//keyboard.close();
		
		return amt;
	}
	
	/**
	 * A method for depositing funds. This operation adds the deposit amount for the current balance.
	 * @param amt Double containing the amount to be deposited, will be validated non-negative.
	 * @return double The validated deposit amount.
	 */
	public double deposit(double amt)
	{
		Scanner keyboard = new Scanner(System.in);
		
		while(amt < 0)
		{
			System.out.print("Invalid deposit amount, enter a non-negative amount: $");			
			amt = keyboard.nextDouble();
		}
		
		balance += amt;
		
		//keyboard.close();
		
		return amt;
	}
	
	/**
	 * A method for calculating and compounding interest. 
	 * @return interest Double containing the amount of interest that was added to the current balance.
	 */
	public double calcInterest()
	{
		double interest = (balance * rate);
		
		balance += interest;
		
		return interest;
	}
	
	/**
	 * A method allowing the user to open another account's information in place of the current one.
	 * Will close and give the option of saving the current account's information.
	 * @param str String representing the file name.
	 * @throws FileNotFoundException
	 */
	public void openAccountFile(String str) throws IOException
	{
		// Make certain that an output file is not already open
		
		// Give the option of saving the current session
		Scanner keyboard = new Scanner(System.in);
		String choice = "z"; //Invalid choice
		
		while(!choice.toLowerCase().equals("y") || !choice.toLowerCase().equals("n"))
		{
			System.out.print("Would you like to save the current account changes (Y/N): ");
			choice = keyboard.nextLine();
		}
		
		//keyboard.close();
		
		if(choice.toLowerCase().equals("y"))
			this.closeAccountFile(); // Closes after saving current balance and rate
		else
			outFile.close(); // Close without saving
		
		
		// Call the helper method
		this.openFile(str);
	}
	
	/**
	 * A helper method that opens and reads from a file, then sets the file up for output.
	 * @param str String representing the file name.
	 * @throws IOException
	 */
	private void openFile(String str) throws IOException
	{
		// Open the input file
		fileName = str;
		File file = new File(str);
		
		if(!file.exists())
		{
			System.out.println("The file " + str + " does not exist, exiting program.");
			System.exit(-1);
		}
		
		Scanner inFile = new Scanner(file);
		
		// Fetch the Balance and Rate

		/*
		   File will be set up containing only two doubles: Balance then Rate 
		   Normally data would need to be validated and and existence checked before read
		   However the file is created by this class and verified at that time
		   This should still be performed but will be omitted for the simplicity of this project
		*/ 
		balance = inFile.nextDouble();
		rate = inFile.nextDouble();
		
		// Close the input file as it is no longer needed
		inFile.close();
	}
	
	/**
	 * A method that writes the current balance and rate to a file and closes it.
	 * @throws FileNotFoundException 
	 */
	public void closeAccountFile() throws FileNotFoundException
	{
		// Write the current balance and rate data
		outFile = new PrintWriter(fileName);
		outFile.print(balance + " " + rate);
		outFile.close();

	}
}

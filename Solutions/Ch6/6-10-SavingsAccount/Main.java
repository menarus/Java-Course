package savings_account;

import java.io.IOException;
import java.util.Scanner;

/**
 * This program implements a savings account class and a main to drive it.
 * This program demonstrates the ability to implement a class, handle file operations, and basic arithmetic.
 * Requires compiler compliance level 1.5 or greater.
 * @throws IOException
 * @author Mohammad Al-Husseini
 * @version 1.0.0
 */
public class Main 
{

	/**
	 * The main method which serves as the program's starting point.
	 * @param args Default Argument
	 */
	public static void main(String[] args) throws IOException
	{
		// Create an instance of the SavingsAccount class
		SavingsAccount savings;
		
		while(true) // loop until the user exits via one of the options
		{
			// Initial user prompt that sets up the object
			savings = initMenu();
			
			// Prompt for the number of months the user would like to enter
			Scanner keyboard = new Scanner(System.in);
			int months;
			
			do
			{
				System.out.print("Enter the number of months you'd like to calculate over (0 to exit): ");
				months = keyboard.nextInt();
				
				if(months == 0)
				{
					System.out.println("\nThank you for using the account manager, goodbye!");
					savings.closeAccountFile();
					keyboard.close();
					System.exit(0);
				}
			} while(months < 1);
			
			
			// Display and execute object functionality
			int choice = 0;
			double withdrawTotal = 0, depositTotal = 0, interestTotal = 0;
			double withdraw, deposit, interest;
			
			while(choice != 3)
			{
				for(int i = 1; i <= months; i++)
				{
					
					System.out.println("\n-Month " + i + "-\n");
					System.out.println("1. Make a deposit.");
					System.out.println("2. Make a withdraw.");
					System.out.println("3. End this month and calculate interest.");
					System.out.print("Enter your choice: ");
					choice = keyboard.nextInt();
					
					while(choice < 1 || choice > 3)
					{
						System.out.print("Enter your choice (1-4): ");
						choice = keyboard.nextInt();
					}	
					
					switch(choice)
					{
						case 1:
							System.out.print("\nEnter a deposit amount: $");
							deposit = keyboard.nextDouble();
							deposit = savings.deposit(deposit); // Validated by class, update local deposit
							System.out.printf("Your current balance is: $%,.2f.\n", savings.getBal());
							depositTotal += deposit; // accumulate
							break;
						case 2:
							System.out.print("\nEnter a withdraw amount: $");
							withdraw = keyboard.nextDouble();
							withdraw = savings.withdraw(withdraw); // Validated by class, update local withdraw
							System.out.printf("Your current balance is: $%,.2f.\n", savings.getBal());
							withdrawTotal += withdraw;
							break;
						case 3:
							interest = savings.calcInterest();
							interestTotal += interest;
							System.out.printf("\nYour interest for month #%d is $%,.2f.\n", i, interest);
							System.out.printf("Your current balance is: $%,.2f.\n", savings.getBal());
							break;
						default:
							System.out.println("Impossible.");
							break;
					}
				}
			}
			
			System.out.printf("\nThe ending balance of the account is $%,.2f.\n", savings.getBal());
			System.out.printf("The total amount of deposits was $%,.2f.\n", depositTotal);
			System.out.printf("The total amount of withdraws was $%,.2f.\n", withdrawTotal);
			System.out.printf("The total amount of interest earned was $%,.2f.\n\n", interestTotal);
			
			//keyboard.close();
			savings.closeAccountFile();
		}
	}

	/**
	 * A helper method that handles the initial main operations.
	 * Determines the account and creates the object.
	 * @return initMenu SavingsAccount object containing the initialized data.
	 * @throws IOException
	 */
	private static SavingsAccount initMenu() throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		int choice;
		
		System.out.println("Welcome to the savings account manager!\n");
		System.out.println("1. Open an existing account.");
		System.out.println("2. Open a new account.");
		System.out.println("3. Exit.\n");
		System.out.print("Enter your choice: ");
		choice = keyboard.nextInt();
		
		while(choice < 1 || choice > 4)
		{
			System.out.print("Enter your choice (1-3): ");
			choice = keyboard.nextInt();
		}

		// Initialization required to prevent return error, although the default won't be used.
		SavingsAccount savings = new SavingsAccount(); 
		
		switch(choice)
		{
			case 1:
				String fileName;
				keyboard.nextLine(); // clear the new line from the buffer
				
				System.out.print("\nEnter the accounts file name: ");
				fileName = keyboard.nextLine();
				
				savings = new SavingsAccount(fileName);
				break;
			case 2:
				double bal, rate;
				
				System.out.print("\nEnter a starting balance: $");
				bal = keyboard.nextDouble();
				System.out.print("Enter a starting rate: ");
				rate = keyboard.nextDouble();
				
				savings = new SavingsAccount(bal, rate);
				break;
			case 3:
				System.out.println("\nThank you for using the account manager, goodbye!");
				if(!(savings.getBal() == 0 && savings.getRate() == 0)) // Prevent junk accounts from being saved 
				{
					savings.closeAccountFile();
				}
				keyboard.close();
				System.exit(0);
				break;
			default:
				System.out.println("Impossible.");
				break;
		}
		
	//	keyboard.close();
		
		return savings;
	}
}

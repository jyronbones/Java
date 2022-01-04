/*
 * Assessment: Lab 2
 * Student Name: Byron Jones
 * Due Date: 10/03/21
 * Description: A banking system that holds accounts, personal info, processes fees and interest
 * Professor Name: Dr. James Mwandi
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Class that reads account type, displays account and runs monthly processes
 */
public class Bank {
	
	/*
	 * Instance variables of bank
	 */
	private static String name;
	private Account[] accounts;
	private int numAccounts;

	/*
	 * No-arg constructor of bank
	 */
	public Bank() {
	}
	
	/*
	 * Parameterized constructor initialized from passed information from main
	 */
	public Bank(String name, int size) {
		Bank.name = name; // assigns bank name
		accounts = new Account[size]; // sets size of accounts array
	}

	/*
	 * Reads account type and account details
	 */
	public void readAccount(Scanner input) {
		int choice = 0; // initializes choice
		if (numAccounts < accounts.length) { // validates there is room for a new account
			System.out.println("1. Chequing\n" // menu for account type
					+ "2. Savings");
			System.out.print("Enter the type of account you want to create: ");
			while (true) { // input validation ensuring choice is only chequing or savings
				try {
				choice = input.nextInt(); // ask the user to enter a number for choice
				} catch (InputMismatchException e) {
					System.err.println("Input mismatch");
					input.nextLine(); // clear the buffer
				}
				if (choice == 1 || choice == 2) { // user chose chequing or savings
					break;
				} else { // user did not choose a valid option
					System.out.print("Please enter a valid account type: ");
				}
			}
			if (choice == 1) { 						// choice is chequing
				Chequing chequing = new Chequing();	// create a Chequing object
				chequing.readAccountDetails(input);	// reads account details of a chequing account
				accounts[numAccounts] = chequing;	// stores chequing object in accounts array
			} else if (choice == 2) {				// choice is savings
				Savings savings = new Savings();	// create a Savings object
				savings.readAccountDetails(input);	// reads account details of a savings account
				accounts[numAccounts] = savings;	// stores savings object in accounts array
			}
			numAccounts++; // incrementing number of accounts
		} else { // no room for an account
			System.out.println(); // line separator
			System.out.println("****Maximum reached....Cannot add more accounts****");
			System.out.println(); // line separator
		}
	}

	/*
	 * Runs monthly processes, fees for chequing and interest for savings
	 */
	public void runMonthlyProcess() {
		if (numAccounts > 0) { // validating there are accounts to process
			for (int i = 0; i < numAccounts; i++) { // iterates through accounts printing updated balance with processed fees or interest
				accounts[i].updateBalance(); // updates the balance of the account
			}
		} else { // no account to process
			System.out.println("**** No accounts to process ****");
		}
	}

	/*
	 * Displays bank accounts
	 */
	public void displayAccount() {
		if (numAccounts > 0) { // validates there are accounts to display
			printTitle(); // calls method to print title
			for (int i = 0; i < numAccounts; i++) { // iterates through accounts printing person's account information
				accounts[i].displayAccount(); // displays account details of the account
			}
		} else { // there is no account to display
			System.out.println("**** No accounts to display ****");
		}
	}

	/*
	 * Prints stars forming a horizontal border line
	 */
	public static void printStar() {
		for (int i = 0; i < 95; i++) { // iterates through printing 95 stars in a single row
			System.out.print("*");
		}
		System.out.println(); // line separator
	}

	/*
	 * Prints title with with border
	 */
	public static void printTitle() {
		System.out.println(); // line separator
		printStar(); // call to method printing row of stars
		System.out.printf("%48s BANK", name); // centers bank name
		System.out.println(); // line separator 
		printStar(); // call to method printing row of stars
		System.out.printf("%12s | %25s | %25s | %12s | %8s", "Acc Number", "Name", "Email", "Phone Number", "Balance"); // prints column headers
		System.out.println(); // line separator
		printStar(); // call to method printing row of stars
	}

}

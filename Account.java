/*
 * Assessment: Lab 2
 * Student Name: Byron Jones
 * Due Date: 10/03/21
 * Description: A banking system that holds accounts, personal info, processes fees and interest
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;
/*
 * Class reads and displays bank account info
 */
public class Account {
	/*
	 * Instance variables of an account
	 */
	protected long accNumber;	 // represents account number
	protected Person accHolder; // represents an account holder of Person
	protected double balance; 	// represents balance of account
	
	/*
	 * Reads person's account information
	 */
	public void readAccountDetails(Scanner input) {
		
		// asks user to enter a value for account number
		System.out.print("Enter Account Number: ");
		accNumber = input.nextLong();
		
		// asks user to enter first name
		System.out.print("Enter first name: ");
		String firstName = input.next();
		
		// asks user to enter last name
		System.out.print("Enter last name: ");
		String lastName = input.next();
		
		// asks user to enter email
		System.out.print("Enter email: ");
		String email = input.next();
		
		// asks user to enter phone number
		System.out.print("Enter phone number: ");
		Long phoneNumber = input.nextLong();
		
		// asks user to enter balance
		System.out.print("Enter Balance: ");
		balance = input.nextDouble();
		
		// creates a person object as an account holder with personal details
		accHolder = new Person(firstName, lastName, email, phoneNumber);
	}
	/*
	 * Displays account information of person
	 */
	public void displayAccount() {
		System.out.printf("%12d | %25s | %25s | %12d | %8.2f\n", accNumber, accHolder.getName(), accHolder.getEmail(), accHolder.getPhoneNumber(), balance);
	
	}
	
	/*
	 *  Updates account balance print statement with account number
	 */
	public void updateBalance() {
		System.out.printf("Updating balance of %d\n", accNumber); // print statement with account number
	}

}

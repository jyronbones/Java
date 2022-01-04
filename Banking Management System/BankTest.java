/*
 * Assessment: Lab 2
 * Student Name: Byron Jones
 * Due Date: 10/03/21
 * Description: A banking system that holds accounts, personal info, processes fees and interest
 * Professor Name: Dr. James Mwandi
 */
/*
 * Class that contains method main.
 */
import java.util.Scanner;

public class BankTest {

	/*
	 * Driver method that reads bank name and number of holders. Prints a menu to read accounts, run monthly process, display account or exit
	 */
	public static void main(String[] args) {
		
		// instance variables
		Scanner input = new Scanner(System.in);
		boolean continueProgram = true;
		
		// ask the user to input name of bank
		System.out.print("Enter the name of the bank: ");
		String name = input.nextLine();
		
		// ask the user to input number of account holders
		System.out.print("How many account holders do you have: ");
		int num = input.nextInt();
		
		// bank object with name and number of accounts
		Bank bank = new Bank(name, num);

		// print menu loop until user exits
		do {
			System.out.print("1. Read Accounts\n" // print menu options
					+ "2. Run monthly process\n"
					+ "3. Display Accounts\n"
					+ "4. Exit\nEnter your option: ");
			int choice = input.nextInt(); // asks user to pick an option
			switch (choice) {
			case 1:	// reads account
				bank.readAccount(input);
				break;
			case 2: // runs monthly processes
				bank.runMonthlyProcess();
				break;
			case 3: // displays accounts
				bank.displayAccount();
				break;
			case 4: // exits the program
				System.out.println("Goodbye... Have a nice day");
				continueProgram = false;
				break;
			default: // error message if invalid option
				System.out.println("Invalid entry... Please pick a valid option");
				break;
			}
		} while (continueProgram);
		input.close(); // close scanner
	}
}

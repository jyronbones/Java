package com.algonquin.cst8132.library;
/*
 * Assessment: Lab 6
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A library management system
 * Professor Name: Mike Norman
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class is the driver class and contains method main and library menu
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class LibraryTest {
	private static final int READ_USER_DETAILS = 1;
	
	private static final int READ_USERS_FROM_FILE = 2;
	
	private static final int READ_BOOKS_FROM_FRILE = 3;
	
	private static final int PRINT_BOOKS = 4;
	
	private static final int RENT_BOOK = 5;
	
	private static final int RETURN_BOOK = 6;
	
	private static final int PRINT_STAFF_DETAILS = 7;
	
	private static final int PRINT_MEMBER_DETAILS = 8;
	
	private static final int CALCULATE_OVERDUE_FEES = 9;
	
	private static final int PAY_FEES = 10;
	
	private static final int EXIT = 0;
	
	/**
	 * This driver method contains the menu Scanner and menu method
	 * @param args is the runtime argument array
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		menu(input);
		input.close(); // close scanner
	}

	/**
	 * This method allows user to input name of library and displays a menu to choose library features
	 * @param input is the passed Scanner for library name and menu selection
	 */
	public static void menu(Scanner input) {
		Library library = new Library();
		boolean continueProgram = true;
		int option = 0;
		
		// ask the user for name of library
		System.out.print("Enter name of the library: ");
		String libraryName = input.nextLine();
		// menu loop until user exits
		do {
			// asks user to enter menu option
			while (true)
				try {
					System.out.print("\n1. Read user details from keyboard\n"
							+ "2. Read user details from file\n"
							+ "3. Read books from file\n"
							+ "4. Print books\n"
							+ "5. Rent a book\n"
							+ "6. Return a book\n"
							+ "7. Print staff details\n"
							+ "8. Print member details\n"
							+ "9. Calculate overdue fees\n"
							+ "10. Pay overdue fees\n"
							+ "0. Exit\n"
							+ "Enter your choice: ");
					option = input.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.err.println("Input mismatch menu selection, please enter a valid menu option");
					input.nextLine();
				}
			switch (option) {
			case READ_USER_DETAILS: // user input is 1
				library.readUserInfo(input); // read user's personal information
				break;
			case READ_USERS_FROM_FILE: // user input is 2
				library.readUserFileDetails(input); // read user's personal information
				break;
			case READ_BOOKS_FROM_FRILE: // user input is 3
				library.readBooksInfo(input);
				break;
			case PRINT_BOOKS: // user input is 4
				library.printBookTitle(libraryName);
				library.printBooks();
				break;
			case RENT_BOOK: // user input is 5
				library.withdrawBook(input);
				break;
			case RETURN_BOOK: // user input is 6
				library.returnBook(input);
				break;
			case PRINT_STAFF_DETAILS: // user input is 7
				library.printStaffTitle(libraryName); // prints the title with library name
				library.printStaffInfo(); // prints staff detailed information
				break;
			case PRINT_MEMBER_DETAILS: // user input is 8
				library.printMemberTitle(libraryName); // prints the title with library name
				library.printMemberInfo(); // prints member detailed information
				break;
			case CALCULATE_OVERDUE_FEES: // user input is 9
				library.calculateFees(input);
				break;
			case PAY_FEES: // user input is 10
				library.payFees(input);
				break;
			case EXIT: // user input is 0
				System.out.println("good bye... have a good day!");
				continueProgram = false;
				break;
			default:
				System.out.println("\nInvalid choice... choice should be a positive integer from 0-10... please try again");
				break;
			}
		} while (continueProgram);
	}
}

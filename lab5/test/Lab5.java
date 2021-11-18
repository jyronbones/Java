package com.algonquincollege.cst8132.lab5.test;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.algonquincollege.cst8132.lab5.Store;
/*
 * Assessment: Lab 5
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A store management system that holds employee information and calculates salary
 * Professor Name: Mike Norman
 */
/*
 * This class is the driver class and contains method main
 */
/**
 * This class is the driver class and contains method main
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class Lab5 {
	/**
	 * Option to read employee details from user
	 */
	public static final int READ_KEY_DETAILS = 1; // option to read employee details from user
	/**
	 * Option to read employee details from file
	 */
	public static final int READ_FILE_DETAILS = 2; // option to read employee details from file
	/**
	 * Option to process increments of employees
	 */
	public static final int PROCESS_INCREMENTS = 3; // option to process increments of employees
	/**
	 * Option to print employee details
	 */
	public static final int PRINT_EMP_DETAILS = 4; // option to print employee details
	/**
	 * Option to exit program
	 */
	public static final int EXIT = 5; // option to exit program
	/*
	 * This driver method reads name and number of employees of the store, 
	 * calls on store methods to read employee details and print employee details with title and header
	 */
	/**
	 * This driver method reads name and number of employees of the store, 
	 * calls on store methods to read employee details and print employee details with title and header
	 * @param args is the runtime argument array
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		menu(input);
		input.close(); // closes Scanner
	}
	/*
	 * This method reads name and number of employees of the store.
	 * Contains a menu to read employees manually, read employees from file,
	 * process increments, print employees and exit
	 * calls on store's methods respectively
	 */
	/**
	 * This method reads name and number of employees of the store.
	 * Contains a menu to read employees manually, read employees from file,
	 * process increments, print employees and exit
	 * calls on store's methods respectively
	 * @param input is the Scanner to read user input
	 */
	public static void menu(Scanner input) {
		boolean continueProgram = true;
		boolean isGoodData = true;
		int num = 0;
		int option = 0;

		// ask the suer for name of store
		System.out.print("Enter name of the store: ");
		String storeName = input.nextLine();

		// ask the user for number of employees
		while (isGoodData) {
			try {
				System.out.print("How many employees do you have? ");
				num = input.nextInt();
				while (num <= 0) {
					throw new InputMismatchException();
				}
				isGoodData = false;
			} catch (InputMismatchException e) {
				System.err.println("Number of employees should be an integer greater than zero... please try again");
				input.nextLine();
			}
		}
		
		Store store = new Store(num); // creates a store with passed number of employees
		// menu loop until user exits
		do {
			// asks user to enter menu option
			while (true)
				try {
					System.out.print("\n1. Read employee details from keyboard\n"
							+ "2. Read employee details from file\n" + "3. Process increments\n"
							+ "4. Print Employee Details\n" + "5. Exit\n" + "Enter your choice: ");
					option = input.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.err.println("Input mismatch menu selection, please enter a valid menu option");
					input.nextLine();
				}
			switch (option) {
			case READ_KEY_DETAILS: // user input is 1
				store.readEmployeeDetails(input); // read employee personal information
				break;
			case READ_FILE_DETAILS: // user input is 2
				store.readFileDetails(input);
				break;
			case PROCESS_INCREMENTS: // user input is 3
				store.processIncrements();
				break;
			case PRINT_EMP_DETAILS: // user input is 4
				store.printTitle(storeName); // prints the title with store name
				store.printEmployeeDetails(); // prints employee detailed information
				break;
			case EXIT: // user input is 5
				System.out.println("good bye... have a good day!");
				continueProgram = false;
				break;
			default:
				System.out.println("Invalid choice... choice should be a positive integer from 1-5... please try again");
				break;
			}
		} while (continueProgram);
		input.close(); // close scanner
	}
}
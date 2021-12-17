package com.algonquin.cst8132.library;
/*
 * Assessment: Lab 6
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A library management system
 * Professor Name: Mike Norman
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class contains member's personal properties and methods to read member information and print it
 * @author Byron Jones
 * * @author Byron Jones
 * @version 1.0
 * @since 1.8
 */
public class Member extends User{
	/**
	 * stores member ID
	 */
	protected int memberID;
	/**
	 * stores member age
	 */
	protected int age;
	/**
	 * stores member balance
	 */
	protected double balance;
	/**
	 * stores number of days rented
	 */
	protected int daysRented;
	/**
	 * stores member's rented books in an array list
	 */
	protected ArrayList<Book> rentedBooks = new ArrayList<>();
	
	/**
	 * This method reads member details from keyboard
	 * @param input is the passed Scanner used to read user details
	 */
	@Override
	public void readUser(Scanner input) {
		super.readUser(input);

		// ask the user for member ID
		while (true) {
			try {
				System.out.print("Enter member ID: ");
				memberID = input.nextInt();
				while (memberID < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch. Please enter a valid memeber ID");
				input.nextLine(); // clears buffer
			} catch (IllegalArgumentException iae) {
				System.err.println("member ID cannot be negative");
				input.nextLine(); // clears buffer
			}
		}
		
		// ask the user for age
		while (true) {
			try {
				System.out.print("Enter age: ");
				age = input.nextInt();
				while (age < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch. Please enter a valid age");
				input.nextLine(); // clears buffer
			} catch (IllegalArgumentException iae) {
				System.err.println("age cannot be negative");
				input.nextLine(); // clears buffer
			}
		}
	}
	
	/**
	 * This method prints detailed member information
	 */
	@Override
	public void printUser() {
		super.printUser();
		System.out.printf(" %9d | %5s | %8.2f | %50s |\n", memberID, age, balance, rentedBooks);
	}
}

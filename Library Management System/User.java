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
 * This class contains user's personal properties and methods to read user information and print it
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 */
public abstract class User{
	/**
	 * holds a person's first name
	 */
	protected String firstName; // represents first name of a person
	/**
	 * holds a person's last name
	 */
	protected String lastName; // represents last name of a person
	/**
	 * holds a person's email
	 */
	protected String email; // represents email of a person
	/**
	 * holds a person's phone number
	 */
	protected long phoneNumber; // represents phone number of a person
	
	/**
	 * This method reads user details from keyboard
	 * @param input is passed Scanner used to read user information
	 */
	public void readUser(Scanner input) {
		
		// ask the user for employee's first name
		System.out.print("Enter first name: ");
		firstName = input.nextLine();

		// ask the user for employee's last name
		System.out.print("Enter last name: ");
		lastName = input.nextLine();

		// ask the user for employee's email
		System.out.print("Enter email: ");
		email = input.nextLine();

		// ask the user for employee's phone number
		while (true) {
			try {
				System.out.print("Enter phone number: ");
				phoneNumber = input.nextLong();
				while (phoneNumber < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch, enter valid phone number");
				input.nextLine(); // clears buffer
			} catch (IllegalArgumentException iae) {
				System.err.println("Phone number cannot be negative");
				input.nextLine();
			}
		}
	}
	
	/**
	 * This method prints detailed user information
	 */
	public void printUser() {
		String fullName = firstName + " " + lastName;
		System.out.printf(" %20s | %20s | %15d |", fullName, email, phoneNumber);
	}
}

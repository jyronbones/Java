package com.algonquincollege.cst8132.lab5;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Assessment: Lab 5
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A store management system that holds employee information and calculates salary
 * Professor Name: Mike Norman
 */

/**
 * This class reads and displays employee information
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public abstract class Employee extends Person{
	/**
	 * stores employee number
	 */
	protected int empNumber;
	/**
	 * stores a worker of person
	 */
	protected Person worker;
	
	/**
	 * no-arg constructor
	 */
	public Employee() {
		
	}
	
	/**
	 * Parameterized constructor assigning personal information and employee number
	 * @param empNumber is a person's employee number
	 * @param firstName is a person's first name
	 * @param lastName is a person's last name
	 * @param email is a person's email
	 * @param phoneNumber is a person's phone number
	 */
	public Employee(int empNumber, String firstName, String lastName, String email, long phoneNumber) {
		super(firstName, lastName, email, phoneNumber);
		this.empNumber = empNumber;
	}
	
	/**
	 * This method reads the details of an employee's personal information
	 * @param input is the passed scanner to read user input
	 */
	public void readEmployee(Scanner input) {
		
		// asks the user for employee number
		while (true) {
			try {
				System.out.print("Enter employee number: ");
				empNumber = input.nextInt();
				while (empNumber < 0) {
					throw new IllegalArgumentException();
				}
				input.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch, enter valid employee number");
				input.nextLine(); // clears buffer
			}  catch (IllegalArgumentException iae) {
				System.err.println("employee number cannot be negative");
				input.nextLine(); // clears buffer
			}
		}
		
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
		
		// creates a person object as a worker with personal details
		worker = new Person(firstName, lastName, email, phoneNumber);
	}

	/**
	 * This method is used to process increments of employees
	 */
	public void processIncrements() {
	}
	
	/**
	 * This method prints account information of an employee
	 */
	public void printEmployee() {
		String fullName = firstName + " " + lastName;
		System.out.printf("%8d | %20s | %20s | %15d |", 
				empNumber, fullName, email, phoneNumber);
	}
}

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
 * This class contains methods to read and print a contractor employee's personal information
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class Contractor extends Employee{
	/**
	 * stores hourly rate of a contractor
	 */
	protected double hourlyRate; // stores hourly rate of a contractor
	/**
	 * stores number of hours worked in that year of a contractor
	 */
	protected double numHours; // stores number of hours worked in that year of a contractor
	
	/*
	 * This method reads the personal information of a contractor
	 */
	/**
	 * This method reads the personal information of a contractor
	 * @param input is a Scanner used to allow input from user for a contractor
	 */
	@Override
	public void readEmployee(Scanner input) {
		super.readEmployee(input);
		
		// ask the user for hourly rate
		while (true) {
			try {
				System.out.print("Enter hourly rate: ");
				hourlyRate = input.nextDouble();
				while (hourlyRate < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch. Please enter a valid hourly rate");
				input.nextLine(); // clears buffer
			} catch (IllegalArgumentException iae) {
				System.err.println("Hourly rate cannot be negative");
				input.nextLine(); // clears buffer
			}
		}
		
		// ask the user for number of hours worked in that year
		while (true) {
			try {
				System.out.print("Enter number of hours worked: ");
				numHours = input.nextDouble();
				while (numHours < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch. Please enter a valid number of hours worked");
				input.nextLine();
			} catch (IllegalArgumentException iae) {
				System.err.println("number of hours worked cannot be negative");
				input.nextLine();
			}
		}
	}
	
	/**
	 * This method is used to increase hourly rate of a contractor by 1
	 */
	@Override
	public void processIncrements() {
		 hourlyRate += 1;
	}

	/**
	 * This method is used to display employee personal information
	 */
	@Override
	public void printEmployee() {
		super.printEmployee(); // this calls employee class printEmployee
		System.out.printf(" %12.2f |\n", numHours * hourlyRate);
	}
}

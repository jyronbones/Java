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
 * This class contains methods to read and print a regular employee's personal information
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class Regular extends Employee{
	/**
	 * stores salary of a regular employee
	 */
	protected double salary; // stores salary of a regular employee
	
	/**
	 * This method reads personal information of a regular employee
	 * @param input is a Scanner used to allow input from user for information of a regular employee
	 */
	@Override
	public void readEmployee(Scanner input) {
		super.readEmployee(input);
		
		// ask the user for annual salary
		while (true) {
			try {
				System.out.print("Enter annual salary: ");
				salary = input.nextDouble() / 12;
				while (salary < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch. Please enter a valid salary");
				input.nextLine();
			} catch (IllegalArgumentException iae) {
				System.err.println("Annual salary cannot be negative");
				input.nextLine();
			}
		}
	}
	
	/**
	 * This method is used to increase salary of a regular employee by 3%
	 */
	@Override
	public void processIncrements() {
		salary *= 1.03;
	}
	
	/**
	 * This method is used to print salary of a regular employee
	 */
	@Override
	public void printEmployee() {
		super.printEmployee();
		System.out.printf(" %12.2f |\n", salary);
	}
}

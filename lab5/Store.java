package com.algonquincollege.cst8132.lab5;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
/*
 * Assessment: Lab 5
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A store management system that holds employee information and calculates salary
 * Professor Name: Mike Norman
 */

/**
 * This class contains the employees and methods to read employee details and display employee details
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class Store {
	private ArrayList<Employee> employees;

	/**
	 * Parameterized constructor initializing the employees array with a size passed from Lab4
	 * @param size is the number of employees of a store
	 */
	public Store(int size) {
		employees = new ArrayList<Employee>(size);
	}

	/**
	 * This method reads the employee type, personal information and stores it in employees array
	 * @param input is the Scanner used to choose which type of employee and their personal information
	 */
	public void readEmployeeDetails(Scanner input) {
		int employeeType = 0;
		boolean goodData = false;
		while (!goodData) {
			while (true) {
				try {
					System.out.println("Enter details of employee " + (employees.size() + 1));
					System.out.print("1. Regular \n" + 
							"2. Contractor\n" + "Enter type of employee: ");
					employeeType = input.nextInt(); 
					break;
				} catch (InputMismatchException e) {
					System.err.println("\n****** Type should be 1 or 2.. please try again ******\n");
					input.nextLine(); // clears buffer
				}
			}
			switch (employeeType) {
			case 1:
				Regular regular = new Regular();
				regular.readEmployee(input);
				employees.add(regular);
				goodData = true;
				break;
			case 2:
				Contractor contractor = new Contractor();
				contractor.readEmployee(input);
				employees.add(contractor);
				goodData = true;
				break;
			default:
				System.out.println("\n****** Type should be 1 or 2.. please try again ******\n");
				break;
			}
		}
	}
	
	/**
	 * This method reads employee details from
	 * @param input is the Scanner used to read file details
	 */
	public void readFileDetails(Scanner input) {

		try {
			input = new Scanner(new File("emp.txt"));

			// Reads employee details line by line in file
			while (input.hasNextLine()) {
				int empType = input.nextInt();
				if (empType == 1) {
					Regular regular = new Regular();
					regular.empNumber = input.nextInt();
					regular.firstName = input.next();
					regular.lastName = input.next();
					regular.email = input.next();
					regular.phoneNumber = input.nextLong();
					regular.salary = input.nextDouble() / 12; // sets employee salary divided by 12 months
					employees.add(regular);
				}
				if (empType == 2) { // employee type is contractor
					Contractor contractor = new Contractor();
					contractor.empNumber = input.nextInt();
					contractor.firstName = input.next();
					contractor.lastName = input.next();
					contractor.email = input.next();
					contractor.phoneNumber = input.nextLong();
					contractor.hourlyRate = input.nextDouble();
					contractor.numHours = input.nextDouble();
					employees.add(contractor);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (InputMismatchException ee) {
			System.err.println("Input mismatch when reading from file");
		}
		if (input != null)
			input.close();
	}
	
	/**
	 * This method processes increments of all employees in employees array list
	 */
	public void processIncrements() {
		if (employees.size() <= 0) {
			System.out.println("\n******No employees to process ******");
		} else { // if employees
			for (int i = 0; i < employees.size(); i++) { // iterates through employees array
				employees.get(i).processIncrements(); // processes increments
			}
		}
	}

	/**
	 * This method prints employee details
	 */
	public void printEmployeeDetails() {
			for (int i = 0; i < employees.size(); i++) { // iterates through employees array
				employees.get(i).printEmployee(); // displays personal details of employee
			}
		}
	
	/**
	 * This method prints the title and header of information table
	 * @param storeName is the name of the store
	 */
	public void printTitle(String storeName) {
		if (employees.size() <= 0) {
			System.out.println("\n******No employees to print ******");
		} else {
			System.out.println();
			printLine();
			System.out.printf("%40s STORE MANAGEMENT SYSTEM", storeName.toUpperCase());
			System.out.println();
			printLine();
			System.out.printf("%8s | %20s | %20s | %15s | %12s |",
					"Emp#", "Name", "Email", "Phone", "Salary");
			System.out.println();
			printLine();
		}
	}
	
	/**
	 * This method prints a row of equal signs
	 */
	public static void printLine() {
		for (int i = 0; i < 89; i++) { // iterates through printing 89 equal signs
			System.out.print("=");
		}
		System.out.println();
	}
}

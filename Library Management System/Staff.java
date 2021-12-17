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
 * This class contains member's personal properties and methods to read staff information and print it
 * @author Byron Jones
 * * @author Byron Jones
 * @version 1.0
 * @since 1.8
 */
public class Staff extends User{
	/**
	 * stores staff ID
	 */
	protected int staffID;
	/**
	 * stores staff's working floor
	 */
	protected int floor;
	/**
	 * stores staff's working section
	 */
	protected int section;
	
	/**
	 * This method reads staff details from a keyboard
	 */
	@Override
	public void readUser(Scanner input) {
		super.readUser(input);
		
		// ask the user for staff ID
		while (true) {
			try {
				System.out.print("Enter staff ID: ");
				staffID = input.nextInt();
				while (staffID < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch. Please enter a valid ID");
				input.nextLine();
			} catch (IllegalArgumentException iae) {
				System.err.println("staff ID cannot be negative");
			}
		}
		
		// ask the user for staff floor
		while (true) {
			try {
				System.out.print("Enter floor: ");
				floor = input.nextInt();
				while (floor < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch. Please enter a valid floor");
				input.nextLine();
			} catch (IllegalArgumentException iae) {
				System.err.println("floor cannot be negative");
			}
		}
		
		// ask the user for staff section
		while (true) {
			try {
				System.out.print("Enter section: ");
				section = input.nextInt();
				while (section < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch. Please enter a valid section");
				input.nextLine();
			} catch (IllegalArgumentException iae) {
				System.err.println("section cannot be negative");
			}
		}
	}
	
	/**
	 * This method prints detailed staff information
	 */
	@Override
	public void printUser() {
		super.printUser();
		System.out.printf(" %8s | %8s | %8s |\n", staffID, floor, section);
	}
}

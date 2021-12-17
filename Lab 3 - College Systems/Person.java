/*
 * Assessment: Lab 3
 * Student Name: Byron Jones
 * Due Date: 10/16/21
 * Description: A college system that holds college information of students personal info, GPA, fees and credits
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;
/**
 * The purpose of this class is to construct a person and store a person's information
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public abstract class Person {
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
	
	/*
	 * This is a no-arg constructor for a person
	 */
	/**
	 * no-argument constructor for a person
	 */
	public Person() {
		
	}
	
	/**
	 * This method allows for user to read info about a person
	 * @param input is the Scanner for user input
	 */
	public void readInfo(Scanner input) {
		
	}
	
	/**
	 * This method displays a person's personal info
	 */
	public void printInfo() {
		
	}

}

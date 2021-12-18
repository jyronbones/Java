/*
 * Assessment: Lab 3
 * Student Name: Byron Jones
 * Due Date: 10/16/21
 * Description: A college system that holds college information of students personal info, GPA, fees and credits
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;
/**
 * This class contains methods to read and print a full time student's personal information
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class FulltimeStudent extends Student{
	private double tuitionFees; // stores tuition fees of a full-time student
	
	/**
	 * This method is used to read the personal information of a full-time student
	 * @param input is a Scanner used to allow input from user for full-time student info
	 */
	@Override
	public void readInfo(Scanner input) {
		super.readInfo(input); // calls the student class readInfo to read full-time student info
		
		// ask the user for tuition fees
		System.out.print("Enter tuition fees: ");
		tuitionFees = input.nextDouble();
	}
	
	/**
	 * This method is used to print the tuition fees of a full-time student
	 * 
	 */
	@Override
	public void printInfo() {
		super.printInfo(); // calls student class printInfo
		System.out.printf(" %8.2f |\n", tuitionFees);
	}
}

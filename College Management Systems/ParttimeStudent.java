/*
 * Assessment: Lab 3
 * Student Name: Byron Jones
 * Due Date: 10/16/21
 * Description: A college system that holds college information of students personal info, GPA, fees and credits
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;
/**
 * This class contains variables and methods to read and print info of a part-time student
 * @author Byron Jones
 *
 */
public class ParttimeStudent extends Student{
	private double courseFees; // holds course fees of a part-time student
	private double credits; // holds credits of a part time-student
	
	/**
	 * This method is used to read info of a part-time student
	 * @param input is a passed Scanner used to read part-time student info
	 */
	@Override
	public void readInfo(Scanner input) {
		super.readInfo(input); // calls readInfo from student class
		
		// ask the user for course fees
		System.out.print("Enter course fees: ");
		courseFees = input.nextDouble();
		
		// ask the user for number of credit hours
		System.out.print("Enter credit hours: ");
		credits = input.nextDouble();
	}
	
	/**
	 * This method is used to display course fees and credit info of a part-time student
	 */
	@Override
	public void printInfo() {
		super.printInfo(); // calls printInfo of student class
		System.out.printf("%9.2f | %8.2f |\n", courseFees, credits);
	}
}

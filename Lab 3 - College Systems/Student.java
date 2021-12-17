/*
 * Assessment: Lab 3
 * Student Name: Byron Jones
 * Due Date: 10/16/21
 * Description: A college system that holds college information of students personal info, GPA, fees and credits
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;
/**
 * This class reads student info, calculates GPA and displays student info 
 *
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class Student extends Person implements Policies {
	/**
	 * Stores a unique student number
	 */
	protected int studentNumber; // unique student number of student
	/**
	 * Stores program name
	 */
	protected String programName; // stores program name of student
	/**
	 * stores student gpa
	 */
	protected double gpa; // stores gpa of student
	
	/*
	 * This is a no-arg constructor of a student
	 */
	/**
	 * no-argument constructor
	 */
	public Student() {

	}
	
	/**
	 * This parameterized constructor initializes student number, program name and gpa
	 * @param studentNumber is the student's number
	 * @param programName is the student's enrolled program
	 * @param gpa is the student's calculated gpa
	 */
	public Student(int studentNumber, String programName, int gpa) {
		this.studentNumber = studentNumber;
		this.programName = programName;
		this.gpa = gpa;
	}
	
	/**
	 * This method is passed a Scanner and reads the details of the student
	 * @param input is the passed scanner to read user input
	 */
	@Override
	public void readInfo(Scanner input) {

		// asks the user for name of program
		System.out.print("Enter program name: ");
		programName = input.nextLine();

		// ask the user for student's number
		System.out.print("Enter student number: ");
		studentNumber = input.nextInt();
		input.nextLine();

		// ask the user for student's first name
		System.out.print("Enter first name: ");
		firstName = input.nextLine();

		// ask the user for student's last name
		System.out.print("Enter last name: ");
		lastName = input.nextLine();

		// ask the user for student's email address
		System.out.print("Enter email Id: ");
		email = input.nextLine();

		// ask the user for student's phone number
		System.out.print("Enter phone number: ");
		phoneNumber = input.nextLong();
		
		readMarks(input); // calls readMarks method

	}
	
	/**
	 * This method reads student marks, stores marks into an array and calls calculateGpa method
	 * @param input is a passed Scanner to read user's marks
	 */
	private void readMarks(Scanner input) {
		
		// ask for number of courses
		System.out.print("Enter number of courses: ");
		int courses = input.nextInt(); // holds number of courses

		double[] marks = new double[courses]; // initializes marks array to the size of number of courses

		for (int i = 0; i < courses; i++) { // asks the user for students mark for each course
			System.out.printf("Enter mark %d: ", i + 1);
			int mark = input.nextInt();
			marks[i] = mark; // stores mark in marks array at a given element
		}
		calculateGpa(marks); // calls calculateGpa method with passed array of marks
	}
	
	/**
	 * This method calculates student gpa based on their marks
	 * @param marks is a student's marks passed as an array
	 */
	@Override
	public void calculateGpa(double[] marks) {
		double totalMarks = 0.0; // initializes starting total marks to 0
		int numCourses = marks.length; // initializes number of courses to number of marks entered

		for (int i = 0; i < numCourses; i++) { // sums marks for total marks
			totalMarks += marks[i];
		}
		gpa = totalMarks / numCourses / MAX_MARKS * MAX_GPA; // calculation for student gpa
	}
	
	/**
	 * This method displays students information
	 */
	@Override
	public void printInfo() {
		String fullName = firstName + " " + lastName;
		System.out.printf("%8s | %8s | %15s | %15s | %12s | %8.2f |", programName, studentNumber, fullName, email,
				phoneNumber, gpa);
	}

}

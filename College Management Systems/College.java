/*
 * Assessment: Lab 3
 * Student Name: Byron Jones
 * Due Date: 10/16/21
 * Description: A college system that holds college information of students personal info, GPA, fees and credits
 * Professor Name: Dr. James Mwandi
 */
import java.util.Scanner;
/*
 * This class holds college info and contains the methods to pick student type and print student info
 */
/**
 * This class holds college info and contains the methods to choose student type as well as displaying student details
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class College {
	private String name; // holds name of college
	private Student[] students; // students array holding students
	private int numStudents; // number of students

	/**
	 * This constructor initializes the name and number of students at a college
	 * @param name is the name of the College
	 * @param size is the number of students at the College
	 */
	College(String name, int size) {
		this.name = name;
		students = new Student[size];
	}

	/**
	 * This method is used to print the header of student information
	 */
	public void printTitle() {
		System.out.printf("%s - List of Students\n", name); // College name title
		for (int i = 0; i < 36; i++) { // prints a row of 36 stars
			System.out.print("*");
		}
		System.out.println(); // line separator
		System.out.printf("%8s | %8s | %15s | %15s | %12s | %8s | %8s | %8s |", "Program", "Student#", "Name", "Email",
				"Phone", "GPA", "Fees", "Credits");
		System.out.println(); // line separator

	}

	/**
	 * This method is used to pick and create a full-time or part-time student, read the student's personal info and store it in students array
	 * @param input is the Scanner used to choose which type of student and to read the student's info
	 */
	public void readStudentDetails(Scanner input) {
		int studentType = 0; // initialize type of student to 0
		if (numStudents < students.length) { // if array is not full
			System.out.printf("Enter details of student %d\n", numStudents + 1);
			System.out.println("===========================");

			while (true) { // input validation ensuring only full-time or part-time student is picked
				System.out.print("1 - Fulltime student \n" + "2 - Parttime Student\n");
				System.out.print("Enter Student type: ");
				studentType = input.nextInt(); // ask the user to enter a student type
				input.nextLine(); // clear buffer
				if (studentType == 1 || studentType == 2) { // if full-time or part-time student
					break;
				} else { // if not full-time student or part-time student
					System.out.println("*** Wrong student type... Please re-enter ***");
				}
			}
			if (studentType == 1) { // if full-time student
				Student fullTimeStudent = new FulltimeStudent(); // creates a full-time student object
				fullTimeStudent.readInfo(input); // calls read info from fullTimeStudent class
				students[numStudents] = fullTimeStudent; // stores fullTimeStudent in students array
			}
			if (studentType == 2) { // if part-time student
				Student partTimeStudent = new ParttimeStudent(); // creates a partTimeStudent object
				partTimeStudent.readInfo(input); // calls read info from partTimeSTudent  class
				students[numStudents] = partTimeStudent; // stores partTimeStudent in a students array
			}
			numStudents++; // increments number of students by 1
		} else { // if array is full
			System.out.println("\n****Array full... cannot add more students ***\n");
		}
	}

	/**
	 * This method is used to display student details
	 */
	public void printStudentDetails() {
		if (numStudents <= 0) { // if no students
			System.out.println("\n*** No students to print ***\n");
		} else { // if students
			printTitle(); // call to printTitle method
			for (int i = 0; i < numStudents; i++) { // prints each student's info+
				students[i].printInfo();
			}
		}
	}
}

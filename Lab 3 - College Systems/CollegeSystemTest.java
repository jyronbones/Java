import java.util.Scanner;
/**
 * This class is the driver class and contains method main
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class CollegeSystemTest {
	/**
	 * This driver method reads College name and number of students, creates a College
	 * and prints a menu to read a student's info, display students info or to exit
	 * @param args is the runtime argument array
	 */
	public static void main(String[] args) {
		
		// instance variables
		Scanner input = new Scanner(System.in);
		boolean continueProgram = true; 
		
		// ask the user to input college name
		System.out.print("Enter name of College: ");
		String collegeName = input.nextLine();
		
		// ask the user to input number of students
		System.out.print("Enter number of students: ");
		int numStudents = input.nextInt();
		
		College college = new College(collegeName, numStudents); // creates a College with passed name and number of students
		
		// prints menu loop until user exits
		do {
			System.out.print("1. Read Students \n" // menu options
					+ "2. Print Details of all Students\n"
					+ "3. Exit \n"
					+ "Enter your option: ");
			int choice = input.nextInt(); // ask the user to enter a choice
			switch (choice) {
			case 1: // read students
				college.readStudentDetails(input);
				break;
				
			case 2: // print details of students
				college.printStudentDetails();
				break;
			case 3: // exits the program
				System.out.println("Goodbye... have a nice day!");
				continueProgram = false;
				break;

			default: // error message if invalid option
				System.out.println("\n*** Wrong choice... please try again ***\n");
				break;
			}
		} while (continueProgram);
		input.close(); // close scanner
	}
}

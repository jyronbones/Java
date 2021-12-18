/*
 * Assessment: Lab 3
 * Student Name: Byron Jones
 * Due Date: 10/16/21
 * Description: A college system that holds college information of students personal info, GPA, fees and credits
 * Professor Name: Dr. James Mwandi
 */
/**
 * The purpose of this interface is to hold instance variables and methods used to calculate GPA
 * 
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public interface Policies {
	
	/**
	 * Max allowed mark of a course
	 */
	public static final int MAX_MARKS = 100; // max allowed mark of a course
	
	/**
	 * Max allowed GPA of a student
	 */
	public static final double MAX_GPA = 4.0; // max allowed GPA of a student
	
	/*
	 * This method is used to calculate GPA from a student's marks
	 */
	/**
	 * This method is passed an array of marks in order to calculate GPA
	 * @param marks is an array of student marks
	 */
	default void calculateGpa(double[] marks) {
		
	}

}

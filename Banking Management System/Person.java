/*
 * Assessment: Lab 2
 * Student Name: Byron Jones
 * Due Date: 10/03/21
 * Description: A banking system that holds accounts, personal info, processes fees and interest
 * Professor Name: Dr. James Mwandi
 */
/*
 * This class stores and gets the information of a person
 */
public class Person {
	
	/*
	 * Instance variables of a person
	 */
	private String firstName;	 // represents first name of a person
	private String lastName;	 // represents last name of a person
	private String email;		 // represents email of a person
	private long phoneNumber; 	// represents phone number of a person
	
	/*
	 * No-arg constructor
	 */
	public Person() {
	}
	
	/*
	 * Parameterized constructor assigning information of a person, passed from Account
	 */
	public Person(String firstName, String lastName, String email, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/*
	 * Accessor for first and last name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}

	/*
	 * Accessor for phone number
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	/*
	 * Accessor for email
	 */
	public String getEmail() {
		return email;
	}

}

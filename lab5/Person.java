package com.algonquincollege.cst8132.lab5;
/*
 * Assessment: Lab 5
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A store management system that holds employee information and calculates salary
 * Professor Name: Mike Norman
 */

/**
 * This class stores and returns the information of a person
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class Person {

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
	
	/**
	 * No-arg constructor
	 */
	public Person() {
		super();
	}
	
	/**
	 * Parameterized constructor assigning information of a person, passed from Employee
	 * @param firstName is a person's first name
	 * @param lastName is a person's last name
	 * @param email is a person's email
	 * @param phoneNumber is a person's phone number
	 */
	public Person(String firstName, String lastName,String email, long phoneNumber) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
}

package com.algonquin.cst8132.library;
/*
 * Assessment: Lab 6
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A library management system
 * Professor Name: Mike Norman
 */
/**
 * This interface contains the field variables of overdue fine and max number of books for a member
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 */
public interface Policies {
	/**
	 * stores overdue fine amount of a book
	 */
	public static final double fine = 1.00;
	/**
	 * stores max number of books a member can rent at a time
	 */
	public static final int maxBooks = 5;
}

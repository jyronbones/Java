package com.algonquin.cst8132.library;
/*
 * Assessment: Lab 6
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A library management system
 * Professor Name: Mike Norman
 */
/**
 * This class contains properties and behaviors of a fiction book of type fantasy
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class Fantasy extends Fiction{
	/**
	 * stores genre of a fantasy book
	 */
	protected String genre;
	
	/**
	 * This method prints a fiction type book's genre fantasy
	 */
	@Override
	public void printBooks() {
		super.printBooks();
		System.out.printf("| %10s |\n", genre);
	}
}

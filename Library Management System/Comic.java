package com.algonquin.cst8132.library;

/*
 * Assessment: Lab 6
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A library management system
 * Professor Name: Mike Norman
 */
/*
 * This class contains properties and behaviors of a fiction book of type comic
 */
/**
 * This class contains properties and behaviors of a fiction book of type comic
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class Comic extends Fiction{
	/**
	 * stores genre of a comic book
	 */
	protected String genre;
	
	/*
	 * This method prints a fiction type book's genre fiction
	 */
	/**
	 * This method prints a fiction type book's genre fiction
	 */
	@Override
	public void printBooks() {
		super.printBooks();
		System.out.printf("| %10s |\n", genre);
	}
}

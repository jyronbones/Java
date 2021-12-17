package com.algonquin.cst8132.library;
/*
 * Assessment: Lab 6
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A library management system
 * Professor Name: Mike Norman
 */
/**
 * This class contains properties and behaviors of a non-fiction book of type history
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class History extends NonFiction{
	/**
	 * stores genre of a history book
	 */
	protected String genre;
	
	/**
	 * This method prints a non-fiction type book's genre history
	 */
	@Override
	public void printBooks() {
		super.printBooks();
		System.out.printf("| %10s |\n", genre);
	}
}

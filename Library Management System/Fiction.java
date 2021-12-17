package com.algonquin.cst8132.library;

/*
 * Assessment: Lab 6
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A library management system
 * Professor Name: Mike Norman
 */
/*
 * This class contains the type of book and method to print book fiction book details
 */
/**
 * This class contains the type of book and method to print book fiction book details
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 */
public class Fiction extends Book{
	/**
	 * stores genre of a fiction book
	 */
	protected String type;
	
	/*
	 * This method prints a fiction type book's details
	 */
	/**
	 * This method prints a fiction type book's details
	 */
	@Override
	public void printBooks() {
		System.out.printf("| %25s | %15s | %10s | %15s ", bookTitle, bookAuthor, isbn, type);
	}
}

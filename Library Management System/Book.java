package com.algonquin.cst8132.library;
/*
 * Assessment: Lab 6
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A library management system
 * Professor Name: Mike Norman
 */
/**
 * This class contains properties and behaviors of a book
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class Book {
	/**
	 * stores book title
	 */
	protected String bookTitle;	
	/**
	 * stores book author
	 */
	protected String bookAuthor;
	/**
	 * stores isbn
	 */
	protected int isbn;

	/**
	 * This is a no-argument constructor
	 */
	public Book() {
	}
	
	/**
	 * This method prints books and their details
	 */
	public void printBooks() {
	}
	
	/**
	 * This method accesses the book title
	 */
	@Override
	public String toString() {
		return bookTitle;
	}
}

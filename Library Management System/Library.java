package com.algonquin.cst8132.library;
/*
 * Assessment: Lab 6
 * Student Name: Byron Jones
 * Due Date: 11/14/21
 * Description: A library management system
 * Professor Name: Mike Norman
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains properties and behaviors of a working library
 * @author Byron Jones
 * @version 1.0
 * @since 1.8
 *
 */
public class Library implements Policies{
	private ArrayList<User> users;
	private ArrayList<Book> books;
	private ArrayList<Member> members;
	
/**
 * This constructor initializes the users, books and members array	
 */
public Library() {
		super();
		users = new ArrayList<>();
		books = new ArrayList<>();
		members = new ArrayList<>();
	}

/**
 * This method chooses user type and reads user's information entered by keyboard
 * @param input is the passed Scanner to read user input
 */
public void readUserInfo(Scanner input) {
	int userType = 0;
	boolean goodData = false;
	while (!goodData) {
		while (true) {
			try {
				System.out.print("1. Staff \n" + // ask user for type of user
						"2. Member\n" + "Enter type of user: ");
				userType = input.nextInt(); // stores user type option
				input.nextLine(); // clear buffer
				break;
			} catch (InputMismatchException e) {
				System.err.println("\n****** Type should be 1 or 2.. please try again ******\n");
				input.nextLine(); // clears buffer
			}
		}
		switch (userType) {
		case 1:
			Staff staff = new Staff(); // creates a staff object
			staff.readUser(input); // calls readUser from Staff class
			users.add(staff); // stores a staff user in users array
			goodData = true;
			break;
		case 2:
			Member member = new Member(); // creates a member object
			member.readUser(input); // calls readUser from Member class
			members.add(member); // stores member in member array
			goodData = true;
			break;
		default:
			System.out.println("\n****** Type should be 1 or 2.. please try again ******\n");
			break;
		}
	}
}

/**
 * This method reads user details from a file
 * @param input is the Scanner used to read file details
 */
public void readUserFileDetails(Scanner input) {

	try {
		input = new Scanner(new File("users.txt"));

		// Reads user details line by line in file
		while (input.hasNextLine()) {
			int empType = input.nextInt(); // stores user type
			if (empType == 1) { // user type is regular
				Staff staff = new Staff(); // creates a staff object
				staff.staffID = input.nextInt(); // stores user ID of a staff user
				staff.firstName = input.next(); // stores first name of staff
				staff.lastName = input.next(); // stores last name of staff
				staff.email = input.next(); // stores email of staff
				staff.phoneNumber = input.nextLong(); // stores phone number of staff
				staff.floor = input.nextInt(); // stores working floor of staff
				staff.section = input.nextInt(); // stores working section of staff
				users.add(staff); // adds staff to users ArrayList
			}
			if (empType == 2) { // user is type member
				Member member = new Member(); // creates a member object object
				member.memberID = input.nextInt(); // stores employee number of regular employee
				member.firstName = input.next(); // stores first name of regular employee
				member.lastName = input.next(); // stores last name of regular employee
				member.email = input.next(); // stores email of regular employee
				member.phoneNumber = input.nextLong(); // stores phone number of regular employee
				member.age = input.nextInt(); // sets employee salary divided by 12
				member.balance = input.nextInt(); // stores regular employee in employee array list
				members.add(member);
			}
		}
	} catch (FileNotFoundException e) {
		System.err.println("File not found");
		e.printStackTrace();
	} catch (InputMismatchException ee) {
		System.err.println("Input mismatch when reading from file");
		ee.printStackTrace();
	}
	if (input != null) // if of end of file
		input.close(); // close scanner
	System.out.println("\n*****Successfully imported user's from file*****");
}

/**
 * This method prints the information of a staff users
 */
public void printStaffInfo() {
	for (User staff : users) { // iterates through users array list and prints each members information
		staff.printUser();
	}
}

/**
 * This method prints the information of a member user
 */
public void printMemberInfo() {
	for (Member member : members) { // iterates through users array list and prints each members information
		member.printUser();
	}
}

/**
 * This method reads books and their details from a file
 * @param input is the passed Scanner to read details of a book
 */
public void readBooksInfo(Scanner input) {
		
		Path bookPath = Paths.get("book_list.txt");
		try  {
			input = new Scanner(bookPath.toFile());
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] bookColumns = line.split(",");
				String genre = bookColumns[0];
				int isbn = Integer.parseInt(bookColumns[1]);
				String bookTitle = bookColumns[2];
				String bookAuthor = bookColumns[3];
				String bookType = bookColumns[4];
				
				if (genre.equalsIgnoreCase("comic")) {
					Comic comic = new Comic();
					comic.genre = genre;
					comic.bookTitle = bookTitle;
					comic.bookAuthor = bookAuthor;
					comic.isbn = isbn;
					comic.type = bookType;
					books.add(comic);
				} else if (genre.equalsIgnoreCase("fantasy")) {
					Fantasy fantasy = new Fantasy();
					fantasy.genre = genre;
					fantasy.bookTitle = bookTitle;
					fantasy.bookAuthor = bookAuthor;
					fantasy.isbn = isbn;
					fantasy.type = bookType;
					books.add(fantasy);
				} else if (genre.equalsIgnoreCase("history")) {
					History history = new History();
					history.genre = genre;
					history.bookTitle = bookTitle;
					history.bookAuthor = bookAuthor;
					history.isbn = isbn;
					history.type = bookType;
					books.add(history);
				} else if (genre.equalsIgnoreCase("science")) {
					Science science = new Science();
					science.genre = genre;
					science.bookTitle = bookTitle;
					science.bookAuthor = bookAuthor;
					science.isbn = isbn;
					science.type = bookType;
					books.add(science);
				} else if (genre.equalsIgnoreCase("biography")) {
					Biography biography = new Biography();
					biography.genre = genre;
					biography.bookTitle = bookTitle;
					biography.bookAuthor = bookAuthor;
					biography.isbn = isbn;
					biography.type = bookType;
					books.add(biography);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			e.printStackTrace();
		} catch (InputMismatchException ee) {
			System.err.println("Input mismatch when reading from file");
			ee.printStackTrace();
		}
		if (input != null) // if of end of file
			input.close(); // close scanner
		System.out.println("\n*****Sucessfully imported library books from file*****");
	}
	
	/*
	 * This method prints the list of books and their details
	 */
	/**
	 * This method prints the list of books and their details
	 */
	public void printBooks() {
		for ( Book book : books) { // iterates through array list of books printing books and its details
			book.printBooks();
		}
	}
	
	/**
	 * This method rents a book for a specific member
	 * @param input is the passed Scanner reading book to be withdrawn
	 */
	public void withdrawBook(Scanner input) {
		int memberID;
		int bookIsbn;
		// ask the user for member's ID
		while (true) {
			try {
				System.out.print("Enter member ID: ");
				memberID = input.nextInt();
				while (memberID < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch, enter valid member ID");
				input.nextLine(); // clears buffer
			} catch (IllegalArgumentException iae) {
				System.err.println("Member ID cannot be negative");
				input.nextLine();
			}
		}
		while (true) {
			try {
				System.out.print("Enter book ISBN: ");
				bookIsbn = input.nextInt();
				while (bookIsbn < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch, enter valid book ISBN");
				input.nextLine(); // clears buffer
			} catch (IllegalArgumentException iae) {
				System.err.println("ISBN cannot be negative");
				input.nextLine();
			}
		}

		Book book = getBookIsbn(bookIsbn); // gets and stores the book isbn from the books array
		Member member = getMemberID(memberID); // gets and stores the member ID from the members array
		if (member == null && book == null) {
			System.out.println("No such user and no such book");
			return;
		}
		if (member != null) {
			if (book != null) {
				if (member.rentedBooks.size() == Policies.maxBooks) {
					System.out.println("*****Max books withdrawn, cannot rent book*****");
				} else {
					member.rentedBooks.add(book);
					member.daysRented = 1;
					System.out.println("\n*****Successfully rented book*****");
				}
			} else {
				System.out.println("No such book");
			}
		} else {
			System.out.println("No such user");
		}
	}
	
	/**
	 * This method is used to return a member's book back to library
	 * @param input is Scanner used to read a book to be returned
	 */
	public void returnBook(Scanner input) {
		int memberID;
		int bookIsbn;
		// ask the user for member's ID
		while (true) {
			try {
				System.out.print("Enter member ID: ");
				memberID = input.nextInt();
				while (memberID < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch, enter valid member ID");
				input.nextLine(); // clears buffer
			} catch (IllegalArgumentException iae) {
				System.err.println("Member ID cannot be negative");
				input.nextLine();
			}
		}
		while (true) {
			try {
				System.out.print("Enter book ISBN: ");
				bookIsbn = input.nextInt();
				while (bookIsbn < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch, enter valid book ISBN");
				input.nextLine(); // clears buffer
			} catch (IllegalArgumentException iae) {
				System.err.println("ISBN cannot be negative");
				input.nextLine();
			}
		}
		
		Book book = getBookIsbn(bookIsbn); // gets and stores the book isbn from the books array
		Member member = getMemberID(memberID); // gets and stores the member ID from the members array
		if (member == null && book == null) {
			System.out.println("No such user and no such book");
			return;
		}
		if (member != null) {
			if (book != null) {
				if (member.rentedBooks.size() <= 0) {
					System.out.println("*****No books to return*****");
				} else {
					member.rentedBooks.remove(book);
					System.out.println("\n*****Successfully returned book*****");
				}
			} else {
				System.out.println("No such book");
			}
		} else {
			System.out.println("No such user");
		}
	}
	
	/**
	 * This method accesses a member id from members array list
	 * @param memberID is the passed member ID from user input
	 * @return member with matching member ID in member array list
	 */
	public Member getMemberID(int memberID) {
		for (Member member : members) { // checks if user entered member ID matches any members ID in member array list
			if (member.memberID == memberID) {
			return member;
			}
		}
		return null;
	}
	
	/**
	 * This method accesses a book isbn from books array list
	 * @param Isbn is the passed book isbn from user input
	 * @return book with matching book isbn in books array list
	 */
	public Book getBookIsbn(int Isbn) {
		for (Book book : books) { // checks if user entered book isbn matches any books isbn in books array list
			if (book.isbn == Isbn) {
				return book;
			}
		}
		return null;
	}
	
	/**
	 * This method calculates overdue fees a member owes based on rented days
	 * @param input is the passed Scanner used for input to calculate overdue fees
	 */
	public void calculateFees(Scanner input) {
		int memberID;
		int days;
		
		// ask the user for member's ID
		while (true) {
			try {
				System.out.print("Enter member ID: ");
				memberID = input.nextInt();
				while (memberID < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch, enter valid member ID");
				input.nextLine(); // clears buffer
			} catch (IllegalArgumentException iae) {
				System.err.println("Member ID cannot be negative");
				input.nextLine();
			}
		}
		
		Member member = getMemberID(memberID);
		if (member == null) {
			System.out.println("No such member");
			return;
		} else if (member.rentedBooks.size() <= 0) {
			System.out.println("\nMember ID: " + member.memberID + "\nMember name: " 
		+ member.firstName + " " + member.lastName + "\nMember has no books");
			return;
		}
		
		// ask the user for number of days rented
		while (true) {
			try {
				System.out.print("Enter number of days rented: ");
				days = input.nextInt();
				while (days < 0) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("Input mismatch, enter valid number of days");
				input.nextLine(); // clears buffer
			} catch (IllegalArgumentException iae) {
				System.err.println("Days cannot be negative");
				input.nextLine();
			}
		}
		
		if (days < 14) {
			System.out.println("\nNo late fees for " + member.firstName + " " + member.lastName);
			return;
		} else {
			member.balance += (Policies.fine * (days - 14)) * member.rentedBooks.size();
			System.out.println("\nMember ID: " + member.memberID + "\nMember name: " 
					+ member.firstName + " " + member.lastName
							+ "\nUpdated balance: " + member.balance);
		}
	}
	
	/**
	 * This method is used to pay a member's overdue fees
	 * @param input is the passed Scanner used for input to pay overdue fees of a member
	 */
	public void payFees(Scanner input) {
		int memberID;
		double payment;
		
				// ask the user for member's ID
				while (true) {
					try {
						System.out.print("Enter member ID: ");
						memberID = input.nextInt();
						while (memberID < 0) {
							throw new IllegalArgumentException();
						}
						break;
					} catch (InputMismatchException e) {
						System.err.println("Input mismatch, enter valid member ID");
						input.nextLine(); // clears buffer
					} catch (IllegalArgumentException iae) {
						System.err.println("Member ID cannot be negative");
						input.nextLine();
					}
				}
				
				Member member = getMemberID(memberID);
				
				if (member == null) {
					System.out.println("No such member");
					return;
				}
				
				if (member.balance == 0) {
					System.out.print("\nMember ID: " + member.memberID + "\nMember name: " + member.firstName + " "
							+ member.lastName + "\nBalance: " + member.balance + "\nNo overdue fees\n");
					return;
				}
				
				// ask the user for number of days rented
				while (true) {
					try {
						System.out.print("\nMember ID: " + member.memberID + "\nMember name: " + member.firstName + " "
								+ member.lastName + "\nBalance: " + member.balance + "\nEnter payment amount: ");
						payment = input.nextInt();
						while (payment < 0) {
							throw new IllegalArgumentException();
						}
						if (payment > member.balance) {
							System.out.println("\nYou cannot pay more than the balance, try again");
						} else {
							break;
						}
					} catch (InputMismatchException e) {
						System.err.println("Input mismatch, enter valid payment");
						input.nextLine(); // clears buffer
					} catch (IllegalArgumentException iae) {
						System.err.println("payment cannot be negative");
						input.nextLine();
					}
				}
				member.balance -= payment;
	}
	
	/**
	 * This methods the print the title and header for a list of books
	 * @param libraryName is the passed library name from LibraryTest class
	 */
	public void printBookTitle(String libraryName) {
		if (books.size() <= 0) { // if no employees
			System.out.println("\n******No books to print ******");
		} else { // if employees
			System.out.println(); // line separator
			printBookTitleLine(); // call to method printing row of =
			System.out.printf("%40s's Library Book List", libraryName); // centers library name title
			System.out.println(); // line separator
			printBookTitleLine(); // call to method printing row of =
			System.out.printf("| %25s | %15s | %10s | %15s | %10s |", // prints column headers
					"Book Title", "Book Author", "ISBN", "Type", "Genre");
			System.out.println(); // line separator
			printBookTitleLine(); // call to method printing row of =
		}
	}
	
	/**
	 * This method prints the title and header of staff table
	 * @param libraryName is the passed name of the library from the Library class
	 */
	public void printStaffTitle(String libraryName) {
		if (users.size() <= 0) { // if no employees
			System.out.println("\n******No staff to print ******");
		} else { // if employees
			System.out.println(); // line separator
			printStaffTitleLine(); // call to method printing row of =
			System.out.printf("%40s's Library Staff List", libraryName); // centers library name title
			System.out.println(); // line separator
			printStaffTitleLine(); // call to method printing row of =
			System.out.printf(" %20s | %20s | %15s | %8s | %8s | %8s |", // prints column headers
					"Name", "Email", "Phone Number", "Staff ID", "Floor", "Section");
			System.out.println(); // line separator
			printStaffTitleLine(); // call to method printing row of =
		}
	}
	
	/**
	 * This method prints the title and header of member table
	 * @param libraryName is the passed library name from the Library class
	 */
	public void printMemberTitle(String libraryName) {
		if (members.size() <= 0) { // if no employees
			System.out.println("\n******No members to print ******");
		} else { // if employees
			System.out.println(); // line separator
			printMemberTitleLine(); // call to method printing row of =
			System.out.printf("%65s's Library Member List", libraryName); // centers library name title
			System.out.println(); // line separator
			printMemberTitleLine(); // call to method printing row of =
			System.out.printf(" %20s | %20s | %15s | %8s | %5s | %8s | %50s |", // prints column headers
					"Name", "Email", "Phone Number", "Member ID", "Age", "Balance", "Rented Books");
			System.out.println(); // line separator
			printMemberTitleLine(); // call to method printing row of =
		}
	}
	
	/**
	 * This method prints a row of equal signs for book title
	 */
	private void printBookTitleLine() {
		for (int i = 0; i < 91; i++) { // iterates through printing 89 equal signs
			System.out.print("=");
		}
		System.out.println(); // line separator
	}
	
	/**
	 * This method prints a row of equal signs for staff header and title
	 */
	private void printStaffTitleLine() {
		for (int i = 0; i < 97; i++) { // iterates through printing 89 equal signs
			System.out.print("=");
		}
		System.out.println(); // line separator
	}
	
	/**
	 * This method prints a row of equal signs for member title and header
	 */
	private void printMemberTitleLine() {
		for (int i = 0; i < 148; i++) { // iterates through printing 89 equal signs
			System.out.print("=");
		}
		System.out.println(); // line separator
	}
}

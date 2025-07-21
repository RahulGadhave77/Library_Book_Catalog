package com.library;

import java.util.Scanner;

import com.library.Ripository.BookRepo;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		BookRepo book = new BookRepo();

		System.out.println("Enter a number to perform the opration");
		System.out.println("1.Add a book");
		System.out.println("2. Get a book Detail ");
		System.out.println("3.update Available Copies ");
		System.out.println("4.delete a book  ");
		
		System.out.println("press 5  add book with bookdetails");
		
		Scanner sc = new Scanner(System.in);
		int opration = sc.nextInt();

		switch (opration) {
		case 1:
			book.addBook();
		case 2:
			book.getBook();
			break;
		case 3:
			book.updateAvailableCopies();
			break;
		case 4:
			book.deleteBook();
			break;
		case 5:
			book.addBookWithDetails();
			break;
			
			default: System.out.println("Enter Valid opration");
		}

	}
}

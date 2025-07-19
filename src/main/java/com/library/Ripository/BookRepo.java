package com.library.Ripository;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.library.Utility.LibraryUtility;
import com.library.entity.BookDetail;

public class BookRepo {
	Scanner sc = new Scanner(System.in);

	public void addBook() {

		BookDetail book = new BookDetail();

		System.out.println("Enter a Book title");
		String bookTitle = sc.next();
		book.setBookTitle(bookTitle);

		System.out.println("Enter the Author");
		String bookAuthor = sc.next();
		book.setBookAuthor(bookAuthor);

		System.out.println("Enter the book isbn ");
		String bookISBN = sc.next();
		book.setBookISBN(bookISBN);

		System.out.println("Enter Available copies");
		int bookAvailableCopis = sc.nextInt();
		book.setBookAvailableCopies(bookAvailableCopis);

		SessionFactory factory = LibraryUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(book);

		transaction.commit();
		session.close();
	}

	public void getBook() {
		SessionFactory factory = LibraryUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter Author name");
		String bookAuthor = sc.next();

		List<BookDetail> b = session.createQuery("select b from BookDetail b where b.bookAuthor = :bookAuthor",
				BookDetail.class).setParameter("bookAuthor", bookAuthor).getResultList();


		b.stream().forEach(k -> System.out.println(k));
		transaction.commit();
		session.close();

	}

	public void updateAvailableCopies() {
		SessionFactory factory = LibraryUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter book id ");
		int bookId = sc.nextInt();
		BookDetail book = session.find(BookDetail.class, bookId);

		System.out.println("Enter AVailable copies");
		int availableCopies = sc.nextInt();
		book.setBookAvailableCopies(availableCopies);

		transaction.commit();
		session.close();
	}

	public void deleteBook() {
		SessionFactory factory = LibraryUtility.getfactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter a ISBN");
		String bookIsbn = sc.next();

		BookDetail b = session.createQuery("select s from BookDetail s where BookISBN = :bookIsbn", BookDetail.class)
				.setParameter("bookIsbn", bookIsbn).getSingleResult();

		session.remove(b);

		transaction.commit();
		session.close();
	}
}

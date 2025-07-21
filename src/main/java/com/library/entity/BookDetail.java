package com.library.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BookDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	private String bookTitle;
	
	private String bookAuthor;
	
	private String BookISBN;
	
	private int bookAvailableCopies;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private BookDetails bookDetails;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookISBN() {
		return BookISBN;
	}

	public void setBookISBN(String bookISBN) {
		BookISBN = bookISBN;
	}

	public int getBookAvailableCopies() {
		return bookAvailableCopies;
	}

	public void setBookAvailableCopies(int bookAvailableCopies) {
		this.bookAvailableCopies = bookAvailableCopies;
	}

	public BookDetails getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(BookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}

	@Override
	public String toString() {
		return "BookDetail [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", BookISBN=" + BookISBN + ", bookAvailableCopies=" + bookAvailableCopies + ", bookDetails="
				+ bookDetails + "]";
	}
	
	

}

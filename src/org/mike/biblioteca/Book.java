package org.mike.biblioteca;

import java.util.ArrayList;

/**
 * Representación de un libro.
 */
public class Book {
	private String title;
	private String author;
	private String publisher;
	private String isbn;
	private String genre;
	private ArrayList<BookCopy> copies = new ArrayList<BookCopy>();
	
	public Book(String title, String author, String publisher, String isbn, String genre) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.genre = genre;
	}
	
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getGenre() {
		return this.genre;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public ArrayList<BookCopy> getCopies(){
		return this.copies;
	}
	public int getCopiesNumber() {
		return this.copies.size();
	}
	public void addCopy() {
		this.copies.add(new BookCopy(this));
	}
	public void removeCopy() {
		this.copies.removeLast();
	}
	
}

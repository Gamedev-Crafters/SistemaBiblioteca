package org.mike.biblioteca;

/**
 * Representación de un préstamo de un {@link BookCopy} de {@link Book} a un {@link User}.
 */
public class Lease {
	private User user;
	private Book book;
	private BookCopy bookCopy;
	
	public Lease(User user, Book book, BookCopy bookCopy) {
		this.user = user;
		this.book = book;
		this.bookCopy = bookCopy;
	}
	
	public String toString() {
		return "Usuario: " + user.getName() + "\nLibro: " + book.getTitle();
	}
	
	public User getUser() {
		return this.user;
	}
	
	public Book getBook(){
		return this.book;
	}
	
	public BookCopy getBookCopy() {
		return this.bookCopy;
	}
}

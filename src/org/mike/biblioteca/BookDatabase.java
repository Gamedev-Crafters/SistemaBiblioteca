package org.mike.biblioteca;

import java.util.ArrayList;

public class BookDatabase {
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public BookDatabase() {
		
	}
	
	public ArrayList<Book> getBooks(){
		return this.books;
	}
}

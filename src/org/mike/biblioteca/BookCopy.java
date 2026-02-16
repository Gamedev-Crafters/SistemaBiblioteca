package org.mike.biblioteca;

/**
 * Representación de un ejemplar de {@link Book}.
 */
public class BookCopy {
	// Variable estática empleada para calcular el ID
	static int id_count = 0;
	private int id;
	private Book book;
	private String location;
	private boolean avaliable;
	
	public BookCopy(Book book) {
		this.book = book;
		this.id = id_count;
		avaliable = true;
		id_count++;
	}
	
	public boolean isAvaliable() {
		return this.avaliable;
	}
	
	public void setAvaliable(boolean avaliability) {
		this.avaliable = avaliability;
	}
}

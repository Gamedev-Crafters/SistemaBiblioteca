package org.mike.biblioteca;

/**
 * Vista de la biblioteca
 */
public class LibraryView {
	
	public LibraryView() {
		
	}
	
	/**
	 * Imprime el menú de gestión de la biblioteca y devuelve la opción elegida.
	 * @return int La opción escogida por el usuario.
	 */
	public int displayLibraryMenu() {
		System.out.println("\n=== Gestión de Libros ===");
		System.out.println("1. Añadir Libro");
		System.out.println("2. Eliminar Libro");
		System.out.println("3. Añadir Ejemplar");
		System.out.println("4. Eliminar Ejemplar");
		System.out.println("5. Buscar Libro");
		System.out.println("6. Volver al menú principal");
		
		return UserInput.getInt();
	}
	
	public Book askUserForBook() {
		System.out.print("Introduce el nombre del libro: ");
		String bookName = UserInput.getString();
		System.out.print("Introduce el autor del libro: ");
		String bookAuthor = UserInput.getString();
		System.out.print("Introduce la editorial del libro: ");
		String bookPublisher = UserInput.getString();
		System.out.print("Introduce el ISBN del libro: ");
		String bookIsbn = UserInput.getString();
		System.out.print("Introduce el género del libro: ");
		String bookGenre = UserInput.getString();
		
		return new Book(bookName, bookAuthor, bookPublisher, bookIsbn, bookGenre);
	}
	
	public int displayUserFindBookMenu() {
		System.out.println("=== Buscador de Libros ===");
		System.out.println("1. Buscar por Nombre");
		System.out.println("2. Buscar por ISBN");
		System.out.println("3. Volver atrás");
		
		return UserInput.getInt();
	}
	
	public String askBookName() {
		System.out.print("Introduce el nombre del libro: ");
		return UserInput.getString();
	}
	
	public String askBookIsbn() {
		System.out.print("Introduce el ISBN del libro: ");
		return UserInput.getString();
	}
	
	public void printBook(Book book) {
		System.out.println("\n" + "Título: " + book.getTitle());
		System.out.println("Autor: " + book.getAuthor());
		System.out.println("Género: " + book.getGenre());
		System.out.println("ISBN: " + book.getIsbn());
		System.out.println("Nº de Ejemplares: " + book.getCopiesNumber() + "\n");
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}
}

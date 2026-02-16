package org.mike.biblioteca;

/**
 * Controlador de los libros y ejemplares en la biblioteca.
 */
public class LibraryController {
	
	private LibraryView libraryView = new LibraryView();
	
	private BookDatabase bookDatabase;
	
	/**
	 * El constructor con el argumento del modelo de la biblioteca.
	 * El modelo de usuarios debe introducirse para la inyección de dependencias.
	 * @param bookDatabase El modelo de la biblioteca.
	 */
	public LibraryController(BookDatabase bookDatabase) {
		this.bookDatabase = bookDatabase;
	}
	
	public void start() {
		boolean userReturn = false;
		
		do {
			int userAnswer = libraryView.displayLibraryMenu();
			
			switch(userAnswer) {
			// Añadir Libro
			case 1:
				addBook();
				break;
			// Eliminar Libro
			case 2:
				removeBook();
				break;
			// Añadir Ejemplar
			case 3:
				addBookCopy();
				break;
			// Eliminar Ejemplar
			case 4:
				removeBookCopy();
				break;
			// Buscar Libro
			case 5:
				userFindBook();
				break;
			// Volver al menú principal
			case 6:
			default:
				userReturn = true;
				break;
			}
		} while(!userReturn);
	}
	
	private void addBook() {
		Book bookToAdd = libraryView.askUserForBook();
		
		if(findBookByIsbn(bookToAdd.getIsbn()) == null) {
			bookDatabase.getBooks().add(bookToAdd);
			libraryView.printMessage("\nEl libro ha sido añadido correctamente.\n");
		} else {
			libraryView.printMessage("\nYa existe un libro con el mismo ISBN.\n");
		}
	}
	
	private void removeBook() {
		Book bookToDelete = findBookByName(libraryView.askBookName());
		
		if(bookToDelete != null) {
			bookDatabase.getBooks().remove(bookToDelete);
			libraryView.printMessage("El libro se ha eliminado correctamente.\n");
		} else {
			libraryView.printMessage("El libro no se ha encontrado.\n");
		}
		
	}
	
	private void addBookCopy() {
		Book bookToAddCopy = findBookByName(libraryView.askBookName());
		
		if(bookToAddCopy != null) {
			bookToAddCopy.addCopy();
			libraryView.printMessage("El ejemplar se ha añadido correctamente.");
		} else {
			libraryView.printMessage("El libro no se ha encontrado.");
		}
		
	}
	
	private void removeBookCopy() {
		Book bookToRemoveCopy = findBookByName(libraryView.askBookName());
		
		if(bookToRemoveCopy != null) {
			if(bookToRemoveCopy.getCopiesNumber() > 0) {
				bookToRemoveCopy.removeCopy();
				libraryView.printMessage("Se ha eliminado un ejemplar correctamente.\n");
			} else {
				libraryView.printMessage("Este libro no tiene ejemplares.\n");
			}
		} else {
			libraryView.printMessage("El libro no se ha encontrado.\n");
		}
	}
	
	private void userFindBook() {
		int userAnswer = libraryView.displayUserFindBookMenu();
		Book bookToFind = null;
		
		switch(userAnswer) {
		case 1:
			bookToFind = findBookByName(libraryView.askBookName());
			if(bookToFind != null) {
				libraryView.printBook(bookToFind);
			} else {
				libraryView.printMessage("El libro no ha sido encontrado.\n");
			}
			break;
		case 2:
			bookToFind = findBookByIsbn(libraryView.askBookIsbn());
			if(bookToFind != null) {
				libraryView.printBook(bookToFind);
			} else {
				libraryView.printMessage("El libro no ha sido encontrado.\n");
			}
			break;
		case 3:
		default:
			break;
		}
	}
	
	public Book findBookByName(String bookName) {
		Book bookToFind = null;
		
		for(Book book : bookDatabase.getBooks()) {
			if(book.getTitle().equals(bookName)) {
				bookToFind = book;
			}
		}
		
		return bookToFind;
	}
	
	private Book findBookByIsbn(String bookIsbn) {
		Book bookToFind = null;
		
		for(Book book : bookDatabase.getBooks()) {
			if(book.getIsbn().equals(bookIsbn)){
				bookToFind = book;
			}
		}
		
		return bookToFind;
	}
	
}

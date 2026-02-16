package org.mike.biblioteca;

import java.util.ArrayList;

/**
 * Controlador de prestamos.
 */
public class LeaseController {

	private LeaseView leaseView = new LeaseView();
	private LeaseDatabase leaseDatabase;
	private LibraryController libraryControler;
	private UserController userController;
	
	/**
	 * Constructor con inyección de dependendias.
	 * @param leaseDatabase El modelo de prestamos
	 * @param libraryControler El controlador de biblioteca
	 * @param userController El controlador de usuarios
	 */
	public LeaseController(LeaseDatabase leaseDatabase, LibraryController libraryControler, UserController userController) {
		this.leaseDatabase = leaseDatabase;
		this.libraryControler = libraryControler;
		this.userController = userController;
	}
	
	public void start() {
		boolean userReturn = false;
		
		do {
			int userAnswer = leaseView.displayLeaseMenu();
			
			String bookName;
			String userName;
			User user;
			Book book;
			
			switch(userAnswer) {
			// Prestar Ejemplar
			case 1:
				userName = leaseView.askUserForUserName();
				bookName = leaseView.askUserForBookName();
				user = userController.findUser(userName);
				book = libraryControler.findBookByName(bookName);
				if(user == null || book == null) {
					leaseView.printMessage("Los datos introducidos no son correctos.\n");
				} else {
					leaseBookCopy(user, book);
					leaseView.printMessage("El préstamo se ha añadido correctamente.\n");
				}
				break;
			// Devolver Ejemplar
			case 2:
				userName = leaseView.askUserForUserName();
				bookName = leaseView.askUserForBookName();
				user = userController.findUser(userName);
				book = libraryControler.findBookByName(bookName);;
				if(user == null || book == null) {
					leaseView.printMessage("Los datos introducidos no son correctos.\n");
				} else {
					Lease lease = findLease(user, book);
					if(lease != null) {
						returnBookCopy(lease);
					} else {
						leaseView.printMessage("No existe ese préstamo.\n");
					}
				}
				break;
			// Mostrar Estadísticas de Ejemplar
			case 3:
				leaseView.printMessage("Los prestamos que existen son los siguientes: ");
				for(Lease lease : leaseDatabase.getLeases()) {
					leaseView.printMessage("\n" + lease.toString());
				}
				leaseView.printMessage("");
				break;
			case 4:
			default:
				userReturn = true;
				break;
			}
		} while (!userReturn);
	}
	
	private void leaseBookCopy(User user, Book book) {
		ArrayList<BookCopy> copies = book.getCopies();
		
		boolean foundAvaliableCopy = false;
		
		for(BookCopy copy : copies) {
			if(copy.isAvaliable() && !foundAvaliableCopy) {
				leaseDatabase.getLeases().add(new Lease(user, book, copy));
				copy.setAvaliable(false);
				foundAvaliableCopy = true;
			}
		}
		
		if(!foundAvaliableCopy) {
			leaseView.printMessage("No hay ejemplares disponibles.\n");
		}
	}
	
	private void returnBookCopy(Lease lease) {
		lease.getBookCopy().setAvaliable(true);
		leaseDatabase.getLeases().remove(lease);
		
	}
	
	private Lease findLease(User user, Book book) {
		ArrayList<Lease> leases = leaseDatabase.getLeases();
		
		Lease leaseToFind = null;
		
		for(Lease lease : leases) {
			if(lease.getUser() == user && lease.getBook() == book) {
				leaseToFind = lease;
			}
		}
		
		return leaseToFind;
	}
}

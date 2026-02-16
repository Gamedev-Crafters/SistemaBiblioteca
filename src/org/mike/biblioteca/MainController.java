package org.mike.biblioteca;

/**
 * El controlador troncal de la aplicación, instancia el resto de controladores, modelos y vistas.
 */
public class MainController {
	
	private MainView mainView = new MainView();
	
	// Instanciación de los modelos para que sean persistentes en la misma sesión
	private UserDatabase userDatabase = new UserDatabase();
	private BookDatabase bookDatabase = new BookDatabase();
	private LeaseDatabase leaseDatabase = new LeaseDatabase();
	
	// Instanciación de los controladores con la inyección del modelo
	private UserController userController = new UserController(userDatabase);
	private LibraryController libraryController = new LibraryController(bookDatabase);
	private LeaseController leaseController = new LeaseController(leaseDatabase, libraryController, userController);
	
	

	public MainController() {
		
	}
	
	public void start() {
		boolean userReturn = false;
		
		do {
			// Pregunta al usuario, a través de la vista, la opción
			int userAnswer = mainView.displayMainMenu();
			
			switch(userAnswer) {
			// Gestión de Usuarios
			case 1:
				userController.start();
				break;
			// Gestión de Libros
			case 2:
				libraryController.start();
				break;
			// Gestión de Préstamos
			case 3:
				leaseController.start();
				break;
			// Salir
			case 4:
			default:
				userReturn = true;
				break;
			}
			
		} while(!userReturn);
	}
	
}

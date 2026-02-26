package org.mike.biblioteca;

/**
 * El controlador troncal de la aplicación, instancia el resto de controladores, modelos y vistas.
 */
public class MainController {
	/**
	 * TODO Mentoría
	 * ¿Es esta estructura la óptima? ¿Existe una estructura más robsuta y fácil
	 * de mantener?
	 * ¿Es la inyección de dependencias adecuada para este caso?
	 	--> Lo mencionaremos más adelante en detalle, pero se puede comentar en sesión alternativas a cómo se están instanciando las clases aquí.
	 */
	
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

	// Se ve un patrón en cómo se leen los tipos de respuesta, podemos comentar alternativas.
	public void start() {
		boolean userReturn = false;
		
		do {
			// Pregunta al usuario, a través de la vista, la opción
			int userAnswer = mainView.displayMainMenu();

			// Hablar de Connascense: Tanto la vista como este controlador saben que el número 1 es el userController, puede llevar a imprevistos en el futuro.
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

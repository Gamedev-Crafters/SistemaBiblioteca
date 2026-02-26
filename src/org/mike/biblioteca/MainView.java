package org.mike.biblioteca;

/**
 * Vista del menú principal de acciones disponibles
 */
public class MainView {
	
	/**
	 * TODO Mentoría
	 * ¿Unificar el display con el retorno de la opción ha sido buena decisión?
	 */
	
	/**
	 * Muestra el menú principla, devuelve la opción elegida.
	 * @return int La opción elegida por el usuaior
	 */
	public int displayMainMenu() {
		// Hablar de Connascense también: Si esta clase conoce que "1." es "Gestión de Usuarios", deberíamos mover aquí la responsabilidad de devolver ese controlador, para evitar acoplamiento implícito. 
		System.out.println("\n=== Gestor de Biblioteca ===");
		System.out.println("1. Gestión de Usuarios");
		System.out.println("2. Gestión de Libros");
		System.out.println("3. Gestión de Prestamos");
		System.out.println("4. Salir\n");

		return UserInput.getInt();
	}

}

package org.mike.biblioteca;

/**
 * Vista del menú principal de acciones disponibles
 */
public class MainView {
	
	/**
	 * Muestra el menú principla, devuelve la opción elegida.
	 * @return int La opción elegida por el usuaior
	 */
	public int displayMainMenu() {
		System.out.println("\n=== Gestor de Biblioteca ===");
		System.out.println("1. Gestión de Usuarios");
		System.out.println("2. Gestión de Libros");
		System.out.println("3. Gestión de Prestamos");
		System.out.println("4. Salir\n");

		return UserInput.getInt();
	}

}

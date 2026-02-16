package org.mike.biblioteca;

/**
 * Vista de los prestamos
 */
public class LeaseView {
	
	/**
	 * Mostrar el menú de préstamos y devolver la opción escogida.
	 * @return int Opción escogida por el usuario.
	 */
	public int displayLeaseMenu() {
		System.out.println("\n=== Gestión de Préstamos ===");
		System.out.println("1. Prestar Ejemplar");
		System.out.println("2. Devolución de Ejemplar");
		System.out.println("3. Mostrar Estadísticas de Préstamos");
		System.out.println("4. Volver atrás\n");
		
		return UserInput.getInt();
	}
	
	public String askUserForBookName() {
		System.out.print("Introduce el nombre del libro: ");
		
		return UserInput.getString();
	}
	
	public String askUserForUserName() {
		System.out.print("Introduce el nombre del usuario: ");
		
		return UserInput.getString();
	}
	
	public void printMessage(String string) {
		System.out.println(string);
	}
}

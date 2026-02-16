package org.mike.biblioteca;

/**
 * Vista de los usuarios.
 */
public class UserView {
	
	public UserView(){
		
	}
	
	/**
	 * Muestra un menú con diversas opciones y devuelve el resultado del usuario.
	 * @return int La opción seleccionada por el usuario.
	 */
	public int displayUserMenu() {
		System.out.println("\n=== Gestión de Usuario ===");
		System.out.println("1. Añadir Usuario");
		System.out.println("2. Eliminar Usuario");
		System.out.println("3. Buscar Usuario");
		System.out.println("4. Salir\n");

		return UserInput.getInt();
	}
	
	public String askUserName() {
		System.out.print("Introduce el nombre del usuario: ");
		return UserInput.getString();
	}
	
	public boolean askUserPremium() {
		System.out.print("¿Es el usuario premium? (y/n)");
		
		boolean userPremium;
		
		switch(UserInput.getChar()) {
		case 'y':
		case 'Y':
			userPremium = true;
			break;
		case 'n':
		case 'N':
		default:
			userPremium = false;
			break;
			
		}
		
		return userPremium;
	}

	public void printUser(User user) {
		if(user != null) {
			System.out.println(user.toString());
		} else {
			System.out.println("El usuario no existe.");
		}
	}
	
	public boolean askDeleteConfirmation() {
		System.out.print("El usuario existe, ¿estás seguro que quieres eliminarlo? (y/n): ");
		char userAnswer = UserInput.getChar();
		
		boolean confimration;
		
		switch(userAnswer) {
		case 'y':
		case 'Y':
			confimration = true;
			break;
		case 'n':
		case 'N':
		default:
			confimration = false;
			break;
		}
		
		return confimration;
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}
}

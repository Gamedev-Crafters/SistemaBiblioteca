package org.mike.biblioteca;

/**
 * Controlador del modelo de usuarios del sistema bancario
 */
public class UserController {
	private UserView userView = new UserView();
	private UserDatabase userDatabase;
	
	/**
	 * El constructor con el argumento del modelo de usuarios.
	 * El modelo de usuarios debe introducirse para la inyección de dependencias.
	 * @param userDatabase El modelo de los usuarios del sistema.
	 */
	public UserController(UserDatabase userDatabase){
		this.userDatabase = userDatabase;
	}
	
	/**
	 * Inicialización del controlador de usuarios.
	 */
	public void start() {
		boolean userReturn = false;
		
		do {
			int userAnswer = userView.displayUserMenu();
			
			switch(userAnswer) {
			case 1:
				addUser();
				break;
			case 2:
				User user = findUser(userView.askUserName());
				removeUser(user);
				break;
			case 3:
				User userToFind = findUser(userView.askUserName());
				userView.printUser(userToFind);
				break;
			case 4:
			default:
				userReturn = true;
				break;
			}
		}while(!userReturn);
	}
	
	private void addUser() {
		String userName = userView.askUserName();
		boolean userPremium = userView.askUserPremium();
		
		if(findUser(userName) == null) {
			userDatabase.getUsers().add(new User(userName, userPremium));
		} else {
			userView.printMessage("El usuario ya existe.");
		}
	}
	
	private void removeUser(User user) {
		if(user != null) {
			boolean confirmation = userView.askDeleteConfirmation();
			if(confirmation) {
				userDatabase.getUsers().remove(user);
				userView.printMessage("El usuario ha sido eliminado correctamente.");
			} else {
				userView.printMessage("La eliminación del usuario ha sido cancelada.");
			}
		}
	}
	
	public User findUser(String userName) {
		User userToFind = null;
		
		for (User user : userDatabase.getUsers()) {
			if(user.getName().equals(userName)) {
				userToFind = user;
			}
		}
		
		return userToFind;
	}
}

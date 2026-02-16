package org.mike.biblioteca;

/**
 * Representación de un usuario.
 */
public class User {
	// Valor estático compartido para calcular el ID
	static int instanceCount = 0;
	private int id;
	private String name;
	private boolean premium;
	
	public User(String name, boolean premium) {
		this.name = name;
		this.premium = premium;
		id = instanceCount;
		++instanceCount;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean getPremium() {
		return this.premium;
	}

	@Override
	public String toString() {
		String userString = "Nombre: " + this.name + "\nID: " + this.id;
		if(premium) {
			userString += "\nEs usuario premium.";
		} else {
			userString += "\nNo es usuario premium.";
		}
		return userString;
	}
	
	
}

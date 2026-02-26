package org.mike.biblioteca;

import java.util.Scanner;

/**
 * TODO Mentoría
 * Me siento bastante orgulloso con la idea de implementar una clase estática
 * como herramienta para gestionar el input. Si bien creo que aquí lo hice bien,
 * suelo pensar que sí me siento muy confíado con algo en concreto, generalmente
 * estoy cometiendo un error que no veo.
 */

/**
 * Clase estática con distintas funcionalidades para gestionar el input del usuario.
 */
public class UserInput {
	// Para sesión: hablar sobre uso de estáticos, y la necesidad de usarlos.
	static private Scanner scanner = new Scanner(System.in);
	
	/**
	 * Obtiene el input como integer y se asegura de consumir el \n.
	 * @return int
	 */
	static public int getInt() {
		int value = scanner.nextInt();
		scanner.nextLine();
		return value;
	}
	
	/**
	 * Obtiene el input como string.
	 * @return string
	 */
	static public String getString() {
		return scanner.nextLine();
	}
	
	/**
	 * Obtiene solamente el primer caracter de la línea de input.
	 * @return char
	 */
	static public char getChar() {
		return scanner.nextLine().charAt(0);
	}
}

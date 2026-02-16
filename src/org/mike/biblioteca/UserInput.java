package org.mike.biblioteca;

import java.util.Scanner;

/**
 * Clase estática con distintas funcionalidades para gestionar el input del usuario.
 */
public class UserInput {
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

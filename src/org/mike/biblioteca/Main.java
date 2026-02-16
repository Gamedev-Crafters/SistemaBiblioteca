package org.mike.biblioteca;

/*
 * TODO Mentoría.
 * ¿Es esta clase redundante? ¿Podría introducir el main() estático directamente
 * en el mainController? ¿O es mejor tenerlo todo por separado?
 */

/**
 * Inicio del programa.
 */
public class Main {

	public static void main(String[] args) {
		MainController mainController = new MainController();
		
		mainController.start();

	}

}

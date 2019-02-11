//proyecto final subido a github
package org.iesalandalus.programacion.reservasaulas;

import org.iesalandalus.programacion.reservasaulas.vista.IUTextual;


//import org.iesalandalus.programacion.reservasaulas.vista



        
public class MainApp {

	public static void main(String[] args) {
		System.out.println("Programa para la gestión de reservas de aulas");
		IUTextual vista = new IUTextual();
		vista.comenzar();
	}

}

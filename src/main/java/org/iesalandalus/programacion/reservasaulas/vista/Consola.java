/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import static java.time.temporal.TemporalQueries.localDate;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;

/**
 *
 * @author Manuel
 */
public class Consola {

	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    

//Para evitar que se cree el constructor por defecto
private Consola() {
		
}

public static void mostrarMenu() {
		mostrarCabecera("Gestión para profesores de reserva de aula");
		for (Opcion opcion: Opcion.values()) {
			System.out.println(opcion);
		}
}

public static void mostrarCabecera(String mensaje) {
		System.out.printf("%n%s%n", mensaje);
		String cadena = "%0" + mensaje.length() + "d%n";
		System.out.println(String.format(cadena, 0).replace("0", "-"));
	}
	
public static int elegirOpcion() {
		int ordinalOpcion;
		do {
			System.out.print("\nElige una opción: ");
			ordinalOpcion = Entrada.entero();
		} while (!Opcion.esOrdinalValido(ordinalOpcion));
		return ordinalOpcion;
}

public static Aula leerAula() {
		System.out.print("Introduce el nombre del aula: ");
		String nombreAula = Entrada.cadena();
                
		return new Aula(nombreAula);
	}

public static Aula leerNombreAula() {
		String aula;
		do {
			System.out.print("Introduce el aula: ");
			aula = Entrada.cadena();
		} while (aula.trim().equals(""));
		
		return new Aula(aula);
        }            

public static Profesor leerProfesor() {
		System.out.print("Introduce el nombre: ");
		String nombre = Entrada.cadena();
          	System.out.print("Introduce el correo: ");
		String correo = Entrada.cadena();
		System.out.print("Introduce el teléfono: ");
		String telefono = Entrada.cadena();

		return new Profesor(nombre, correo,telefono);
	}

public static Tramo leerTramo() {
		System.out.print("Introduzca turno de mañana o de tarde: ");
                Tramo turno = Tramo.MANANA;//la inicializo por pticion del IDE, no era mi idea dar nungún valor inicial, pero me quita el error.
                int opcion;
            do 
        {
            System.out.println("Introduzca turno de 1-mañana o 2-tarde(: ");
            opcion = Entrada.entero();
	} while (opcion < 1 || opcion > 2);
            
            switch (opcion) 
        {
            
            case 1:
               
                turno = Tramo.MANANA;
                           
           
                break;      
            case 2:                        
                turno = Tramo.TARDE;
                break;
            }    
                      
                       
		
            return  turno;
}
            

public static LocalDate leerDia()
    {
        String dia;
		boolean diaCorrecto = false;
		do {
			System.out.print("Introduce el día (dd/mm/aaaa): ");
			dia = Entrada.cadena();
			try {
				LocalDate.parse(dia, FORMATO_DIA);
				diaCorrecto = true;
			} catch (DateTimeParseException e) {
				diaCorrecto = false;
			}
		} while (!diaCorrecto);
		LocalDate fecha=LocalDate.parse(dia, FORMATO_DIA);
                
                return fecha;
                            //¿habria que poner return LocalDate(fecha)?
    }
}





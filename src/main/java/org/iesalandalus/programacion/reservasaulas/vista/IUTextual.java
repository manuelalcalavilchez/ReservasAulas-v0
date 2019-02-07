/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista;


import javax.naming.OperationNotSupportedException;
import modelo.ModeloReservasAulas;
//import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

/**
 *
 * @author Manuel
 */
public class IUTextual {

	
	private static final String ERROR = "ERROR: ";
	private static final String NOMBRE_VALIDO = "Manuel";
	private static final String CORREO_VALIDO = "manuel.alcala@caritasalmeria.es";
	
        private ModeloReservasAulas modelo;

	public IUTextual() {
		this.modelo = new ModeloReservasAulas();
		Opcion.setVista(this);
	}

	
	public void comenzar() {
	int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}

	public void salir() {
		System.out.println("Aplicación finalizada");;
	}
//aulas
	public void insertarAula() {
		Consola.mostrarCabecera("Insertar aula");
		try {
			Aula aula = Consola.leerAula();
			modelo.insertarAula(aula);
			System.out.println("Aula insertado correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void borrarAula() {
		Consola.mostrarCabecera("Borrar aula");
		try {
			Aula aula = Consola.leerNombreAula();
			modelo.borrarAula(aula);
			System.out.println("Aula borrada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void buscarAula() {
		Consola.mostrarCabecera("Buscar aula");
		Aula aula = null;
		try {
			aula = Consola.leerNombreAula();
			aula = modelo.buscarAula(aula);
			if (aula != null) {
				System.out.println("El aula buscado es: " + aula);
			} else {
				System.out.println("No existe ningún aula con dicho nombre.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void listarAulas() {
		Consola.mostrarCabecera("Listar aulas");
		String[] aulas = modelo.representarAulas();
		if (aulas.length > 0) {
			for (String aula : aulas) {
				System.out.println(aula);
			}
		} else {
			System.out.println("No hay aulas que listar.");
		}
	}
//profesores       
        public void insertarProfesor() {
		Consola.mostrarCabecera("Insertar profesor");
		try {
			Profesor profesor = Consola.leerProfesor();
			modelo.insertarProfesor(profesor);
			System.out.println("Profesor insertado correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void borrarProfesor() {
                String nombre="";
		Consola.mostrarCabecera("Borrar profesor");
		try {
                        nombre=Consola.leerNombreProfesor();
			Profesor profesor =new Profesor(nombre,CORREO_VALIDO);
			modelo.borrarProfesor(profesor);
			System.out.println("Profesor borrado correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void buscarProfesor() {
		Consola.mostrarCabecera("Buscar profesor");
		Profesor profesor = null;
                String nombre="";
		try {
			nombre = Consola.leerNombreProfesor();
                        profesor=new Profesor(nombre,CORREO_VALIDO);
			profesor = modelo.buscarProfesor(profesor);
			if (profesor != null) {
				System.out.println("El profesor buscado es: " + profesor);
			} else {
				System.out.println("No existe ningún profesor con dicho nombre.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void listarProfesores() {
		Consola.mostrarCabecera("Listar profesores");
		String[] profesores = modelo.representarProfesores();
		if (profesores.length > 0) {
			for (String profesor : profesores) {
				System.out.println(profesor);
			}
		} else {
			System.out.println("No hay profesores que listar.");
		}
	}
       
            
            
        

/////////////////////////////////////////////////////////////////////
        
        
private Reserva leerReserva(Profesor profesor) {
		Profesor profesorAEncontrar = modelo.buscarProfesor(profesor);
		if(profesorAEncontrar == null)
			return null;
		Aula buscada = modelo.buscarAula(new Aula(Consola.leerNombreAula()));
		if(buscada==null)
			return null;
		return new Reserva(profesorAEncontrar, buscada, new Permanencia(Consola.leerDia(), Consola.leerTramo()));
	}

/* código profesor
private Reserva leerReserva(Profesor profesor) {
                
                Reserva reserva =null;
                
                Aula aula=Consola.leerAula();
                aula=modelo.buscarAula(aula);
                Permanencia permanencia=new Permanencia(Consola.LeerDia(), Consola.leerTramo());
                
                try{
                    
                    reserva=new reserva(aula, profesor,permanencia);
                    
                } catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
                
                return reserva;
*/


public void realizarReserva() {
		Consola.mostrarCabecera("REALIZAR RESERVA");
		Profesor profesor = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
		boolean lecturaCorrecta = true;
		if(modelo.buscarProfesor(profesor)==null) {
			System.out.println(ERROR + "El profesor introducido no existe.");
			lecturaCorrecta = false;
		}
		Reserva reserva = null;
		if(lecturaCorrecta) {
			reserva = leerReserva(profesor);
			if(reserva==null)
				System.out.println(ERROR + "El aula introducida no existe.");
		}
		if(reserva==null)
			System.out.println(ERROR + "La reserva no se pudo realizar.");
		else {
			try {
				modelo.realizarReserva(reserva);
				System.out.println("Reserva realizada correctamente.");
			} catch (OperationNotSupportedException e) {
				System.out.println(ERROR + e.getMessage());
			}
		}
	}

/*
código del profe
public void realizarReserva() {
	Consola.mostrarCabecera("Realizar reserva");
		
                Profesor profesor;
                
                profesor new consola.leerNombreProfesor();
                
                profesor=modelo.buscarProfesor();
                
                       
                try {
			Reserva reserva =leerReserva(profesor);
			modelo.realizarReserva(reserva);
			System.out.println("Reserva realizada correctamente.");
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}*/
  
public void anularReserva() {
		Consola.mostrarCabecera("ANULAR RESERVA");
		Profesor profesorABuscar = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
		boolean lecturaCorrecta = true;
		if(modelo.buscarProfesor(profesorABuscar)==null) {
			System.out.println("El profesor introducido no existe.");
			lecturaCorrecta = false;
		}
		Reserva reserva = null;
		if(lecturaCorrecta) {
			reserva = leerReserva(profesorABuscar);
			if(reserva==null)
				System.out.println("El aula introducida no existe.");
		}
		if(reserva==null)
			System.out.println("La reserva no se pudo anular.");
		else {
			try {
				modelo.anularReserva(reserva);
			} catch (OperationNotSupportedException e) {
				System.out.println(ERROR + e.getMessage());
			}
			System.out.println("Reserva anulada correctamente.");
		}
	}


public void listarReservas() {
		Consola.mostrarCabecera("LISTAR RESERVAS");
		String[] reservas = modelo.representarReservas();
		if(reservas.length==0)
			System.out.println("No hay ninguna reserva hecha.");
		for(int i = 0; i<reservas.length && reservas[i]!=null; i++)
			System.out.println(reservas[i]);
	}

public void listarReservasAula() {
		Consola.mostrarCabecera("LISTAR RESERVAS AULA");
		Aula aula = new Aula(Consola.leerNombreAula());
		boolean lecturaCorrecta = true;
		if(modelo.buscarAula(aula)==null){
			System.out.println(ERROR + "El aula introducida no existe.");
			lecturaCorrecta = false;
		}
		Reserva[] reservas = modelo.getReservasAula(aula);
		if(lecturaCorrecta && reservas[0] == null)
			System.out.println("El aula indicada no está reservada.");
		if(lecturaCorrecta) {
			for(int i = 0; i<reservas.length && reservas[i]!=null; i++)
				System.out.println(reservas[i]);
		}
	}


public void listarReservasProfesor() {
		Consola.mostrarCabecera("LISTAR RESERVAS PROFESOR");
		Profesor profesor = new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO);
		boolean lecturaCorrecta = true;
		if(modelo.buscarProfesor(profesor)==null){
			System.out.println(ERROR + "El profesor introducida no existe.");
			lecturaCorrecta = false;
		}
		Reserva[] reservas = modelo.getReservasProfesor(profesor);
		if(lecturaCorrecta && reservas[0]==null)
			System.out.println("El profesor indicado no tiene ningún aula reservada.");
		if(lecturaCorrecta) {
			for(int i = 0; i<reservas.length && reservas[i]!=null; i++)
				System.out.println(reservas[i]);
		}
	}

public void listarReservasPermanencia() {
		Consola.mostrarCabecera("LISTAR RESERVAS PERMANENCIA");
		Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		Reserva[] reservas = modelo.getReservasPermanencia(permanencia);
		if(reservas[0]==null)
			System.out.println("En ese tramo no hay ningún aula reservada.");
		for(int i = 0; i<reservas.length && reservas[i]!=null; i++)
			System.out.println(reservas[i]);
	}

public void consultarDisponibilidad() {
		Consola.mostrarCabecera("CONSULTAR DISPONIBILIDAD");
		Aula aula = new Aula(Consola.leerNombreAula());
		boolean lecturaCorrecta = true;
		if(modelo.buscarAula(aula) == null) {
			System.out.println(ERROR + "El aula indicada no existe.");
			lecturaCorrecta = false;
		}
		if(lecturaCorrecta) {
			Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
			boolean disponible = modelo.consultarDisponibilidad(aula, permanencia);
			if(disponible)
				System.out.println("El aula consultada está disponible para el tramo especificado.");
			else
				System.out.println("El aula consultada no está disponible para el tramo especificado.");
		}
	}
}





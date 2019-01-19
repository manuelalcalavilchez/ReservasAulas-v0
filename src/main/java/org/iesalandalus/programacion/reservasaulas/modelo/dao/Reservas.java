/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;


/**
 *
 * @author Manuel
 */
public class Reservas {
    
    
     //declaracion de variables y array 
    private static final int MAX_RESERVAS = 5;
    private Reserva[] coleccionReservas;
    private int numReservas;
    
    //contructor por defecto
    
    public Reservas() {
		coleccionReservas = new Reserva[MAX_RESERVAS];
		numReservas = 0;
	}
    
    //constructor copia
	public Reservas (Reservas reservas) {
		setReservas(reservas);
	}
         
    //implementar set
    
    private void setReservas(Reservas reservas) {
		if (reservas == null) {
			throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
		}
		coleccionReservas = copiaProfundaReservas(reservas.coleccionReservas);
		numReservas = reservas.numReservas;
    }
    //copiaProfunda

    private Reserva[] copiaProfundaReservas(Reserva[] reservas) {
		Reserva[] otrasReservas = new Reserva[reservas.length];
		for (int i = 0; i < reservas.length && reservas[i] != null; i++) {
			otrasReservas[i] = new Reserva(reservas[i]);
		}
		return otrasReservas;
    }
    
    //get
	public Reserva[] getReservas() {
		return copiaProfundaReservas(coleccionReservas);
	}
	
    //getNumClientes
	public int getNumReservas() {
		return numReservas;
	}
	//insertar
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new IllegalArgumentException("No se puede insertar una reserva nula.");
		}
		int indice = buscarIndiceReserva(reserva);
		if (!indiceNoSuperaTamano(indice)) {
			coleccionReservas[indice] = reserva;
			numReservas++;
		} else {
			if (indiceNoSuperaCapacidad(indice)) {
				throw new OperationNotSupportedException("La reserva ya existe.");
			} else {
				throw new OperationNotSupportedException("No se aceptan más reservas.");
			}		}
	}

        //buscar indice ( se puede hacer tambien con for)
	private int buscarIndiceReserva(Reserva reserva) {
		int indice = 0;
		boolean reservaEncontrada = false;
		while (indiceNoSuperaTamano(indice) && !reservaEncontrada) {
			if (coleccionReservas[indice].equals(reserva)) {
				reservaEncontrada = true;
			} else {
				indice++;
			}
		}
		return indice;
	}
        
        private boolean indiceNoSuperaTamano(int indice) {
		return indice < numReservas;
	}
	
	private boolean indiceNoSuperaCapacidad(int indice) {
		return indice < MAX_RESERVAS;
	}
        
        //buscar 
        public Reserva buscar(Reserva reserva) {
		int indice = 0;
		indice = buscarIndiceReserva(reserva);
		if (indiceNoSuperaTamano(indice)) {
			return coleccionReservas[indice];
		} else {
			return null;
		}
	}

        public void borrar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new IllegalArgumentException("No se puede borrar una reserva nula.");
		}
		int indice = buscarIndiceReserva(reserva);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		}
		else {
			throw new OperationNotSupportedException("La reserva a borrar no existe.");
		}
	}
        
        private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < numReservas - 1; i++) {
			coleccionReservas[i] = coleccionReservas[i+1];
		}
		coleccionReservas [numReservas] = null;
		numReservas--;
	}
        
        public String[] representar() {
		String[] representacion = new String[numReservas];
		for (int i = 0; indiceNoSuperaTamano(i); i++) {
			representacion[i] = coleccionReservas[i].toString();
		}
		return representacion;
	}
                
         //getReservasAula
        
        private getReservaAula()
        
        //getReservasProfesor
        
        //getReservasPermanencia
        
        //consultarDiponibilidad
        
        
    
    
}

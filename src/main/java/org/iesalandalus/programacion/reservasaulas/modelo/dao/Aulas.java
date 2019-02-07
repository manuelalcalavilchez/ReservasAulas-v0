/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;

/**
 *
 * @author Manuel
 */
public class Aulas {
    //declaracion de variables y array 
    private static final int MAX_AULAS = 5;
    private Aula[] coleccionAulas;
    private int numAulas;
    
    //contructor por defecto
    
    public Aulas() {
		coleccionAulas = new Aula[MAX_AULAS];
		numAulas = 0;
	}
    
    //constructor copia
	public Aulas (Aulas aulas) {
		setAulas(aulas);
	}
         
    //implementar setAulas
    
    private void setAulas(Aulas aulas) {
		if (aulas == null) {
			throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
		}
		coleccionAulas = copiaProfundaAulas(aulas.coleccionAulas);
		numAulas = aulas.numAulas;
    }
    //copiaProfundaAulas

    private Aula[] copiaProfundaAulas(Aula[] aulas) {
		Aula[] otrasAulas = new Aula[aulas.length];
		for (int i = 0; i < aulas.length && aulas[i] != null; i++) {
			otrasAulas[i] = new Aula(aulas[i]);
		}
		return otrasAulas;
    }
    
    //getAulas
	public Aula[] getAulas() {
		return copiaProfundaAulas(coleccionAulas);
	}
	
    //getNumClientes
	public int getNumAulas() {
		return numAulas;
	}
	//insertar
	public void insertar(Aula aula) throws OperationNotSupportedException {
		if (aula == null) {
			throw new IllegalArgumentException("No se puede insertar un aula nula.");
		}
		int indice = buscarIndiceAula(aula);
		if (!indiceNoSuperaTamano(indice)) {
			coleccionAulas[indice] = aula;
			numAulas++;
		} else {
			if (indiceNoSuperaCapacidad(indice)) {
				throw new OperationNotSupportedException("El aula ya existe.");
			} else {
				throw new OperationNotSupportedException("No se aceptan más aulas.");
			}		}
	}

        //buscar indice ( se puede hacer tambien con for)
	private int buscarIndiceAula(Aula aula) {
		int indice = 0;
		boolean aulaEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !aulaEncontrado) {
			if (coleccionAulas[indice].equals(aula)) {
				aulaEncontrado = true;
			} else {
				indice++;
			}
		}
		return indice;
	}
        
        private boolean indiceNoSuperaTamano(int indice) {
		return indice < numAulas;
	}
	
	private boolean indiceNoSuperaCapacidad(int indice) {
		return indice < MAX_AULAS;
	}
        
        //buscar aula
        public Aula buscar(Aula aula) {
		int indice = 0;
		indice = buscarIndiceAula(aula);
		if (indiceNoSuperaTamano(indice)) {
			return coleccionAulas[indice];
		} else {
			return null;
		}
	}

        public void borrar(Aula aula) throws OperationNotSupportedException {
		if (aula == null) {
			throw new IllegalArgumentException("No se puede borrar un aula nula.");
		}
		int indice = buscarIndiceAula(aula);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		}
		else {
			throw new OperationNotSupportedException("El aula a borrar no existe.");
		}
	}
        
        private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < numAulas - 1; i++) {
			coleccionAulas[i] = coleccionAulas[i+1];
		}
		coleccionAulas [numAulas] = null;
		numAulas--;
	}
        
        public String[] representar() {
		String[] representacion = new String[numAulas];
		for (int i = 0; indiceNoSuperaTamano(i); i++) {
			representacion[i] = coleccionAulas[i].toString();
		}
		return representacion;
	}
                
        
}
    
    



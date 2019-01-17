/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio.dao;

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
    
     
    //implementar setAulas
    
    private void setAulas(Aulas aulas) {
		if (aulas == null) {
			throw new IllegalArgumentException("No se pueden copiar clientes nulos.");
		}
		coleccionAulas = copiaProfundaAulas(aulas.coleccionAulas);
		numAulas = aulas.numAulas;
    
    //copiaProfundaAulas

    private Aula[] copiaProfundaAulas(Aula[] aulas) {
		Aula[] otrasAulas = new Aula[aulas.length];
		for (int i = 0; i < aulas.length && aulas[i] != null; i++) {
			otrasAulas[i] = new Aula(aulas[i]);
		}
		return otrasAulas;
    
    
    //contructor con un parámetro
    
   public Aulas(Aulas aulas) {
		setAulas(aulas);
	}
    
    
}

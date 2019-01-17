/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.util.Objects;

/**
 *
 * @author Manuel
 */
public class Reserva {
    //variables
    private Profesor profesor;
    private Aula aula;
    private Permanencia permanencia;

    
    //setter
    private void setProfesor(Profesor profesor) {
        if (profesor == null) {
			throw new IllegalArgumentException("La reserva debe estar a nombre de un profesor.");
		}
        
        this.profesor = new Profesor(profesor);
    }

    private void setAula(Aula aula) {
         if (aula == null) {
			throw new IllegalArgumentException("La reserva debe ser para un aula concreta.");
		}
        
        this.aula = new Aula(aula);
    }

    private void setPermanencia(Permanencia permanencia) {
         if (permanencia == null) {
			throw new IllegalArgumentException("La reserva se debe hacer para una permanencia concreta.");
		}
        
        this.permanencia = Permanencia(permanencia);
    }
    //getter

    public Profesor getProfesor() {
        return  new Profesor(profesor);
    }

    public Aula getAula() {
        return new Aula(aula);
    }

    public Permanencia getPermanencia() {
        return Permanencia(permanencia);
    }
    
    //método comparador
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.profesor);
        hash = 31 * hash + Objects.hashCode(this.aula);
        hash = 31 * hash + Objects.hashCode(this.permanencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.profesor, other.profesor)) {
            return false;
        }
        if (!Objects.equals(this.aula, other.aula)) {
            return false;
        }
        if (!Objects.equals(this.permanencia, other.permanencia)) {
            return false;
        }
        return true;
    }
    //método toString
    
     @Override
    public String toString() {
        return "[profesor=" + profesor + ", aula=" + aula + ", permanencia=" + permanencia + "]";
    }
    
    //contructores

   public Reserva (Profesor profesor, Aula aula, Permanencia permanencia){
       
       setProfesor(profesor);
       setAula(aula);
       setPermanencia(permanencia);
       
   }
   
   public Reserva (Reserva reserva){
       if (reserva == null) {
			throw new IllegalArgumentException("No se puede copiar una reserva nula.");
		}
       
       setProfesor(reserva.profesor);
       setAula(reserva.aula);
       setPermanencia(reserva.permanencia);
   }

   
    
    
    




}





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Manuel
 */
public class Permanencia {
    
//declaración de variables
    static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate dia;
    
    private Tramo tramo;
//constructor con dos parametros
    public Permanencia (LocalDate dia,Tramo tramo){
        setDia(dia);
	setTramo(tramo);

    }

   	public Permanencia(Permanencia permanencia) {
		if(permanencia==null)
			throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
		setDia(permanencia.getDia());
		setTramo(permanencia.getTramo());
	}
        
        
        
        //getter y setter dia
       
        
        
        
        public LocalDate getDia() {
	
        return LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
	
        }

        
        
        private void setDia(LocalDate dia) {
		if(dia==null)
			throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
		this.dia = LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
	}
        
        
        //getter y setter Tramo
        public Tramo getTramo() {
            return tramo;
        }

        public void setTramo(Tramo tramo) {
            if(tramo == null)
			throw new IllegalArgumentException("El tramo de una permanencia no puede ser nulo.");
        this.tramo = tramo;
    }
        //hascode y equal

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.dia);
        hash = 17 * hash + Objects.hashCode(this.tramo);
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
        final Permanencia other = (Permanencia) obj;
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (this.tramo != other.tramo) {
            return false;
        }
        return true;
    }

   
    

        //toString

    @Override
    public String toString() {
         //return "[dia=" + dia + "tramo=" + tramo +"]";
         return "[dia=" + getDia().format(FORMATO_DIA)+',' + " tramo=" + tramo +"]";
    }
               
}


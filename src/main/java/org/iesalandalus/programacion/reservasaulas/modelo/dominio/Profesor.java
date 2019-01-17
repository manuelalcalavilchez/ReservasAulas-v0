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
public class Profesor {
    //variables
static final String ER_TELEFONO="[69]([0-9]{8})";
static final String ER_CORREO="[.a-zA-Z0-9]+@[.a-zA-Z0-9]+.[a-zAZ]{2,4}";
private String nombre;
private String telefono;
private String correo;


//metodos
   private void setNombre(String nombre) {
    if (nombre == null) {
			throw new IllegalArgumentException("El nombre del profesor no puede ser nulo.");
		}
		if (nombre.trim().equals("")) {
			throw new IllegalArgumentException("El nombre del profesor no puede estar vacío.");
		}
		this.nombre = nombre;
    }    

   public String getNombre()  {
       return nombre;
   }
           
   public void setTelefono(String telefono) {
                     
            if (telefono.matches(ER_TELEFONO))
            {
            this.telefono = telefono;
            }else throw new IllegalArgumentException("El teléfono del profesor no es válido.");
    }    
   
   public String getTelefono() {
        return telefono;
    }

   public void setCorreo(String correo) {
        if ( correo ==null) throw new IllegalArgumentException("El correo del profesor no puede ser nulo.");
              
            if (correo.matches(ER_CORREO))
            {
            this.correo = correo;
            }else throw new IllegalArgumentException("El correo del profesor no es válido.");
    }    
   

   public String getCorreo() {
        return correo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
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
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + "]";
    }

        public Profesor(String nombre, String telefono, String correo){
        
      setNombre(nombre);
      setTelefono(telefono);
      setCorreo(correo);
        
    }

    public Profesor(String telefono, String correo) {
        setTelefono (telefono);
        setCorreo (correo);
    }

        public Profesor (Profesor profesor) {
        if (profesor == null) {
			throw new IllegalArgumentException("No se puede copiar un profesor nulo.");
		}
		setNombre(profesor.nombre);
		setTelefono(profesor.telefono);
		setCorreo(profesor.correo);
	}


}
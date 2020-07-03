/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doble;

/**
 *
 * @author edi
 */
public class NodoDoble {
    
   private int id ;
   private String Nombre;
   private String Apellido;
   private NodoDoble Siguiente;
   private NodoDoble Anterior; 
    
   public NodoDoble(int id, String Nombre,String Apellido){
     this.setId(id);
     this.setNombre(Nombre);
     this.setApellido(Apellido);
 
   
   }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the Siguiente
     */
    public NodoDoble getSiguiente() {
        return Siguiente;
    }

    /**
     * @param Siguiente the Siguiente to set
     */
    public void setSiguiente(NodoDoble Siguiente) {
        this.Siguiente = Siguiente;
    }

    /**
     * @return the Anterior
     */
    public NodoDoble getAnterior() {
        return Anterior;
    }

    /**
     * @param Anterior the Anterior to set
     */
    public void setAnterior(NodoDoble Anterior) {
        this.Anterior = Anterior;
    }
   
   
   
    
    
}

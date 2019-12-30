/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;

/**
 *
 * @author Jose
 */
public class Editorial {
    private int id;
    private String nombre;
    private List<Ejemplar> ejemplares;

    public Editorial(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(List<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }
    
    public void addEjemplar(Ejemplar ejemplar) {
        this.ejemplares.add(ejemplar);
    }
    
    public String toString() {
        return "[ID]: " + id + " [NOMBRE]: " + nombre + " [EJEMPLARES]: " + ejemplares.size() + "\n";
    }    
}

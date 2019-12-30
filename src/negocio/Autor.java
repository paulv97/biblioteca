/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class Autor {
    private int id;
    private String nombre;
    private List<Libro> libros;
    
    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.libros = new ArrayList();
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

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    public void addLibro(Libro libro) {
        this.libros.add(libro);
    }
    
    @Override
    public String toString() {
        return "[ID]: " + id + " [NOMBRE]: " + nombre + " Libros: " + this.libros.size()+ "\n";        
    }
}

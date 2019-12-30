/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Jose
 */
public class Edicion {
    private int numEdicion;
    private int anioLanzamiento;
    private Libro libro;
    
    public Edicion(int numEdicion, int anioLanzamiento, Libro libro) {
        this.numEdicion = numEdicion;
        this.anioLanzamiento = anioLanzamiento;
        this.libro = libro;
    }
    
    public Edicion(int numEdicion, int anioLanzamiento) {
        this.numEdicion = numEdicion;
        this.anioLanzamiento = anioLanzamiento;
    }

    public int getNumEdicion() {
        return numEdicion;
    }

    public void setNumEdicion(int numEdicion) {
        this.numEdicion = numEdicion;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    @Override
    public String toString() {
        return "[EDICION]: " + numEdicion + " [AÑO]: " + anioLanzamiento + " [LIBRO]: " + libro.getNombre() + "\n";
    }
}

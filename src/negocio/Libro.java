/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class Libro {
    private int id;
    private String ISBN;
    private String nombre;
    private Date fecha;
    private List<Edicion> ediciones;
    
    public Libro(int id, String ISBN, String nombre, Date fecha) {
        this.id = id;
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.fecha = fecha;
        this.ediciones = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Edicion> getEdiciones() {
        return ediciones;
    }

    public void setEdiciones(List<Edicion> ediciones) {
        this.ediciones = ediciones;
    }
    
    public void addEdicion(Edicion edicion) {
        this.ediciones.add(edicion);
    }
    
    @Override 
    public String toString() {
        return "[ID]: " + id + " [ISBN]: " + ISBN + " [NOMBRE]: " 
                + nombre + " [FECHA]: " + fecha + " [EDICIONES]: " 
                + ediciones.size() + "\n";
    }
}

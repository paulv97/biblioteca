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
public class Ejemplar {
    private int id;
    private int anioImpresion;
    private int cantidad;
    private Edicion edicion;
    private Editorial editorial;
    private List<Prestamo> prestamos;
    
    public Ejemplar(int id, int anioImpresion, int cantidad) {
        this.id = id;
        this.anioImpresion = anioImpresion;
        this.cantidad = cantidad;
        this.editorial = null;
        this.prestamos = new ArrayList();
    }
    
    public Ejemplar(int id, int anioImpresion, int cantidad, Editorial editorial, Edicion edicion) {
        this.id = id;
        this.anioImpresion = anioImpresion;
        this.cantidad = cantidad;
        this.editorial = editorial;
        this.edicion = edicion;
        this.prestamos = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnioImpresion() {
        return anioImpresion;
    }

    public void setAnioImpresion(int anioImpresion) {
        this.anioImpresion = anioImpresion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Edicion getEdicion() {
        return edicion;
    }

    public void setEdicion(Edicion edicion) {
        this.edicion = edicion;
    }        

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    public void addPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }
    
    @Override
    public String toString() {
        return "[ID]: " + id + " [AÑO IMP]: " + anioImpresion + " [CANTIDAD]: " + cantidad + " [EDITORIAL]: " + editorial.getNombre();
    }
}

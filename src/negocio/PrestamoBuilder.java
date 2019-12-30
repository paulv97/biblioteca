/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Date;

/**
 *
 * @author Jose
 */
public class PrestamoBuilder {
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private int cantidad;
    private int estado;
    private Usuario usuario;
    private Ejemplar ejemplar;
    
    public PrestamoBuilder setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        return this;
    }
    
    public PrestamoBuilder setFechaDevoluvion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
        return this;
    }
    
    public PrestamoBuilder setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }
    
    public PrestamoBuilder setEstado(int estado) {
        this.estado = estado;
        return this;
    }
    
    public PrestamoBuilder setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }
    
    public PrestamoBuilder setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
        return this;
    }
    
    public Prestamo build() {
        return new Prestamo(
            this.fechaPrestamo,
            this.fechaDevolucion, 
            this.cantidad,
            this.estado,
            this.usuario,
            this.ejemplar
        );
    }
}

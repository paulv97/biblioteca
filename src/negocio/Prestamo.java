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
public class Prestamo {
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private int cantidad;
    private int estado;
    private Usuario usuario;
    private Ejemplar ejemplar;

    public Prestamo(Date fechaPrestamo, Date fechaDevolucion, int cantidad, int estado, Usuario usuario, Ejemplar ejemplar) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.cantidad = cantidad;
        this.estado = estado;
        this.usuario = usuario;
        this.ejemplar = ejemplar;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }
    
    @Override
    public String toString() {
        return "[FECHA PRESTAMO]: " + fechaPrestamo
            + " [FECHA DEVOLUCION]: " + fechaDevolucion
            + " [CANTIDAD]: " + cantidad
            + " [ESTADO]: " + estado
            + " [USUARIO]: " + usuario.getNombre()
            + " [EJEMPLAR]: " + ejemplar.getEdicion().getLibro().getNombre() + "\n";
    }
}

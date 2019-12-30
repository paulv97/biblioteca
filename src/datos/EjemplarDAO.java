/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import negocio.Ejemplar;

/**
 *
 * @author Jose
 */
public class EjemplarDAO implements IDAO<Ejemplar> {
    
    final String INSERT = "INSERT INTO ejemplares(id, id_libro, id_editorial, id_edicion, anio_impresion, stock) values(?, ?, ?, ?, ?, ?)";
    final String DELETE = "DELETE FROM ejemplares where id = ?";
    final String UPDATE = "UPDATE ejemplares SET anio_impresion = ?, stock = ? WHERE id = ?";
    final String GET = "SELECT * FROM ejemplares WHERE id = ?";
    final String GETALL = "SELECT * FROM ejemplares";

    @Override
    public boolean insert(Object o) throws DAOException {
        boolean ban = false;
        Ejemplar ej = (Ejemplar) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(INSERT);
            stm.setInt(1, ej.getId());
            stm.setInt(2, ej.getEdicion().getLibro().getId());
            stm.setInt(3, ej.getEditorial().getId());
            stm.setInt(4, ej.getEdicion().getNumEdicion());
            stm.setInt(5, ej.getAnioImpresion());
            stm.setInt(6, ej.getCantidad());
            ban = stm.executeUpdate() > 0;
            if(!ban) {
                throw new DAOException("Transacción abortada.");
            }
        } catch(SQLException e) {
            ban = false;
            throw new DAOException("Error en SQL", e);
        } finally {
            if(stm != null)
                try {
                    stm.close();
                } catch(SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            return ban;
        }
    }

    @Override
    public boolean delete(Object o) throws DAOException {
        boolean ban = false;
        Ejemplar ej = (Ejemplar) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(DELETE);
            stm.setInt(1, ej.getId());
            ban = stm.executeUpdate() > 0;
            if(!ban) {
                throw new DAOException("Transacción abortada.");
            }
        } catch(SQLException e) {
            ban = false;
            throw new DAOException("Error en SQL", e);
        } finally {
            if(stm != null)
                try {
                    stm.close();
                } catch(SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            return ban;
        }
    }

    @Override
    public boolean update(Object o) throws DAOException {
        boolean ban = false;
        Ejemplar ej = (Ejemplar) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(INSERT);
            stm.setInt(1, ej.getAnioImpresion());
            stm.setInt(2, ej.getCantidad());
            stm.setInt(3, ej.getId());
            ban = stm.executeUpdate() > 0;
            if(!ban) {
                throw new DAOException("Transacción abortada.");
            }
        } catch(SQLException e) {
            ban = false;
            throw new DAOException("Error en SQL", e);
        } finally {
            if(stm != null)
                try {
                    stm.close();
                } catch(SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            return ban;
        }
    }

    @Override
    public Ejemplar get(Object o) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ejemplar> getAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

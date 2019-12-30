/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Editorial;

/**
 *
 * @author Jose
 */
public class EditorialDAO implements IDAO<Editorial> {

    final String INSERT = "INSERT INTO editoriales(nombre) values(?)";
    final String DELETE = "DELETE FROM editoriales where id = ?";
    final String UPDATE = "UPDATE editoriales SET nombre = ? WHERE id = ?";
    final String GET = "SELECT * FROM editoriales WHERE id = ?";
    final String GETALL = "SELECT * FROM editoriales";
    
    @Override
    public boolean insert(Object o) throws DAOException {
        boolean ban = false;
        Editorial ed = (Editorial) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(INSERT);
            stm.setString(1, ed.getNombre());
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
        Editorial ed = (Editorial) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(DELETE);            
            stm.setInt(1, ed.getId());
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
        Editorial ed = (Editorial) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(UPDATE);
            stm.setString(1, ed.getNombre());
            stm.setInt(2, ed.getId());
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
    public Editorial get(Object o) throws DAOException {
        Integer id = (Integer) o;
        Editorial editorial = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = Conexion.connect().prepareStatement(GET);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs.next()) {
                int ide = rs.getInt("id");
                String nombre = rs.getString("nombre");
                editorial = new Editorial(ide, nombre);
            } else {
                throw new DAOException("No se ha encontrado el usuario.");
            }
        } catch(SQLException e) {
            throw new DAOException("Error en SQL.", e);
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }                               
            }
            
            if(stm != null) {
                try {
                    stm.close();
                } catch(SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
            
            return editorial;
        }
    }

    @Override
    public List<Editorial> getAll() throws DAOException {
        List<Editorial> editoriales = new ArrayList();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = Conexion.connect().prepareStatement(GETALL);
            rs = stm.executeQuery();
            int id = 0;
            String nombre = "";
            while(rs.next()) {
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                editoriales.add(new Editorial(id, nombre));
            } 
        } catch(SQLException e) {
            throw new DAOException("Error en SQL.", e);
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch(SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }                               
            }
            
            if(stm != null) {
                try {
                    stm.close();
                } catch(SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
            
            return editoriales;
        }
    }
    
}

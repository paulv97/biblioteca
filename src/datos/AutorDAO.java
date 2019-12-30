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
import negocio.Autor;

/**
 *
 * @author Jose
 */
public class AutorDAO implements IDAO<Autor> {
    
    final String INSERT = "INSERT INTO autores(id, nombre) values(?, ?)";
    final String DELETE = "DELETE FROM autores where id = ?";
    final String UPDATE = "UPDATE autores SET nombre = ? WHERE id = ?";
    final String GET = "SELECT * FROM autores WHERE id = ?";
    final String GETALL = "SELECT * FROM autores";

    @Override
    public boolean insert(Object o) throws DAOException {
        boolean ban = false;
        Autor a = (Autor) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(INSERT);
            stm.setInt(1, a.getId());
            stm.setString(2, a.getNombre());
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
        Autor a = (Autor) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(DELETE);            
            stm.setInt(1, a.getId());
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
        Autor a = (Autor) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(UPDATE);
            stm.setString(1, a.getNombre());
            stm.setInt(2, a.getId());
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
    public Autor get(Object o) throws DAOException {
        Integer id = (Integer) o;
        Autor autor = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = Conexion.connect().prepareStatement(GET);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs.next()) {
                int ide = rs.getInt("id");
                String nombre = rs.getString("nombre");
                autor = new Autor(ide, nombre);
            } else {
                throw new DAOException("No se ha encontrado el autor.");
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
            
            return autor;
        }
    }

    @Override
    public List<Autor> getAll() throws DAOException {
        List<Autor> autores = new ArrayList();
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
                autores.add(new Autor(id, nombre));
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
            
            return autores;
        }
    }
    
}

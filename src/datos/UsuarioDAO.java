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
import negocio.Usuario;

/**
 *
 * @author Jose
 */
public class UsuarioDAO implements IDAO<Usuario> {
    
    final String INSERT = "INSERT INTO usuarios(nombre) values(?)";
    final String DELETE = "DELETE FROM usuarios where id = ?";
    final String UPDATE = "UPDATE usuarios SET nombre = ? WHERE id = ?";
    final String GET = "SELECT * FROM usuarios WHERE id = ?";
    final String GETALL = "SELECT * FROM usuarios";

    @Override
    public boolean insert(Object o) throws DAOException {
        boolean ban = false;
        Usuario u = (Usuario) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(INSERT);
            stm.setString(1, u.getNombre());
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
        Usuario u = (Usuario) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(DELETE);            
            stm.setInt(1, u.getId());
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
        Usuario u = (Usuario) o;
        PreparedStatement stm = null;
        try {
            stm = Conexion.connect().prepareStatement(UPDATE);
            stm.setString(1, u.getNombre());
            stm.setInt(2, u.getId());
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
    public Usuario get(Object o) throws DAOException {
        Integer id = (Integer) o;
        Usuario user = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = Conexion.connect().prepareStatement(GET);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if(rs.next()) {
                int ide = rs.getInt("id");
                String nombre = rs.getString("nombre");
                user = new Usuario(ide, nombre);
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
            
            return user;
        }
    }

    @Override
    public List<Usuario> getAll() throws DAOException {
        List<Usuario> usuarios = new ArrayList();
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
                usuarios.add(new Usuario(id, nombre));
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
            
            return usuarios;
        }
    }
    
}

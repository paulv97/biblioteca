/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;

/**
 *
 * @author Jose
 * @param <T>
 */
public interface IDAO<T> {
    public boolean insert(Object o) throws DAOException;
    public boolean delete(Object o) throws DAOException;
    public boolean update(Object o) throws DAOException;
    public T get(Object o) throws DAOException;
    public List<T> getAll() throws DAOException;
}

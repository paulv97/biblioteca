/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jose
 */
public class Conexion {
    public static final String HOST = "localhost";
    public static final String PORT = "5432";
    public static final String DATABASE = "Biblioteca";
    public static final String USER = "postgres";
    public static final String PASSWORD = "1234";
    
    public static Connection connect() {
        try {                        
            try {
            Class.forName("org.postgresql.Driver");
            } catch(ClassNotFoundException e) {
                System.out.println("Error al registrar el driver de postgresql");
            }
            
            String url = "jdbc:postgresql://";
            url += HOST + ":";
            url += PORT + "/";
            url += DATABASE;

            Connection cn = null;
            cn = DriverManager.getConnection(url, USER, PASSWORD);
            return cn;
        } catch(java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
            return null;
        }
    }
}

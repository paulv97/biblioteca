/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import datos.*;
import java.util.ArrayList;
import negocio.*;
/**
 *
 * @author Jose
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException {
        UsuarioDAO udao = new UsuarioDAO();
        EditorialDAO edao = new EditorialDAO();
        AutorDAO autorDao = new AutorDAO();
        //udao.insert(new Usuario(1, "Pepe"));
        //udao.delete(new Usuario(6, "Peperoni"));
        //udao.insert(new Usuario(7, "Peperoni"));
        //udao.update(new Usuario(7, "Pepepeee"));
        //Usuario u = udao.get(2);
        //System.out.println(u.toString());
        
        //ArrayList lista = (ArrayList) udao.getAll();
        //for(int i=0; i<lista.size(); i++) {
        //    System.out.println(lista.get(i).toString());
        //}
        
        //edao.insert(new Editorial(1, "LNS"));
        //edao.delete(new Editorial(2, ""));
        //edao.update(new Editorial(1, "Editorial LNS"));
        //Editorial editorial = edao.get(2);
        //System.out.println(editorial.toString());
        
        //ArrayList lista = (ArrayList) edao.getAll();
        //for(int i=0; i<lista.size(); i++) {
         //   System.out.println(lista.get(i).toString());
        //}
        
        ArrayList<Autor> autores = (ArrayList<Autor>) autorDao.getAll();
        autores.forEach(autor -> {
            System.out.println(autor.toString());
        });
        
    }
    
}

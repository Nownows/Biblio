/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author romain
 */
public class DB {
    
    static String Driver="com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/Biblio";
    static String login = "userBiblio";
    static String mdp = "Biblio";

    static Connection conn = null;
    
    static void creerConnexion() throws ClassNotFoundException{
       try{
           try {
               Object newInstance = Class.forName(Driver).newInstance();
           } catch (InstantiationException | IllegalAccessException ex) {
               Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
           }
            conn = DriverManager.getConnection(url,login,mdp);
                
            if(conn == null)
                System.out.println("Erreur de connexion à la base");
           
       }catch(SQLException e){
            System.out.println("Erreur pendant la connexion à la base de donnée");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
       
       public static Connection getConnexion() throws ClassNotFoundException{
           if(conn==null)
               creerConnexion();
           return conn;
       }
    
    
    
}


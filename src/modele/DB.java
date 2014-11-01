/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author romain
 */
public class DB {
    
    static String Driver="com.mysql.jdbc.Driver";
//    static String url = "jdbc:mysql://localhost/Biblio";
    static String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
    static String login = "userBiblio";
    static String mdp = "Biblio";

    static Connection conn = null;
    
    static void creerConnexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
       try{
           Object newInstance = Class.forName(Driver).newInstance(); //charge le driver MYSQL
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
       
       public static Connection getConnexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
           if(conn==null)
               creerConnexion();
           return conn;
       }
}
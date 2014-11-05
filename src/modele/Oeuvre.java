package modele;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Oeuvre implements DBObject {
    
    private int id;
    private String nom;
    private String auteur;

    public Oeuvre(int id, String nom, String auteur) {
        this.id = id;
        this.nom = nom;
        this.auteur = auteur;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    public String getAuteur() {
        return auteur;
    }
    
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    

    @Override
    public void save() {
        
        try { 
            String req="INSERT INTO OEUVRE (NOM, AUTEUR) VALUES ('"+this.getNom()+"', '"+this.getAuteur()+"');";
            Statement statement = DB.getConnexion().createStatement();
            statement.executeUpdate(req);
        } 
        catch (SQLException e){ 
            System.out.println("Pb d'insertion d'une oeuvre :" + e.toString()); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Oeuvre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Oeuvre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Oeuvre.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }  

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

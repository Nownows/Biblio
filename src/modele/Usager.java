package modele;

import java.sql.SQLException;
import java.sql.Statement;

public class Usager implements DBObject{

    private int id;
    private String nom;
    private String prenom;

    public Usager(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public void persisterUsager() throws ClassNotFoundException, SQLException{
                
        try { 
            String req="INSERT INTO usager (nom, prenom) VALUES ("+this.getNom()+","+this.getPrenom()+");";

            Statement statement = DB.getConnexion().createStatement();
            statement.executeUpdate(req);
        } 
        catch (SQLException e){ 
            System.out.println("Pb d'insertion d'un usager :" + e.toString()); 
        } 
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

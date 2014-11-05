package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usager implements DBObject {

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

    @Override
    public void save() {

        try {
            String req = "INSERT INTO USAGER (NOM, PRENOM) VALUES ('" + this.getNom() + "', '" + this.getPrenom() + "');";
            System.out.println(req);
            Statement statement = DB.getConnexion().createStatement();
            statement.executeUpdate(req);
        } catch (SQLException e) {
            System.out.println("Pb d'insertion d'un usager :" + e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Usager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Usager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

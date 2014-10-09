package modele;

import java.util.ArrayList;
import java.util.List;

public class Usager {
    
    private int id;
    private String nom;
    private String prenom;
    private static List<Oeuvre> listUsagers =  new ArrayList<Oeuvre>() ;

    public Usager(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public static Usager e_idf(String nom){
        return null;
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
    
    
    
}

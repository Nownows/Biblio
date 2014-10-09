package modele;

import java.util.ArrayList;
import java.util.List;

public class Oeuvre {
    
    private int id;
    private String nom;
    private String auteur;
    public static List<Oeuvre> listOeuvre =  new ArrayList<>() ;

    public Oeuvre(String nom, String auteur) {
        this.id = listOeuvre.size();
        this.nom = nom;
        this.auteur = auteur;
        listOeuvre.add(this);
    }
    
    public static Oeuvre e_idf(String nom){
        return null;
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
    
    
    
}

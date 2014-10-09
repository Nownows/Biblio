package modele;

import java.util.ArrayList;
import java.util.List;

public class Oeuvre {
    
    private int id;
    private String nom;
    private static List<Oeuvre> listOeuvre =  new ArrayList<Oeuvre>() ;

    public Oeuvre(int id, String nom) {
        this.id = id;
        this.nom = nom;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
}

package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Oeuvre {
    
    private int id;
    private String nom;
    private String auteur;
    private List<Exemplaire> listExemplaires = new ArrayList<>();

    public Oeuvre(int id, String nom, String auteur) {
        this.id = id;
        this.nom = nom;
        this.auteur = auteur;
    }
    
    public Exemplaire trouverExemplaire(){
        if (listExemplaires.isEmpty()) {
            return null;
        }
        
        for(Exemplaire e : listExemplaires){
            if (e.getDisponible() == true) {
                return e;
            }
        }      
        return null;      
    }
    
    public void rendrerExemplaire(Exemplaire e, String etat, Boolean dispo){
        
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
    
    public void ajouterExemplaire(Exemplaire e){
        this.listExemplaires.add(e);
    }
    
    
    
}

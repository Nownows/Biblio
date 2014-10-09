package controller;

import java.util.Date;
import modele.Oeuvre;
import modele.Usager;

public class Gestion {
    
    public void reserver(String nomOeuvre, String nomUsager){
        
    }
    
    public void emprunter(String nomOeuvre, String nomUsager){
        
    }
    
    public void retournerExemplaire(String nomOeuvre, int idExemplaire, String nomusager){
        
    } 
    
    public void supprimerReservation(String nomOeuvre, String nomUsager, Date d ){
        
    }
    
    public void ajouterUtilisateur(String nom, String prenom) {
        Usager tmp = new Usager(nom,prenom);
    }
    
    public Usager rechercherUsager(String nom, String prenom) {
        return Usager.e_idf(nom, prenom);
    }
    
    public void ajouterOeuvre(String nom, String auteur) {
        Oeuvre tmp = new Oeuvre(nom, auteur);
    }
    
}

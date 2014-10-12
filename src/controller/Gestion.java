package controller;

import java.util.Date;
import java.util.List;
import java.util.Set;
import modele.Oeuvre;
import modele.Reservation;
import modele.Usager;
import modele.Exemplaire;

public class Gestion {
    
    public int reserverOeuvre(String nomUsager, String prenomUsager, String nomOeuvre, Date date){
        Oeuvre o = Oeuvre.e_idf(nomOeuvre);
        Usager u = Usager.e_idf(nomUsager, prenomUsager);
        if (o == null || u == null) {
            return -1;
        }
 
        
        Reservation r = new Reservation(u, o, date);
        return 1;
    }
    
    public void emprunterExemplaire(String nomOeuvre, String nomUsager){
        
    }
    
    public void retournerExemplaire(String nomOeuvre, int idExemplaire, String nomusager){
        
    } 
    
    public void supprimerReservation(String nomUsager, String prenomUsager, String nomOeuvre, Date date ){
        Oeuvre o = Oeuvre.e_idf(nomOeuvre);
        Usager u = Usager.e_idf(nomUsager, prenomUsager);
        Reservation.supprimerResa(o, u, date);
    }
    
    public void ajouterUsager(String nom, String prenom) {
        Usager tmp = new Usager(nom,prenom);
    }
    
    public Usager rechercherUsager(String nom, String prenom) {
        return Usager.e_idf(nom, prenom);
    }
    
    public void ajouterOeuvre(String nom, String auteur) {
        Oeuvre tmp = new Oeuvre(nom, auteur);
    }
    
    public List<Reservation> getAllReservations(){
        return Reservation.getAllReservations();
    }
    public List<Oeuvre> getAllOeuvres(){
        return Oeuvre.getAllOeuvres();
    }
    public Set<Usager> getAllUsagers(){
        return Usager.getAllUsagers();
    }
    public void ajouterExemplaire(String nomOeuvre,int id, String editeur, String Type, String etat, Boolean disponible){
        Exemplaire e = new Exemplaire(id, editeur, Type, etat, disponible);
        Oeuvre o = Oeuvre.e_idf(nomOeuvre);
        o.ajouterExemplaire(e);
    }
    
}

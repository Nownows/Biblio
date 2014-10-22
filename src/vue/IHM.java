package vue;

import controller.Gestion;
import java.util.Date;
import java.util.List;
import java.util.Set;
import modele.Oeuvre;
import modele.Reservation;
import modele.Usager;

public class IHM {
    
    Gestion gestion = new Gestion();
    
    public List<Reservation> getAllReservations(){
        return gestion.getAllReservations();
    }
    public List<Oeuvre> getAllOeuvres(){
        return gestion.getAllOeuvres();
    }
    public Set<Usager> getAllUsagers(){
        return gestion.getAllUsagers();
    }
    public void ajouterOeuvre(String nom, String auteur){
        gestion.ajouterOeuvre(nom, auteur);
    }
    public void ajouterUsager(String nom, String prenom){
        gestion.ajouterUsager(nom, prenom);
    }
    public Usager rechercherUsager(String nom, String prenom) {
        return gestion.rechercherUsager(nom, prenom);
    }

    public int reserverOeuvre(String nomUsager, String prenomUsager, String nomOeuvre, Date date) {
        return gestion.reserverOeuvre(nomUsager, prenomUsager, nomOeuvre, date );
    }
    public void supprimerReservation(String nomUsager, String prenomUsager, String nomOeuvre, Date date){
        gestion.supprimerReservation(nomUsager, prenomUsager,nomOeuvre, date);
    }
    public void ajouterExemplaire(String nomOeuvre,int id, String editeur, String Type, String etat){
        gestion.ajouterExemplaire(nomOeuvre, id, editeur, Type, etat);
    }
    public int emprunterExemplaire(String nomUsager, String prenomUsager, String nomOeuvre, Date dateRetour){
        return gestion.emprunterExemplaire(nomUsager, prenomUsager, nomOeuvre,dateRetour);
    }
    
    public int retourExemplaire(String nomUsager, String prenomUsager, String idOeuvre, String nomOeuvre, String etat){
        return gestion.retourExemplaire(nomUsager, prenomUsager, idOeuvre, nomOeuvre, etat);
    }
    
    
    
}

package vue;

import controller.Gestion;
import java.util.Date;
import java.util.List;
import java.util.Set;
import modele.Oeuvre;
import modele.Reservation;
import modele.Usager;

public class IHM {
    
    static Gestion gestion = new Gestion();
    
    public static List<Reservation> getAllReservations(){
        return gestion.getAllReservations();
    }
    public static List<Oeuvre> getAllOeuvres(){
        return gestion.getAllOeuvres();
    }
    public static Set<Usager> getAllUsagers(){
        return gestion.getAllUsagers();
    }
    public static void ajouterOeuvre(String nom, String auteur){
        gestion.ajouterOeuvre(nom, auteur);
    }
    public static void ajouterUsager(String nom, String prenom){
        gestion.ajouterUsager(nom, prenom);
    }
    public static Usager rechercherUsager(String nom, String prenom) {
        return gestion.rechercherUsager(nom, prenom);
    }

    public static int reserverOeuvre(String nomUsager, String prenomUsager, String nomOeuvre, Date date) {
        return gestion.reserverOeuvre(nomUsager, prenomUsager, nomOeuvre, date );
    }
    public static void supprimerReservation(String nomUsager, String prenomUsager, String nomOeuvre, Date date){
        gestion.supprimerReservation(nomUsager, prenomUsager,nomOeuvre, date);
    }
    public static void ajouterExemplaire(String nomOeuvre,int id, String editeur, String Type, String etat, Boolean disponible){
        gestion.ajouterExemplaire(nomOeuvre, id, editeur, Type, etat, disponible);
    }
    
    
    
}

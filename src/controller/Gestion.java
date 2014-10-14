package controller;

import java.util.Date;
import java.util.List;
import java.util.Set;
import modele.Emprunt;
import modele.Exemplaire;
import modele.ModelManager;
import modele.Oeuvre;
import modele.Reservation;
import modele.Usager;

public class Gestion {
    
    private ModelManager mm;
    
    public Gestion(){
        mm = ModelManager.getInstance();
    }

    public int reserverOeuvre(String nomUsager, String prenomUsager, String nomOeuvre, Date date) {
        Oeuvre o = mm.getOeuvre(nomOeuvre);
        Usager u = mm.getUsager(nomUsager, prenomUsager);
        if (o == null || u == null) {
            return -1;
        }

        Reservation r = new Reservation(u, o, date);
        return 1;
    }

    public int emprunterExemplaire(String nomUsager, String prenomUsager, String nomOeuvre, Date dateRetour) {
        Oeuvre o = mm.getOeuvre(nomOeuvre);
        long now = System.currentTimeMillis();
        Date dateEmprunt = new java.util.Date(now);
        Exemplaire e = o.trouverExemplaire();
        if (e == null) {
            return -1;
        }

        Emprunt emp = new Emprunt(mm.getUsager(nomUsager, prenomUsager),e, dateEmprunt, dateRetour);
        return 1;
    }

    public void retournerExemplaire(String nomOeuvre, int idExemplaire, String nomusager) {

    }

    public void supprimerReservation(String nomUsager, String prenomUsager, String nomOeuvre, Date date) {
        Oeuvre o = mm.getOeuvre(nomOeuvre);
        Usager u = mm.getUsager(nomUsager, prenomUsager);
        Reservation.supprimerResa(o, u, date);
    }

    public void ajouterUsager(String nomUsager, String prenomUsager) {
        mm.nouvelUsager(nomUsager, prenomUsager);
    }

    public Usager rechercherUsager(String nomUsager, String prenomUsager) {
        return mm.getUsager(nomUsager, prenomUsager);
    }

    public void ajouterOeuvre(String nom, String auteur) {
        mm.nouvelleOeuvre(nom, auteur);
    }

    public List<Reservation> getAllReservations() {
        return Reservation.getAllReservations();
    }

    public List<Oeuvre> getAllOeuvres() {
        return mm.getAllOeuvres();
    }

    public Set<Usager> getAllUsagers() {
        return mm.getAllUsagers();
    }

    public void ajouterExemplaire(String nomOeuvre, int id, String editeur, String Type, String etat, Boolean disponible) {
        Exemplaire e = new Exemplaire(id, editeur, Type, etat, disponible);
        Oeuvre o = mm.getOeuvre(nomOeuvre);
        o.ajouterExemplaire(e);
    }

}

package controller;

import java.util.Date;
import java.util.List;
import java.util.Set;
import modele.Emprunt;
import modele.Emprunts;
import modele.Exemplaire;
import modele.Oeuvre;
import modele.Oeuvres;
import modele.Reservation;
import modele.Reservations;
import modele.Usager;
import modele.Usagers;

public class Gestion {

    private final Emprunts emprunts;
    private final Oeuvres oeuvres;
    private final Reservations reservations;
    private final Usagers usagers;

    
    public Gestion() {
        emprunts = Emprunts.getInstance();
        oeuvres = Oeuvres.getInstance();
        reservations = Reservations.getInstance();
        usagers = Usagers.getInstance();
    }

    public int reserverOeuvre(String nomUsager, String prenomUsager, String nomOeuvre, Date date) {
        Oeuvre o = oeuvres.getOeuvre(nomOeuvre);
        Usager u = usagers.getUsager(nomUsager, prenomUsager);
        if (o == null || u == null) {
            return -1;
        }
        reservations.nouvelleReservation(u, o, date);
        return 1;
    }

    public int emprunterExemplaire(String nomUsager, String prenomUsager, String nomOeuvre, Date dateRetour) {
        Oeuvre o = oeuvres.getOeuvre(nomOeuvre);
        if (o == null) {
            return -1;
        }
        long now = System.currentTimeMillis();
        Date dateEmprunt = new java.util.Date(now);
        Exemplaire e = o.trouverExemplaire();
        if (e == null) {
            return -2;
        }
        Usager u = usagers.getUsager(nomUsager, prenomUsager);
        if (u == null) {
            return -3;
        }
        emprunts.ajouterEmprunt(new Emprunt(u, e, dateEmprunt, dateRetour));
        return 1;
    }

    public int retourExemplaire(String nomUsager, String prenomUsager, String idOeuvre, String nomOeuvre, String etat){
        Oeuvre o = oeuvres.getOeuvre(nomOeuvre);
        if (o == null) {
            return -1;
        }
        Usager u = usagers.getUsager(nomUsager, prenomUsager);
        if (u == null) {
            return -2;
        }
        Exemplaire e = o.getExemplaire(Integer.parseInt(idOeuvre));
        o.rendreExemplaire(e, etat);
        
        
        return 1;
    }

    public void supprimerReservation(String nomUsager, String prenomUsager, String nomOeuvre, Date date) {
        Oeuvre o = oeuvres.getOeuvre(nomOeuvre);
        Usager u = usagers.getUsager(nomUsager, prenomUsager);
        reservations.supprimerResa(o, u, date);
    }

    public void ajouterUsager(String nomUsager, String prenomUsager) {
        usagers.nouvelUsager(nomUsager, prenomUsager);
    }

    public Usager rechercherUsager(String nomUsager, String prenomUsager) {
        return usagers.getUsager(nomUsager, prenomUsager);
    }

    public void ajouterOeuvre(String nom, String auteur) {
        oeuvres.nouvelleOeuvre(nom, auteur);
    }

    public List<Reservation> getAllReservations() {
        return reservations.getAllReservations();
    }

    public List<Oeuvre> getAllOeuvres() {
        return oeuvres.getAllOeuvres();
    }

    public Set<Usager> getAllUsagers() {
        return usagers.getAllUsagers();
    }

    public void ajouterExemplaire(String nomOeuvre, int id, String editeur, String Type, String etat) {
        Exemplaire e = new Exemplaire(id, editeur, Type, etat);
        Oeuvre o = oeuvres.getOeuvre(nomOeuvre);
        o.ajouterExemplaire(e);
    }

}

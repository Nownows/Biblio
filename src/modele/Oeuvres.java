/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Oeuvres {

    private List<Oeuvre> listOeuvre;
    private List<Exemplaire> listExemplaires;

    private static Oeuvres INSTANCE = null;

    private Oeuvres() {
        listOeuvre = new ArrayList<>();
        listExemplaires = new ArrayList<>();
    }

    public static Oeuvres getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Oeuvres();
        }
        return INSTANCE;
    }

    public Exemplaire trouverExemplaire() {
        if (listExemplaires.isEmpty()) {
            return null;
        }

        for (Exemplaire e : listExemplaires) {
            if (e.getDisponible() == true) {
                return e;
            }
        }
        return null;
    }

    public Oeuvre getOeuvre(String nom) {
        for (Oeuvre o : listOeuvre) {
            if (o.getNom().equals(nom)) {
                return o;
            }
        }
        return null;
    }

    public void nouvelExemplaire(int id, String editeur, String type, String etat) {
        Exemplaire e = new Exemplaire(id, editeur, type, etat);
        listExemplaires.add(e);
        e.save();
    }

    public List<Oeuvre> getAllOeuvres() {
        return listOeuvre;
    }
    
    public void nouvelleOeuvre(String nom, String auteur) {
        Oeuvre o = new Oeuvre(listOeuvre.size(), nom, auteur);
        listOeuvre.add(o);
        o.save();
    }
}

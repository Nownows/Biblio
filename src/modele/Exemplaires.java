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
public class Exemplaires {

    private List<Exemplaire> listExemplaires;

    private static Exemplaires INSTANCE = null;

    private Exemplaires() {
        listExemplaires = new ArrayList<>();

    }

    public static Exemplaires getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Exemplaires();
        }
        return INSTANCE;
    }

    public Exemplaire trouverExemplaire(Oeuvre o) {
        if (listExemplaires.isEmpty()) {
            return null;
        }

        for (Exemplaire e : listExemplaires) {
            if (e.getO().equals(o) && e.getDisponible() == true) {
                return e;
            }
        }
        return null;
    }
    
    public Exemplaire getExemplaire(int id){
        for (Exemplaire e : listExemplaires) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
    
    public void rendreExemplaire(Exemplaire e, String etat){
        for (Exemplaire e1 : listExemplaires) {
            if (e1.equals(e)) {
                e1.setDisponible(Boolean.TRUE);
                e1.setEtat(etat);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ASUS
 */
public class Usagers {

    private Set<Usager> listUsagers;
    private static Usagers INSTANCE = null;

    private Usagers() {
        listUsagers = new HashSet<>();
    }

    public static Usagers getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Usagers();
        }
        return INSTANCE;
    }

    public Usager getUsager(String nom, String prenom) {
        for (Usager u : listUsagers) {
            // si on trouve le nom de famille
            if (u.getNom().equals(nom)) {
                // s'il n'y a pas de prenom
                if (prenom.equals("")) {
                    return u;
                } else {
                    // si noml et prenom correspondent
                    if (u.getPrenom().equals(prenom)) {
                        return u;
                    }
                }
            }
        }
        // non trouvé
        return null;
    }

    public Set<Usager> getAllUsagers() {
        return listUsagers;
    }
    
    public void nouvelUsager(String nom, String prenom) {
        Usager u = new Usager(listUsagers.size(), nom, prenom);
        listUsagers.add(u);
    }
}

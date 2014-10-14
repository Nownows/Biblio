package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModelManager {

    // singleton
    private static ModelManager INSTANCE = null;
    private List<Oeuvre> listOeuvre;
    private List<Reservation> listReservations;
    private List<Exemplaire> listExemplaires;
    private Set<Usager> listUsagers;

    private ModelManager() {
        listOeuvre = new ArrayList<>();
        listExemplaires = new ArrayList<>();
        listUsagers = new HashSet<>();
    }

    public static ModelManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ModelManager();
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

    public void nouvelUsager(String nom, String prenom) {
        Usager u = new Usager(listUsagers.size(), nom, prenom);
        listUsagers.add(u);
    }

    public void nouvelleOeuvre(String nom, String auteur) {
        Oeuvre o = new Oeuvre(listOeuvre.size(), nom, auteur);
        listOeuvre.add(o);
    }

    public void nouvelExemplaire(int id, String editeur, String type, String etat, Boolean disponible) {
        Exemplaire e = new Exemplaire(id, editeur, type, etat, disponible);
        listExemplaires.add(e);
    }

    public void nouvelleReservation(Usager u, Oeuvre o, Date d) {
        Reservation r = new Reservation(u, o, d);
        listReservations.add(r);
    }

    public Set<Usager> getAllUsagers() {
        return listUsagers;
    }

    public List<Oeuvre> getAllOeuvres() {
        return listOeuvre;
    }

}

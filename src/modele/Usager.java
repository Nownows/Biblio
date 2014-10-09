package modele;

import java.util.HashSet;
import java.util.Set;

public class Usager {

    private int id;
    private String nom;
    private String prenom;
    public static Set<Usager> listUsagers = new HashSet<>();

    public Usager(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = listUsagers.size();
        // on ajoute l'usager à la liste
        listUsagers.add(this);
    }

    public static Usager e_idf(String nom, String prenom) {
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

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}

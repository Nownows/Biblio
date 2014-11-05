/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Usagers {

    private Set<Usager> listUsagers;
    private static Usagers INSTANCE = null;

    private Usagers() {
        try {
            listUsagers = this.loadDB();
        } catch (Exception e) {
            listUsagers = new HashSet<>();
        }
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
        u.save();
    }

    private Set<Usager> loadDB() {
        Set<Usager> lu = new HashSet<Usager>();
        try {
            String req = "SELECT * FROM USAGER";
            Statement statement = DB.getConnexion().createStatement();
            ResultSet rs = statement.executeQuery(req);

            while (rs.next()) {
                Usager u = new Usager(Integer.parseInt(rs.getString("ID_USAGER")), rs.getString("NOM"), rs.getString("PRENOM"));
                lu.add(u);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Usager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Usager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lu;
    }
}

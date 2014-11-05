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
public class Oeuvres {

    private List<Oeuvre> listOeuvre;
    private List<Exemplaire> listExemplaires;

    private static Oeuvres INSTANCE = null;

    private Oeuvres() {
        try {
            listOeuvre = this.loadOeuvres();
        } catch (Exception e) {
            listOeuvre = new ArrayList<>();
        }

        listExemplaires = new ArrayList<>();
    }

    public static Oeuvres getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Oeuvres();
        }
        return INSTANCE;
    }

    public Oeuvre getOeuvre(String nom) {
        for (Oeuvre o : listOeuvre) {
            if (o.getNom().equals(nom)) {
                return o;
            }
        }
        return null;
    }

    public List<Oeuvre> getAllOeuvres() {
        return listOeuvre;
    }

    public void nouvelleOeuvre(String nom, String auteur) {
        Oeuvre o = new Oeuvre(listOeuvre.size(), nom, auteur);
        listOeuvre.add(o);
        o.save();

    }

    private List<Oeuvre> loadOeuvres() {
        List<Oeuvre> lu = new ArrayList<Oeuvre>();
        try {
//            String req = "SELECT * FROM oeuvre";
            String req = "SELECT * FROM OEUVRE";
            Statement statement = DB.getConnexion().createStatement();
            ResultSet rs = statement.executeQuery(req);

            while (rs.next()) {
                Oeuvre u = new Oeuvre(Integer.parseInt(rs.getString("ID_OEUVRE")), rs.getString("NOM"), rs.getString("AUTEUR"));
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

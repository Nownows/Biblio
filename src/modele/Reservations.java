/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Reservations {

    private List<Reservation> listReservations;

    private static Reservations INSTANCE = null;

    private Reservations() {
        listReservations = new ArrayList<>();
    }

    public static Reservations getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Reservations();
        }
        return INSTANCE;
    }

    public void nouvelleReservation(Usager u, Oeuvre o, Date d) {
        Reservation r = new Reservation(listReservations.size(), u, o, d);
        listReservations.add(r);
        r.save();
    }

    public List<Reservation> getAllReservations() {
        return listReservations;
    }

    public void supprimerResa(Oeuvre o, Usager u, Date d) {
        for (Reservation r : listReservations) {
            if (r.getOeuvre().equals(o) && r.getUsager().equals(u) && r.getDateResa().equals(d)) {
                listReservations.remove(r);
            }
        }
    }
}

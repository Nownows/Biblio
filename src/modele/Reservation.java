package modele;

import java.util.ArrayList;
import java.util.List;


public class Reservation {

    private int id;
    private String dateResa;
    private Usager u;
    private Oeuvre o;
    private static List<Reservation> listReservations =  new ArrayList<>() ;

    public Reservation(Usager u, Oeuvre o,String dateResa) {
        this.o = o;
        this.u = u;
        this.dateResa = dateResa;
        this.id = listReservations.size();
        listReservations.add(this);
    }
    
    public static List<Reservation> getAllReservations() {
        return listReservations;
    }

    public static void supprimerResa(Oeuvre o, Usager u, String d) {
        listReservations.stream().filter((r) -> (r.getUsager().equals(u) && r.getOeuvre().equals(o) && r.getDateResa().equals(d))).forEach((r) -> {
            listReservations.remove(r);
        });
    }

    public Usager getUsager() {
        return u;
    }

    public void setUsager(Usager u) {
        this.u = u;
    }

    public Oeuvre getOeuvre() {
        return o;
    }

    public void setOeuvre(Oeuvre e) {
        this.o = o;
    }

    public String getDateResa() {
        return dateResa;
    }

    public void setDateResa(String dateResa) {
        this.dateResa = dateResa;
    }

}

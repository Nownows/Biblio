package modele;

import java.util.Date;

public class Reservation {

    private Date dateResa;
    private Usager u;
    private Exemplaire e;

    public Reservation(Date dateResa) {
        this.dateResa = dateResa;
    }

    public Reservation creerResa(Usager u, Oeuvre o) {
        return null;
    }

    public void supprimerResa(Oeuvre o, Usager u, Date d) {

    }

    public Usager getUsager() {
        return u;
    }

    public void setUsager(Usager u) {
        this.u = u;
    }

    public Exemplaire getExemplaire() {
        return e;
    }

    public void setExemplaire(Exemplaire e) {
        this.e = e;
    }

    public Date getDateResa() {
        return dateResa;
    }

    public void setDateResa(Date dateResa) {
        this.dateResa = dateResa;
    }

}

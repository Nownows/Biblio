package modele;

import java.util.Date;

public class Reservation {
    
    private Date dateResa;

    public Reservation(Date dateResa) {
        this.dateResa = dateResa;
    }
    
    public Reservation creerResa(Usager u, Oeuvre o){
        return null;
    }
    
    public void supprimerResa(Oeuvre o, Usager u, Date d){
        
    }

    public Date getDateResa() {
        return dateResa;
    }

    public void setDateResa(Date dateResa) {
        this.dateResa = dateResa;
    }
    
    
    
}

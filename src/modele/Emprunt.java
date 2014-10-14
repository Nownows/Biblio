package modele;

import java.util.Date;

public class Emprunt {
    
    private int id;
    private Date date_emprunt;
    private Date date_retour;
    private Usager usager;
    private Exemplaire exemplaire;

    public Emprunt(int id, Date date_emprunt, Date date_retour) {
        this.id = id;
        this.date_emprunt = date_emprunt;
        this.date_retour = date_retour;
    }
    
    public void creerEmprunt(Usager u, Exemplaire e){
        
    }
    
    public void rendreEmprunt(Usager u, Exemplaire e, Date dr){
        
    }

    public int getId() {
        return id;
    }

    public Date getDate_emprunt() {
        return date_emprunt;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_emprunt(Date date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }
    
    
    
    
}

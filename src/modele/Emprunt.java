package modele;

import java.util.Date;

public class Emprunt {
    

    private Date date_emprunt;
    private Date date_retour;
    private Usager usager;
    private Exemplaire exemplaire;

    public Emprunt(Usager u, Exemplaire e, Date date_emprunt, Date date_retour) {
        this.usager = u;
        this.exemplaire = e;
        this.date_emprunt = date_emprunt;
        this.date_retour = date_retour;
    }
    
    public void creerEmprunt(Usager u, Exemplaire e){
        
    }
    
    public void rendreEmprunt(Usager u, Exemplaire e, Date dr){
        
    }

    public Date getDate_emprunt() {
        return date_emprunt;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_emprunt(Date date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public Usager getUsager() {
        return usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }
    
    
    
    
}

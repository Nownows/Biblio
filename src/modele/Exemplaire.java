package modele;

public class Exemplaire {
    
    private int id;
    private String editeur;
    private String Type;
    private String etat;
    private Boolean disponible;

    public Exemplaire(int id, String editeur, String Type, String etat, Boolean disponible) {
        this.id = id;
        this.editeur = editeur;
        this.Type = Type;
        this.etat = etat;
        this.disponible = disponible;
    }


    public int getId() {
        return id;
    }

    public String getEditeur() {
        return editeur;
    }

    public String getType() {
        return Type;
    }

    public String getEtat() {
        return etat;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    
    
    
    
}

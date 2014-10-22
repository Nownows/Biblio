package modele;

import java.sql.SQLException;
import java.sql.Statement;

public class Exemplaire implements DBObject {
    
    private int id;
    private String editeur;
    private String Type;
    private String etat;
    private Boolean disponible;

    public Exemplaire(int id, String editeur, String Type, String etat) {
        this.id = id;
        this.editeur = editeur;
        this.Type = Type;
        this.etat = etat;
        this.disponible = true;
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
    
    public void persisterExemplaire() throws ClassNotFoundException, SQLException{
                
        try { 
            String req="INSERT INTO exemplaire (editeur, type, etat,disponible) VALUES ("+this.getEditeur()+
                    ","+this.getType()+","+this.getEtat()+"," +this.getDisponible()+");";


            Statement statement = DB.getConnexion().createStatement();
            statement.executeUpdate(req);
        } 
        catch (SQLException e){ 
            System.out.println("Pb d'insertion d'exemplaire : " + e.toString()); 
        } 
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

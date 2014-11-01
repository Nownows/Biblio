package modele;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Oeuvre implements DBObject {
    
    private int id;
    private String nom;
    private String auteur;
    private List<Exemplaire> listExemplaires = new ArrayList<>();

    public Oeuvre(int id, String nom, String auteur) {
        this.id = id;
        this.nom = nom;
        this.auteur = auteur;
    }
    
    public Exemplaire trouverExemplaire(){
        if (listExemplaires.isEmpty()) {
            return null;
        }
        
        for(Exemplaire e : listExemplaires){
            if (e.getDisponible() == true) {
                return e;
            }
        }      
        return null;      
    }
    
    public void rendreExemplaire(Exemplaire e, String etat){
        for(Exemplaire ex : listExemplaires){
            if (ex.getId() == e.getId()) {
                ex.setDisponible(true);
                ex.setEtat(etat);
            }
        }
    }
    
    public Exemplaire getExemplaire(int id){
        for(Exemplaire ex : listExemplaires){
            if (ex.getId() == id) {
                return ex;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    public String getAuteur() {
        return auteur;
    }
    
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void ajouterExemplaire(Exemplaire e){
        this.listExemplaires.add(e);
    }
    
    public void persisterUsager() throws ClassNotFoundException, SQLException{


    }

    @Override
    public void save() {
        
        try { 
            String req="INSERT INTO usager (nom, auteur) VALUES ("+this.getNom()+","+this.getAuteur()+");";

            Statement statement = DB.getConnexion().createStatement();
            statement.executeUpdate(req);
        } 
        catch (SQLException e){ 
            System.out.println("Pb d'insertion d'une oeuvre :" + e.toString()); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Oeuvre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Oeuvre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Oeuvre.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }  
}

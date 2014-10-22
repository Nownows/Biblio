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
public class Emprunts {

    private List<Emprunt> listEmprunts;
    private static Emprunts INSTANCE = null;

    private Emprunts() {
        listEmprunts = new ArrayList<>();
    }

    public static Emprunts getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Emprunts();
        }
        return INSTANCE;
    }
    
    public void ajouterEmprunt(Emprunt e){
        listEmprunts.add(e);
    }
    
    public void supprimerEmprunt(Usager u, Exemplaire e, Date d){
       for (Emprunt em : listEmprunts) {
           if (em.getUsager() == u && em.getExemplaire() == e && em.getDate_emprunt() == d) {
               listEmprunts.remove(e);
           }
       }
    }
    
   

}

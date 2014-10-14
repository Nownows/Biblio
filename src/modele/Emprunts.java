/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
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

}

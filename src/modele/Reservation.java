package modele;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Reservation implements DBObject {

    private int id;
    private Date dateResa;
    private Usager u;
    private Oeuvre o;

    public Reservation(int id,Usager u, Oeuvre o,Date dateResa) {
        this.o = o;
        this.u = u;
        this.dateResa = dateResa;
        this.id = id;
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

    public Date getDateResa() {
        return dateResa;
    }

    public void setDateResa(Date dateResa) {
        this.dateResa = dateResa;
    }

    @Override
    public void save() {
        
        try { 
            String req="INSERT INTO emprunt (id_oeuvre, id_usager, date_reservation) VALUES ("+this.getOeuvre().getId()+
                    ","+this.getUsager().getId()+","+this.getDateResa()+");";


            Statement statement = DB.getConnexion().createStatement();
            statement.executeUpdate(req);
        } 
        catch (SQLException e){ 
            System.out.println("Pb d'insertion d'une réservation : " + e.toString()); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }   
}

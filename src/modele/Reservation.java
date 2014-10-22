package modele;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


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
    
    public void persisterResa() throws ClassNotFoundException, SQLException{
                
        try { 
            String req="INSERT INTO emprunt (id_oeuvre, id_usager, date_reservation) VALUES ("+this.getOeuvre().getId()+
                    ","+this.getUsager().getId()+","+this.getDateResa()+");";


            Statement statement = DB.getConnexion().createStatement();
            statement.executeUpdate(req);
        } 
        catch (SQLException e){ 
            System.out.println("Pb d'insertion d'une réservation : " + e.toString()); 
        } 
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figure.model;
import figure.control.Tacka2D;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author aurel
 */
public class DatabaseProxy {
    private Connection c;
    public DatabaseProxy() {
        try {
            c = DriverManager.getConnection("jdbc:ucanaccess://src\\resursi\\Figure.accdb");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseProxy.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ne mogu da se povezem sa bazom","Greska",JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Tacka2D> getTacka2D() {
        ArrayList<Tacka2D> podaci = new ArrayList<>();           
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Tacka2D");
            while(rs.next()){
                //System.out.println( rs.getString("Oznaka")  );
                Tacka2D tacka = new Tacka2D(rs.getString("Oznaka") , rs.getInt("X"), rs.getInt("Y"));                
                podaci.add(tacka);
            }
            return podaci;
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseProxy.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ne mogu da procitam podatke","Greska",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        
    }
    
    
    
}

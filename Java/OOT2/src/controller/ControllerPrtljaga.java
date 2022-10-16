package controller;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.*;
import net.proteanit.sql.DbUtils;
import view.GlavniProzor;

public class ControllerPrtljaga{

     public ControllerPrtljaga(){
     }
    

    public void potvrda_evidencijskog_listica(JLabel sifra,JLabel datum,JLabel prtljaga,JLabel cijena, String id) {
        DBHandler mcon = new DBHandler();
        Connection con = mcon.spajanje();
        String sqlquery = "SELECT * FROM EvidencijskiListic WHERE sifra_evidencijskog_listica= "+id;
        Statement stmt;
        ResultSet rs;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            rs = stmt.executeQuery(sqlquery);
            while(rs.next()){
            sifra.setText(String.valueOf(rs.getInt(1)));
            datum.setText(rs.getDate(2).toString());
            prtljaga.setText(rs.getString(3));
            cijena.setText(String.valueOf(rs.getFloat(4)));
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPrtljaga.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
  
    public void spremanje_evidencijskog_listica(String sifra, String datum, String prtljaga, String cijena) {
        try {
            DBHandler mcon = new DBHandler();
            Connection con = mcon.spajanje();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO EvidencijskiListic VALUES ('" + sifra + "','" + datum + "','" + prtljaga + "','" + cijena + "')");
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPrtljaga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dohvati_evidencijske_listice(JTable table, JLabel sifra, JLabel date){
        DBHandler mcon = new DBHandler();
        Connection con = mcon.spajanje();
        String sqlquery = "SELECT sifra_evidencijskog_listica AS 'Šifra evidencijskog listica', datum_evidencijskog_listica AS 'Datum', vrsta_prtljage AS 'Vrsta prtljage', cijena_po_danu AS 'Cijena po danu' FROM EvidencijskiListic";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sqlquery);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            long millis = System.currentTimeMillis();
            Date sqlDate= new Date(millis);
            rs.last();
            sifra.setText(Integer.toString(rs.getInt(1)+1));
            date.setText(String.valueOf(sqlDate));
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GlavniProzor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void potvrda_stavke(String sifra,String datum, String prtljaga, String cijena, JTable NoviRacun, JLabel ukupnaCijena) {
         
        Object[] row = { sifra, datum, prtljaga, cijena};

        DefaultTableModel model = (DefaultTableModel) NoviRacun.getModel();

        model.addRow(row);

    }

    public void kreiranje_racuna(JTable noviRacun, JTable racun, JLabel sifraRacuna,JLabel datum, JLabel ukupnaCijena) {
        TableModel model = noviRacun.getModel();
        TableModel model2 = racun.getModel();
        float ukupno=0f;
        float poDanu;
        String dan;
        long dani=1;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        racun.setModel(model);
        for(int i = 0; i< noviRacun.getRowCount();i++){
            poDanu=Float.parseFloat(noviRacun.getValueAt(i, 3).toString());
            dan = noviRacun.getValueAt(i, 1).toString();
            try {
                dani += (Math.abs(format.parse(dan).getTime()- System.currentTimeMillis()))/(24*60*60*1000);
            } catch (ParseException ex) {
                Logger.getLogger(ControllerPrtljaga.class.getName()).log(Level.SEVERE, null, ex);
            }
            ukupno+=poDanu*dani;
            dani=1;
            for(int j = 0; j<noviRacun.getColumnCount(); j++){
                noviRacun.setValueAt(racun.getValueAt(i, j), i, j);
                
            }
        }
        DBHandler mcon = new DBHandler();
        Connection con = mcon.spajanje();
        String sqlquery = "SELECT * FROM Racun";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sqlquery);
            long millis = System.currentTimeMillis();
            Date sqlDate= new Date(millis);
            rs.last();
            sifraRacuna.setText(Integer.toString(rs.getInt(1)+1));
            ukupnaCijena.setText(String.valueOf(ukupno));
            datum.setText(String.valueOf(sqlDate));
            stmt.close();
            rs.close();
            con.close();
            noviRacun.setModel(model2);
        } catch (SQLException ex) {
            Logger.getLogger(GlavniProzor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void spremanje_racuna(JTable racun, String sifraRacuna, String datumRacuna, JLabel ukupno) {
        try {
            DBHandler mcon = new DBHandler();
            Connection con = mcon.spajanje();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Racun VALUES ('" + sifraRacuna + "','" + datumRacuna + "','"+ukupno.getText()+"')");
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            ukupno.setText("0");
            DefaultTableModel model = (DefaultTableModel) racun.getModel();
            model.setRowCount(0);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPrtljaga.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void dohvati_racune(JTable table){
         DBHandler mcon = new DBHandler();
        Connection con = mcon.spajanje();
        String sqlquery = "SELECT sifra_racuna As 'Šifra računa', datum_racuna AS 'Datum', ukupna_cijena AS Cijena FROM Racun";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sqlquery);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GlavniProzor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
  
    public static void delete(String tablename, Object id){
        DBHandler mcon = new DBHandler();
        String red = id.toString();
        try {
           Connection con = mcon.spajanje();
           PreparedStatement pstmt = null;
           switch(tablename){
               case "EvidencijskiListic":
                   pstmt = con.prepareStatement("DELETE FROM "+tablename+" WHERE sifra_evidencijskog_listica = " + red);
                   break;
               case "Racun":
                   pstmt = con.prepareStatement("DELETE FROM "+tablename+" WHERE sifra_racuna = " + red);
                   break;
           }
           
           if(pstmt.isPoolable()){
            pstmt.executeUpdate();
           }
           pstmt.close();
            con.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPrtljaga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

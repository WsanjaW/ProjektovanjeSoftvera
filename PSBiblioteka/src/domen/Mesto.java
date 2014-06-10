/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Domenska klasa Mesto
 * 
 * @author Sanja
 */
public class Mesto extends OpstiDomenskiObjekat {

    private int mestoId;
    private String pttBroj;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int mestoId, String pttBroj, String naziv) {
        this.mestoId = mestoId;
        this.pttBroj = pttBroj;
        this.naziv = naziv;
    }

    public Mesto(int mestoId) {
        this.mestoId = mestoId;
    }

    public int getMestoId() {
        return mestoId;
    }

    public void setMestoId(int mestoId) {
        this.mestoId = mestoId;
    }

    public String getPttBroj() {
        return pttBroj;
    }

    public void setPttBroj(String pttBroj) {
        this.pttBroj = pttBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String nazivTabele() {
        return "mesto";
    }

    @Override
    public String vratiVrednostAtributa() {
        return "'" + pttBroj + "','" + naziv + "'";
    }

    @Override
    public String vratiAtribute() {
        return "pttBroj,naziv";
    }

    @Override
    public int vratiID() {
        return mestoId;
    }

    @Override
    public void postaviID(int id) {
        mestoId = id;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "pttBroj='" + pttBroj + "',naziv='" + naziv + "'";
    }

    @Override
    public String vratiUslov() {
        return "mestoid";
    }

    @Override
    public String vratiUslovPretrage() {
       
        if (mestoId > 0) {
            return "mestoid = " + mestoId;
        }
        return "1";
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int vratiBrojPovezanihObjekata() {
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i, int j) {
        return null;
    }

    @Override
    public int vratiBrojObjekata(int i) {
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiNoviPovezaniObjekat(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean povezanObjekatZaIzmenu(int i) {
        return false;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
               
                Mesto m = new Mesto();
                m.setMestoId(rs.getInt("mestoid"));
                m.setPttBroj(rs.getString("pttBroj"));
                m.setNaziv(rs.getString("naziv"));
                lista.add(m);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("greska pri popunjavanju liste");
        }
        return lista;
    }

    @Override
    public void spoj(List<OpstiDomenskiObjekat> lista2, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

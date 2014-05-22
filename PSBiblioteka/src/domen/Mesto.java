/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
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
        return "1";
    }

    @Override
    public void popuniListu(ResultSet rs, List<OpstiDomenskiObjekat> lista) throws SQLException {
        Mesto m = new Mesto();
        try {
            m.setMestoId(rs.getInt("mestoid"));
            m.setPttBroj(rs.getString("pttBroj"));
            m.setNaziv(rs.getString("naziv"));
            lista.add(m);

        } catch (SQLException ex) {
            throw new SQLException("greska pri popunjavanju liste");
        }
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
    public void popuniListuVezanih(List<OpstiDomenskiObjekat> lista2, List<OpstiDomenskiObjekat> lista, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivPovezanogObjekata(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaPovezanObjekat(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiIdZaPovezan(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat vratiNoviPovezaniObjekat(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean povezanObjekatZaIzmenu(int i) {
        return false;
    }

}

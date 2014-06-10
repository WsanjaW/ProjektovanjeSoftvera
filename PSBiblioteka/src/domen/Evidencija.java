/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * Domenska klasa Evidencija
 * 
 * @author Sanja
 */
public class Evidencija extends OpstiDomenskiObjekat {

    private Biciklista biciklista;
    private Putovanje putovanje;
    private Date datumOd;
    private Date datumDo;

    public Evidencija() {
        biciklista = new Biciklista();
        putovanje = new Putovanje();
    }

    public Evidencija(Biciklista biciklista, Putovanje putovanje, Date datumOd, Date datumDo) {
        this.biciklista = biciklista;
        this.putovanje = putovanje;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public Biciklista getBiciklista() {
        return biciklista;
    }

    public void setBiciklista(Biciklista biciklista) {
        this.biciklista = biciklista;
    }

    public Putovanje getPutovanje() {
        return putovanje;
    }

    public void setPutovanje(Putovanje putovanje) {
        this.putovanje = putovanje;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    @Override
    public String nazivTabele() {
        return "evidencija";
    }

    @Override
    public String vratiVrednostAtributa() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return biciklista.getId() + "," + putovanje.getPutovanjeID()
                + ",'" + df.format(datumOd) + "','"
                + df.format(datumDo) + "'";
    }

    @Override
    public String vratiAtribute() {
        return "biciklistaid,putovanjeid,datumOd,datumDo";
    }

    @Override
    public int vratiID() {
        return biciklista.getId();
    }

    @Override
    public void postaviID(int id) {

    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "biciklistaid=" + biciklista.getId()
                + ",putovanjeid=" + putovanje.getPutovanjeID()
                + ",datumOd='" + df.format(datumOd)
                + "',datumDo='" + df.format(datumDo) + "'";
    }

    @Override
    public String vratiUslov() {
        return "biciklistaid";
    }

    @Override
    public String vratiUslovPretrage() {
        return "biciklistaid = " + biciklista.getId();
    }

    @Override
    public int vratiBrojPovezanihObjekata() {
        return 1;
    }

    @Override
    public int vratiBrojObjekata(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i, int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat vratiNoviPovezaniObjekat(int i) {
        if (i == 0) {
            Putovanje p = new Putovanje();
            p.postaviID(this.putovanje.getPutovanjeID());
            return p;
        }

        return null;
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
             
                Evidencija evi = new Evidencija();
                evi.setBiciklista(new Biciklista(rs.getInt("biciklistaid")));
                evi.setPutovanje(new Putovanje(rs.getInt("putovanjeid")));
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                evi.setDatumOd(rs.getDate("datumOd"));
                evi.setDatumDo(rs.getDate("datumDo"));
                lista.add(evi);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("greska pri popunjavanju liste");
        }
        return lista;
    }

    @Override
    public void spoj(List<OpstiDomenskiObjekat> lista2, int i) {
        if (i == 0) {
            putovanje = (Putovanje) lista2.get(0);
        }
    }

}

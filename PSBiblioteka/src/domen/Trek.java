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
 * Domenska klasa Trek
 *
 * @author Sanja
 */
public class Trek extends OpstiDomenskiObjekat {

    private int trackId;
    private Putovanje putovanje;
    private String naziv;
    private Double kilometraza;
    private Long vreme;
    private Double prosecnaBrzina;

    public Trek (Putovanje putovanje, String naziv, Double kilometraza, Long vreme, Double prosecnaBrzina) {
        this.putovanje = putovanje;
        this.naziv = naziv;
        this.kilometraza = kilometraza;
        this.vreme = vreme;
        this.prosecnaBrzina = prosecnaBrzina;
    }

    public Trek(){
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public Putovanje getPutovanje() {
        return putovanje;
    }

    public void setPutovanje(Putovanje putovanje) {
        this.putovanje = putovanje;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(Double kilometraza) {
        this.kilometraza = kilometraza;
    }

    public Long getVreme() {
        
        return vreme;
    }

    public void setVreme(Long vreme) {

        this.vreme = vreme;
    }

    public Double getProsecnaBrzina() {
        return prosecnaBrzina;
    }

    public void setProsecnaBrzina(Double prosecnaBrzina) {
        this.prosecnaBrzina = prosecnaBrzina;
    }

    @Override
    public String nazivTabele() {
        return "trek";
    }

    @Override
    public String vratiVrednostAtributa() {
       
        return putovanje.getPutovanjeID() + ",'" + naziv + "'," + kilometraza + "," + vreme + "," + prosecnaBrzina;
    }

    @Override
    public String vratiAtribute() {
        return "putovanjeid,naziv,kilometraza,vreme,prosecnaBrzina";
    }

    @Override
    public int vratiID() {
        return trackId;
    }

    @Override
    public void postaviID(int id) {
        trackId = id;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovPretrage() {
        return "putovanjeid = " + putovanje.getPutovanjeID();
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

                Trek t = new Trek();               
                t.setTrackId(rs.getInt("trackid"));
                t.setNaziv(rs.getString("naziv"));
                t.setKilometraza(rs.getDouble("kilometraza"));
                t.setVreme(rs.getLong("vreme"));
                t.setProsecnaBrzina(rs.getDouble("prosecnaBrzina"));
                t.setPutovanje(new Putovanje(rs.getInt("putovanjeid")));
                lista.add(t);
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

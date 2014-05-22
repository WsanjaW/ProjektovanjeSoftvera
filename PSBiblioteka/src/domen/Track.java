/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sanja
 */
public class Track extends OpstiDomenskiObjekat {

    private int trackId;
    private Putovanje putovanje;
    private String naziv;
    private Double kilometraza;
    private Date vreme;
    private Double prosecnaBrzina;

    public Track(Putovanje putovanje, String naziv, Double kilometraza, Date vreme, Double prosecnaBrzina) {
        this.putovanje = putovanje;
        this.naziv = naziv;
        this.kilometraza = kilometraza;
        this.vreme = vreme;
        this.prosecnaBrzina = prosecnaBrzina;
    }

    public Track() {
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

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
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
        return "track";
    }

    @Override
    public String vratiVrednostAtributa() {
        return putovanje.getPutovanjeID() + ",'" + naziv + "'," + kilometraza;
    }

    @Override
    public String vratiAtribute() {
        return "putovanjeid,naziv,kilometraza";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popuniListu(ResultSet rs, List<OpstiDomenskiObjekat> lista) throws SQLException {
        try {
            Track t = new Track();
            t.setTrackId(rs.getInt("trackid"));
            t.setNaziv(rs.getString("naziv"));
            t.setKilometraza(rs.getDouble("kilometraza"));      
            t.setPutovanje(new Putovanje(rs.getInt("putovanjeid")));
            lista.add(t);
        } catch (SQLException ex) {
            throw new SQLException("greska pri popunjavanju liste");
        }
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

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
 * Domenska klasa Putovanje
 * 
 * @author Sanja
 */
public class Putovanje extends OpstiDomenskiObjekat {

    private int putovanjeID;
    private String naziv;
    private Mesto odMesta;
    private Mesto doMesta;
    private List<Track> trackovi;

    public Putovanje() {
        naziv = null;
        odMesta = null;
        doMesta = null;
        trackovi = new ArrayList<>();
    }

    public Putovanje(String naziv, Mesto odMesta, Mesto doMesta, List<Track> trackovi) {
        this.naziv = naziv;
        this.odMesta = odMesta;
        this.doMesta = doMesta;
        this.trackovi = trackovi;
    }

    public Putovanje(int putovanjeID) {
        this.putovanjeID = putovanjeID;
    }

    public int getPutovanjeID() {
        return putovanjeID;
    }

    public void setPutovanjeID(int putovanjeID) {
        this.putovanjeID = putovanjeID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Mesto getOdMesta() {
        return odMesta;
    }

    public void setOdMesta(Mesto odMesta) {
        this.odMesta = odMesta;
    }

    public Mesto getDoMesta() {
        return doMesta;
    }

    public void setDoMesta(Mesto doMesta) {
        this.doMesta = doMesta;
    }

    public List<Track> getTrackovi() {
        return trackovi;
    }

    public void setTrackovi(List<Track> trackovi) {
        this.trackovi = trackovi;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String nazivTabele() {
        return "putovanje";
    }

    @Override
    public String vratiVrednostAtributa() {
        String s = "'" + naziv + "'";
        if (odMesta != null) {
            s += "," + odMesta.getMestoId();
        } else {
            s += ",null";
        }
        if (doMesta != null) {
            s += "," + doMesta.getMestoId();
        } else {
            s += ",null";
        }
        return s;
    }

    @Override
    public String vratiAtribute() {
        return "naziv,odMesta,doMesta";
    }

    @Override
    public int vratiID() {
        return putovanjeID;
    }

    @Override
    public void postaviID(int id) {
        putovanjeID = id;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        String s = "naziv='" + naziv + "'";
        if (odMesta != null) {
            s += ",odMesta=" + odMesta.getMestoId();
        }
        if (doMesta != null) {
            s += ",doMesta=" + doMesta.getMestoId();
        }
        return s;
    }

    @Override
    public String vratiUslov() {
        return "putovanjeid";
    }

    @Override
    public String vratiUslovPretrage() {
        String uslov = "";
        if (putovanjeID > 0) {
            uslov += "putovanjeid=" + putovanjeID;
        }
        if (naziv != null && !naziv.isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "naziv='" + naziv + "'";
        }
        if (odMesta != null && !odMesta.getNaziv().isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "odMesta IN (SELECT mestoid FROM mesto WHERE naziv LIKE '" + odMesta.getNaziv() + "%')";
        }
        if (doMesta != null && !doMesta.getNaziv().isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "doMesta IN (SELECT mestoid FROM mesto WHERE naziv LIKE '" + doMesta.getNaziv() + "%')";
        }
        if (uslov.isEmpty()) {
            uslov = "1";
        }
        return uslov;
    }

    @Override
    public int vratiBrojPovezanihObjekata() {
        return 3;
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i, int j) {
        if (i == 0) {
            return trackovi.get(j);
        }

        return null;
    }

    @Override
    public int vratiBrojObjekata(int i) {
        if (i == 0) {
            return trackovi.size();
        }
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiNoviPovezaniObjekat(int i) {
        if (i == 0) {
            Track t = new Track();
            t.setPutovanje(this);
            return t;
        }
        if (i == 1) {
            Mesto m = new Mesto(odMesta.getMestoId());
            return m;
        } else if (i == 2) {
            Mesto m = new Mesto(doMesta.getMestoId());
            return m;
        }
        return null;
    }

    @Override
    public boolean povezanObjekatZaIzmenu(int i) {
        if (i == 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
               
                Putovanje p = new Putovanje();
                p.setPutovanjeID(rs.getInt("putovanjeid"));
                p.setNaziv(rs.getString("naziv"));
                p.setOdMesta(new Mesto(rs.getInt("odMesta")));
                p.setDoMesta(new Mesto(rs.getInt("doMesta")));
                lista.add(p);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("greska pri popunjavanju liste");
        }
        return lista;
    }

    @Override
    public void spoj(List<OpstiDomenskiObjekat> lista2, int i) {
        if (i == 0) {
            for (OpstiDomenskiObjekat opstiDomenskiObjekat : lista2) {
                trackovi.add((Track) opstiDomenskiObjekat);
            }
        }
        if (i == 1) {
            odMesta = (Mesto) lista2.get(0);
        } else if (i == 2) {
           doMesta = (Mesto) lista2.get(0);
        }
       
    }

}

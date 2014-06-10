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
 * Domenska klasa Biciklista
 * 
 * @author Sanja
 */
public class Biciklista extends OpstiDomenskiObjekat {

    private int id;
    private String ime;
    private String prezime;
    private String jmbg;
    private String nazivBicikla;
    private String tipBicikla;
    private Mesto mesto;
    private List<Evidencija> evidencije;

    public Biciklista() {
        evidencije = new ArrayList<>();
    }

    public Biciklista(int id) {
        this.id = id;
    }

    //<editor-fold defaultstate="collapsed" desc="geteti i seteri">
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getIme() {
        return ime;
    }
    
    public void setIme(String ime) {
        this.ime = ime;
    }
    
    public String getPrezime() {
        return prezime;
    }
    
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    public String getJmbg() {
        return jmbg;
    }
    
    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    
    public String getNazivBicikla() {
        return nazivBicikla;
    }
    
    public void setNazivBicikla(String nazivBicikla) {
        this.nazivBicikla = nazivBicikla;
    }
    
    public String getTipBicikla() {
        return tipBicikla;
    }
    
    public void setTipBicikla(String tipBicikla) {
        this.tipBicikla = tipBicikla;
    }
    
    public Mesto getMesto() {
        return mesto;
    }
    
    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }
    
    public List<Evidencija> getEvidencije() {
        return evidencije;
    }
    
    public void setEvidencije(List<Evidencija> evidencije) {
        this.evidencije = evidencije;
    }
//</editor-fold>

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String nazivTabele() {
        return "biciklista";
    }

    @Override
    public String vratiVrednostAtributa() {
        if (mesto != null) {
            return "'" + ime + "','" + prezime + "','" + jmbg + "','" + nazivBicikla + "','" + tipBicikla + "'," + mesto.getMestoId();
        }
        return "'" + ime + "','" + prezime + "','" + jmbg + "','" + nazivBicikla + "','" + tipBicikla + "',null";
    }

    @Override
    public String vratiAtribute() {
        return "ime,prezime,jmbg,naziv_bicikla,tip_bicikla,mestoid";
    }

    @Override
    public int vratiID() {
        return id;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        if (mesto == null) {
            return "ime='" + ime + "',prezime='" + prezime
                    + "',jmbg='" + jmbg
                    + "',naziv_bicikla='" + nazivBicikla
                    + "',tip_bicikla='" + tipBicikla + "'";
        }
        if (mesto.getMestoId() == 0) {
            return "ime='" + ime + "',prezime='" + prezime
                    + "',jmbg='" + jmbg
                    + "',naziv_bicikla='" + nazivBicikla
                    + "',tip_bicikla='" + tipBicikla
                    + "'";
        }
        return "ime='" + ime + "',prezime='" + prezime
                + "',jmbg='" + jmbg
                + "',naziv_bicikla='" + nazivBicikla
                + "',tip_bicikla='" + tipBicikla
                + "',mestoid=" + mesto.getMestoId();

    }

    @Override
    public String vratiUslov() {
        return "biciklistaid";
    }

    @Override
    public void postaviID(int id) {
        this.id = id;
    }

    @Override
    public String vratiUslovPretrage() {
        String uslov = "";
        if (id > 0) {
            uslov += "biciklistaid=" + id;
        }
        if (ime != null && !ime.isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "ime='" + ime + "'";
        }
        if (prezime != null && !prezime.isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "prezime='" + prezime + "'";
        }
        if (jmbg != null && !jmbg.isEmpty()) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "jmbg='" + jmbg + "'";
        }
        if (uslov.isEmpty()) {
            uslov = "1";
        }

        return uslov;
    }

    @Override
    public int vratiBrojPovezanihObjekata() {
        return 2;
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i, int j) {
        if (i == 0) {
            return evidencije.get(j);
        }
        if (i == 1) {
            return mesto;
        }
        return null;
    }

    @Override
    public int vratiBrojObjekata(int i) {
        if (i == 0) {
            return evidencije.size();
        }
        if (i == 1) {
            return 1;
        }
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiNoviPovezaniObjekat(int i) {
        if (i == 0) {
            Evidencija ev = new Evidencija();
            ev.setBiciklista(this);
            return ev;
        }
        if (i == 1) {
            Mesto m = new Mesto();
            m.setMestoId(mesto.getMestoId());
            return m;
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
                Biciklista bic = new Biciklista();

                bic.setId(rs.getInt("biciklistaid"));
                bic.setIme(rs.getString("ime"));
                bic.setPrezime(rs.getString("prezime"));
                bic.setJmbg(rs.getString("jmbg"));
                bic.setNazivBicikla(rs.getString("naziv_bicikla"));
                bic.setTipBicikla(rs.getString("tip_bicikla"));
                Mesto m = new Mesto();
                m.setMestoId(rs.getInt("mestoid"));
                bic.setMesto(m);
                lista.add(bic);

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
                evidencije.add((Evidencija) opstiDomenskiObjekat);
            }
        }
        if (i == 1) {
            mesto = (Mesto) lista2.get(0);
        }
       
    }

}

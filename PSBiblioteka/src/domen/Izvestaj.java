/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sanja
 */
public class Izvestaj extends OpstiDomenskiObjekat {

    private int izvestajID;
    private Date datumKreiranja;
    private String komentar;
    private Biciklista biciklista;
    private Kordinator kordinator;

    public Izvestaj() {
        biciklista = new Biciklista();
        kordinator = new Kordinator();
        datumKreiranja = new Date();
    }

    public int getIzvestajID() {
        return izvestajID;
    }

    public void setIzvestajID(int izvestajID) {
        this.izvestajID = izvestajID;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Biciklista getBiciklista() {
        return biciklista;
    }

    public void setBiciklista(Biciklista biciklista) {
        this.biciklista = biciklista;
    }

    public Kordinator getKordinator() {
        return kordinator;
    }

    public void setKordinator(Kordinator kordinator) {
        this.kordinator = kordinator;
    }

    @Override
    public String nazivTabele() {
        return "izvestaj";
    }

    @Override
    public String vratiVrednostAtributa() {
        
        return "'2000-01-01',null,null,1" ;
    }

    @Override
    public String vratiAtribute() {
        return "datumKreiranja,komentar,biciklistaid,kordinatorid";
    }

    @Override
    public int vratiID() {
        return izvestajID;
    }

    @Override
    public void postaviID(int id) {
        izvestajID = id;
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "datumKreiranja='" + df.format(datumKreiranja)
                + "',komentar='" + komentar + "',biciklistaid=" + biciklista.getId()
                + ",kordinatorid=" + kordinator.getKordinatorID() ;
    }

    @Override
    public String vratiUslov() {
        return "izvestajid";
    }

    @Override
    public String vratiUslovPretrage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popuniListu(ResultSet rs, List<OpstiDomenskiObjekat> lista) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiBrojPovezanihObjekata() {
        return 0;
    }

    @Override
    public int vratiBrojObjekata(int i) {
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiPovezanObjekat(int i, int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

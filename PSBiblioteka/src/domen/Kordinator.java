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
public class Kordinator extends OpstiDomenskiObjekat{
    private int kordinatorID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Kordinator() {
        kordinatorID = 1;
        
    }

    public int getKordinatorID() {
        return kordinatorID;
    }

    public void setKordinatorID(int kordinatorID) {
        this.kordinatorID = kordinatorID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String nazivTabele() {
        return "kordinator";
    }

    @Override
    public String vratiVrednostAtributa() {
        return "ime='"+ime + "',prezime='" +  prezime + "',username='" + username + "',passwoed='" + password + "'";
    }

    @Override
    public String vratiAtribute() {
        return "ime,prezime,username,password";
    }

    @Override
    public int vratiID() {
       return kordinatorID;
    }

    @Override
    public void postaviID(int id) {
       kordinatorID = id;
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
        return "username='" + username + "' AND password='" + password + "'";
    }

    @Override
    public void popuniListu(ResultSet rs, List<OpstiDomenskiObjekat> lista) throws SQLException {
            Kordinator k = new Kordinator();
            k.setKordinatorID(rs.getInt("kordinatorid"));
            k.setIme(rs.getString("ime"));
            k.setPrezime(rs.getString("prezime"));
            k.setUsername(rs.getString("username"));
            k.setPassword(rs.getString("password"));
            lista.add(k);
    }

    @Override
    public int vratiBrojPovezanihObjekata() {
       return 0;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

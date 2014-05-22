/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandar
 */
public class BrokerBaze {

    Connection konekcija;

    public void otvoriKonekciju() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        konekcija = DriverManager.getConnection("jdbc:mysql://localhost/ps_baza?user=root&password=root");
        konekcija.setAutoCommit(false);

    }

    public void zatvoriKonekciju() throws SQLException {

        konekcija.close();

    }

    public void commit() throws SQLException {

        konekcija.commit();

    }

    public void rollback() throws SQLException {

        konekcija.rollback();

    }

    public Map<String, Object> ubaciSlog(OpstiDomenskiObjekat domenskiObjekat) {
        Map<String, Object> mapa = new Hashtable<String, Object>();
        try {
            Statement s = konekcija.createStatement();
            String upitID = "SELECT max(" + domenskiObjekat.vratiUslov() + ") FROM "
                    + domenskiObjekat.nazivTabele();

            ResultSet rs = s.executeQuery(upitID);
            if (rs.next() == false) {
                domenskiObjekat.postaviID(1);
            } else {
                domenskiObjekat.postaviID(rs.getInt(1) + 1);
            }

            s = konekcija.createStatement();
            String upit = "INSERT INTO " + domenskiObjekat.nazivTabele() + "(" + domenskiObjekat.vratiAtribute() + ") VALUES ("
                    + domenskiObjekat.vratiVrednostAtributa() + ")";
            System.out.println(upit);
            s.executeUpdate(upit);
            System.out.println("izvrsen");
            mapa.put("poruka", domenskiObjekat.nazivTabele() + " je uspesno kreiran");
            mapa.put("domenskiObjekat", domenskiObjekat);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            mapa.put("poruka", domenskiObjekat.nazivTabele() + " ne moze biti kreiran");
            mapa.put("Greska", "Greska");
        }
        return mapa;
    }

    public Map<String, Object> zapamtiSlog(OpstiDomenskiObjekat domenskiObjekat) {
        Map<String, Object> mapa = new Hashtable<String, Object>();
        try {
            Statement s = konekcija.createStatement();
            String upit = "UPDATE " + domenskiObjekat.nazivTabele() + " SET "
                    + domenskiObjekat.vratiVrednostiZaIzmenu() + " WHERE "
                    + domenskiObjekat.vratiUslov() + "=" + domenskiObjekat.vratiID();
            System.out.println(upit);
            s.executeUpdate(upit);
            System.out.println("izvrsen");

            for (int i = 0; i < domenskiObjekat.vratiBrojPovezanihObjekata(); i++) {
                if (domenskiObjekat.povezanObjekatZaIzmenu(i)) {
                    for (int j = 0; j < domenskiObjekat.vratiBrojObjekata(i); j++) {
                        OpstiDomenskiObjekat povezanObjekat = domenskiObjekat.vratiPovezanObjekat(i, j);
                        upit = "INSERT INTO " + povezanObjekat.nazivTabele() + "(" + povezanObjekat.vratiAtribute() + ") VALUES ("
                                + povezanObjekat.vratiVrednostAtributa() + ")";
                        s.execute(upit);
                    }
                }

            }

            mapa.put("poruka", domenskiObjekat.nazivTabele() + " je uspesno sacuvan");
            mapa.put("domenskiObjekat", domenskiObjekat);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            mapa.put("poruka", domenskiObjekat.nazivTabele() + " ne moze biti sacuvan");
            mapa.put("Greska", "Greska");
        }
        return mapa;
    }

    public Map<String, Object> izbrisiSlog(OpstiDomenskiObjekat domenskiObjekat) {
        Map<String, Object> mapa = new Hashtable<String, Object>();
        try {
            Statement s = konekcija.createStatement();
            String upit = "DELETE FROM " + domenskiObjekat.nazivTabele() + " WHERE "
                    + domenskiObjekat.vratiUslov() + "=" + domenskiObjekat.vratiID();
            System.out.println(upit);
            s.executeUpdate(upit);
            System.out.println("izvrsen");
            mapa.put("poruka", domenskiObjekat.nazivTabele() + " je uspesno izbrisan");
            mapa.put("domenskiObjekat", domenskiObjekat);
            mapa.put("operacija", "izbrisiSlog");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            mapa.put("poruka", domenskiObjekat.nazivTabele() + " ne moze biti izbrisan");
            mapa.put("Greska", "Greska");
        }
        return mapa;
    }

    public Map<String, Object> pronadji(OpstiDomenskiObjekat domenskiObjekat) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        Map<String, Object> mapa = new Hashtable<String, Object>();
        try {
            Statement s = konekcija.createStatement();
            String upit = "SELECT * FROM " + domenskiObjekat.nazivTabele() + " WHERE "
                    + domenskiObjekat.vratiUslovPretrage();
            System.out.println(upit);
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {
                domenskiObjekat.popuniListu(rs, lista);
                for (int i = 0; i < domenskiObjekat.vratiBrojPovezanihObjekata(); i++) {
                    OpstiDomenskiObjekat povezaniObjekat = domenskiObjekat.vratiNoviPovezaniObjekat(i);

                    upit = "SELECT * FROM " + domenskiObjekat.vratiNazivPovezanogObjekata(i) + " WHERE "
                            + domenskiObjekat.vratiUslovZaPovezanObjekat(i) + "=" + lista.get(lista.size() - 1).vratiIdZaPovezan(i);
                    System.out.println(upit);
                    Statement s2 = konekcija.createStatement();
                    ResultSet rs2 = s2.executeQuery(upit);
                    List<OpstiDomenskiObjekat> lista2 = new ArrayList<>();
                    while (rs2.next()) {
                        povezaniObjekat.popuniListu(rs2, lista2);
                        for (int j = 0; j < povezaniObjekat.vratiBrojPovezanihObjekata(); j++) {
                            OpstiDomenskiObjekat povezaniObjekat2 = povezaniObjekat.vratiNoviPovezaniObjekat(j);
                            upit = "SELECT * FROM " + povezaniObjekat.vratiNazivPovezanogObjekata(i) + " WHERE "
                                    + povezaniObjekat.vratiUslovZaPovezanObjekat(j) + "=" + lista2.get(lista2.size() - 1).vratiIdZaPovezan(j);
                            System.out.println(upit);
                            Statement s3 = konekcija.createStatement();
                            ResultSet rs3 = s3.executeQuery(upit);
                            List<OpstiDomenskiObjekat> lista3 = new ArrayList<>();
                            while (rs3.next()) {
                                povezaniObjekat2.popuniListu(rs3, lista3);

                            }
                            povezaniObjekat.popuniListuVezanih(lista3, lista2, i);
                        }
                    }
                    domenskiObjekat.popuniListuVezanih(lista2, lista, i);
                    s2.close();

                }

            }
            s.close();
            System.out.println("izvrsen");
            if (!lista.isEmpty()) {
                mapa.put("poruka", domenskiObjekat.nazivTabele() + " je uspesno pronadjen");
                mapa.put("rezultatPretrage", lista);
            } else {
                mapa.put("poruka", domenskiObjekat.nazivTabele() + " nije pronadjen");
            }

        } catch (SQLException ex) {
            Logger.getLogger(BrokerBaze.class.getName()).log(Level.SEVERE, null, ex);
            mapa.put("poruka", domenskiObjekat.nazivTabele() + " nije uspesno pronadjen");
            mapa.put("Greska", "Greska");
        }
        return mapa;

    }
}

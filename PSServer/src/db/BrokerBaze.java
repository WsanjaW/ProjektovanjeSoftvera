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
import java.util.List;
import javax.management.RuntimeErrorException;
import util.Util;

/**
 *
 * @author Aleksandar
 */
public class BrokerBaze {

    Connection konekcija;

    /**
     * Otvaranje konekcije na mysql bazu TODO property
     *
     * @throws RuntimeException
     */
    public void otvoriKonekciju() throws RuntimeException {

        try {
            Class.forName(Util.getInstance().getDriver());
            konekcija = DriverManager.getConnection(Util.getInstance().getConnectionUrl());
            konekcija.setAutoCommit(false);
        } catch (Exception ex) {
            throw new RuntimeException("Neuspesno otvaranje konekcije!");
        }

    }

    /**
     * Zatvaranje konekcije
     *
     * @throws RuntimeException
     */
    public void zatvoriKonekciju() throws RuntimeException {

        try {
            konekcija.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Neuspesno zatvaranje konekcije!");
        }

    }

    /**
     * Commit
     *
     * @throws RuntimeException
     */
    public void commitTransakcije() throws RuntimeException {

        try {
            konekcija.commit();
        } catch (SQLException ex) {
            throw new RuntimeException("Neuspesan commit transakcije!");
        }

    }

    /**
     * Rollback
     *
     * @throws RuntimeException
     */
    public void rollbackTransakcije() throws RuntimeException {

        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            throw new RuntimeException("Neuspesan rollback transakcije!");
        }

    }

    /**
     * Vraca id od datog objekta
     * @param domenskiObjekat
     * @return id
     * @throws RuntimeException 
     */
    public int vratiID(OpstiDomenskiObjekat domenskiObjekat) throws RuntimeException {
        int id = 0;
        try {
            Statement s = konekcija.createStatement();
            //pronadji najvecu vrednost id-a u tabeli
            String upitID = "SELECT max(" + domenskiObjekat.vratiUslov() + ") FROM "
                    + domenskiObjekat.nazivTabele();

            ResultSet rs = s.executeQuery(upitID);

            //ako je tabela prazna postavi id na 1
            if (rs.next() == false) {
                id = 1;
            } //ako nije prazna onda ce id biti nadjeni maksimalni +1
            else {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Neuspesno postavljanje ID-a");
        }
        return id;
    }

    /**
     * Ubacivanje novog OpstogDomenskogObjekta u bazu
     *
     * @param domenskiObjekat
     * @return ubacen domenski objekat
     * @throws RuntimeException
     */
    public void ubaci(OpstiDomenskiObjekat domenskiObjekat) throws RuntimeException {
        try {

            Statement s = konekcija.createStatement();

            //ubacivanje u bazu
            String upit = "INSERT INTO " + domenskiObjekat.nazivTabele() + "(" + domenskiObjekat.vratiAtribute() + ") VALUES ("
                    + domenskiObjekat.vratiVrednostAtributa() + ")";
            System.out.println(upit);
            s.executeUpdate(upit);
            System.out.println("izvrsen");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Neuspesno ubcivanje novog objekata");

        }
       
    }

    /**
     * Pamti(menja) vrednosti sloga u bazi
     *
     * @param domenskiObjekat
     * @return
     * @throws RuntimeException
     */
    public void zapamti(OpstiDomenskiObjekat domenskiObjekat) throws RuntimeException {

        try {
            Statement s = konekcija.createStatement();
            //izmena polja u bazi
            String upit = "UPDATE " + domenskiObjekat.nazivTabele() + " SET "
                    + domenskiObjekat.vratiVrednostiZaIzmenu() + " WHERE "
                    + domenskiObjekat.vratiUslov() + "=" + domenskiObjekat.vratiID();
            System.out.println(upit);
            s.executeUpdate(upit);
            System.out.println("izvrsen");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Neuspesno pamcenje objekata");
        }
       // return domenskiObjekat;
    }
    /**
     * Pamti(ubacuje) objekte koji su povezani sa datim objektom
     * @param domenskiObjekat
     * @throws RuntimeException 
     */
    public void zapamtiPovezane(OpstiDomenskiObjekat domenskiObjekat) throws RuntimeException {

        try {
            Statement s = konekcija.createStatement();
            String upit = "";
            //ako objekat koji se pamti ima povezane objekte njih je potrebno sacuvati u bazi (slab objekat)
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

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Neuspesno pamcenje objekata");
        }
       // return domenskiObjekat;
    }

    /**
     * Brisanje sloga iz baze
     *
     * @param domenskiObjekat objekat koji treba izbrisati
     * @return
     * @throws RuntimeErrorException
     */
    public void izbrisi(OpstiDomenskiObjekat domenskiObjekat) throws RuntimeErrorException {

        try {
            Statement s = konekcija.createStatement();
            String upit = "DELETE FROM " + domenskiObjekat.nazivTabele() + " WHERE "
                    + domenskiObjekat.vratiUslov() + "=" + domenskiObjekat.vratiID();
            System.out.println(upit);
            s.executeUpdate(upit);
            System.out.println("izvrsen");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Neuspesno brisanje objekata");

        }

      //  return domenskiObjekat;
    }

    /**
     * Pronalazenje slogova u bazi koji zadovoljavaju uslov pretrage
     *
     * @param domenskiObjekat
     * @return lista pronadjenih objekata
     * @throws RuntimeErrorException
     */
    public List<OpstiDomenskiObjekat> pronadji(OpstiDomenskiObjekat domenskiObjekat) throws RuntimeErrorException {

        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {

            Statement s = konekcija.createStatement();
            //uzmi slogove koji zadovoljavaju kriterijum
            String upit = "SELECT * FROM " + domenskiObjekat.nazivTabele() + " WHERE "
                    + domenskiObjekat.vratiUslovPretrage();
            System.out.println(upit);
            ResultSet rs = s.executeQuery(upit);
            //popuni listu objekata pronadjenim slogovima
            lista = domenskiObjekat.vratiListu(rs);
            //za svaki objekat u listi pronadji njegove povezane objekte i spoji ih sa datim objektom
            for (OpstiDomenskiObjekat obj : lista) {
                List<OpstiDomenskiObjekat> lista2 = null;
                for (int i = 0; i < obj.vratiBrojPovezanihObjekata(); i++) {
                    //pronaji povezan objekat
                    lista2 = pronadji(obj.vratiNoviPovezaniObjekat(i));
                    //spoj sa "glavnim" objektom
                    obj.spoj(lista2, i);
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException("Neuspesno brisanje objekata");
        }
        return lista;

    }
}

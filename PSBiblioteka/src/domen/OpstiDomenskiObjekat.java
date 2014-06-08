/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aleksandar
 */
public abstract class OpstiDomenskiObjekat implements Serializable{
   
    public abstract String nazivTabele();
    public abstract String vratiVrednostAtributa();
    public abstract String vratiAtribute();

    public abstract int vratiID();
    public abstract void postaviID(int id);
    public abstract String vratiVrednostiZaIzmenu();
    public abstract String vratiUslov();
    public abstract String vratiUslovPretrage();

    public abstract void popuniListu(ResultSet rs,List<OpstiDomenskiObjekat> lista) throws SQLException;
    
    public abstract int vratiBrojPovezanihObjekata();
    public abstract int vratiBrojObjekata(int i);
    public abstract OpstiDomenskiObjekat vratiPovezanObjekat(int i,int j);

    public abstract void popuniListuVezanih(List<OpstiDomenskiObjekat> lista2,List<OpstiDomenskiObjekat> lista, int i);

    public abstract String vratiNazivPovezanogObjekata(int i);

    public abstract String vratiUslovZaPovezanObjekat(int i);

    public abstract int vratiIdZaPovezan(int i);

    public abstract OpstiDomenskiObjekat vratiNoviPovezaniObjekat(int i);

    public abstract boolean povezanObjekatZaIzmenu(int i);

    

    public abstract List<OpstiDomenskiObjekat> vratiListuRek(ResultSet rs);

    public abstract void spoj(List<OpstiDomenskiObjekat> lista2, int i);
   
}

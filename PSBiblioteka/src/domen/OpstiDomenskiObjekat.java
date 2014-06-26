/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * Opsti domenski objekat
 * 
 * @author Sanja
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
    
    public abstract int vratiBrojPovezanihObjekata();
    public abstract int vratiBrojObjekata(int i);
    public abstract OpstiDomenskiObjekat vratiPovezanObjekat(int i,int j);
    public abstract OpstiDomenskiObjekat vratiNoviPovezaniObjekat(int i);
    public abstract boolean povezanObjekatZaIzmenu(int i);
    public abstract void spoj(List<OpstiDomenskiObjekat> lista2, int i);
    
    public abstract List<OpstiDomenskiObjekat> vratiListu(ResultSet rs);
    
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler;

import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import komunikacija.Komunikacija;
import transfer.TransferObjekat;
import view.panel.PanelAkcije;

/**
 *
 * @author Sanja
 */
public abstract class OpstiKontroler {

    protected PanelAkcije form;
    protected Map<String, Object> mapa;
    protected OpstiDomenskiObjekat domenskiObjekat;
    protected String signal;

    public OpstiKontroler() {
        mapa = new HashMap<>();
    }

    public String kreirajNovi() {
        domenskiObjekat = form.vratiDomenskiObjekat();
        mapa.put("domenskiObjekat", domenskiObjekat);
        mapa.put("operacija", "kreirajNoviSlog");
        signal = pozoviSO();
        prikaziRezultatSO();
        return signal;

    }
    public String zapamti(){
      
        domenskiObjekat = procitajUnosKorisnika();
        mapa.put("domenskiObjekat", domenskiObjekat);
        mapa.put("operacija", "zapamtiSlog");
        signal = pozoviSO();
        prikaziRezultatSO();
        return signal;
    }
    
    public String izbrisi(){
        domenskiObjekat = procitajUnosKorisnika();
        mapa.put("domenskiObjekat", domenskiObjekat);
        mapa.put("operacija", "izbrisiSlog");
        signal = pozoviSO();
        prikaziRezultatSO();
        return signal;
    }
    
    public String pronadji(){
        domenskiObjekat = procitajUnosKorisnika();
        mapa.put("domenskiObjekat", domenskiObjekat);
        mapa.put("operacija", "pronadji");
        signal = pozoviSO();
        prikaziRezultatSO();
        return signal;
    }
    
    private String pozoviSO() {
        try {
            TransferObjekat transfer = new TransferObjekat(mapa);
            Komunikacija.getInstance().posalji(transfer);
            TransferObjekat primljeniObjekat = Komunikacija.getInstance().primi();
            mapa = primljeniObjekat.getMapa();
            return (String) mapa.get("poruka");
        } catch (IOException ex) {
           return "Neuspesna komunikacija sa serverom";
        } catch (ClassNotFoundException ex) {
           return "Neuspesna komunikacija sa serverom";
        }
    }

    public abstract void prikaziRezultatSO();

    public abstract OpstiDomenskiObjekat procitajUnosKorisnika();
    
   // public abstract OpstiDomenskiObjekat vratiDomenskiObjekat();

    public OpstiDomenskiObjekat getDomenskiObjekat() {
        return domenskiObjekat;
    }

        

}

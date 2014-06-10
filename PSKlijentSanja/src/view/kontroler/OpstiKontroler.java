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
import javax.swing.JPanel;
import komunikacija.Komunikacija;
import transfer.TransferObjekat;

/**
 * Opsti kontroler
 * @author Sanja
 */
public abstract class OpstiKontroler {

    protected JPanel form;
    protected Map<String, Object> parametriKomunikacije;
    protected OpstiDomenskiObjekat domenskiObjekat;
    protected String signal;

    public OpstiKontroler() {
        parametriKomunikacije = new HashMap<>();
    }
    /**
     * Poziva izvrsavanje so slanjem transfer objekta severu
     * i cita primljeni odgovor
     * @return poruku servera
     */
    public String pozoviSO() {
        try {
            TransferObjekat transfer = new TransferObjekat(parametriKomunikacije);
            Komunikacija.getInstance().posalji(transfer);
            TransferObjekat primljeniObjekat = Komunikacija.getInstance().primi();
            parametriKomunikacije = primljeniObjekat.getMapa();
            return (String) parametriKomunikacije.get("poruka");
        } catch (IOException ex) {
           return "Neuspesna komunikacija sa serverom";
        } catch (ClassNotFoundException ex) {
           return "Neuspesna komunikacija sa serverom";
        }
    }
    
    public abstract void prikaziRezultatSO();

    public abstract OpstiDomenskiObjekat procitajUnosKorisnika();
    

        

}

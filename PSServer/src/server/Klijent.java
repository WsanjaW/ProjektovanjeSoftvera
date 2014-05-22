/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.komunikacija.KomunikacijaServer;
import transfer.TransferObjekat;
import so.OpstaSO;
import so.SOIzbrisi;
import so.SOKreiraj;
import so.SOPronadji;
import so.SOZapamti;

/**
 *
 * @author Aleksandar
 */
class Klijent extends Thread {

    KomunikacijaServer kom;

    public Klijent(Socket klientSocket) {
        try {
            kom = new KomunikacijaServer(klientSocket);
            start();
        } catch (IOException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                TransferObjekat to = kom.primi();
                if (to.getMapa().get("operacija").equals("kreirajNoviSlog")) {

                    OpstiDomenskiObjekat b = (OpstiDomenskiObjekat) to.getMapa().get("domenskiObjekat");
                    // b.setIme("Vucic");

                    OpstaSO.izvrsenjeOpsteSO(to, new SOKreiraj());
//                    to.setSignal("promenjen");
                    kom.posalji(to);

                } else if (to.getMapa().get("operacija").equals("zapamtiSlog")) {

                    OpstiDomenskiObjekat b = (OpstiDomenskiObjekat) to.getMapa().get("domenskiObjekat");
                    // b.setIme("Vucic");

                    OpstaSO.izvrsenjeOpsteSO(to, new SOZapamti());
//                    to.setSignal("promenjen");
                    kom.posalji(to);

                } else if (to.getMapa().get("operacija").equals("izbrisiSlog")) {

                    OpstiDomenskiObjekat b = (OpstiDomenskiObjekat) to.getMapa().get("domenskiObjekat");
                    // b.setIme("Vucic");

                    OpstaSO.izvrsenjeOpsteSO(to, new SOIzbrisi());
//                    to.setSignal("promenjen");
                    kom.posalji(to);

                } else if (to.getMapa().get("operacija").equals("pronadji")) {

                    OpstiDomenskiObjekat b = (OpstiDomenskiObjekat) to.getMapa().get("domenskiObjekat");
                    // b.setIme("Vucic");

                    OpstaSO.izvrsenjeOpsteSO(to, new SOPronadji());
//                    to.setSignal("promenjen");
                    kom.posalji(to);

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

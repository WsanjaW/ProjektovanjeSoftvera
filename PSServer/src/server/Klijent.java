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
import poslovnalogika.Kontroler;
import server.komunikacija.KomunikacijaServer;
import transfer.TransferObjekat;
import so.OpstaSO;
import so.SOKreiraj;
import so.SOKreirajNoviIzvestaj;
import so.SOKreirajNovoPutovanje;
import so.SOKreirajNovogBiciklistu;
import so.SOKreirajNovuEvidenciju;
import so.SOObrisiBiciklistu;
import so.SOPronadji;
import so.SOPronadjiBiciklistu;
import so.SOPronadjiPutovanje;
import so.SOUcitajMesta;
import so.SOUlogujSe;
import so.SOZapamti;
import so.SOZapamtiBiciklistu;
import so.SOZapamtiEvidenciju;
import so.SOZapamtiIzvestaj;
import so.SOZapamtiPutovanje;
import util.Konstante;

/**
 *
 * @author Aleksandar
 */
class Klijent extends Thread {

    KomunikacijaServer kom;

    public Klijent(Socket klientSocket) {
        try {
            kom = new KomunikacijaServer(klientSocket);

        } catch (IOException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

        while (true) {
            TransferObjekat to = null;
            try {
                to = kom.primi();
                OpstaSO sistemskaOperacija = null;
                Object obj = null;
                int operacija = (int) to.getMapa().get("operacija");
                Object domenskiObjekat = to.getMapa().get("domenskiObjekat");
                switch (operacija) {

                    case Konstante.KREIRAJ_BICIKLISTU:
                        sistemskaOperacija = new SOKreirajNovogBiciklistu();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Biciklista je uspesno kreiran");
                        break;
                    case Konstante.KREIRAJ_PUTOVANJE:
                        sistemskaOperacija = new SOKreirajNovoPutovanje();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Putovanje je uspesno kreirano");
                        break;
                    case Konstante.KREIRAJ_IZVESTAJ:
                        sistemskaOperacija = new SOKreirajNoviIzvestaj();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Izvestaj je uspesno kreiran");
                        break;

                    case Konstante.KREIRAJ_EVIDENCIJU:
                        sistemskaOperacija = new SOKreirajNovuEvidenciju();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Evidencija je uspesno kreirana");
                        break;

                    case Konstante.OBRISI_BICIKLISTU:
                        sistemskaOperacija = new SOObrisiBiciklistu();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Biciklista je uspesno izbrisan");
                        break;
                    case Konstante.PRONADJI_BICIKLISTU:
                        sistemskaOperacija = new SOPronadjiBiciklistu();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("rezultatPretrage", obj);
                        to.getMapa().put("poruka", "Biciklisti su uspesno pronadjeni");
                        break;
                    case Konstante.PRONADJI_PUTOVANJE:
                        sistemskaOperacija = new SOPronadjiPutovanje();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("rezultatPretrage", obj);
                        to.getMapa().put("poruka", "Putovanja su uspesno pronadjena");
                        break;
                    case Konstante.ZAPAMTI_BICIKLISTU:
                        sistemskaOperacija = new SOZapamtiBiciklistu();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Biciklista je uspesno zapamcen");
                        break;

                    case Konstante.ZAPAMTI_PUTOVANJE:
                        sistemskaOperacija = new SOZapamtiPutovanje();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Putovanje je uspesno zapamceno");
                        break;
                    case Konstante.ZAPAMTI_EVIDENCIJU:
                        sistemskaOperacija = new SOZapamtiEvidenciju();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Evidencija je uspesno zapamcena");
                        break;
                    case Konstante.ZAPAMTI_IZVESTAJ:
                        sistemskaOperacija = new SOZapamtiIzvestaj();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Izvestaj uspesno zapamcen");
                        break;
                    case Konstante.ULOGUJ_SE:
                        sistemskaOperacija = new SOUlogujSe();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("rezultatPretrage", obj);
                        to.getMapa().put("poruka", "Biciklista je uspesno zapamcen");
                        break;
                    case Konstante.UCITAJ_MESTA:
                        sistemskaOperacija = new SOUcitajMesta();
                        obj = sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
                        to.getMapa().put("rezultatPretrage", obj);
                        to.getMapa().put("poruka", "Biciklista je uspesno zapamcen");
                        break;
                    default:
                        throw new AssertionError();
                }

            } catch (Exception e) {
                to.getMapa().put("poruka", e.getMessage());
                to.getMapa().put("izuzetak", e);
            }
            kom.posalji(to);
        }
//        try {
//            while (true) {
//                TransferObjekat to = kom.primi();
//                if (to.getMapa().get("operacija").equals("kreirajNoviSlog")) {
//
//                    OpstiDomenskiObjekat b = (OpstiDomenskiObjekat) to.getMapa().get("domenskiObjekat");
//                    // b.setIme("Vucic");
//
//                    SOKreirajNovogBiciklistu so = new SOKreirajNovogBiciklistu();
//                    so
//                   // OpstaSO.izOpstaSOvrsenjeOpsteSO(to, new SOKreiraj());
////                    to.setSignal("promenjen");
//                    kom.posalji(to);
//
//                } else if (to.getMapa().get("operacija").equals("zapamtiSlog")) {
//
//                    OpstiDomenskiObjekat b = (OpstiDomenskiObjekat) to.getMapa().get("domenskiObjekat");
//                    // b.setIme("Vucic");
//
//                   // OpstaSO.izvrsenjeOpsteSO(to, new SOZapamti());
////                    to.setSignal("promenjen");
//                    kom.posalji(to);
//
//                } else if (to.getMapa().get("operacija").equals("izbrisiSlog")) {
//
//                    OpstiDomenskiObjekat b = (OpstiDomenskiObjekat) to.getMapa().get("domenskiObjekat");
//                    // b.setIme("Vucic");
//
//                   // OpstaSO.izvrsenjeOpsteSO(to, new SOIzbrisiBiciklistu());
////                    to.setSignal("promenjen");
//                    kom.posalji(to);
//
//                } else if (to.getMapa().get("operacija").equals("pronadji")) {
//
//                    OpstiDomenskiObjekat b = (OpstiDomenskiObjekat) to.getMapa().get("domenskiObjekat");
//                    // b.setIme("Vucic");
//
//                   // OpstaSO.izvrsenjeOpsteSO(to, new SOPronadji());
////                    to.setSignal("promenjen");
//                    kom.posalji(to);
//
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
    }

}

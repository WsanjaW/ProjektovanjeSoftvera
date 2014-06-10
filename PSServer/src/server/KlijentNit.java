/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.Socket;
import poslovnalogika.Kontroler;
import server.komunikacija.KomunikacijaServer;
import transfer.TransferObjekat;
import poslovnalogika.so.OpstaSO;
import util.Konstante;

/**
 * Klijentska nit
 *
 * @author Sanja
 */
class KlijentNit extends Thread {

    KomunikacijaServer kom;

    public KlijentNit(Socket klientSocket) {
        try {
            kom = new KomunikacijaServer(klientSocket);

        } catch (IOException ex) {
            ex.printStackTrace();
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
                //uzmi operaciju od klijenta
                int operacija = (int) to.getMapa().get("operacija");
                // uzmi objekat od klijenta
                Object domenskiObjekat = to.getMapa().get("domenskiObjekat");
                //u zavisnosti od operacije pozovi odredjenu metodu kontrolera
                switch (operacija) {

                    case Konstante.KREIRAJ_BICIKLISTU:
                        obj = Kontroler.getInstance().kreirajBiciklistu(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Biciklista je uspesno kreiran");
                        break;
                    case Konstante.KREIRAJ_PUTOVANJE:
                        obj = Kontroler.getInstance().kreirajPutovanje(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Putovanje je uspesno kreirano");
                        break;
                    case Konstante.KREIRAJ_IZVESTAJ:
                        obj = Kontroler.getInstance().kreirajIzvestaj(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Izvestaj je uspesno kreiran");
                        break;

                    case Konstante.KREIRAJ_EVIDENCIJU:
                        obj = Kontroler.getInstance().kreirajEvidenciju(domenskiObjekat);
                        to.getMapa().put("domenskiObjekat", obj);
                        to.getMapa().put("poruka", "Evidencija je uspesno kreirana");
                        break;

                    case Konstante.OBRISI_BICIKLISTU:
                        Kontroler.getInstance().obrisiBiciklistu(domenskiObjekat);
                        to.getMapa().put("poruka", "Biciklista je uspesno izbrisan");
                        break;
                    case Konstante.PRONADJI_BICIKLISTU:
                        obj = Kontroler.getInstance().pronadjiBiciklistu(domenskiObjekat);
                        to.getMapa().put("rezultatPretrage", obj);
                        to.getMapa().put("poruka", "Biciklisti su uspesno pronadjeni");
                        break;
                    case Konstante.PRONADJI_PUTOVANJE:
                        obj = Kontroler.getInstance().pronadjiPutovanja(domenskiObjekat);
                        to.getMapa().put("rezultatPretrage", obj);
                        to.getMapa().put("poruka", "Putovanja su uspesno pronadjena");
                        break;
                    case Konstante.ZAPAMTI_BICIKLISTU:
                        Kontroler.getInstance().zapamtiBiciklistu(domenskiObjekat);

                        to.getMapa().put("poruka", "Biciklista je uspesno zapamcen");
                        break;

                    case Konstante.ZAPAMTI_PUTOVANJE:
                        Kontroler.getInstance().zapamtiPutovanje(domenskiObjekat);

                        to.getMapa().put("poruka", "Putovanje je uspesno zapamceno");
                        break;
                    case Konstante.ZAPAMTI_EVIDENCIJU:
                        Kontroler.getInstance().zapamtiEvidenciju(domenskiObjekat);

                        to.getMapa().put("poruka", "Evidencija je uspesno zapamcena");
                        break;
                    case Konstante.ZAPAMTI_IZVESTAJ:
                        Kontroler.getInstance().zapamtiIzvestaj(domenskiObjekat);

                        to.getMapa().put("poruka", "Izvestaj uspesno zapamcen");
                        break;
                    case Konstante.ULOGUJ_SE:
                        obj = Kontroler.getInstance().ulogujSe(domenskiObjekat);
                        to.getMapa().put("rezultatPretrage", obj);
                        to.getMapa().put("poruka", "Korisnik je ulogovan");
                        break;
                    case Konstante.UCITAJ_MESTA:
                        obj = Kontroler.getInstance().ucitajMesta(domenskiObjekat);
                        to.getMapa().put("rezultatPretrage", obj);
                        to.getMapa().put("poruka", "Mesta su uspesno ucitana");
                        break;

                    default:
                        throw new AssertionError();
                }

            } catch (Exception e) {
                to.getMapa().put("poruka", e.getMessage());
                to.getMapa().put("izuzetak", e);
            }
            //posalji odgovor klijentu
            kom.posalji(to);
        }

    }

}

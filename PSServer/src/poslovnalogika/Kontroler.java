/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import poslovnalogika.so.OpstaSO;
import poslovnalogika.so.SOKreirajNoviIzvestaj;
import poslovnalogika.so.SOKreirajNovoPutovanje;
import poslovnalogika.so.SOKreirajNovogBiciklistu;
import poslovnalogika.so.SOKreirajNovuEvidenciju;
import poslovnalogika.so.SOObrisiBiciklistu;
import poslovnalogika.so.SOPronadjiBiciklistu;
import poslovnalogika.so.SOPronadjiPutovanje;
import poslovnalogika.so.SOUcitajPodatke;
import poslovnalogika.so.SOUlogujSe;
import poslovnalogika.so.SOZapamtiBiciklistu;
import poslovnalogika.so.SOZapamtiEvidenciju;
import poslovnalogika.so.SOZapamtiIzvestaj;
import poslovnalogika.so.SOZapamtiPutovanje;

/**
 * Kontroler poslovne logike.
 * Poziva sistemske operacije
 * @author Sanja
 */
public class Kontroler {

    private static Kontroler instance;
    private OpstaSO sistemskaOperacija;

    private Kontroler() {

    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Object kreirajBiciklistu(Object domenskiObjekat) {
        sistemskaOperacija = new SOKreirajNovogBiciklistu();
        return sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public Object kreirajPutovanje(Object domenskiObjekat) {
        sistemskaOperacija = new SOKreirajNovoPutovanje();
        return sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public Object kreirajIzvestaj(Object domenskiObjekat) {
        sistemskaOperacija = new SOKreirajNoviIzvestaj();
        return sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public Object kreirajEvidenciju(Object domenskiObjekat) {
        sistemskaOperacija = new SOKreirajNovuEvidenciju();
        return sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public void obrisiBiciklistu(Object domenskiObjekat) {
        sistemskaOperacija = new SOObrisiBiciklistu();
        sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public Object pronadjiBiciklistu(Object domenskiObjekat) {
        sistemskaOperacija = new SOPronadjiBiciklistu();
        return sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public Object pronadjiPutovanja(Object domenskiObjekat) {
        sistemskaOperacija = new SOPronadjiPutovanje();
        return sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public void zapamtiBiciklistu(Object domenskiObjekat) {
        sistemskaOperacija = new SOZapamtiBiciklistu();
        sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public void zapamtiPutovanje(Object domenskiObjekat) {
        sistemskaOperacija = new SOZapamtiPutovanje();
        sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public void zapamtiEvidenciju(Object domenskiObjekat) {
        sistemskaOperacija = new SOZapamtiEvidenciju();
        sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public void zapamtiIzvestaj(Object domenskiObjekat) {
        sistemskaOperacija = new SOZapamtiIzvestaj();
        sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public Object ulogujSe(Object domenskiObjekat) {
        sistemskaOperacija = new SOUlogujSe();
        return sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

    public Object ucitajMesta(Object domenskiObjekat) {
        sistemskaOperacija = new SOUcitajPodatke();
        return sistemskaOperacija.izvrsenjeOpsteSO(domenskiObjekat);
    }

}

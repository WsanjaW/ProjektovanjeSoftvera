/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.izvestaj;

import domen.Biciklista;
import domen.Izvestaj;
import domen.OpstiDomenskiObjekat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import sesija.Sesija;
import view.kontroler.OpstiKontroler;
import view.panel.izvestaj.IzvestajPanel;

/**
 *
 * @author Sanja
 */
public class KontrolerIzvestaj extends OpstiKontroler {

    public KontrolerIzvestaj(IzvestajPanel form) {
        super();
        this.form = form;
    }

    @Override
    public void prikaziRezultatSO() {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        IzvestajPanel f = (IzvestajPanel) form;
        Izvestaj izvestaj = (Izvestaj) mapa.get("domenskiObjekat");
        f.setIzvestajidTextField(String.valueOf(izvestaj.getIzvestajID()));
        f.setDatumTextField(df.format(izvestaj.getDatumKreiranja()));
        f.setKordinatorTextField(izvestaj.getKordinator().getIme() + " " + izvestaj.getKordinator().getPrezime());
    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        try {
            Izvestaj iz = new Izvestaj();
            IzvestajPanel f = (IzvestajPanel) form;
            iz.setIzvestajID(Integer.parseInt(f.getIzvestajidTextField().getText()));
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            iz.setDatumKreiranja(df.parse(f.getDatumTextField().getText()));
            iz.setKomentar(f.getKomentarTextArea().getText());
            iz.setBiciklista((Biciklista) f.getBiciklistaComboBox().getSelectedItem());
            iz.setKordinator(Sesija.getInstanc().getKordinator());

            return iz;
        } catch (ParseException ex) {
            throw new RuntimeException("Neispravan datum");
        }
    }

}

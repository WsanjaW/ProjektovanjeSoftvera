/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.putovanja;

import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Putovanje;
import view.kontroler.OpstiKontroler;
import view.panel.putovanja.UnosPutovanjaPanel;

/**
 *
 * @author Sanja
 */
public class KontrolerUnosPutovanja extends OpstiKontroler {

    public KontrolerUnosPutovanja(UnosPutovanjaPanel form) {
        super();
        this.form = form;
    }

    @Override
    public void prikaziRezultatSO() {
        Putovanje putovanje = (Putovanje) mapa.get("domenskiObjekat");
        UnosPutovanjaPanel f = (UnosPutovanjaPanel) form;
        f.setIdTextField(String.valueOf(putovanje.getPutovanjeID()));
        f.setNazivTextField(putovanje.getNaziv());
    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        UnosPutovanjaPanel f = (UnosPutovanjaPanel) form;
        Putovanje putovanje = new Putovanje();
        putovanje.setPutovanjeID(Integer.parseInt(f.getIdTextField().getText()));
        putovanje.setOdMesta((Mesto) f.getMestoOdComboBox().getSelectedItem());
        putovanje.setDoMesta((Mesto) f.getMestoDoComboBox().getSelectedItem());
        putovanje.setNaziv(f.getNazivTextField().getText());
        putovanje.setTrackovi(f.getTtm().getTrekovi());
        return putovanje;
    }
}

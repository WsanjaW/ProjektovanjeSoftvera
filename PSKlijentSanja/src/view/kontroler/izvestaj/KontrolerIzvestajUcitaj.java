/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.izvestaj;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import view.kontroler.OpstiKontroler;
import view.panel.izvestaj.IzvestajPanel;

/**
 *
 * @author Sanja
 */
public class KontrolerIzvestajUcitaj extends OpstiKontroler {

    public KontrolerIzvestajUcitaj(IzvestajPanel form) {
        super();
        this.form = form;
    }
    
    @Override
    public void prikaziRezultatSO() {
        List<Biciklista> mesta = (List<Biciklista>) mapa.get("rezultatPretrage");
        form.getMestoComboBox().get(0).setModel(new DefaultComboBoxModel(mesta.toArray()));
    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        return new Biciklista();
    }
}

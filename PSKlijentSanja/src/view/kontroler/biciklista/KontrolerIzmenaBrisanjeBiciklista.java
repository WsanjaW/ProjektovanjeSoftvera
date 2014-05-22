/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.biciklista;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import view.kontroler.OpstiKontroler;
import view.models.BicikistiTableModel;
import view.panel.biciklista.IzmenaBrisanjeBiciklistaPanel;

/**
 *
 * @author Aleksandar
 */
public class KontrolerIzmenaBrisanjeBiciklista extends OpstiKontroler {

    public KontrolerIzmenaBrisanjeBiciklista(IzmenaBrisanjeBiciklistaPanel form) {
        super();
        this.form = form;
    }

    @Override
    public void prikaziRezultatSO() {
        if ("izbrisiSlog".equals(mapa.get("operacija"))) {
            ((BicikistiTableModel)form.vratiModel()).izbaciBiciklistu((Biciklista) mapa.get("domenskiObjekat"));
        }
        
    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        Biciklista biciklista = new Biciklista();
        biciklista = ((IzmenaBrisanjeBiciklistaPanel) form).vratiIzabranogBiciklistu();
        return biciklista;
    }

}

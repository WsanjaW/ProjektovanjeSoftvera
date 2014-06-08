/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.biciklista;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import util.Konstante;
import view.kontroler.OpstiKontroler;
import view.models.BicikistiTableModel;
import view.panel.biciklista.IzmenaBrisanjeBiciklistaPanel;

/**
 *
 * @author Aleksandar
 */
public class KontrolerIzmenaBrisanjeBiciklista extends OpstiKontroler {

    int operacija = 0;

    public KontrolerIzmenaBrisanjeBiciklista(IzmenaBrisanjeBiciklistaPanel form) {
        super();
        this.form = form;
    }

    @Override
    public void prikaziRezultatSO() {

        if (operacija == Konstante.OBRISI_BICIKLISTU) {
            ((BicikistiTableModel) form.vratiModel()).izbaciBiciklistu((Biciklista) mapa.get("domenskiObjekat"));
        }

    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        Biciklista biciklista = new Biciklista();
        biciklista = ((IzmenaBrisanjeBiciklistaPanel) form).vratiIzabranogBiciklistu();
        return biciklista;
    }

    public String izbrisiBiciklistu() throws RuntimeException {
        operacija = Konstante.OBRISI_BICIKLISTU;
        mapa.clear();
        mapa.put("domenskiObjekat", procitajUnosKorisnika());
        mapa.put("operacija", Konstante.OBRISI_BICIKLISTU);
        signal = pozoviSO();
        if (mapa.containsKey("izuzetak")) {
            throw new RuntimeException((String) mapa.get("poruka"));
        }
        prikaziRezultatSO();
        return signal;
    }

    public String izmeniBiciklistu() throws RuntimeException{
        operacija = Konstante.ZAPAMTI_BICIKLISTU;

        mapa.put("domenskiObjekat", procitajUnosKorisnika());
        mapa.put("operacija", Konstante.ZAPAMTI_BICIKLISTU);
        signal = pozoviSO();
        if (mapa.containsKey("izuzetak")) {
            throw new RuntimeException((String) mapa.get("poruka"));
        }
        prikaziRezultatSO();
        return signal;
    }

}

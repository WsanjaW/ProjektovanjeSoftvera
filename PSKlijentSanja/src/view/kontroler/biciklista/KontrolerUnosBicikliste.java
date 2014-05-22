/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.biciklista;

import domen.Biciklista;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import view.kontroler.OpstiKontroler;
import view.panel.biciklista.KreirajBiciklistuPanel;

/**
 * Kontrolor za formu(panel) za unos bicikliste
 *
 * @author Aleksandar
 */
public class KontrolerUnosBicikliste extends OpstiKontroler {

    public KontrolerUnosBicikliste(KreirajBiciklistuPanel form) {
        super();
        this.form = form;

    }

    @Override
    public void prikaziRezultatSO() {
        Biciklista biciklista = (Biciklista) mapa.get("domenskiObjekat");
        KreirajBiciklistuPanel f = (KreirajBiciklistuPanel) form;
        f.setImeTextField(biciklista.getIme());
        f.setPrezimeTextField(biciklista.getPrezime());
        f.setIdTextField(String.valueOf(biciklista.vratiID()));
        f.setJmbgTextField(biciklista.getJmbg());
        f.setNazivBiciklaTextField(biciklista.getNazivBicikla());
        f.setTipBicikla(biciklista.getTipBicikla());
    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        KreirajBiciklistuPanel f = (KreirajBiciklistuPanel) form;
        Biciklista bicikista = new Biciklista();
        bicikista.setId(Integer.parseInt(f.getIdTextField().getText().trim()));
        bicikista.setIme(f.getImeTextField().getText().trim());
        bicikista.setJmbg(f.getJmbgTextField().getText().trim());
        bicikista.setNazivBicikla(f.getNazivBiciklaTextField().getText().trim());
        bicikista.setPrezime(f.getPrezimeTextField().getText().trim());
        bicikista.setTipBicikla((String) f.getTipBiciklaComboBox().getSelectedItem());
        bicikista.setMesto((Mesto) f.getMestoComboBox().get(0).getSelectedItem());
        return bicikista;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.evidencija;

import domen.Biciklista;
import domen.Evidencija;
import domen.OpstiDomenskiObjekat;
import domen.Putovanje;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import view.kontroler.OpstiKontroler;
import view.panel.evidencija.EvidencijaPanel;

/**
 *
 * @author Sanja
 */
public class KontrolerEvidencija extends OpstiKontroler {

    public KontrolerEvidencija(EvidencijaPanel form) {
        super();
        this.form = form;
    }

    @Override
    public void prikaziRezultatSO() {

    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        try {
            EvidencijaPanel f = (EvidencijaPanel) form;
            Evidencija evi = new Evidencija();
            evi.setBiciklista((Biciklista) f.getBiciklistaComboBox().getSelectedItem());
            evi.setPutovanje((Putovanje) f.getPutovanjeComboBox().getSelectedItem());
            String d = f.getDatumOdTextField().getText();
            SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
            evi.setDatumOd(ft.parse(d));
            evi.setDatumDo(ft.parse(f.getDatumDoTextField().getText()));
            return evi;
        } catch (ParseException ex) {
            throw new RuntimeException("Datum u pograsnom formatu");
        }
    }

}

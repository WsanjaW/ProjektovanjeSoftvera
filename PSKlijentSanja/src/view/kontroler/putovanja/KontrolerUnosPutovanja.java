/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.putovanja;

import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Putovanje;
import domen.Trek;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import util.Konstante;
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
        Putovanje putovanje = (Putovanje) parametriKomunikacije.get("domenskiObjekat");
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
        List<Trek> trackovi = f.getTtm().getTrekovi();
        for (Trek track : trackovi) {
            track.setPutovanje(putovanje);
        }
        putovanje.setTrackovi(f.getTtm().getTrekovi());
        return putovanje;
    }

    public String kreirajNovoPutovanje() throws RuntimeException{
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", kreirajObjekat());
        parametriKomunikacije.put("operacija", Konstante.KREIRAJ_PUTOVANJE);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Sistem ne može da kreira novo putovanje");
        }
        prikaziRezultatSO();
        return signal;
    }

    public void ucitajMesta(JComboBox mestoOdComboBox, JComboBox mestoDoComboBox) {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", new Mesto());
        parametriKomunikacije.put("operacija", Konstante.UCITAJ_MESTA);
        signal = pozoviSO();
        List<OpstiDomenskiObjekat> mesta = (List<OpstiDomenskiObjekat>) parametriKomunikacije.get("rezultatPretrage");
        mestoOdComboBox.setModel(new DefaultComboBoxModel(mesta.toArray()));
        mestoDoComboBox.setModel(new DefaultComboBoxModel(mesta.toArray()));
    }

    private Object kreirajObjekat() {
        Putovanje putovanje = new Putovanje();
        putovanje.setNaziv("unesi...");
        return putovanje;
    }

    /**
     * Popunjava TransferObjekat za izvrsavanje so zapamti putovanje i citanje
     * rezultata so
     *
     * @return
     * @throws RuntimeException
     */
    public String zapamtiPutovanje() throws RuntimeException {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", procitajUnosKorisnika());
        parametriKomunikacije.put("operacija", Konstante.ZAPAMTI_PUTOVANJE);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Sistem ne može da zapamti novo putovanje");
        }
        prikaziRezultatSO();
        return signal;
    }
}

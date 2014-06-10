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
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import util.Konstante;
import view.kontroler.OpstiKontroler;
import view.panel.evidencija.EvidencijaPanel;

/**
 * Kontroler panela EvidencijaPanel
 * @author Sanja
 */
public class KontrolerEvidencija extends OpstiKontroler {

    public KontrolerEvidencija(EvidencijaPanel form) {
        super();
        this.form = form;
    }
    /**
     * Nema prikaza posle izvrsenja so
     */
    @Override
    public void prikaziRezultatSO() {

    }
    /**
     * Kreira objekat Evidencija na osnovu unosa korisnika
     * @return 
     */
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
    /**
     * Popunjava TransferObjekat za izvrsavanje so pronadji bicikliste
     * @param biciklistaComboBox 
     */
    public void ucitajBicikliste(JComboBox biciklistaComboBox) {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", new Biciklista());
        parametriKomunikacije.put("operacija", Konstante.PRONADJI_BICIKLISTU);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException(("Pocetni podaci nisu ucitani"));
        }
        List<OpstiDomenskiObjekat> mesta = (List<OpstiDomenskiObjekat>) parametriKomunikacije.get("rezultatPretrage");
        biciklistaComboBox.setModel(new DefaultComboBoxModel(mesta.toArray()));
    }
    /**
     * Popunjava TransferObjekat za izvrsavanje so pronadji putovanja
     * i citanje rezultata
     * @param putovanjeComboBox 
     */
    public void ucitajPutovanja(JComboBox putovanjeComboBox) {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", new Putovanje());
        parametriKomunikacije.put("operacija", Konstante.PRONADJI_PUTOVANJE);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException(("Pocetni podaci nisu ucitani"));
        }
        List<OpstiDomenskiObjekat> mesta = (List<OpstiDomenskiObjekat>) parametriKomunikacije.get("rezultatPretrage");
        putovanjeComboBox.setModel(new DefaultComboBoxModel(mesta.toArray()));
    }
    /**
     * Popunjava TransferObjekat za izvrsavanje so kreiraj evidenciju
     * i citanje rezultata
     * @return 
     */
    public String kreirajNovuEvidenciju() {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", procitajUnosKorisnika());
        parametriKomunikacije.put("operacija", Konstante.KREIRAJ_EVIDENCIJU);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException(("Evidencija ne moze biti kreirana kreirana"));
        }
        prikaziRezultatSO();
        return signal;
    }
    

}

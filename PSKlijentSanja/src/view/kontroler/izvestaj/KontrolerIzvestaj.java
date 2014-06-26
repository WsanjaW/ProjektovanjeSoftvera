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
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import sesija.Sesija;
import util.Konstante;
import view.kontroler.OpstiKontroler;
import view.panel.izvestaj.IzvestajPanel;

/**
 * Kontroler za IzvestajPanel
 * @author Sanja
 */
public class KontrolerIzvestaj extends OpstiKontroler {

    public KontrolerIzvestaj(IzvestajPanel form) {
        super();
        this.form = form;
    }
    /**
     * Prikaz kreiranog izvestaja
     */
    @Override
    public void prikaziRezultatSO() {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        IzvestajPanel f = (IzvestajPanel) form;
        Izvestaj izvestaj = (Izvestaj) parametriKomunikacije.get("domenskiObjekat");
        f.setIzvestajidTextField(String.valueOf(izvestaj.getIzvestajID()));
        f.setDatumTextField(df.format(izvestaj.getDatumKreiranja()));
        f.setKordinatorTextField(izvestaj.getKordinator().getIme() + " " + izvestaj.getKordinator().getPrezime());
    }
    /**
     * Kreira objekat Izvestaj sa unetim parametrima
     * @return 
     */
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
    /**
     * Popunjava TransferObjekat za izvrsavanje so pronadji bicikliste
     * i upisivanje rezultata u biciklistaComboBox
     * @param biciklistaComboBox 
     */
    public void ucitajBicikliste(JComboBox biciklistaComboBox) {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", new Biciklista());
        parametriKomunikacije.put("operacija", Konstante.PRONADJI_BICIKLISTU);
        signal = pozoviSO();
        List<OpstiDomenskiObjekat> mesta = (List<OpstiDomenskiObjekat>) parametriKomunikacije.get("rezultatPretrage");
        biciklistaComboBox.setModel(new DefaultComboBoxModel(mesta.toArray()));

    }
    /**
     * Popunjava TransferObjekat za izvrsavanje so kreiraj biciklistu
     * i citanje rezultata
     * @return 
     */
    public String kreirajNoviIzvestaj() {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", kreirajObjekat());
        parametriKomunikacije.put("operacija", Konstante.KREIRAJ_IZVESTAJ);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Sistem ne može da kreira novi izveštaj");
        }
        prikaziRezultatSO();
        return signal;
    }
    /**
     * Kreira objekat Izvestaj i postavlja kordinatorra iz sesije
     * @return 
     */
    private Object kreirajObjekat() {
        Izvestaj iz = new Izvestaj();
        iz.setKordinator(sesija.Sesija.getInstanc().getKordinator());
        return iz;
    }
    /**
     * Popunjava TransferObjekat za izvrsavanje so kreiraj biciklistu
     * i citanje rezultata
     * @return 
     */
    public String zapamtiIzvestaj() {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", procitajUnosKorisnika());
        parametriKomunikacije.put("operacija", Konstante.ZAPAMTI_IZVESTAJ);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Sistem ne može da zapamti novi izveštaj");
        }
        prikaziRezultatSO();
        return signal;
    }

}

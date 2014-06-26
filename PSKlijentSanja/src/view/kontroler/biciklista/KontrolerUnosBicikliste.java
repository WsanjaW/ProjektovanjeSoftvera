/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.biciklista;

import domen.Biciklista;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import util.Konstante;
import view.kontroler.OpstiKontroler;
import view.panel.biciklista.KreirajBiciklistuPanel;

/**
 * Kontrolor za panel za unos bicikliste
 *
 * @author Sanja
 */
public class KontrolerUnosBicikliste extends OpstiKontroler {

    public KontrolerUnosBicikliste(KreirajBiciklistuPanel form) {
        super();
        this.form = form;

    }

    /**
     * Prikazuje kreiranog biciklistu na panelu
     */
    @Override
    public void prikaziRezultatSO() {
        Biciklista biciklista = (Biciklista) parametriKomunikacije.get("domenskiObjekat");
        KreirajBiciklistuPanel f = (KreirajBiciklistuPanel) form;
        f.setImeTextField(biciklista.getIme());
        f.setPrezimeTextField(biciklista.getPrezime());
        f.setIdTextField(String.valueOf(biciklista.vratiID()));
        f.setJmbgTextField(biciklista.getJmbg());
        f.setNazivBiciklaTextField(biciklista.getNazivBicikla());
        f.setTipBicikla(biciklista.getTipBicikla());
    }

    /**
     * Cita podatke i kreira objekat biciklista sa tim parametrima
     *
     * @return
     */
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

    /**
     * Popunjava TransferObjekat za izvrsavanje so pronadji mesta Kao
     * domenskiObjekat se salje Mesto bez parametara kako bi se dobila sva mesta
     * iz baze
     *
     * @param mestoComboBox
     */
    public void vratiMesta(JComboBox mestoComboBox) {

        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", new Mesto());
        parametriKomunikacije.put("operacija", Konstante.UCITAJ_MESTA);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Pocetni podaci nisu ucitani");
        }
        //procitaj rezultate pretrage
        List<OpstiDomenskiObjekat> mesta = (List<OpstiDomenskiObjekat>) parametriKomunikacije.get("rezultatPretrage");
        //postavi model
        mestoComboBox.setModel(new DefaultComboBoxModel(mesta.toArray()));

    }

    /**
     * Popunjava TransferObjekat za izvrsavanje so kreiraj biciklistu
     * i citanje rezultata
     * @return
     */
    public String kreirajNovogBiciklistu() {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", kreirajObjekat());
        parametriKomunikacije.put("operacija", Konstante.KREIRAJ_BICIKLISTU);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Sistem ne može da kreira novog biciklistu");
        }
        prikaziRezultatSO();
        return signal;
    }

    /**
     * Popunjava TransferObjekat za izvrsavanje so sacuvaj biciklistu
     * i citanje rezultata
     * @return
     */
    public String sacuvajBiciklistu() throws RuntimeException {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", procitajUnosKorisnika());
        parametriKomunikacije.put("operacija", Konstante.ZAPAMTI_BICIKLISTU);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Sistem ne može da zapamti novog biciklistu");
        }
        prikaziRezultatSO();
        return signal;
    }
    /**
     * Kreira objekat Biciklista sa pocetnim parametrima
     * @return 
     */
    public OpstiDomenskiObjekat kreirajObjekat() {
        Biciklista biciklista = new Biciklista();
        biciklista.setIme("unesi...");
        biciklista.setPrezime("unesi...");
        biciklista.setJmbg("unesi...");
        biciklista.setNazivBicikla("unesi...");
        biciklista.setTipBicikla("MTB");
        biciklista.setMesto(null);
        return biciklista;
    }

}

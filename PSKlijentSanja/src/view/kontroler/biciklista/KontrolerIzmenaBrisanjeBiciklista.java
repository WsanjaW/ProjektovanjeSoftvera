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
 * Kontroler panela IzmenaBrisanjeBiciklista
 *
 * @author Sanja
 */
public class KontrolerIzmenaBrisanjeBiciklista extends OpstiKontroler {

    int operacija = 0;

    public KontrolerIzmenaBrisanjeBiciklista(IzmenaBrisanjeBiciklistaPanel form) {
        super();
        this.form = form;
    }

    /**
     * Brise biciklistu iz modela ako je izvrsena operacija brisanja
     */
    @Override
    public void prikaziRezultatSO() {

        IzmenaBrisanjeBiciklistaPanel f = (IzmenaBrisanjeBiciklistaPanel) form;
        if (operacija == Konstante.OBRISI_BICIKLISTU) {
            ((BicikistiTableModel) f.getBiklistiTableModel()).izbaciBiciklistu((Biciklista) parametriKomunikacije.get("domenskiObjekat"));
        }

    }

    /**
     * Cita izabranog biciklistu iz modela
     *
     * @return
     */
    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        Biciklista biciklista = new Biciklista();
        biciklista = ((IzmenaBrisanjeBiciklistaPanel) form).vratiIzabranogBiciklistu();
        return biciklista;
    }

    /**
     * Popunjava TransferObjekat za izvrsavanje so brisanja bicikliste
     * i citanje rezultata
     *
     * @return
     * @throws RuntimeException
     */
    public String izbrisiBiciklistu() throws RuntimeException {
        operacija = Konstante.OBRISI_BICIKLISTU;
        parametriKomunikacije.clear();
        //popuni mapu
        parametriKomunikacije.put("domenskiObjekat", procitajUnosKorisnika());
        parametriKomunikacije.put("operacija", Konstante.OBRISI_BICIKLISTU);
        //pozovi so
        signal = pozoviSO();
        //ako se desio izuzetak(nije uspesno izvrsena so) 
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Sistem ne može da obriše biciklistu");
        }
        prikaziRezultatSO();
        return signal;
    }

    /**
     * Popunjava TransferObjekat za izvrsavanje so izmenu bicikliste
     * i citanje rezultata
     * @return
     * @throws RuntimeException
     */
    public String izmeniBiciklistu() throws RuntimeException {
        operacija = Konstante.ZAPAMTI_BICIKLISTU;
        parametriKomunikacije.clear();
        //popuni mapu
        parametriKomunikacije.put("domenskiObjekat", procitajUnosKorisnika());
        parametriKomunikacije.put("operacija", Konstante.ZAPAMTI_BICIKLISTU);
        //pozovi so
        signal = pozoviSO();
        //ako se desio izuzetak(nije uspesno izvrsena so) 
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Sistem ne može da zapamti biciklistu");
        }
        prikaziRezultatSO();
        return signal;
    }

}

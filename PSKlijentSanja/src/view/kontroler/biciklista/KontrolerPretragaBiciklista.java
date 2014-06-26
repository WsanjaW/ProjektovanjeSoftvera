/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.biciklista;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import javax.swing.JPanel;
import util.Konstante;
import view.kontroler.OpstiKontroler;
import view.models.BicikistiTableModel;
import view.panel.biciklista.PretragaBiciklistaPanel;

/**
 *
 * Kontroler panela IzmenaBrisanjeBiciklista
 *
 * @author Sanja
 */
public class KontrolerPretragaBiciklista extends OpstiKontroler {

    public KontrolerPretragaBiciklista(JPanel form) {
        super();
        this.form = form;
    }
    
    /**
     * Upisuje listu pronadjenih biciklista u model
     */
    @Override
    public void prikaziRezultatSO() {
        PretragaBiciklistaPanel f = (PretragaBiciklistaPanel)form;
        List<Biciklista> biciklisti = (List<Biciklista>) parametriKomunikacije.get("rezultatPretrage");
        ((BicikistiTableModel) f.getBtm()).setBiciklisti(biciklisti);
    }

    /**
     * Cita kriterijume pretrage i kreira Biciklistu sa tim parametrima
     * @return biciklista sa unetim parametrima
     */
    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        Biciklista biciklista = new Biciklista();
        PretragaBiciklistaPanel f = (PretragaBiciklistaPanel) form;
        if (f.getPretraziIDTextField().getText().isEmpty()) {
            biciklista.setId(0);
        } else {
            biciklista.setId(Integer.parseInt(f.getPretraziIDTextField().getText().trim()));
        }
        biciklista.setIme(f.getPretrazImeTextField().getText().trim());
        biciklista.setJmbg(f.getPretraziJmbgTextField().getText().trim());
        biciklista.setPrezime(f.getPretraziPrezimeTextField().getText().trim());
        return biciklista;
    }
    /**
     * Popunjava TransferObjekat za izvrsavanje so pronadji bicikliste
     * i citanje rezultata
     * @return
     * @throws RuntimeException 
     */
    public String pronadjiBicikliste() throws RuntimeException{
        parametriKomunikacije.clear();
        //popuni mapu
        parametriKomunikacije.put("domenskiObjekat", procitajUnosKorisnika());
        parametriKomunikacije.put("operacija", Konstante.PRONADJI_BICIKLISTU);
        //pozovi so
        signal = pozoviSO();
        //ako se desio izuzetak(nije uspesno izvrsena so) 
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Sistem ne može da nađe bicikliste po zadatim vrednostima");
        }
        prikaziRezultatSO();
        return signal;
    }

}

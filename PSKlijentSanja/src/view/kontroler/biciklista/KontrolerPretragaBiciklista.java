/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.biciklista;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import view.kontroler.OpstiKontroler;
import view.models.BicikistiTableModel;
import view.panel.PanelAkcije;
import view.panel.biciklista.PretragaBiciklistaPanel;

/**
 *
 * @author Aleksandar
 */
public class KontrolerPretragaBiciklista extends OpstiKontroler {

    public KontrolerPretragaBiciklista(PanelAkcije form) {
        super();
        this.form = form;
    }

    @Override
    public void prikaziRezultatSO() {
        List<Biciklista> biciklisti = (List<Biciklista>) mapa.get("rezultatPretrage");
        ((BicikistiTableModel) form.vratiModel()).setBiciklisti(biciklisti);
    }

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

}

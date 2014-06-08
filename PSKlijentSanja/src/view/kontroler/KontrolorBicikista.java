/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.kontroler;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import view.panel.PanelAkcije;

/**
 *
 * @author Sanja
 */
public class KontrolorBicikista extends OpstiKontroler{

    public KontrolorBicikista(PanelAkcije form) {
        this.form = form;
    }

    
    
    @Override
    public void prikaziRezultatSO() {
        List<Biciklista> biciklisti = (List<Biciklista>) mapa.get("rezultatPretrage");
        for (JComboBox combo : form.getMestoComboBox()) {
            combo.setModel(new DefaultComboBoxModel(biciklisti.toArray()));
        }
    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        return new Biciklista();
    }

   
    
}

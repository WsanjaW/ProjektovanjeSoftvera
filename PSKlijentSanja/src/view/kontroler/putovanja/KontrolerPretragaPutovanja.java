/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.putovanja;

import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Putovanje;
import java.util.List;
import view.kontroler.OpstiKontroler;
import view.models.PutovanjeTableModel;
import view.panel.putovanja.PretragaPutovanjaPanel;

/**
 *
 * @author Sanja
 */
public class KontrolerPretragaPutovanja extends OpstiKontroler {

    public KontrolerPretragaPutovanja(PretragaPutovanjaPanel form) {
        super();
        this.form = form;
    }

    
    @Override
    public void prikaziRezultatSO() {
        List<Putovanje> putovanja = (List<Putovanje>) mapa.get("rezultatPretrage");

        ((PutovanjeTableModel)form.vratiModel()).setPutovanja(putovanja);
    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        Putovanje putovanje = new Putovanje();
        PretragaPutovanjaPanel f = (PretragaPutovanjaPanel)form;
        if (f.getPretraziIDTextField().getText().isEmpty()) {
            putovanje.setPutovanjeID(0);
        } else {
            putovanje.setPutovanjeID(Integer.parseInt(f.getPretraziIDTextField().getText().trim()));
        }
        putovanje.setNaziv(f.getPretraziNazivTextField().getText());
        putovanje.setOdMesta(new Mesto(0, "0", f.getPretraziOdTextField().getText().trim()));
        putovanje.setDoMesta(new Mesto(0, "0", f.getPretraziDoTextField().getText().trim()));
        
        return putovanje;
    }

   
    
}

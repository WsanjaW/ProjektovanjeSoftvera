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
import util.Konstante;
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
    /**
     * Prikaz nadjenih putovanja
     */
    @Override
    public void prikaziRezultatSO() {
        PretragaPutovanjaPanel f = (PretragaPutovanjaPanel) form;
        List<Putovanje> putovanja = (List<Putovanje>) parametriKomunikacije.get("rezultatPretrage");
        //postavi putovanja u model
        ((PutovanjeTableModel) f.getPtm()).setPutovanja(putovanja);
    }

    /**
     * Kreira objekat Putovanje sa ucitanim parametrima
     * @return 
     */
    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        Putovanje putovanje = new Putovanje();
        PretragaPutovanjaPanel f = (PretragaPutovanjaPanel) form;
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
    /**
     * Popunjava TransferObjekat za izvrsavanje so pronadji putovanja
     * i citanje rezultata so
     * @return
     * @throws RuntimeException 
     */
    public String pronadjiPutovanja() throws RuntimeException {
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", procitajUnosKorisnika());
        parametriKomunikacije.put("operacija", Konstante.PRONADJI_PUTOVANJE);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("PSistem ne može da nađe putovanja po zadatim vrednostima");
        }
        prikaziRezultatSO();
        return signal;
    }

}

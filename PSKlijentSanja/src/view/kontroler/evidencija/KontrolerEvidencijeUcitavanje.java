/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.evidencija;

import domen.Biciklista;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Putovanje;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import transfer.TransferObjekat;
import view.kontroler.OpstiKontroler;
import view.kontroler.biciklista.KontrolerUnosBicikliste;
import view.panel.evidencija.EvidencijaPanel;

/**
 *
 * @author Sanja
 */
public class KontrolerEvidencijeUcitavanje extends OpstiKontroler {

    public KontrolerEvidencijeUcitavanje(EvidencijaPanel form) {
        super();
        this.form = form;
    }

    @Override
    public void prikaziRezultatSO() {
       List<OpstiDomenskiObjekat> mesta = (List<OpstiDomenskiObjekat>) mapa.get("rezultatPretrage");
        for (JComboBox combo : form.getMestoComboBox()) {
            combo.setModel(new DefaultComboBoxModel(mesta.toArray()));
        }
    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        return form.vratiDomenskiObjekat();
    }

  

//    EvidencijaPanel form;
//    String signal;
//
//    public KontrolerEvidencijeUcitavanje(EvidencijaPanel form) {
//        this.form = form;
//    }
//
//    public String vratiBicikliste() {
//        try {
//
//            String operacija = "pronadjiBicikliste";
//            signal = pozoviSO(operacija);
//            JOptionPane.showMessageDialog(form, signal);
//
//        } catch (IOException ex) {
//            Logger.getLogger(KontrolerUnosBicikliste.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(KontrolerUnosBicikliste.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return signal;
//    }
//
//    public String vratiPutovanja() {
//        try {
//
//            String operacija = "pronadjiMesta";
//            signal = pozoviSO(operacija);
//            JOptionPane.showMessageDialog(form, signal);
//
//        } catch (IOException ex) {
//            Logger.getLogger(KontrolerUnosBicikliste.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(KontrolerUnosBicikliste.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return signal;
//    }
//
//    private String pozoviSO(String operacija) throws IOException, ClassNotFoundException {
//        Map<String, Object> mapa = new Hashtable<String, Object>();
//        if ("pronadjiBicikliste".equals(operacija)) {
//            mapa.put("domenskiObjekat", new Biciklista());
//        } else {
//            mapa.put("domenskiObjekat", new Putovanje());
//        }
//        mapa.put("operacija", "pronadji");
//
//        TransferObjekat transfer = new TransferObjekat(mapa);
//        Komunikacija.getInstance().posalji(transfer);
//        TransferObjekat primljeniObjekat = Komunikacija.getInstance().primi();
//
//        if ("pronadjiBicikliste".equals(operacija)) {
//            List<Biciklista> mesta = (List<Biciklista>) primljeniObjekat.getMapa().get("rezultatPretrage");
//            form.getBiciklistaComboBox().setModel(new DefaultComboBoxModel(mesta.toArray()));
//        } else {
//            List<Putovanje> mesta = (List<Putovanje>) primljeniObjekat.getMapa().get("rezultatPretrage");
//            form.getPutovanjeComboBox().setModel(new DefaultComboBoxModel(mesta.toArray()));
//        }
//
//        return (String) primljeniObjekat.getMapa().get("poruka");
//    }
}

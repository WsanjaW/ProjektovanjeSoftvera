/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.kontroler.login;

import domen.Kordinator;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import sesija.Sesija;
import util.Konstante;
import view.LogInForm;
import view.kontroler.OpstiKontroler;

/**
 * Kontroler za LOgIn formu
 * @author Sanja
 */
public class KontrolerLogIn extends OpstiKontroler {

    LogInForm f;
    public KontrolerLogIn(LogInForm form) {
        super();
        this.f = form;
    }
    /**
     * Ukoliko je korisnik uspesno ulogovan cuva se u sesili
     */
    @Override
    public void prikaziRezultatSO() {
        List<Kordinator> kordinatori = (List<Kordinator>) parametriKomunikacije.get("rezultatPretrage");
        Kordinator kordinator = new Kordinator();
        if (kordinatori != null) {
            kordinator = kordinatori.get(0);
            Sesija.getInstanc().setKordinator(kordinator);
        } else {
            kordinator = null;
        }
        
    }
    /**
     * Kreira kordinatora sa unetim parametrima
     * @return 
     */
    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        Kordinator kordinator = new Kordinator();
       
        kordinator.setUsername(f.getUsernameTextField().getText());
        kordinator.setPassword(f.getjPasswordField1().getText());
        return kordinator;
    }
    
    /**
     * 
     * @return
     * @throws RuntimeException 
     */
    public String ulogujKordinatora() throws RuntimeException{
        parametriKomunikacije.clear();
        parametriKomunikacije.put("domenskiObjekat", procitajUnosKorisnika());
        parametriKomunikacije.put("operacija", Konstante.ULOGUJ_SE);
        signal = pozoviSO();
        if (parametriKomunikacije.containsKey("izuzetak")) {
            throw new RuntimeException("Sistem ne može da nađe kordinatora na osnovu unetih vrednosti");
        }
        prikaziRezultatSO();
        return signal;
    }

}

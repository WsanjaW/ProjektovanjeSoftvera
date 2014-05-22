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
import view.LogInForm;
import view.kontroler.OpstiKontroler;

/**
 *
 * @author Sanja
 */
public class KontrolerLogIn extends OpstiKontroler{

    public KontrolerLogIn(LogInForm form) {
        super();
        this.form = form;
    }

    @Override
    public void prikaziRezultatSO() {
        List<Kordinator> kordinatori = (List<Kordinator>) mapa.get("rezultatPretrage");
        Kordinator kordinator = new Kordinator();
        if (kordinatori != null) {
            kordinator = kordinatori.get(0);
            Sesija.getInstanc().setKordinator(kordinator);
        }else{
            kordinator = null;
        }
        domenskiObjekat = kordinator;
    }

    @Override
    public OpstiDomenskiObjekat procitajUnosKorisnika() {
        Kordinator kordinator = new Kordinator();
        LogInForm f = (LogInForm) form;
        kordinator.setUsername(f.getUsernameTextField().getText());
        kordinator.setPassword(f.getjPasswordField1().getText());
        return kordinator;
    }

}

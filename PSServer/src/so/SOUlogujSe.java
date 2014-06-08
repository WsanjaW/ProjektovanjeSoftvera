/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Kordinator;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import static so.OpstaSO.dbb;

/**
 *
 * @author Sanja
 */
public class SOUlogujSe extends OpstaSO {

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        List<OpstiDomenskiObjekat> rezultatPretrage = dbb.pronadji((Kordinator) obj);
        return rezultatPretrage;
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {

    }

}

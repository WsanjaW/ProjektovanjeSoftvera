/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika.so;

import domen.Evidencija;
import domen.Izvestaj;
import static poslovnalogika.so.OpstaSO.dbb;

/**
 *
 * @author Sanja
 */
public class SOZapamtiIzvestaj extends OpstaSO {

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        dbb.zapamti((Izvestaj) obj);
        return obj;
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {

    }

}

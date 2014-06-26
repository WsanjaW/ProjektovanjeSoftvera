/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika.so;

import domen.OpstiDomenskiObjekat;
import domen.Putovanje;
import static poslovnalogika.so.OpstaSO.dbb;

/**
 *
 * @author Sanja
 */
public class SOKreirajNovoPutovanje extends OpstaSO {

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        Putovanje put = (Putovanje) obj;
        dbb.ubaci(put);
        int id = dbb.vratiID(put);
        put.postaviID(id);
        return put;
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {

    }

}

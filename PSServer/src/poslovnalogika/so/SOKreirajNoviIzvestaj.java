/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poslovnalogika.so;

import domen.Izvestaj;


/**
 *
 * @author Sanja
 */
public class SOKreirajNoviIzvestaj extends OpstaSO{

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        Izvestaj izv = (Izvestaj) obj;
        dbb.ubaci(izv);
        int id = dbb.vratiID(izv);
        izv.postaviID(id);
        return izv;
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {

    }

}

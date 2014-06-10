/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poslovnalogika.so;

import domen.Izvestaj;
import domen.Putovanje;


/**
 *
 * @author Sanja
 */
public class SOKreirajNoviIzvestaj extends OpstaSO{

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        return dbb.ubaciSlog((Izvestaj) obj);
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {

    }

}

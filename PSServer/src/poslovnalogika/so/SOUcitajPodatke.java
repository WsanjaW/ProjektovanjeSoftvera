/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poslovnalogika.so;

import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Putovanje;
import java.util.ArrayList;
import java.util.List;
import static poslovnalogika.so.OpstaSO.dbb;

/**
 *
 * @author Sanja
 */
public class SOUcitajPodatke extends OpstaSO{

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
       List<OpstiDomenskiObjekat> rezultatPretrage = dbb.pronadji((Mesto) obj);
       return rezultatPretrage;
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {
        
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poslovnalogika.so;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Sanja
 */
public class SOKreirajNovogBiciklistu extends OpstaSO{

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        Biciklista bic = (Biciklista) obj;
        dbb.ubaci(bic);
        int id = dbb.vratiID(bic);
        bic.postaviID(id);
        return bic;
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {
        
    }
    
}

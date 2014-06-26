/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poslovnalogika.so;

import domen.Evidencija;
import domen.OpstiDomenskiObjekat;
import static poslovnalogika.so.OpstaSO.dbb;

/**
 *
 * @author Sanja
 */
public class SOKreirajNovuEvidenciju extends OpstaSO{

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        Evidencija evi = (Evidencija) obj;
        dbb.ubaci(evi);
        int id = dbb.vratiID(evi);
        evi.postaviID(id);
        return evi;
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poslovnalogika.so;

import domen.Evidencija;
import static poslovnalogika.so.OpstaSO.dbb;

/**
 *
 * @author Sanja
 */
public class SOZapamtiEvidenciju extends OpstaSO{

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        dbb.zapamti((Evidencija) obj);
        return obj;
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {
        Evidencija evi = (Evidencija) obj;
        if (evi.getBiciklista() != null || evi.getPutovanje() != null 
                || evi.getDatumOd() != null || evi.getDatumDo() != null
                || evi.getDatumDo().before(evi.getDatumOd())) {
            throw new RuntimeException("Nije zadovoljen preduslov");
        }
    }
    
}
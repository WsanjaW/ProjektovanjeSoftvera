/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so;

import domen.Biciklista;
import domen.Putovanje;
import static so.OpstaSO.dbb;

/**
 *
 * @author Sanja
 */
public class SOZapamtiPutovanje extends OpstaSO{

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        return dbb.zapamtiSlog((Biciklista) obj);
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {
        Putovanje p = (Putovanje)obj;
        if (p.getPutovanjeID() <= 0 || p.getNaziv() == null || p.getNaziv().isEmpty()) {
            throw new RuntimeException("Nije zadovoljen preduslov");
        }
    }
    
}

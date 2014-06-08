/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author Sanja
 */
public class SOPronadjiBiciklistu extends OpstaSO{

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
       List<OpstiDomenskiObjekat> rezultatPretrage = dbb.pronadji((Biciklista) obj);
        if (rezultatPretrage.isEmpty()) {
            throw new RuntimeException("Biciklista nije pronadjen");
        }
       return rezultatPretrage;
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {
        
    }
    
}

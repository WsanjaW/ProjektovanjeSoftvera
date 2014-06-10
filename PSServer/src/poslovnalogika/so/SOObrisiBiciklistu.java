/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poslovnalogika.so;

import domen.Biciklista;
import static poslovnalogika.so.OpstaSO.dbb;

/**
 *
 * @author Sanja
 */
public class SOObrisiBiciklistu extends OpstaSO{

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        return dbb.izbrisiSlog((Biciklista) obj);
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {
        
    }
    
}

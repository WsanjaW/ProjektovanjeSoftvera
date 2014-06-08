/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package so;

import domen.Biciklista;
import domen.Evidencija;
import static so.OpstaSO.dbb;

/**
 *
 * @author Sanja
 */
public class SOKreirajNovuEvidenciju extends OpstaSO{

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        return dbb.ubaciSlog((Evidencija) obj);
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {
        
    }
    
}

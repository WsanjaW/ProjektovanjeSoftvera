/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Putovanje;
import static so.OpstaSO.dbb;

/**
 *
 * @author Sanja
 */
public class SOKreirajNovoPutovanje extends OpstaSO {

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {
        return dbb.ubaciSlog((Putovanje) obj);
    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {

    }

}

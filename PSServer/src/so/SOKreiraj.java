/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import java.util.Map;

/**
 *
 * @author Aleksandar
 */
public class SOKreiraj extends OpstaSO {

    @Override
    Map<String, Object> izvrsiSO(OpstiDomenskiObjekat domenskiObjekat) {
        Map<String, Object> mapa = dbb.ubaciSlog(domenskiObjekat);
        this.uspesno = true;
        return mapa;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika.so;

import domen.Biciklista;

/**
 *
 * @author Sanja
 */
public class SOZapamtiBiciklistu extends OpstaSO {

    @Override
    public Object izvrsiSO(Object obj) throws RuntimeException {

        dbb.zapamti((Biciklista) obj);
        return obj;

    }

    @Override
    public void proveriPreduslove(Object obj) throws RuntimeException {
        Biciklista b = (Biciklista) obj;
        if (b.getId() <= 0 || b.getIme() == null || b.getIme().isEmpty()
                || b.getPrezime() == null || b.getPrezime().isEmpty()
                || b.getJmbg() == null || b.getJmbg().isEmpty() || b.getMesto() == null) {
            throw new RuntimeException("Nisu ispunjeni preduslovi");
        }
    }

}

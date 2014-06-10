/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika.so;

import db.BrokerBaze;

/**
 * Opsta sistemska operacija
 * Poziva izvrsenje so
 * @author Sanja
 */
public abstract class OpstaSO {

    protected static BrokerBaze dbb;

    public OpstaSO() {
        dbb = new BrokerBaze();
    }

    public Object izvrsenjeOpsteSO(Object obj) throws RuntimeException {
        try {
            dbb.otvoriKonekciju();
            proveriPreduslove(obj);
            obj = izvrsiSO(obj);
            dbb.commitTransakcije();
            return obj;

        } catch (RuntimeException ex) {
            dbb.rollbackTransakcije();
            throw ex;
        } finally {

            dbb.zatvoriKonekciju();

        }
    }

    abstract public Object izvrsiSO(Object obj) throws RuntimeException;

    abstract public void proveriPreduslove(Object obj) throws RuntimeException;

}

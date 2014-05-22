/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.BrokerBaze;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.TransferObjekat;

/**
 *
 * @author Aleksandar
 */
public abstract class OpstaSO {

    protected static BrokerBaze dbb;
    protected static boolean uspesno;

    static {
        dbb = new BrokerBaze();
        uspesno = false;
    }

    public static void izvrsenjeOpsteSO(TransferObjekat transferObjekat, OpstaSO sistemskaOperacija) {
        Map<String, Object> mapa = transferObjekat.getMapa();
        try {
            dbb.otvoriKonekciju();
            mapa = sistemskaOperacija.izvrsiSO((OpstiDomenskiObjekat) transferObjekat.getMapa().get("domenskiObjekat"));
            transferObjekat.setMapa(mapa);
            if (!mapa.containsKey("Greska")) {
                dbb.commit();
            } else {
                dbb.rollback();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                dbb.rollback();
            } catch (SQLException ex1) {
                System.out.println(ex.getMessage());
                mapa.put("poruka", ex);
            }
        } finally {
            try {
                dbb.zatvoriKonekciju();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                mapa.put("poruka", ex);
            }
        }

    }

    abstract Map<String, Object> izvrsiSO(OpstiDomenskiObjekat domenskiObjekat);

}

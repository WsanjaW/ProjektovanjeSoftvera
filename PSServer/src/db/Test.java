/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import domen.Biciklista;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandar
 */
public class Test {
    public static void main(String[] args) {
        BrokerBaze bb = new BrokerBaze();
        try {
            bb.otvoriKonekciju();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        Biciklista b = new Biciklista();
        b.setIme("sanja");
        b.setJmbg("123");
        b.setNazivBicikla("sanja");
        b.setPrezime("sanja");
        bb.ubaciSlog(b);
        try {
            //        bb.iscitaj();
            bb.zatvoriKonekciju();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sesija;

import domen.Kordinator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sanja
 */
public class Sesija {
    private static Sesija instance;
    private Kordinator kordinator;
    private Map<String,Object> aktivneOperacije;
    private Sesija() {
        kordinator = new Kordinator();
        aktivneOperacije = new HashMap<>();
    }
    
    public static Sesija getInstanc() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }

    public Kordinator getKordinator() {
        return kordinator;
    }

    public void setKordinator(Kordinator kordinator) {
        this.kordinator = kordinator;
    }

    public Map<String, Object> getAktivneOperacije() {
        return aktivneOperacije;
    }

    
    
    
    
}

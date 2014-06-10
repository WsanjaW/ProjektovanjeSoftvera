/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transfer;

import java.io.Serializable;
import java.util.Map;

/**
 * Objekat koji se koristi za komunikaciju klijenta i servera
 * 
 * @author Sanja
 */
public class TransferObjekat implements Serializable{
       
    private Map<String,Object> parametriKomunikacije;
    
    
    public TransferObjekat(Map<String, Object> mapa) {
        this.parametriKomunikacije = mapa;
    }

    public Map<String, Object> getMapa() {
        return parametriKomunikacije;
    }

    public void setMapa(Map<String, Object> mapa) {
        this.parametriKomunikacije = mapa;
    }

    
}

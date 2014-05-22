/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transfer;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Aleksandar
 */
public class TransferObjekat implements Serializable{
    private static final long serialVersionUID = 111L;
    
    private Map<String,Object> mapa;
    
    
    public TransferObjekat(Map<String, Object> mapa) {
        this.mapa = mapa;
    }

    public Map<String, Object> getMapa() {
        return mapa;
    }

    public void setMapa(Map<String, Object> mapa) {
        this.mapa = mapa;
    }

    
}

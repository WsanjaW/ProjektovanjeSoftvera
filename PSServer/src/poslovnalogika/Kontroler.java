/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poslovnalogika;

/**
 *
 * @author Sanja
 */
public class Kontroler {
    private Kontroler instance;

    public Kontroler() {
        
    }
    
    public Kontroler getObject(){
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }
    
    
    
    
}

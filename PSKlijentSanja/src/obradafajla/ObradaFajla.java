/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package obradafajla;

import java.io.File;
import java.util.Date;

/**
 * Obrada .gpx fajla
 * TODO implement
 * @author Sanja
 */
public class ObradaFajla {
    
    private File fajl;
    private Double kilometraza;
    private Double prosecnaBrzina;
    private Date vreme;

    public ObradaFajla(File fajl) {
        this.fajl = fajl;
    }

    public Double getKilometraza() {
        return kilometraza;
    }

    public Double getProsecnaBrzina() {
        return prosecnaBrzina;
    }

    public Date getVreme() {
        return vreme;
    }
    
    public void obradi(){
        
    }
}

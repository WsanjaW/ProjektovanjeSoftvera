/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.panel;

import domen.OpstiDomenskiObjekat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sanja
 */
public interface PanelAkcije {
    public abstract AbstractTableModel vratiModel();
    //public abstract OpstiDomenskiObjekat kreirajObjekat();

    public abstract List<JComboBox> getMestoComboBox();

    public OpstiDomenskiObjekat vratiDomenskiObjekat();
    
}

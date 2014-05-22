/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.models;

import domen.Evidencija;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sanja
 */
public class EvidencijaTableModel extends AbstractTableModel{

    private List<Evidencija> evidencije;

    public EvidencijaTableModel() {
        evidencije = new ArrayList<>();
    }

    public List<Evidencija> getEvidencije() {
        return evidencije;
    }

    public void setEvidencije(List<Evidencija> evidencije) {
        this.evidencije = evidencije;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
       return evidencije.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Evidencija evi = evidencije.get(row);
        if (col == 0) {
            return evi.getPutovanje().getPutovanjeID();
        }
        if (col == 1) {
            return evi.getPutovanje().getNaziv();
        }
        if (col == 2) {
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            return df.format(evi.getDatumOd());
        }
        if (col == 3) {
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            return df.format(evi.getDatumDo());
        }
        return "greska";
    }

    @Override
    public String getColumnName(int col) {
        
        if (col == 0) {
            return "ID";
        }
        if (col == 1) {
            return "Naziv";
        }
        if (col == 2) {
            return "Od";
        }
        if (col == 3) {
            return "Do";
        }
        return "greska";
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.models;

import domen.Putovanje;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sanja
 */
public class PutovanjeTableModel extends AbstractTableModel {

    List<Putovanje> putovanja;

    public PutovanjeTableModel() {
        putovanja = new ArrayList<>();
    }

    public List<Putovanje> getPutovanja() {
        return putovanja;
    }

    public void setPutovanja(List<Putovanje> putovanja) {
        this.putovanja = putovanja;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (putovanja != null) {
            return putovanja.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Putovanje p = putovanja.get(row);
        switch (col) {
            case 0:
                return p.getPutovanjeID();
            case 1:
                return p.getNaziv();
            case 2:
                return p.getOdMesta().getNaziv();
            case 3:
                return p.getDoMesta().getNaziv();
            default:
                return "greska";
        }
    }

    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "ID";
            case 1:
                return "Naziv";
            case 2:
                return "Od";
            case 3:
                return "Do";
            default:
                return "greska";
        }
    }

    public Putovanje getPutovanje(int i) {
        return putovanja.get(i);

    }

}

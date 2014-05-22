/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.models;

import domen.Biciklista;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aleksandar
 */
public class BicikistiTableModel extends AbstractTableModel {

    List<Biciklista> biciklisti;

    public BicikistiTableModel() {
        biciklisti = new ArrayList<>();
    }

    public BicikistiTableModel(List<Biciklista> biciklisti) {
        if (biciklisti == null) {
            this.biciklisti = new ArrayList<>();
        }
        this.biciklisti = biciklisti;
    }

    public List<Biciklista> getBiciklisti() {
        return biciklisti;
    }

    public void setBiciklisti(List<Biciklista> biciklisti) {
        if (biciklisti == null) {
            this.biciklisti = new ArrayList<>();
        }
        this.biciklisti = biciklisti;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (biciklisti == null) {
            return 0;
        }
        return biciklisti.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Biciklista b = biciklisti.get(rowIndex);
        if (columnIndex == 0) {
            return b.getId();
        }
        if (columnIndex == 1) {
            return b.getIme();
        }
        if (columnIndex == 2) {
            return b.getPrezime();
        }
        if (columnIndex == 3) {
            return b.getJmbg();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        }
        if (column == 1) {
            return "Ime";
        }
        if (column == 2) {
            return "Prezime";
        }
        if (column == 3) {
            return "JMBG";
        }
        return null;
    }

    public Biciklista getBiciklista(int row) {
        return biciklisti.get(row);
    }

    public void izbaciBiciklistu(Biciklista b) {
        for (Biciklista biciklista : biciklisti) {
            if (biciklista.getId() == b.getId()) {
                biciklisti.remove(biciklista);
                break;
            }
        }
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (col != 0) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object o, int row, int col) {
        Biciklista bic = biciklisti.get(row);
        switch (col) {
            case 1:
                bic.setIme((String) o);
                break;
            case 2:
                bic.setPrezime((String) o);
            case 3:
                bic.setJmbg((String) o);
            default:
                break;
        }
    }

}

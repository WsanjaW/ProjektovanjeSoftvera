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
public class EvidencijaTableModel extends AbstractTableModel {

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
        return 6;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Evidencija evi = evidencije.get(row);

        if (col == 0) {
            return evi.getPutovanje().getNaziv();
        }
        if (col == 1) {
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            return df.format(evi.getDatumOd());
        }
        if (col == 2) {
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            return df.format(evi.getDatumDo());
        }
        if (col == 3) {
            return String.format("%.2f km", evi.getPutovanje().getUkupnaKilometraza());
        }
        if (col == 4) {
            return prikaziVreme(evi.getPutovanje().getUkupnoVreme());
        }
        if (col == 5) {
            return String.format("%.2f km/h", evi.getPutovanje().getProsecnaBrzina() * 1000);
        }
        return "greska";
    }

    @Override
    public String getColumnName(int col) {

        if (col == 0) {
            return "Naziv";
        }
        if (col == 1) {
            return "Od";
        }
        if (col == 2) {
            return "Do";
        }
        if (col == 3) {
            return "Kilometraza";
        }
        if (col == 4) {
            return "Vreme";
        }
        if (col == 5) {
            return "Pros. brzina";
        }
        return "greska";
    }

    private String prikaziVreme(Long vreme) {

        long diffSeconds = vreme / 1000 % 60;
        long diffMinutes = vreme / (60 * 1000) % 60;
        long diffHours = vreme / (60 * 60 * 1000);
        return String.format("%02d:%02d:%02d", diffHours, diffMinutes, diffSeconds);

    }

}

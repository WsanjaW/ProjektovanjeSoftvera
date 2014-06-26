/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.models;

import domen.Trek;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sanja
 */
public class TrackTableModel extends AbstractTableModel {

    List<Trek> trekovi;

    public TrackTableModel() {
        trekovi = new ArrayList<>();
    }

    public TrackTableModel(List<Trek> trekovi) {
        this.trekovi = trekovi;
    }

    public List<Trek> getTrekovi() {
        return trekovi;
    }

    public void setTrekovi(List<Trek> trekovi) {
        this.trekovi = trekovi;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return trekovi.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Trek t = trekovi.get(row);
        switch (col) {
            case 0:
                return t.getTrackId();
            case 1:
                return t.getNaziv();
            case 2:
                return String.format("%.2f km",t.getKilometraza());

            case 3:

                return prikaziVreme(t.getVreme());
            case 4:
                return String.format("%.2f km/h",t.getProsecnaBrzina()*1000);
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
                return "Kilometraza";
            case 3:
                return "Vreme";
            case 4:
                return "Prosecna brzina";
            default:
                return "greska";
        }
    }

    public void addTrack(Trek t) {
        trekovi.add(t);
        fireTableDataChanged();
    }

    private String prikaziVreme(Long vreme) {

        long diffSeconds = vreme / 1000 % 60;
        long diffMinutes = vreme / (60 * 1000) % 60;
        long diffHours = vreme / (60 * 60 * 1000);
        return String.format("%02d:%02d:%02d",diffHours,diffMinutes,diffSeconds);

    }

}

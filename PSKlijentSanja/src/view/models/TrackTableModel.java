/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.models;

import domen.Track;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sanja
 */
public class TrackTableModel extends AbstractTableModel{
    
    List<Track> trekovi;

    public TrackTableModel() {
        trekovi = new ArrayList<>();
    }

    public TrackTableModel(List<Track> trekovi) {
        this.trekovi = trekovi;
    }

    public List<Track> getTrekovi() {
        return trekovi;
    }

    public void setTrekovi(List<Track> trekovi) {
        this.trekovi = trekovi;
        fireTableDataChanged();
    }
    
    
    

    @Override
    public int getRowCount() {
        return trekovi.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Track t = trekovi.get(row);
        switch (col) {
            case 0:
                return t.getTrackId();
            case 1:
                return t.getNaziv();
            case 2:
                return t.getKilometraza();
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
            default:
                return "greska";
        }
    }
    
    public void addTrack(Track t){
        trekovi.add(t);
        fireTableDataChanged();
    }
    
    
    
    
}

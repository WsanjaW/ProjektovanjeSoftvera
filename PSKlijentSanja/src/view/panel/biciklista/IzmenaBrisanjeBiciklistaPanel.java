/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel.biciklista;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import view.kontroler.biciklista.KontrolerIzmenaBrisanjeBiciklista;
import view.models.BicikistiTableModel;


/**
 *
 * @author Sanja
 */
public class IzmenaBrisanjeBiciklistaPanel extends javax.swing.JPanel {

    KontrolerIzmenaBrisanjeBiciklista kontroler;
    //BicikistiTableModel btm;
    /**
     * Creates new form IzmenaBrisanjeBiciklistaPanel
     */
    public IzmenaBrisanjeBiciklistaPanel() {
        initComponents();
        kontroler = new KontrolerIzmenaBrisanjeBiciklista(this);
        pretragaBiciklistaPanel1.getPrikaziButton().setVisible(false);
       // pretragaBiciklistaPanel1.repaint();
        pretragaBiciklistaPanel1.updateUI();
        //btm = new BicikistiTableModel();
        //pretragaBiciklistaPanel1.getRezutatTable().setModel(btm);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        obrisiButton = new javax.swing.JButton();
        izmeniButton = new javax.swing.JButton();
        pretragaBiciklistaPanel1 = new view.panel.biciklista.PretragaBiciklistaPanel();

        obrisiButton.setText("Obrisi izabranog biciklistu");
        obrisiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obrisiButtonActionPerformed(evt);
            }
        });

        izmeniButton.setText("Izmeni izabranog biciklistu");
        izmeniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izmeniButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pretragaBiciklistaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obrisiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(izmeniButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pretragaBiciklistaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(izmeniButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(obrisiButton)
                        .addGap(103, 103, 103))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void obrisiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obrisiButtonActionPerformed
        try {
            String poruka = kontroler.izbrisiBiciklistu();
            JOptionPane.showMessageDialog(this, poruka);
        } catch (RuntimeException runtimeException) {
            JOptionPane.showMessageDialog(this, runtimeException.getMessage());
        }
    }//GEN-LAST:event_obrisiButtonActionPerformed

    private void izmeniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izmeniButtonActionPerformed

        try {
            String poruka = kontroler.izmeniBiciklistu();
            JOptionPane.showMessageDialog(this, poruka);
        } catch (RuntimeException runtimeException) {
            JOptionPane.showMessageDialog(this, runtimeException.getMessage());
        }

    }//GEN-LAST:event_izmeniButtonActionPerformed

    public BicikistiTableModel getBiklistiTableModel() {
        return pretragaBiciklistaPanel1.getBtm();
    }

    public Biciklista vratiIzabranogBiciklistu() {
        return pretragaBiciklistaPanel1.btm.getBiciklista(pretragaBiciklistaPanel1.getRezutatTable().getSelectedRow());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton izmeniButton;
    private javax.swing.JButton obrisiButton;
    private view.panel.biciklista.PretragaBiciklistaPanel pretragaBiciklistaPanel1;
    // End of variables declaration//GEN-END:variables

  
}

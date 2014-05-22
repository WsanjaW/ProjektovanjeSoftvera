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
import javax.swing.table.DefaultTableModel;
import view.kontroler.biciklista.KontrolerIzmenaBrisanjeBiciklista;
import view.kontroler.biciklista.KontrolerUnosBicikliste;
import view.models.BicikistiTableModel;
import view.panel.PanelAkcije;

/**
 *
 * @author Sanja
 */
public class IzmenaBrisanjeBiciklistaPanel extends javax.swing.JPanel implements PanelAkcije{

    KontrolerIzmenaBrisanjeBiciklista kontroler;
    //BicikistiTableModel btm;
    /**
     * Creates new form IzmenaBrisanjeBiciklistaPanel
     */
    public IzmenaBrisanjeBiciklistaPanel() {
        initComponents();
        kontroler = new KontrolerIzmenaBrisanjeBiciklista(this);
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pretragaBiciklistaPanel1 = new view.panel.biciklista.PretragaBiciklistaPanel();

        jButton1.setText("Obrisi izabranog biciklistu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Izmeni izabranog biciklistu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pretragaBiciklistaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pretragaBiciklistaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String poruka = kontroler.izbrisi();
        JOptionPane.showMessageDialog(this, poruka);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String poruka = kontroler.zapamti();
        JOptionPane.showMessageDialog(this, poruka);

    }//GEN-LAST:event_jButton2ActionPerformed

    public BicikistiTableModel getBiklistiTableModel() {
        return pretragaBiciklistaPanel1.getBtm();
    }

    public Biciklista vratiIzabranogBiciklistu() {
        return pretragaBiciklistaPanel1.btm.getBiciklista(pretragaBiciklistaPanel1.getRezutatTable().getSelectedRow());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private view.panel.biciklista.PretragaBiciklistaPanel pretragaBiciklistaPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public AbstractTableModel vratiModel() {
        return getBiklistiTableModel();
    }

    @Override
    public List<JComboBox> getMestoComboBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat vratiDomenskiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
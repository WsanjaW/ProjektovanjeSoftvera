/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel.biciklista;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import view.kontroler.biciklista.KontrolerPretragaBiciklista;
import view.models.BicikistiTableModel;

/**
 *
 * @author Sanja
 */
public class PretragaBiciklistaPanel extends javax.swing.JPanel {

    KontrolerPretragaBiciklista kontroler;
    BicikistiTableModel btm;

    /**
     * Creates new form PretragaBiciklistaPanel
     */
    public PretragaBiciklistaPanel() {
        initComponents();
        btm = new BicikistiTableModel();
        rezutatTable.setModel(btm);
        kontroler = new KontrolerPretragaBiciklista(this);

    }

    public BicikistiTableModel getBtm() {
        return btm;
    }

    public void setBtm(BicikistiTableModel btm) {
        this.btm = btm;
    }

    public JTextField getPretrazImeTextField() {
        return pretrazImeTextField;
    }

    public void setPretrazImeTextField(String pretrazImeTextField) {
        this.pretrazImeTextField.setText(pretrazImeTextField);
    }

    public JTextField getPretraziIDTextField() {
        return pretraziIDTextField;
    }

    public void setPretraziIDTextField(String pretraziIDTextField) {
        this.pretraziIDTextField.setText(pretraziIDTextField);
    }

    public JTextField getPretraziJmbgTextField() {
        return pretraziJmbgTextField;
    }

    public void setPretraziJmbgTextField(String pretraziJmbgTextField) {
        this.pretraziJmbgTextField.setText(pretraziJmbgTextField);
    }

    public JTextField getPretraziPrezimeTextField() {
        return pretraziPrezimeTextField;
    }

    public void setPretraziPrezimeTextField(String pretraziPrezimeTextField) {
        this.pretraziPrezimeTextField.setText(pretraziPrezimeTextField);
    }

    public JTable getRezutatTable() {
        return rezutatTable;
    }

    public void setRezutatTable(JTable rezutatTable) {
        this.rezutatTable = rezutatTable;
    }

    public JButton getPrikaziButton() {
        return prikaziButton;
    }

    public void setPrikaziButton(JButton prikaziButton) {
        this.prikaziButton = prikaziButton;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pretraziIDTextField = new javax.swing.JTextField();
        pretraziButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        rezutatTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pretrazImeTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pretraziPrezimeTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pretraziJmbgTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        prikaziButton = new javax.swing.JButton();

        pretraziIDTextField.setName(""); // NOI18N

        pretraziButton.setText("Pretrazi bicikliste");
        pretraziButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pretraziButtonActionPerformed(evt);
            }
        });

        rezutatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ime i Prezime", "JMBG", "Naziv Bicikla"
            }
        ));
        rezutatTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rezutatTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rezutatTable);

        jLabel1.setText("Rezultat pretrage:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Pretraga bicikilsta");

        jLabel3.setText("ID:");

        pretrazImeTextField.setName(""); // NOI18N

        jLabel4.setText("Ime:");

        pretraziPrezimeTextField.setName(""); // NOI18N

        jLabel5.setText("Prezime:");

        pretraziJmbgTextField.setName(""); // NOI18N

        jLabel6.setText("JMBG:");

        prikaziButton.setText("Prikazi");
        prikaziButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prikaziButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prikaziButton))
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pretraziJmbgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pretraziIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pretraziPrezimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pretrazImeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addComponent(pretraziButton)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pretraziIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pretrazImeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pretraziPrezimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(pretraziButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pretraziJmbgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prikaziButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pretraziButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pretraziButtonActionPerformed
        try {
            String poruka = kontroler.pronadjiBicikliste();
            JOptionPane.showMessageDialog(this, poruka);
        } catch (RuntimeException runtimeException) {
            JOptionPane.showMessageDialog(this, runtimeException.getMessage());
        }
    }//GEN-LAST:event_pretraziButtonActionPerformed

    private void rezutatTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rezutatTableMouseClicked

    }//GEN-LAST:event_rezutatTableMouseClicked

    private void prikaziButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prikaziButtonActionPerformed
        JTabbedPane jtp = (JTabbedPane) this.getParent().getParent();
        jtp.setSelectedIndex(3);
        Biciklista b = btm.getBiciklista(rezutatTable.getSelectedRow());
        PrikazBiciklistePanel ppp = (PrikazBiciklistePanel) jtp.getSelectedComponent().getComponentAt(0, 0);
        ppp.prikaziBiciklistu(b);
    }//GEN-LAST:event_prikaziButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pretrazImeTextField;
    private javax.swing.JButton pretraziButton;
    private javax.swing.JTextField pretraziIDTextField;
    private javax.swing.JTextField pretraziJmbgTextField;
    private javax.swing.JTextField pretraziPrezimeTextField;
    private javax.swing.JButton prikaziButton;
    private javax.swing.JTable rezutatTable;
    // End of variables declaration//GEN-END:variables

    
  

}

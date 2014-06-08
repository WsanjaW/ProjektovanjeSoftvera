/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel.putovanja;

import domen.Biciklista;
import domen.OpstiDomenskiObjekat;
import domen.Putovanje;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import view.kontroler.putovanja.KontrolerPretragaPutovanja;
import view.models.PutovanjeTableModel;
import view.panel.PanelAkcije;
import view.panel.biciklista.PrikazBiciklistePanel;

/**
 *
 * @author Sanja
 */
public class PretragaPutovanjaPanel extends javax.swing.JPanel implements PanelAkcije{

    KontrolerPretragaPutovanja kontroler;
    PutovanjeTableModel ptm;

    /**
     * Creates new form PretragaPutovanjaPanel
     */
    public PretragaPutovanjaPanel() {
        initComponents();
        kontroler = new KontrolerPretragaPutovanja(this);
        ptm = new PutovanjeTableModel();
        putovanjaTable.setModel(ptm);
    }

    public JTextField getPretraziDoTextField() {
        return pretraziDoTextField;
    }

    public void setPretraziDoTextField(JTextField pretraziDoTextField) {
        this.pretraziDoTextField = pretraziDoTextField;
    }

    public JTextField getPretraziIDTextField() {
        return pretraziIDTextField;
    }

    public void setPretraziIDTextField(JTextField pretraziIDTextField) {
        this.pretraziIDTextField = pretraziIDTextField;
    }

    public JTextField getPretraziNazivTextField() {
        return pretraziNazivTextField;
    }

    public void setPretraziNazivTextField(JTextField pretraziNazivTextField) {
        this.pretraziNazivTextField = pretraziNazivTextField;
    }

    public JTextField getPretraziOdTextField() {
        return pretraziOdTextField;
    }

    public void setPretraziOdTextField(JTextField pretraziOdTextField) {
        this.pretraziOdTextField = pretraziOdTextField;
    }

    public PutovanjeTableModel getPtm() {
        return ptm;
    }

    public void setPtm(PutovanjeTableModel ptm) {
        this.ptm = ptm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pretraziNazivTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pretraziIDTextField = new javax.swing.JTextField();
        pretraziButton = new javax.swing.JButton();
        pretraziDoTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pretraziOdTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        putovanjaTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        prikaziButton = new javax.swing.JButton();

        pretraziNazivTextField.setName(""); // NOI18N

        jLabel4.setText("Naziv:");

        pretraziIDTextField.setName(""); // NOI18N

        pretraziButton.setText("Pretrazi putovanja");
        pretraziButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pretraziButtonActionPerformed(evt);
            }
        });

        pretraziDoTextField.setName(""); // NOI18N

        jLabel6.setText("Do:");

        pretraziOdTextField.setName(""); // NOI18N

        jLabel5.setText("Od:");

        jLabel3.setText("ID:");

        putovanjaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Naziv", "Od", "Do"
            }
        ));
        jScrollPane1.setViewportView(putovanjaTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Pretraga putovanja");

        jLabel1.setText("Rezultat pretrage:");

        prikaziButton.setText("prikazi");
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
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(188, 188, 188)
                        .addComponent(pretraziButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pretraziDoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pretraziNazivTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pretraziIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pretraziOdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prikaziButton))
                    .addComponent(jLabel2))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pretraziIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pretraziNazivTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pretraziOdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(pretraziButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(pretraziDoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prikaziButton)
                        .addGap(165, 165, 165))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pretraziButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pretraziButtonActionPerformed
        //String poruka = kontroler.pronadji();
        //JOptionPane.showMessageDialog(this, poruka);
    }//GEN-LAST:event_pretraziButtonActionPerformed

    private void prikaziButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prikaziButtonActionPerformed
        JTabbedPane jtp = (JTabbedPane) this.getParent().getParent();
        jtp.setSelectedIndex(2);
        Putovanje b = ptm.getPutovanje(putovanjaTable.getSelectedRow());
        PrikazPutovanjaPanel ppp = (PrikazPutovanjaPanel) jtp.getSelectedComponent().getComponentAt(0, 0);
        ppp.prikaziPutovanje(b);
    }//GEN-LAST:event_prikaziButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pretraziButton;
    private javax.swing.JTextField pretraziDoTextField;
    private javax.swing.JTextField pretraziIDTextField;
    private javax.swing.JTextField pretraziNazivTextField;
    private javax.swing.JTextField pretraziOdTextField;
    private javax.swing.JButton prikaziButton;
    private javax.swing.JTable putovanjaTable;
    // End of variables declaration//GEN-END:variables

    @Override
    public AbstractTableModel vratiModel() {
        return ptm;
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

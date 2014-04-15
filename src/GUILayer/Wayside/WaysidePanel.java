/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUILayer.Wayside;

import DataLayer.Wayside.TrackController;
import DataLayer.Wayside.Wayside;
import java.util.ArrayList;

/**
 *
 * @author domino54
 */
public class WaysidePanel extends javax.swing.JPanel {
    Wayside wayside;
    /**
     * Creates new form WaysidePanel
     */
    public WaysidePanel() {
        initComponents();
    }
    
    public void setWayside(Wayside wayside)
    {
        this.wayside = wayside;
        for (TrackController tc : wayside.getControllers())
        {
            this.pLCTestPanel1.addController(tc);
           
        }
        reInitComponents();
    }
    
    private void reInitComponents()
    {
         controllerSelectComboBox.setModel(new javax.swing.DefaultComboBoxModel(wayside.getControllerNames()));
         setControllers();
    }
    
    private void setControllers()
    {
        int index = this.controllerSelectComboBox.getSelectedIndex();
         this.trackControllerPanel1.SetController(this.wayside.getController(index));
         this.pLCTestPanel1.selectController(index);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controllerRadioGroup = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        controllerSelectComboBox = new javax.swing.JComboBox();
        trackControllerPanel1 = new GUILayer.Wayside.TrackControllerPanel();
        pLCTestPanel1 = new GUILayer.Wayside.PLCTestPanel();

        jLabel5.setText("Track Controllers");

        controllerSelectComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        controllerSelectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controllerSelectComboBoxActionPerformed(evt);
            }
        });

        trackControllerPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pLCTestPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(controllerSelectComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trackControllerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(pLCTestPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(controllerSelectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(trackControllerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pLCTestPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void controllerSelectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controllerSelectComboBoxActionPerformed
        // TODO add your handling code here:
        setControllers();
    }//GEN-LAST:event_controllerSelectComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup controllerRadioGroup;
    private javax.swing.JComboBox controllerSelectComboBox;
    private javax.swing.JLabel jLabel5;
    private GUILayer.Wayside.PLCTestPanel pLCTestPanel1;
    private GUILayer.Wayside.TrackControllerPanel trackControllerPanel1;
    // End of variables declaration//GEN-END:variables
}

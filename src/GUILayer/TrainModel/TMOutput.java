/******************************************************************************
 * 
 * TMOutput class
 * 
 * Developed by AJility
 * April 2014
 * 
 * Contributers:
 *  Drew Winfield
 * 
 * DISCLAIMER:
 *   This document contains un-editable code generated by NetBeans.  Due to this
 *  un-editable code, this document does not follow the AJility coding standard.
 *
 *****************************************************************************/

package GUILayer.TrainModel;
import DataLayer.Train.*;
import DataLayer.Train.TrainModel.*;
import java.text.DecimalFormat;

public class TMOutput extends javax.swing.JPanel {

    private PhysicsEngine physicsEngine;
    private TrainState trainState;
    private DecimalFormat df;
    
    /**
     * Creates new form StateDisplay
     */
    public TMOutput() {
        initComponents();
        df = new DecimalFormat("##.#");
    }

    public void setPhysicsEngine(PhysicsEngine e)
    {
        physicsEngine = e;
    }
    
    public void setTrainState(TrainState s)
    {
        trainState = s;
    }
    
    public void update()
    {
        double velocity = physicsEngine.getVelocity();
        boolean sBrake = physicsEngine.getServiceBrake();
        boolean eBrake = physicsEngine.getEmergencyBrake();
        boolean lDoor = trainState.getLeftDoors();
        boolean rDoor = trainState.getRightDoors();
        boolean extLights = trainState.getExteriorLights();
        boolean intLights = trainState.getInteriorLights();
        boolean heater = trainState.getHeater();
        String advertisement = trainState.getAdvertisement();
        String announcement = trainState.getAnnouncement();
        
        velocity = velocity * 2.23694; // conversion from m/s to mph
        // correct for rounding error
        if (velocity > 43.5)
        {
            velocity = 43.5;
        }
        velocityDisplayBox.setText(df.format(velocity));
        
        if (sBrake)
        {
            sBrakeDisplayBox.setText("ON");
        }
        else
        {
            sBrakeDisplayBox.setText("OFF");
        }
        
        if (eBrake)
        {
            eBrakeDisplayBox.setText("ON");
        }
        else
        {
            eBrakeDisplayBox.setText("OFF");
        }
         
        if (lDoor)
        {
            leftDoorDisplayBox.setText("OPEN");
        }
        else
        {
            leftDoorDisplayBox.setText("CLOSED");
        }
        
         
        if (rDoor)
        {
            rightDoorDisplayBox.setText("OPEN");
        }
        else
        {
            rightDoorDisplayBox.setText("CLOSED");
        }
        
        if (intLights)
        {
            intLightsDisplayBox.setText("ON");
        }
        else
        {
            intLightsDisplayBox.setText("OFF");
        }
        
        if (extLights)
        {
            extLightsDisplayBox.setText("ON");
        }
        else
        {
            extLightsDisplayBox.setText("OFF");
        }

        if (heater)
        {
            heaterDisplayBox.setText("ON");
        }
        else
        {
            heaterDisplayBox.setText("OFF");
        }
        
        announcementDisplayBox.setText(announcement);
        advertisementDisplayBox.setText(advertisement);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outputsLabel = new javax.swing.JLabel();
        velocityOutputLabel = new javax.swing.JLabel();
        rightDoorOutputLabel = new javax.swing.JLabel();
        eBrakeOutputLabel = new javax.swing.JLabel();
        sBrakeOutputLabel = new javax.swing.JLabel();
        exteriorLightsOutputLabel = new javax.swing.JLabel();
        leftDoorOutputLabel = new javax.swing.JLabel();
        interiorLightsOutputLabel = new javax.swing.JLabel();
        mphLabel = new javax.swing.JLabel();
        sBrakeDisplayBox = new javax.swing.JTextField();
        eBrakeDisplayBox = new javax.swing.JTextField();
        rightDoorDisplayBox = new javax.swing.JTextField();
        leftDoorDisplayBox = new javax.swing.JTextField();
        intLightsDisplayBox = new javax.swing.JTextField();
        extLightsDisplayBox = new javax.swing.JTextField();
        velocityDisplayBox = new javax.swing.JTextField();
        heaterOutputLabel = new javax.swing.JLabel();
        heaterDisplayBox = new javax.swing.JTextField();
        announcementDisplayBox = new javax.swing.JTextField();
        announcementOutputLabel = new javax.swing.JLabel();
        advertisementDisplayBox = new javax.swing.JTextField();
        advertisementOutputLabel = new javax.swing.JLabel();

        outputsLabel.setText("Outputs");

        velocityOutputLabel.setText("Velocity");

        rightDoorOutputLabel.setText("Door open/close (Right side) \u0000");

        eBrakeOutputLabel.setText("Emergency Brake");

        sBrakeOutputLabel.setText("Service Brake");

        exteriorLightsOutputLabel.setText("Lights on/off (Exterior) \u0000");

        leftDoorOutputLabel.setText("Door open/close (Left side) \u0000");

        interiorLightsOutputLabel.setText("Lights on/off (Interior) \u0000");

        mphLabel.setText("mph");

        sBrakeDisplayBox.setText("Off");

        eBrakeDisplayBox.setText("Off");

        rightDoorDisplayBox.setText("Closed");

        leftDoorDisplayBox.setText("Closed");

        intLightsDisplayBox.setText("Off");

        extLightsDisplayBox.setText("Off");

        velocityDisplayBox.setText("0");

        heaterOutputLabel.setText("Heater");

        heaterDisplayBox.setText("Off");

        announcementDisplayBox.setText("<Next station>");
        announcementDisplayBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                announcementDisplayBoxActionPerformed(evt);
            }
        });

        announcementOutputLabel.setText("Announcement");

        advertisementDisplayBox.setText("Advertisement");

        advertisementOutputLabel.setText("Advertisement");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(velocityOutputLabel)
                    .addComponent(interiorLightsOutputLabel)
                    .addComponent(leftDoorOutputLabel)
                    .addComponent(rightDoorOutputLabel)
                    .addComponent(exteriorLightsOutputLabel)
                    .addComponent(sBrakeOutputLabel)
                    .addComponent(eBrakeOutputLabel)
                    .addComponent(heaterOutputLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(outputsLabel))
                    .addComponent(announcementOutputLabel)
                    .addComponent(advertisementOutputLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(advertisementDisplayBox)
                    .addComponent(announcementDisplayBox, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(velocityDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mphLabel))
                            .addComponent(sBrakeDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eBrakeDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rightDoorDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leftDoorDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(intLightsDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(extLightsDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(heaterDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputsLabel)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(velocityOutputLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mphLabel)
                        .addComponent(velocityDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sBrakeOutputLabel)
                    .addComponent(sBrakeDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eBrakeOutputLabel)
                    .addComponent(eBrakeDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightDoorOutputLabel)
                    .addComponent(rightDoorDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftDoorOutputLabel)
                    .addComponent(leftDoorDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interiorLightsOutputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(intLightsDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exteriorLightsOutputLabel)
                    .addComponent(extLightsDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heaterDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heaterOutputLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(announcementDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(announcementOutputLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(advertisementDisplayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advertisementOutputLabel))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void announcementDisplayBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_announcementDisplayBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_announcementDisplayBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField advertisementDisplayBox;
    private javax.swing.JLabel advertisementOutputLabel;
    private javax.swing.JTextField announcementDisplayBox;
    private javax.swing.JLabel announcementOutputLabel;
    private javax.swing.JTextField eBrakeDisplayBox;
    private javax.swing.JLabel eBrakeOutputLabel;
    private javax.swing.JTextField extLightsDisplayBox;
    private javax.swing.JLabel exteriorLightsOutputLabel;
    private javax.swing.JTextField heaterDisplayBox;
    private javax.swing.JLabel heaterOutputLabel;
    private javax.swing.JTextField intLightsDisplayBox;
    private javax.swing.JLabel interiorLightsOutputLabel;
    private javax.swing.JTextField leftDoorDisplayBox;
    private javax.swing.JLabel leftDoorOutputLabel;
    private javax.swing.JLabel mphLabel;
    private javax.swing.JLabel outputsLabel;
    private javax.swing.JTextField rightDoorDisplayBox;
    private javax.swing.JLabel rightDoorOutputLabel;
    private javax.swing.JTextField sBrakeDisplayBox;
    private javax.swing.JLabel sBrakeOutputLabel;
    private javax.swing.JTextField velocityDisplayBox;
    private javax.swing.JLabel velocityOutputLabel;
    // End of variables declaration//GEN-END:variables
}

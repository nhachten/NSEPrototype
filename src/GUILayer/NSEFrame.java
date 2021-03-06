/******************************************************************************
 * 
 * NSEFrame class
 * 
 * Developed by AJility
 * April 2014
 * 
 * Contributers:
 *  Nathan Hachten
 *  Michael Kudlaty
 *  Ryan Mertz
 *  Stephen Ruzzini
 *  Drew Winfield
 * 
 * DISCLAIMER:
 *   This document contains un-editable code generated by NetBeans.  Due to this
 *  un-editable code, this document does not follow the AJility coding standard.
 *
 *****************************************************************************/

package GUILayer;
import DataLayer.*;
import DataLayer.TrackModel.*;
import DataLayer.Train.*;
import DataLayer.Wayside.Wayside;
import java.util.Vector;

public class NSEFrame extends javax.swing.JFrame implements Runnable {

    public NSE NSEObject; //NSE object bound to the gui
    public boolean StartClicked; //true if start was clicked
    
    public NSEFrame() {
        initComponents();
        this.NSEObject = null; //create new NSE object with 10 trains
        this.wallClock_Radio.setSelected(true);
        this.StartClicked = false;
    }
    
    /* run() used to implement Runnable.
    */
    public void run()
    {
        while (true)
        {
            this.trainPanel1.update(); 
            this.trackModelPanel1.updateDisplay();
            this.cTCGUI1.update();
        }
    }
    
    /* SetNSE(NSE n) sets the nse object bound to the gui
     * Paramters:
     *     NSE n - NSE object to set
    */
    public void setNSE(NSE n)
    {
        this.NSEObject = n;
        this.trainPanel1.setTrain(this.NSEObject.Trains.get(0));
        this.cTCGUI1.setCTCOffice(this.NSEObject.CTCOffice);
        this.automatic_Clicked(null);
    }
    
    /* SetSystemTime(String s) sets the systemTime_txt label to the string
     * Parameters:
     *     String s - time to set to systemTime_txt
    */
    public void setSystemTime(String s)
    {
        this.systemTime_txt.setText(s);
    }
    
    /* SetTrackModel(TrackModel t) sets TrackModel object to trackmodel panel
     * Paramters:
     *     TrackModel t - TrackModel object to be bound
    */
    public void setTrackModel(TrackModel t)
    {
        this.trackModelPanel1.setTrack(t);
    }
    
    /* SetWayside(Wayside w) sets the Wayside object to wayside panel
     * Parameters:
     *     Wayside w - Wayside object to be bound
    */
    public void setWayside(Wayside w)
    {
       this.waysidePanel1.setWayside(w);
    }
    
    /* UpdateTrainSelectList() updates the train list on the train panel
    */
    public void updateTrainSelectList()
    {
        Vector<String> list = new Vector<String>();
        for (Train t : NSEObject.Trains)
        {
            list.add(t.toString());
        }
        trainSelectList.setListData(list);
        trainSelectList.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        speed_group = new javax.swing.ButtonGroup();
        mode_group = new javax.swing.ButtonGroup();
        wallClock_Radio = new javax.swing.JRadioButton();
        wallClock10_Radio = new javax.swing.JRadioButton();
        pause_button = new javax.swing.JButton();
        reset_button = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        CTC_panel = new javax.swing.JPanel();
        cTCGUI1 = new GUILayer.CTC.CTCGUI();
        Waysides_panel = new javax.swing.JPanel();
        waysidePanel1 = new GUILayer.Wayside.WaysidePanel();
        TrackModel_panel = new javax.swing.JPanel();
        trackModelPanel1 = new GUILayer.TrackModelPanel();
        Trains_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        trainPanel1 = new GUILayer.TrainPanel();
        trainSelectList = new javax.swing.JList();
        start_button = new javax.swing.JButton();
        systemTime_txt = new javax.swing.JLabel();
        manual_radio = new javax.swing.JRadioButton();
        automatic_radio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        speed_group.add(wallClock_Radio);
        wallClock_Radio.setSelected(true);
        wallClock_Radio.setText("Wall Clock");
        wallClock_Radio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wallClock_RadioMouseClicked(evt);
            }
        });

        speed_group.add(wallClock10_Radio);
        wallClock10_Radio.setText("10x Wall Clock");
        wallClock10_Radio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timeMultiplier_Clicked(evt);
            }
        });

        pause_button.setText("Pause");
        pause_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pause_clicked(evt);
            }
        });

        reset_button.setText("Reset");
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CTC_panelLayout = new javax.swing.GroupLayout(CTC_panel);
        CTC_panel.setLayout(CTC_panelLayout);
        CTC_panelLayout.setHorizontalGroup(
            CTC_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTC_panelLayout.createSequentialGroup()
                .addComponent(cTCGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );
        CTC_panelLayout.setVerticalGroup(
            CTC_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTC_panelLayout.createSequentialGroup()
                .addComponent(cTCGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CTC", CTC_panel);

        javax.swing.GroupLayout Waysides_panelLayout = new javax.swing.GroupLayout(Waysides_panel);
        Waysides_panel.setLayout(Waysides_panelLayout);
        Waysides_panelLayout.setHorizontalGroup(
            Waysides_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Waysides_panelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(waysidePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        Waysides_panelLayout.setVerticalGroup(
            Waysides_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Waysides_panelLayout.createSequentialGroup()
                .addComponent(waysidePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Waysides", Waysides_panel);

        javax.swing.GroupLayout TrackModel_panelLayout = new javax.swing.GroupLayout(TrackModel_panel);
        TrackModel_panel.setLayout(TrackModel_panelLayout);
        TrackModel_panelLayout.setHorizontalGroup(
            TrackModel_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TrackModel_panelLayout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(trackModelPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );
        TrackModel_panelLayout.setVerticalGroup(
            TrackModel_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TrackModel_panelLayout.createSequentialGroup()
                .addComponent(trackModelPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Track Model", TrackModel_panel);

        jLabel1.setText("Trains");

        trainSelectList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        trainSelectList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                trainSelectListValueChanged(evt);
            }
        });

        javax.swing.GroupLayout Trains_panelLayout = new javax.swing.GroupLayout(Trains_panel);
        Trains_panel.setLayout(Trains_panelLayout);
        Trains_panelLayout.setHorizontalGroup(
            Trains_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Trains_panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(trainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(Trains_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trainSelectList, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Trains_panelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addGap(27, 27, 27))
        );
        Trains_panelLayout.setVerticalGroup(
            Trains_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Trains_panelLayout.createSequentialGroup()
                .addComponent(trainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(Trains_panelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trainSelectList, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Trains", Trains_panel);

        start_button.setText("Start");
        start_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                start_Clicked(evt);
            }
        });

        systemTime_txt.setText("12 : 00 : 00");

        mode_group.add(manual_radio);
        manual_radio.setText("Manual");
        manual_radio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manual_Clicked(evt);
            }
        });

        mode_group.add(automatic_radio);
        automatic_radio.setSelected(true);
        automatic_radio.setText("Automatic");
        automatic_radio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                automatic_Clicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wallClock_Radio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wallClock10_Radio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(start_button)
                        .addGap(2, 2, 2)
                        .addComponent(pause_button)
                        .addGap(12, 12, 12)
                        .addComponent(reset_button)
                        .addGap(18, 18, 18)
                        .addComponent(manual_radio)
                        .addGap(18, 18, 18)
                        .addComponent(automatic_radio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(systemTime_txt)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wallClock_Radio)
                    .addComponent(wallClock10_Radio)
                    .addComponent(pause_button)
                    .addComponent(reset_button)
                    .addComponent(start_button)
                    .addComponent(systemTime_txt)
                    .addComponent(manual_radio)
                    .addComponent(automatic_radio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void start_Clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_start_Clicked
        // TODO add your handling code here:
        this.StartClicked = true;
        if (this.wallClock_Radio.isSelected()) //selected wall clock speed
        {
            this.NSEObject.setTimeMultiplier(1);
        }
        else //selected 10x multiplier
        {
            this.NSEObject.setTimeMultiplier(10);
        }
        if (!this.NSEObject.isRunning.booleanValue()) //if we havent started simulating, start
        {
            new Thread(this.NSEObject).start();
        }
        this.start_button.setEnabled(false);
        this.reset_button.setEnabled(false);
    }//GEN-LAST:event_start_Clicked

    private void trainSelectListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_trainSelectListValueChanged
        this.trainPanel1.setTrain(this.NSEObject.Trains.get(trainSelectList.getSelectedIndices()[0]));
    }//GEN-LAST:event_trainSelectListValueChanged

    private void timeMultiplier_Clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timeMultiplier_Clicked
        if (this.wallClock_Radio.isSelected()) //selected wall clock speed
        {
            this.NSEObject.setTimeMultiplier(1);
        }
        else //selected 10x multiplier
        {
            this.NSEObject.setTimeMultiplier(10);
        }
    }//GEN-LAST:event_timeMultiplier_Clicked

    private void wallClock_RadioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wallClock_RadioMouseClicked
        if (this.wallClock_Radio.isSelected()) //selected wall clock speed
        {
            this.NSEObject.setTimeMultiplier(1);
        }
        else //selected 10x multiplier
        {
            this.NSEObject.setTimeMultiplier(10);
        }
    }//GEN-LAST:event_wallClock_RadioMouseClicked

    private void pause_clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pause_clicked
        if (this.NSEObject.isRunning.booleanValue()) //if the 
        {
            this.NSEObject.setTimeMultiplier(0);
        }
        this.start_button.setEnabled(true);
        this.reset_button.setEnabled(true);
    }//GEN-LAST:event_pause_clicked

    private void automatic_Clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_automatic_Clicked
        if (this.automatic_radio.isSelected()) //selected automatic
        {
            this.NSEObject.IsAutomatic = true;
            this.trainPanel1.setAutomatic();
            this.waysidePanel1.setAutomatic();
            this.cTCGUI1.setAutomatic();
        }
        else //manual mode selected
        {
            this.NSEObject.IsAutomatic = false;
            this.trainPanel1.setManual();
            this.waysidePanel1.setManual();
            this.cTCGUI1.setManual();
        }
    }//GEN-LAST:event_automatic_Clicked

    private void manual_Clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manual_Clicked
        if (this.automatic_radio.isSelected()) //selected automatic
        {
            this.NSEObject.IsAutomatic = true;
            this.trainPanel1.setAutomatic();
            this.waysidePanel1.setAutomatic();
            this.cTCGUI1.setAutomatic();
        }
        else //manual mode selected
        {
            this.NSEObject.IsAutomatic = false;
            this.trainPanel1.setManual();
            this.waysidePanel1.setManual();
            this.cTCGUI1.setManual();
        }
    }//GEN-LAST:event_manual_Clicked

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed
        NSEObject.reset();
    }//GEN-LAST:event_reset_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CTC_panel;
    private javax.swing.JPanel TrackModel_panel;
    private javax.swing.JPanel Trains_panel;
    private javax.swing.JPanel Waysides_panel;
    private javax.swing.JRadioButton automatic_radio;
    private GUILayer.CTC.CTCGUI cTCGUI1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton manual_radio;
    private javax.swing.ButtonGroup mode_group;
    private javax.swing.JButton pause_button;
    private javax.swing.JButton reset_button;
    private javax.swing.ButtonGroup speed_group;
    private javax.swing.JButton start_button;
    private javax.swing.JLabel systemTime_txt;
    private GUILayer.TrackModelPanel trackModelPanel1;
    private GUILayer.TrainPanel trainPanel1;
    private javax.swing.JList trainSelectList;
    private javax.swing.JRadioButton wallClock10_Radio;
    private javax.swing.JRadioButton wallClock_Radio;
    private GUILayer.Wayside.WaysidePanel waysidePanel1;
    // End of variables declaration//GEN-END:variables
}

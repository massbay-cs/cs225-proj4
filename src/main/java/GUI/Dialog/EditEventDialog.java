/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Dialog;

import BackEnd.EventSystem.Event;
import BackEnd.EventSystem.SubEvent;
import BackEnd.EventSystem.TimeSchedule;
import BackEnd.ManagerSystem.MainManager;
import BackEnd.ManagerSystem.ManagerExceptions.PrivilegeInsufficientException;
import BackEnd.UserSystem.Location;
import EMS_Database.DoesNotExistException;
import GUI.DesignDefault;
import auth.AuthorizationException;
import exception.UpdateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Karina
 */
public class EditEventDialog extends javax.swing.JDialog {

    private boolean confirm;
    private Event selectedEvent;
    private MainManager manager;
    private TimeSchedule tempTimeSchedule;
    private DesignDefault dd;
    /**
     * Creates new form EditSubEventDialog
     */
    public EditEventDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        dd = DesignDefault.getInstance();
        manager = MainManager.getInstance();
        selectedEvent = manager.getEventManager().getSelectedEvent();
        tempTimeSchedule = selectedEvent.getTimeSchedule();
        initComponents();
        initLabels();
        /* Added following line to center dialog. -Ketty */
        setLocationRelativeTo(null);
        confirm = false;
        
        DefaultComboBoxModel dayModel = new DefaultComboBoxModel();
        for(int i = 0; i < 32; i++)
        {
            if(i == 0)
            { dayModel.addElement("Day"); }
            else
            { dayModel.addElement(i); }
        }
        DefaultComboBoxModel yearModel = new DefaultComboBoxModel();
        yearModel.addElement("Year");
        for(int i = 2013; i < 2050; i++)
        {
            yearModel.addElement(i);
        }
        DefaultComboBoxModel minModel = new DefaultComboBoxModel();
        minModel.addElement("Minute");
        for(int i = 1; i < 61; i++)
        {
            minModel.addElement(i);
        }
        
    }
    
    public boolean getConfirm()
    { return confirm; }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveSubEventButton = new javax.swing.JButton();
        cancelChangesButton = new javax.swing.JButton();
        locationField = new javax.swing.JTextField();
        locationLabel = new javax.swing.JLabel();
        headerLabel = new javax.swing.JLabel();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        nameField = new javax.swing.JTextField();
        startDateLabel = new javax.swing.JLabel();
        editTimeScheduleButton = new javax.swing.JButton();
        dueDateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        saveSubEventButton.setText("Save");
        saveSubEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSubEventButtonActionPerformed(evt);
            }
        });

        cancelChangesButton.setText("Cancel");
        cancelChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelChangesButtonActionPerformed(evt);
            }
        });

        locationLabel.setFont(dd.getStandardText());
        locationLabel.setText("Location:");

        headerLabel.setFont(dd.getHeaderText());
        headerLabel.setText("Event Name");

        descriptionTextArea.setFont(dd.getStandardText());
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setText("Description of this event.\nDoesn't do anything yet.");
        descriptionScrollPane.setViewportView(descriptionTextArea);

        startDateLabel.setFont(dd.getStandardText());
        startDateLabel.setText("Start Date: MM/DD/YY - 00:00 AM");

        editTimeScheduleButton.setFont(dd.getStandardText());
        editTimeScheduleButton.setMinimumSize(dd.getBigButtonDimension());
        editTimeScheduleButton.setText("Edit");
        editTimeScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTimeScheduleButtonActionPerformed(evt);
            }
        });

        dueDateLabel.setFont(dd.getStandardText());
        dueDateLabel.setText("Due Date : MM/DD/YY - 00:00 AM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(locationLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(startDateLabel)
                            .addComponent(dueDateLabel)
                            .addComponent(editTimeScheduleButton))
                        .addGap(0, 178, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(headerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveSubEventButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                                .addComponent(cancelChangesButton)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(descriptionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(startDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dueDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editTimeScheduleButton)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationLabel)
                    .addComponent(locationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveSubEventButton)
                    .addComponent(cancelChangesButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelChangesButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelChangesButtonActionPerformed

    private void saveSubEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSubEventButtonActionPerformed
        try {
            manager.getEventManager().setSelectedEvent(selectedEvent);
            manager.getEventManager().editTimeSchedule(tempTimeSchedule);
            manager.getEventManager().editLocation(new Location(locationField.getText()));
            manager.getEventManager().editTitle(nameField.getText());
            manager.getEventManager().editDescription(descriptionTextArea.getText());
            manager.getEventManager().editLocation(new Location(locationField.getText()));

            confirm = true;
            this.dispose();
        }
        catch (PrivilegeInsufficientException ex) {
            Logger.getLogger(EditEventDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (DoesNotExistException ex) {
            Logger.getLogger(EditEventDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UpdateException error) {
            JOptionPane.showMessageDialog(this, "Unable to add SubEvent.");
            System.out.println("Update SubEvent error in EditEventDialog: " + error.getMessage());
        }catch (AuthorizationException ex){
            System.out.println("Error: Lacking authority");
        }
    }//GEN-LAST:event_saveSubEventButtonActionPerformed

    private void editTimeScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTimeScheduleButtonActionPerformed
        // TODO add your handling code here:
        NewTimeStampDialog ntsd = new NewTimeStampDialog(null, true, tempTimeSchedule);
        ntsd.setVisible(true);
        if(ntsd.getConfirm())
        {
            tempTimeSchedule = ntsd.createTimeSchedule();
        }
        updateLabels();
    }//GEN-LAST:event_editTimeScheduleButtonActionPerformed

    private void initLabels()
    {
        nameField.setText(selectedEvent.getTitle());
        descriptionTextArea.setText(selectedEvent.getDescription());
        dueDateLabel.setText("Due date: " + tempTimeSchedule.getEndDateTimeTimestamp().toString());
        startDateLabel.setText("Start date: " + tempTimeSchedule.getStartDateTimeTimestamp().toString());
        locationField.setText(selectedEvent.getLocation().getDetails());
    }
    
    private void updateLabels()
    {
        dueDateLabel.setText("Due date: " + tempTimeSchedule.getEndDateTimeTimestamp().toString());
        startDateLabel.setText("Start date: " + tempTimeSchedule.getStartDateTimeTimestamp().toString());
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelChangesButton;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel dueDateLabel;
    private javax.swing.JButton editTimeScheduleButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JTextField locationField;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton saveSubEventButton;
    private javax.swing.JLabel startDateLabel;
    // End of variables declaration//GEN-END:variables
}

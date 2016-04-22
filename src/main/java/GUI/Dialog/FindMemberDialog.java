/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Dialog;

import BackEnd.ManagerSystem.MainManager;
import BackEnd.UserSystem.Participant;
import BackEnd.UserSystem.User;
import GUI.DesignDefault;

import javax.swing.DefaultListModel;

/**
 *
 * @author Sid
 */
public class FindMemberDialog extends javax.swing.JDialog {

    private MainManager manager;
    private boolean confirm;
    private DesignDefault dd;
    /**
     * Creates new form FindMemberDialog
     */
    public FindMemberDialog(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        dd = DesignDefault.getInstance();
        initComponents();
        /* Added following line to center dialog. -Ketty */
        setLocationRelativeTo(null);
        manager = MainManager.getInstance();
        updateInfo();
        confirm = false;
        this.setBackground(dd.getDialogBGColor());
        this.setTitle("Select a Member");
    }
    
    public void updateInfo()
    {
        DefaultListModel model = new DefaultListModel();
        for(Participant p : manager.getUserManager().getUserList())
        {
            model.addElement(p.getFirstName() + " " + p.getLastName());
        }
        memberList.setModel(model);
    }
    
    public boolean getConfirm()
    { return confirm; }
    
    public User createUser()
    {
        return (User)manager.getUserManager().getUserList().get(memberList.getSelectedIndex());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memberListScrollPane = new javax.swing.JScrollPane();
        memberList = new javax.swing.JList();
        listLabel = new javax.swing.JLabel();
        SelectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        memberList.setFont(dd.getStandardText());
        memberList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        memberListScrollPane.setViewportView(memberList);

        listLabel.setFont(dd.getStandardText());
        listLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listLabel.setText("Member List");

        SelectButton.setFont(dd.getStandardText());
        SelectButton.setText("Select");
        SelectButton.setMinimumSize(dd.getBigButtonDimension());
        SelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listLabel)
                    .addComponent(SelectButton)
                    .addComponent(memberListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(listLabel)
                .addGap(18, 18, 18)
                .addComponent(memberListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(SelectButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectButtonActionPerformed
        // TODO add your handling code here:
        confirm = true;
        this.dispose();
    }//GEN-LAST:event_SelectButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FindMemberDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindMemberDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindMemberDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindMemberDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                FindMemberDialog dialog = new FindMemberDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SelectButton;
    private javax.swing.JLabel listLabel;
    private javax.swing.JList memberList;
    private javax.swing.JScrollPane memberListScrollPane;
    // End of variables declaration//GEN-END:variables
}

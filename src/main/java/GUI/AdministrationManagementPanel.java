package GUI;


import BackEnd.ManagerSystem.UserManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BackEnd.ManagerSystem.MainManager;
import BackEnd.UserSystem.Participant;
import EMS_Database.DoesNotExistException;
import auth.AuthorizationException;
import auth.PrivilegeLevel;
import exception.UpdateException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by michael on 4/19/2016.
 */

public class AdministrationManagementPanel extends javax.swing.JPanel implements ActionListener {

    private Object[][] data = new Object[10][5];
    private MainManager manage;
    private UserManager user;
    private AdminPanelTable ut;
    private JTable userTable;
    private ArrayList<Participant> userList;
    private JScrollPane scrollBar;
    private JButton submit;


    public AdministrationManagementPanel() throws DoesNotExistException, AuthorizationException {
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        manage = new MainManager().getInstance();
        user = manage.getUserManager();
        userList = user.getUserList();
        setTable();

        scrollBar = new JScrollPane(userTable);
        scrollBar.setVisible(true);
        submit = new JButton("Submit");
        submit.setPreferredSize(new Dimension(30, 30));
        submit.addActionListener(this);
        this.add(scrollBar);
        this.add(submit);
    }

    /**
     * update the database to make users an admin when the buttons is clicked
     */
    public void actionPerformed(ActionEvent e)
    {
        for(int i =0; i < ut.getRowCount(); i++)
        {
            if((boolean) ut.getValueAt(i, 3) == true)
            {
                System.out.println("row: " + i + " is checked");
                //update the database on click
                try {
                    user.getUsersTable().setPrivilegeLevel((int )ut.getValueAt(i,2), PrivilegeLevel.ADMIN);
                    System.out.println("is now an admin");
                } catch (DoesNotExistException e1) {
                    e1.printStackTrace();
                } catch (AuthorizationException e1) {
                    e1.printStackTrace();
                } catch (UpdateException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * set up the table for all users that are not already admins
     * @throws DoesNotExistException
     */
    public void setTable() throws AuthorizationException, DoesNotExistException {
        ut = new AdminPanelTable();
        for (int j = 0; j < userList.size(); j++) {
            try {
                if (user.getUsersTable().getPrivilegeLevel(userList.get(j).getUserId()) != PrivilegeLevel.ADMIN)

                    ut.addRow(new Object[]{userList.get(j).getFirstName(), userList.get(j).getLastName(), userList.get(j).getUserId(), false});
            }catch (DoesNotExistException dne){
                throw new DoesNotExistException(""+dne.getMessage());
            }

        }
        userTable = new JTable(ut);
        userTable.setPreferredScrollableViewportSize(new Dimension(50, 50));
        userTable.setFillsViewportHeight(true);
    }
    public class AdminPanelTable extends DefaultTableModel
    {
        public AdminPanelTable() {
            super(new String[]{"First Name", "Last Name", "UID", "Make Admin"}, 0);
        }

        public Class<?> getColumnClass(int columnIndex) {
            Class clazz = String.class;
            switch (columnIndex) {
                case 2:
                    clazz = Boolean.class;
            }
            return clazz;
        }

        public boolean isCellEditable(int row, int column) {
            return column == 2;
        }

        public void setValueAt(Object aValue, int row, int column) {
            if (aValue instanceof Boolean && column == 2) {
                Vector rowData = (Vector) getDataVector().get(row);
                rowData.set(2, (boolean) aValue);
                fireTableCellUpdated(row, column);
                if((boolean) aValue)
                    System.out.println("checked");
            }
        }
    }
}
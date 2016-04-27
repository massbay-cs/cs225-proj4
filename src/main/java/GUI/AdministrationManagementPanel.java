package GUI;


import BackEnd.ManagerSystem.UserManager;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BackEnd.ManagerSystem.MainManager;
import BackEnd.UserSystem.Participant;
import EMS_Database.DoesNotExistException;
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


    public AdministrationManagementPanel() {
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
                try
                {
                    user.getUsersTable().setPrivilegeLevel((int) ut.getValueAt(i,3), PrivilegeLevel.ADMIN);
                    System.out.println((ut.getValueAt(i, 0) + " has been promoted to admin"));
                    setTable();
                }catch(DoesNotExistException ex)
                {
                    System.out.println("That user cannot be found: " + ex.getMessage());
                }
                catch(auth.AuthorizationException aex)
                {
                    System.out.println("You do not have proper authorization level for this content: " + aex.getMessage());
                    this.setVisible(false);
                }catch(UpdateException uex)
                {
                    System.out.println("Could not update the database: " + uex.getMessage());
                }

            }
        }
    }

    /**
     * set up the table for all users that are not already admins
     * @throws DoesNotExistException
     */
    public void setTable()  {
        ut = new AdminPanelTable();
        for (int j = 0; j < userList.size(); j++)
        {
            try
            {
                if(user.getUsersTable().getPrivilegeLevel(userList.get(j).getUserId()) != PrivilegeLevel.ADMIN)

                    ut.addRow(new Object[]{userList.get(j).getFirstName(), userList.get(j).getLastName(), userList.get(j).getPrivilegeLevel(), false});
                }catch(DoesNotExistException ex)
                {
                    System.out.println("Does not exist: " + ex.getMessage());
                }catch(auth.AuthorizationException aex)
                {
                    System.out.println("you do not have the proper authorization level for this content: " + aex.getMessage());
                    this.setVisible(false);
                }
        }
        userTable = new JTable(ut);
        userTable.setPreferredScrollableViewportSize(new Dimension(50, 50));
        userTable.setFillsViewportHeight(true);
    }


    public class AdminPanelTable extends DefaultTableModel
    {
        public AdminPanelTable() {
            super(new String[]{"First Name", "Last Name", "Current Level", "Make Admin"}, 0);
        }

        public Class<?> getColumnClass(int columnIndex) {
            Class clazz = String.class;
            switch (columnIndex) {
                case 3:
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
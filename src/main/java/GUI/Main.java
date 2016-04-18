/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BackEnd.EventSystem.Event;
import BackEnd.ManagerSystem.MainManager;
import BackEnd.ManagerSystem.ManagerExceptions.PrivilegeInsufficientException;
import GUI.Reportable.EventReport;
import java.awt.CardLayout;

/**
 *
 * @author sara
 */
public class Main extends javax.swing.JPanel {

    private Home home;
    private MainManager manager;
    private UserManagementPanel ump;
    private CommitteeListPanel clp;
    private MainPanel mainPanel;
    private DesignDefault dd;
    private Event selectedEvent;
    private TotalBudgetPanel bp;
    private EmailPanel ep;

    /**
     * Creates new form Main
     */
    public Main(Home home) throws PrivilegeInsufficientException {
        this.home = home;
        dd = DesignDefault.getInstance();
        initComponents();
        mainPanel = new MainPanel();
        bp = new TotalBudgetPanel();
        ump = new UserManagementPanel();
        clp = new CommitteeListPanel();
        ep = new EmailPanel();

        SwitchingPanelHolder.add(mainPanel, "home");
        SwitchingPanelHolder.add(clp, "committees");
        SwitchingPanelHolder.add(ep, "email");
        SwitchingPanelHolder.add(bp, "budget");
        SwitchingPanelHolder.add(ump, "userManagement");

        manager = MainManager.getInstance();
        selectedEvent = manager.getEventManager().getSelectedEvent();
        this.setSize(dd.getFrameDimension());
        this.setBackground(dd.getBGColor());
        updateInfo();
    }

    public void updateInfo() {
        Event event = manager.getEventManager().getSelectedEvent();
        taskProgressValueLabel.setText(selectedEvent.getTotalTaskProgress() + "%");
        expenseValueLabel.setText("$" + String.format("%,.2f", selectedEvent.getTotalEventExpense()));
        incomeValueLabel.setText("$" + String.format("%,.2f", selectedEvent.getTotalEventIncome()));
        double totalEventBudget = selectedEvent.getTotalEventBudget();
        if (totalEventBudget >= 0) {
            totalValueLabel.setText("$" + String.format("%,.2f", selectedEvent.getTotalEventBudget()));
        } else {
            totalValueLabel.setText("-$" + String.format("%,.2f", Math.abs(selectedEvent.getTotalEventBudget())));
        }
    }

    public UserManagementPanel getUserManagementPanel() {
        return ump;
    }

    public void setCommitteeView() {
        mainPanel.setNonAdminOrganizerView();
        clp.setNonAdminOrganizerView();
        ump.setNonAdminView();
        reportPanel.setVisible(false);
        budgetPanel.setVisible(false);
        tasksPanel.setVisible(false);
    }

    public void setParticipantView() {
        setCommitteeView();
        committeesPanel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tasksPanel = new javax.swing.JPanel();
        taskProgressLabel = new javax.swing.JLabel();
        taskProgressValueLabel = new javax.swing.JLabel();
        committeesPanel = new javax.swing.JPanel();
        committeesLabel = new javax.swing.JLabel();
        changeCommitteesButton = new javax.swing.JButton();
        participantsPanel = new javax.swing.JPanel();
        accountManagementLabel = new javax.swing.JLabel();
        changeUserManagementButton = new javax.swing.JButton();
        reportPanel = new javax.swing.JPanel();
        eventReportLabel = new javax.swing.JLabel();
        viewEventButton = new javax.swing.JButton();
        budgetPanel = new javax.swing.JPanel();
        budgetLabel = new javax.swing.JLabel();
        incomeLabel = new javax.swing.JLabel();
        expenseLabel = new javax.swing.JLabel();
        changeBudgetButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        incomeValueLabel = new javax.swing.JLabel();
        expenseValueLabel = new javax.swing.JLabel();
        totalValueLabel = new javax.swing.JLabel();
        emailPanel = new javax.swing.JPanel();
        emailButton = new javax.swing.JButton();
        contactLabel = new javax.swing.JLabel();
        eventManagementLabel = new javax.swing.JLabel();
        SwitchingPanelHolder = new javax.swing.JPanel();
        ChangeHomeButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(160, 160, 160));
        setMaximumSize(new java.awt.Dimension(960, 680));
        setMinimumSize(new java.awt.Dimension(960, 680));
        setPreferredSize(new java.awt.Dimension(960, 680));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        tasksPanel.setBackground(dd.getPanelBGColor());
        tasksPanel.setMaximumSize(new java.awt.Dimension(160, 80));
        tasksPanel.setMinimumSize(new java.awt.Dimension(160, 80));
        tasksPanel.setPreferredSize(new java.awt.Dimension(160, 80));

        taskProgressLabel.setFont(dd.getStandardText());
        taskProgressLabel.setText("Task Progress");

        taskProgressValueLabel.setText("temp");

        org.jdesktop.layout.GroupLayout tasksPanelLayout = new org.jdesktop.layout.GroupLayout(tasksPanel);
        tasksPanel.setLayout(tasksPanelLayout);
        tasksPanelLayout.setHorizontalGroup(
            tasksPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tasksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(tasksPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tasksPanelLayout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(taskProgressValueLabel))
                    .add(taskProgressLabel))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        tasksPanelLayout.setVerticalGroup(
            tasksPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tasksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(taskProgressLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(taskProgressValueLabel)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        committeesPanel.setBackground(dd.getPanelBGColor());
        committeesPanel.setMaximumSize(new java.awt.Dimension(160, 80));
        committeesPanel.setMinimumSize(new java.awt.Dimension(160, 80));
        committeesPanel.setPreferredSize(new java.awt.Dimension(160, 80));

        committeesLabel.setFont(dd.getStandardText());
        committeesLabel.setText("Committees");

        changeCommitteesButton.setFont(dd.getStandardText());
        changeCommitteesButton.setText("Manage");
        changeCommitteesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeCommitteesButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout committeesPanelLayout = new org.jdesktop.layout.GroupLayout(committeesPanel);
        committeesPanel.setLayout(committeesPanelLayout);
        committeesPanelLayout.setHorizontalGroup(
            committeesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(committeesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(committeesLabel)
                .addContainerGap(94, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, committeesPanelLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .add(changeCommitteesButton)
                .addContainerGap())
        );
        committeesPanelLayout.setVerticalGroup(
            committeesPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(committeesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(committeesLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 21, Short.MAX_VALUE)
                .add(changeCommitteesButton)
                .addContainerGap())
        );

        participantsPanel.setBackground(dd.getPanelBGColor());
        participantsPanel.setMaximumSize(new java.awt.Dimension(160, 80));
        participantsPanel.setMinimumSize(new java.awt.Dimension(160, 80));
        participantsPanel.setPreferredSize(new java.awt.Dimension(160, 80));

        accountManagementLabel.setFont(dd.getStandardText());
        accountManagementLabel.setText("Account Management");

        changeUserManagementButton.setFont(dd.getStandardText());
        changeUserManagementButton.setMinimumSize(dd.getBigButtonDimension());
        changeUserManagementButton.setText("Edit");
        changeUserManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUserManagementButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout participantsPanelLayout = new org.jdesktop.layout.GroupLayout(participantsPanel);
        participantsPanel.setLayout(participantsPanelLayout);
        participantsPanelLayout.setHorizontalGroup(
            participantsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(participantsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(accountManagementLabel)
                .addContainerGap(46, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, participantsPanelLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .add(changeUserManagementButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        participantsPanelLayout.setVerticalGroup(
            participantsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(participantsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(accountManagementLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 21, Short.MAX_VALUE)
                .add(changeUserManagementButton)
                .addContainerGap())
        );

        setSize(71,23);

        reportPanel.setBackground(dd.getPanelBGColor());
        reportPanel.setMaximumSize(new java.awt.Dimension(160, 80));
        reportPanel.setMinimumSize(new java.awt.Dimension(160, 80));
        reportPanel.setPreferredSize(new java.awt.Dimension(160, 80));

        eventReportLabel.setFont(dd.getStandardText());
        eventReportLabel.setText("Event Report");

        viewEventButton.setFont(dd.getStandardText());
        viewEventButton.setText("View");
        viewEventButton.setPreferredSize(new java.awt.Dimension(71, 23));
        viewEventButton.setMinimumSize(dd.getBigButtonDimension());
        viewEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEventButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout reportPanelLayout = new org.jdesktop.layout.GroupLayout(reportPanel);
        reportPanel.setLayout(reportPanelLayout);
        reportPanelLayout.setHorizontalGroup(
            reportPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(reportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(eventReportLabel)
                .addContainerGap(86, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, reportPanelLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .add(viewEventButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        reportPanelLayout.setVerticalGroup(
            reportPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(reportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(eventReportLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 21, Short.MAX_VALUE)
                .add(viewEventButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(71,23);

        budgetPanel.setBackground(dd.getPanelBGColor());
        budgetPanel.setMaximumSize(new java.awt.Dimension(160, 160));
        budgetPanel.setMinimumSize(new java.awt.Dimension(160, 160));
        budgetPanel.setPreferredSize(new java.awt.Dimension(160, 160));

        budgetLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        budgetLabel.setText("Budget");

        incomeLabel.setText("Income :");

        expenseLabel.setText("Expenses :");

        changeBudgetButton.setFont(dd.getStandardText());
        changeBudgetButton.setText("Details");
        changeBudgetButton.setPreferredSize(new java.awt.Dimension(71, 23));
        changeBudgetButton.setMinimumSize(dd.getBigButtonDimension());
        changeBudgetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBudgetButtonActionPerformed(evt);
            }
        });

        totalLabel.setText("Total :");

        incomeValueLabel.setText("temp");

        expenseValueLabel.setText("temp");

        totalValueLabel.setText("temp");

        org.jdesktop.layout.GroupLayout budgetPanelLayout = new org.jdesktop.layout.GroupLayout(budgetPanel);
        budgetPanel.setLayout(budgetPanelLayout);
        budgetPanelLayout.setHorizontalGroup(
            budgetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(budgetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(budgetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, budgetPanelLayout.createSequentialGroup()
                        .add(0, 69, Short.MAX_VALUE)
                        .add(changeBudgetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(budgetPanelLayout.createSequentialGroup()
                        .add(budgetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(budgetLabel)
                            .add(budgetPanelLayout.createSequentialGroup()
                                .add(incomeLabel)
                                .add(18, 18, 18)
                                .add(incomeValueLabel))
                            .add(budgetPanelLayout.createSequentialGroup()
                                .add(budgetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(expenseLabel)
                                    .add(totalLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(budgetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(totalValueLabel)
                                    .add(expenseValueLabel))))
                        .add(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
        );
        budgetPanelLayout.setVerticalGroup(
            budgetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(budgetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(budgetLabel)
                .add(18, 18, 18)
                .add(budgetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(incomeLabel)
                    .add(incomeValueLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(budgetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(expenseLabel)
                    .add(expenseValueLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(budgetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(totalLabel)
                    .add(totalValueLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 25, Short.MAX_VALUE)
                .add(changeBudgetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(71,23);

        emailPanel.setBackground(dd.getPanelBGColor());
        emailPanel.setMaximumSize(new java.awt.Dimension(160, 80));
        emailPanel.setMinimumSize(new java.awt.Dimension(160, 80));
        emailPanel.setPreferredSize(new java.awt.Dimension(160, 80));

        emailButton.setFont(dd.getStandardText());
        emailButton.setText("Email");
        emailButton.setPreferredSize(new java.awt.Dimension(71, 23));
        emailButton.setMinimumSize(dd.getBigButtonDimension());
        emailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailButtonActionPerformed(evt);
            }
        });

        contactLabel.setFont(dd.getStandardText());
        contactLabel.setText("Contact");

        org.jdesktop.layout.GroupLayout emailPanelLayout = new org.jdesktop.layout.GroupLayout(emailPanel);
        emailPanel.setLayout(emailPanelLayout);
        emailPanelLayout.setHorizontalGroup(
            emailPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, emailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(contactLabel)
                .addContainerGap(112, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, emailPanelLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .add(emailButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        emailPanelLayout.setVerticalGroup(
            emailPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(emailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(contactLabel)
                .add(18, 18, 18)
                .add(emailButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        setSize(71,23);

        eventManagementLabel.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        eventManagementLabel.setText("Event Management");

        SwitchingPanelHolder.setMaximumSize(new java.awt.Dimension(760, 620));
        SwitchingPanelHolder.setMinimumSize(new java.awt.Dimension(760, 620));
        SwitchingPanelHolder.setPreferredSize(new java.awt.Dimension(760, 620));
        SwitchingPanelHolder.setLayout(new java.awt.CardLayout());

        ChangeHomeButton.setText("Home");
        ChangeHomeButton.setMaximumSize(new java.awt.Dimension(75, 25));
        ChangeHomeButton.setMinimumSize(new java.awt.Dimension(75, 25));
        ChangeHomeButton.setPreferredSize(new java.awt.Dimension(75, 25));
        ChangeHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeHomeButtonActionPerformed(evt);
            }
        });

        logOutButton.setText("Log Out");
        logOutButton.setMaximumSize(new java.awt.Dimension(150, 25));
        logOutButton.setMinimumSize(new java.awt.Dimension(150, 25));
        logOutButton.setPreferredSize(new java.awt.Dimension(150, 25));
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(ChangeHomeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(224, 224, 224)
                        .add(eventManagementLabel)
                        .add(232, 232, 232)
                        .add(logOutButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(SwitchingPanelHolder, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(emailPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(reportPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, committeesPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(participantsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(12, 12, 12))
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, tasksPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, budgetPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(layout.createSequentialGroup()
                        .add(reportPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(committeesPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(participantsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(emailPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(eventManagementLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(logOutButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, ChangeHomeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(171, 171, 171)
                                .add(budgetPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(tasksPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(SwitchingPanelHolder, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 620, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void emailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailButtonActionPerformed
        CardLayout cl = (CardLayout) (SwitchingPanelHolder.getLayout());
        cl.show(SwitchingPanelHolder, "email");
    }//GEN-LAST:event_emailButtonActionPerformed

    private void changeBudgetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBudgetButtonActionPerformed
        bp.updateInfo();
        CardLayout cl = (CardLayout) (SwitchingPanelHolder.getLayout());
        cl.show(SwitchingPanelHolder, "budget");
    }//GEN-LAST:event_changeBudgetButtonActionPerformed

    private void viewEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEventButtonActionPerformed
        // TODO add your handling code here:
        EventReport ed = new EventReport(null, true);
        ed.setVisible(true);
    }//GEN-LAST:event_viewEventButtonActionPerformed

    private void ChangeHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeHomeButtonActionPerformed
        CardLayout cl = (CardLayout) (SwitchingPanelHolder.getLayout());
        cl.show(SwitchingPanelHolder, "home");
        mainPanel.switchToCal(); //forces panel to display Calendar
    }//GEN-LAST:event_ChangeHomeButtonActionPerformed

    private void changeUserManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUserManagementButtonActionPerformed
        CardLayout cl = (CardLayout) (SwitchingPanelHolder.getLayout());
        cl.show(SwitchingPanelHolder, "userManagement");
    }//GEN-LAST:event_changeUserManagementButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        home.logOut();
    }//GEN-LAST:event_logOutButtonActionPerformed

private void changeCommitteesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeCommitteesButtonActionPerformed
        CardLayout cl = (CardLayout) (SwitchingPanelHolder.getLayout());
        cl.show(SwitchingPanelHolder, "committees");
}//GEN-LAST:event_changeCommitteesButtonActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        updateInfo();
    }//GEN-LAST:event_formMouseMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChangeHomeButton;
    private javax.swing.JPanel SwitchingPanelHolder;
    private javax.swing.JLabel accountManagementLabel;
    private javax.swing.JLabel budgetLabel;
    private javax.swing.JPanel budgetPanel;
    private javax.swing.JButton changeBudgetButton;
    private javax.swing.JButton changeCommitteesButton;
    private javax.swing.JButton changeUserManagementButton;
    private javax.swing.JLabel committeesLabel;
    private javax.swing.JPanel committeesPanel;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JButton emailButton;
    private javax.swing.JPanel emailPanel;
    private javax.swing.JLabel eventManagementLabel;
    private javax.swing.JLabel eventReportLabel;
    private javax.swing.JLabel expenseLabel;
    private javax.swing.JLabel expenseValueLabel;
    private javax.swing.JLabel incomeLabel;
    private javax.swing.JLabel incomeValueLabel;
    private javax.swing.JButton logOutButton;
    private javax.swing.JPanel participantsPanel;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JLabel taskProgressLabel;
    private javax.swing.JLabel taskProgressValueLabel;
    private javax.swing.JPanel tasksPanel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalValueLabel;
    private javax.swing.JButton viewEventButton;
    // End of variables declaration//GEN-END:variables
}
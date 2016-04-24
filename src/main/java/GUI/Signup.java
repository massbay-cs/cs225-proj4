/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BackEnd.ManagerSystem.MainManager;
import BackEnd.ManagerSystem.ManagerExceptions.DuplicateEmailException;
import BackEnd.ManagerSystem.UserManager;
import BackEnd.UserSystem.UserExceptions.IllegalCharacterException;
import BackEnd.UserSystem.UserExceptions.PasswordMismatchError;
import BackEnd.UserSystem.UserExceptions.PhoneNumberInvalidLengthException;
import BackEnd.UserSystem.UserExceptions.PhoneNumberNonNumericException;
import BackEnd.UserSystem.UserExceptions.ZipCodeInvalidFormatException;
import BackEnd.UserSystem.UserExceptions.ZipCodeInvalidLengthException;
import BackEnd.UserSystem.PhoneNumber;
import BackEnd.UserSystem.User;
import auth.AuthorizationException;
import auth.PrivilegeLevel;
import exception.UpdateException;

import java.awt.*;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author sara
 */
public class Signup extends javax.swing.JPanel {

    private UserManager userManager;
    private JDialog parentDialog;
    private boolean firstRun;
    private final String FIRST_NAME_FIELD = "First";
    private final String LAST_NAME_FIELD = "Last";
    private final String PHONE_NUMBER_FIELD = "(XXX) XXX - XXXX";
    private final String STREET_FIELD = "Street";
    private final String CITY_FIELD = "City";
    private final String STATE_FIELD = "State";
    private final String ZIP_CODE_FIELD = "Zip Code";
    private final String COUNTRY_FIELD = "Country";

    /**
     * Creates new form Signup
     */
    public Signup(JDialog parentDialog) {
        this.parentDialog = parentDialog;
        MainManager mainManager = MainManager.getInstance();
        userManager = mainManager.getUserManager();
        firstRun = true;
        if (userManager.getUserList().isEmpty()) {
            JOptionPane.showMessageDialog(this, "This first account you create will be an administrator.");
        }
        initComponents();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signinLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        informationLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        reenterPasswordLabel = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        streetField = new javax.swing.JTextField();
        cityField = new javax.swing.JTextField();
        stateField = new javax.swing.JTextField();
        countryField = new javax.swing.JTextField();
        zipCodeField = new javax.swing.JTextField();
        signupLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        signupButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        reenterPassWordField = new javax.swing.JPasswordField();
        nameAsterisk = new javax.swing.JLabel();
        emailAsterisk = new javax.swing.JLabel();
        passwordAsterisk = new javax.swing.JLabel();
        reEnterPasswordAsterisk = new javax.swing.JLabel();
        requiredFields = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(800, 600));

        signinLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        signinLabel.setText("How would you like to sign in?");

        nameLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        nameLabel.setText("Name");

        phoneNumberLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        phoneNumberLabel.setText("Phone Number");

        //<editor-fold desc="The code below is used to initially add text and text color to form fields">
        firstNameField.setText(FIRST_NAME_FIELD);
        firstNameField.setForeground(java.awt.Color.gray);
        firstNameField.setPreferredSize(new java.awt.Dimension(380, 28));
        firstNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameFieldFocusLost(evt);
            }
        });

        lastNameField.setText(LAST_NAME_FIELD);
        lastNameField.setForeground(java.awt.Color.gray);
        lastNameField.setPreferredSize(new java.awt.Dimension(360, 28));
        lastNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameFieldFocusLost(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        emailLabel.setText("Email");

        informationLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        informationLabel.setText("What is your information?");

        passwordLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        passwordLabel.setText("Create a password");

        reenterPasswordLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        reenterPasswordLabel.setText("Re-enter password");

        phoneNumberField.setText(PHONE_NUMBER_FIELD);
        phoneNumberField.setForeground(java.awt.Color.gray);
        phoneNumberField.setPreferredSize(new java.awt.Dimension(380, 28));
        phoneNumberField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phoneNumberFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                phoneNumberFieldFocusLost(evt);
            }
        });

        addressLabel.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        addressLabel.setText("Address");

        streetField.setText(STREET_FIELD);
        streetField.setForeground(java.awt.Color.gray);
        streetField.setPreferredSize(new java.awt.Dimension(380, 28));
        streetField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                streetFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                streetFieldFocusLost(evt);
            }
        });

        cityField.setText(CITY_FIELD);
        cityField.setForeground(java.awt.Color.gray);
        cityField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cityFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cityFieldFocusLost(evt);
            }
        });

        stateField.setText(STATE_FIELD);
        stateField.setForeground(java.awt.Color.gray);
        stateField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stateFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stateFieldFocusLost(evt);
            }
        });

        countryField.setText(COUNTRY_FIELD);
        countryField.setForeground(java.awt.Color.gray);
        countryField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                countryFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                countryFieldFocusLost(evt);
            }
        });

        zipCodeField.setText(ZIP_CODE_FIELD);
        zipCodeField.setForeground(java.awt.Color.gray);
        zipCodeField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                zipCodeFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                zipCodeFieldFocusLost(evt);
            }
        });
        //</editor-fold>

        signupLabel.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        signupLabel.setText("Sign up");
        signupLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        signupButton.setText("Sign up");
        signupButton.setActionCommand("signup");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        nameAsterisk.setText("*");

        emailAsterisk.setText("*");

        passwordAsterisk.setText("*");

        reEnterPasswordAsterisk.setText("*");

        requiredFields.setText("* Indicates required fields");

        // For documentation on org.jdesktop.layout.GroupLayout visit:
        // http://javadox.com/org.swinglabs/swing-layout/1.0.3/org/jdesktop/layout/GroupLayout.html
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        System.out.println("what is this " + this.toString());
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(signupLabel)
                    .add(informationLabel)
                    .add(layout.createSequentialGroup()
                        .add(nameLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(nameAsterisk, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(phoneNumberLabel)
                    .add(addressLabel)
                    .add(layout.createSequentialGroup()
                        .add(cityField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 185, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(stateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(zipCodeField))
                    .add(streetField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(phoneNumberField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lastNameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(firstNameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(countryField))
                .add(18, 18, 18)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 30, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, signinLabel)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(emailLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(emailAsterisk, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(passwordLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(passwordAsterisk, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(reenterPasswordLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(reEnterPasswordAsterisk, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, emailField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, passwordField)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, reenterPassWordField)
                    .add(layout.createSequentialGroup()
                        .add(requiredFields)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(signupButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cancelButton)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(47, 47, 47)
                .add(signupLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(informationLabel)
                            .add(signinLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(emailLabel)
                                .add(emailAsterisk))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(nameLabel)
                                .add(nameAsterisk)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(emailField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 50, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(passwordLabel)
                                    .add(passwordAsterisk))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(reenterPasswordLabel)
                                    .add(reEnterPasswordAsterisk))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(reenterPassWordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(12, 12, 12)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                            .add(signupButton)
                                            .add(cancelButton)))
                                    .add(layout.createSequentialGroup()
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(requiredFields)))
                                .add(269, 269, 269))
                            .add(layout.createSequentialGroup()
                                .add(firstNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(lastNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(phoneNumberLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(phoneNumberField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(addressLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(streetField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(cityField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(stateField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(zipCodeField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(countryField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .add(layout.createSequentialGroup()
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 318, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))))
        );

        // Set focus traversal Policy to true for this panel, otherwise it returns null for getFocusTraversalPolicy()
        this.setFocusTraversalPolicyProvider(true);
        // Stores the TAB focus order of the form
        Vector<Component> order = new Vector<Component>(13);
        order.add(firstNameField);
        order.add(lastNameField);
        order.add(phoneNumberField);
        order.add(streetField);
        order.add(cityField);
        order.add(stateField);
        order.add(zipCodeField);
        order.add(countryField);
        order.add(emailField);
        order.add(passwordField);
        order.add(reenterPassWordField);
        order.add(signupButton);
        order.add(cancelButton);

        // Creates new policy using MyOwnFocusTraversalPolicy, a subclass of FocusTraversalPolicy
        newPolicy = new MyOwnFocusTraversalPolicy(order);
        this.setFocusTraversalPolicy(newPolicy);
    }// </editor-fold>//GEN-END:initComponents

    // Change made by Syed
    
    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed

        if (firstNameField.getText().equals("") || firstNameField.getText().equals(FIRST_NAME_FIELD)
                || lastNameField.getText().equals("") || lastNameField.getText().equals(LAST_NAME_FIELD)
                || emailField.getText().equals("")
                || new String(passwordField.getPassword()).equals("")
                || new String(reenterPassWordField.getPassword()).equals("")) {
            String message = "Please fill out all the required fields.";
            JOptionPane.showMessageDialog(this, message);
        }
        
        else {

            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String street, city, state, zipCode, country, phoneNumber;
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String reenterPassword = new String(reenterPassWordField.getPassword());

            if (streetField.getText().equals(STREET_FIELD)) {
                street = "";
            } else {
                street = streetField.getText();
            }

            if (cityField.getText().equals(CITY_FIELD)) {
                city = "";
            } else {
                city = cityField.getText();
            }
            
            if (stateField.getText().equals(STATE_FIELD)) {
                state = "";
            } else {
                state = stateField.getText();
            }
            
            if (zipCodeField.getText().equals(ZIP_CODE_FIELD)) {
                zipCode = "";
            } else {
                zipCode = zipCodeField.getText();
            }
            
            if (countryField.getText().equals(COUNTRY_FIELD)) {
                country = "";
            } else {
                country = countryField.getText();
            }
            
            if (phoneNumberField.getText().equals(PHONE_NUMBER_FIELD)) {
                phoneNumber = "";
            } else {
                phoneNumber = phoneNumberField.getText();
            }

            try {
                User newUser = new User(firstName, lastName,
                        email, password, reenterPassword);
                newUser.getAddress().setStreet(street);
                newUser.getAddress().setCity(city);
                newUser.getAddress().setState(state);
                newUser.getAddress().setZipCode(zipCode);
                newUser.getAddress().setCountry(country);
                newUser.setPhoneNumber(new PhoneNumber(phoneNumber));

                if (userManager.getUserList().isEmpty()) {
                    newUser.setPrivilegeLevel(PrivilegeLevel.ADMIN);
                }
   
                newUser = userManager.createUser(newUser);
                parentDialog.dispose();
            }
            catch (PasswordMismatchError error) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
            }
            catch (IllegalCharacterException error) {
                JOptionPane.showMessageDialog(this, "Illegal characters found.");
            }
            catch (PhoneNumberInvalidLengthException error) {
                JOptionPane.showMessageDialog(this, "Please enter a valid phone number.");
            }
            catch (PhoneNumberNonNumericException error) {
                JOptionPane.showMessageDialog(this, "Please enter a valid phone number.");
            }
            catch (ZipCodeInvalidFormatException error) {
                JOptionPane.showMessageDialog(this, "Please enter a valid zip code.");
            }
            catch (ZipCodeInvalidLengthException error) {
                JOptionPane.showMessageDialog(this, "Please enter a valid zip code.");
            }
            catch (AuthorizationException error){
                JOptionPane.showMessageDialog(this, "You are not authorized to do this.");
            }
        }
    }//GEN-LAST:event_signupButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        parentDialog.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed


    //<editor-fold desc="The code below pertains to gaining and losing focus for the fields on the left side of the form">
    private void firstNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameFieldFocusLost
        if (firstNameField.getText().equals("") || firstNameField.getText().equals(FIRST_NAME_FIELD)) {
            firstNameField.setForeground(Color.gray);
            firstNameField.setText(FIRST_NAME_FIELD);
        }
    }//GEN-LAST:event_firstNameFieldFocusLost

    private void lastNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFieldFocusGained
        if (lastNameField.getText().equals(LAST_NAME_FIELD)) {
            lastNameField.setText("");
            lastNameField.setForeground(Color.black);
        }
    }//GEN-LAST:event_lastNameFieldFocusGained

    private void lastNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFieldFocusLost
        if (lastNameField.getText().equals("") || lastNameField.getText().equals(LAST_NAME_FIELD)) {
            lastNameField.setForeground(Color.gray);
            lastNameField.setText(LAST_NAME_FIELD);
        }
    }//GEN-LAST:event_lastNameFieldFocusLost

    private void phoneNumberFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneNumberFieldFocusGained
        if (phoneNumberField.getText().equals(PHONE_NUMBER_FIELD)) {
            phoneNumberField.setText("");
            phoneNumberField.setForeground(Color.black);
        }
    }//GEN-LAST:event_phoneNumberFieldFocusGained

    private void phoneNumberFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneNumberFieldFocusLost
        if (phoneNumberField.getText().equals("") || phoneNumberField.getText().equals(PHONE_NUMBER_FIELD)) {
            phoneNumberField.setForeground(Color.gray);
            phoneNumberField.setText(PHONE_NUMBER_FIELD);
        }
    }//GEN-LAST:event_phoneNumberFieldFocusLost

    private void streetFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_streetFieldFocusGained
        if (streetField.getText().equals(STREET_FIELD)) {
            streetField.setText("");
            streetField.setForeground(Color.black);
        }
    }//GEN-LAST:event_streetFieldFocusGained

    private void streetFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_streetFieldFocusLost
        if (streetField.getText().equals("") || streetField.getText().equals(STREET_FIELD)) {
            streetField.setForeground(Color.gray);
            streetField.setText(STREET_FIELD);
        }
    }//GEN-LAST:event_streetFieldFocusLost

    private void cityFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFieldFocusGained
        if (cityField.getText().equals(CITY_FIELD)) {
            cityField.setText("");
            cityField.setForeground(Color.black);
        }
    }//GEN-LAST:event_cityFieldFocusGained

    private void cityFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFieldFocusLost
        if (cityField.getText().equals("") || cityField.getText().equals(CITY_FIELD)) {
            cityField.setForeground(Color.gray);
            cityField.setText(CITY_FIELD);
        }
    }//GEN-LAST:event_cityFieldFocusLost

    private void stateFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stateFieldFocusGained
        if (stateField.getText().equals(STATE_FIELD)) {
            stateField.setText("");
            stateField.setForeground(Color.black);
        }
    }//GEN-LAST:event_stateFieldFocusGained

    private void stateFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stateFieldFocusLost
        if (stateField.getText().equals("") || stateField.getText().equals(STATE_FIELD)) {
            stateField.setForeground(Color.gray);
            stateField.setText(STATE_FIELD);
        }
    }//GEN-LAST:event_stateFieldFocusLost

    private void zipCodeFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_zipCodeFieldFocusGained
        if (zipCodeField.getText().equals(ZIP_CODE_FIELD)) {
            zipCodeField.setText("");
            zipCodeField.setForeground(Color.black);
        }
    }//GEN-LAST:event_zipCodeFieldFocusGained

    private void zipCodeFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_zipCodeFieldFocusLost
        if (zipCodeField.getText().equals("") || zipCodeField.getText().equals(ZIP_CODE_FIELD)) {
            zipCodeField.setForeground(Color.gray);
            zipCodeField.setText(ZIP_CODE_FIELD);
        }
    }//GEN-LAST:event_zipCodeFieldFocusLost

    private void countryFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryFieldFocusGained
        if (countryField.getText().equals(COUNTRY_FIELD)) {
            countryField.setText("");
            countryField.setForeground(Color.black);
        }
    }//GEN-LAST:event_countryFieldFocusGained

    private void countryFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryFieldFocusLost
        if (countryField.getText().equals("") || countryField.getText().equals(COUNTRY_FIELD)) {
            countryField.setForeground(Color.gray);
            countryField.setText(COUNTRY_FIELD);
        }
    }//GEN-LAST:event_countryFieldFocusLost

    // There is a slight difference here between firstNameFieldFocusGained, and every other FieldFocusGained,
    // when the sign-up form first becomes visible, a check is run if this is the first run, if so,
    // the content of the field are selected.
    private void firstNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameFieldFocusGained
        if (firstRun) {
            firstRun = false;
            firstNameField.selectAll();
            firstNameField.setForeground(Color.black);
        } else if (firstNameField.getText().equals(FIRST_NAME_FIELD)) {
            firstNameField.setText("");
            firstNameField.setForeground(Color.black);
        }
    }//GEN-LAST:event_firstNameFieldFocusGained
    //</editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cityField;
    private javax.swing.JTextField countryField;
    private javax.swing.JLabel emailAsterisk;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel nameAsterisk;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel passwordAsterisk;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel reEnterPasswordAsterisk;
    private javax.swing.JPasswordField reenterPassWordField;
    private javax.swing.JLabel reenterPasswordLabel;
    private javax.swing.JLabel requiredFields;
    private javax.swing.JLabel signinLabel;
    private javax.swing.JButton signupButton;
    private javax.swing.JLabel signupLabel;
    private javax.swing.JTextField stateField;
    private javax.swing.JTextField streetField;
    private javax.swing.JTextField zipCodeField;
    // End of variables declaration//GEN-END:variables
    static MyOwnFocusTraversalPolicy newPolicy;


    /**
     * This snippet is taken of code, was taken from, http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/FocusTraversalDemoProject/src/misc/FocusTraversalDemo.java
     * For an explanation and a good demo, go to http://docs.oracle.com/javase/tutorial/uiswing/misc/focus.html
     */
    public static class MyOwnFocusTraversalPolicy
            extends FocusTraversalPolicy
    {
        Vector<Component> order;

        public MyOwnFocusTraversalPolicy(Vector<Component> order) {
            this.order = new Vector<Component>(order.size());
            this.order.addAll(order);
        }
        public Component getComponentAfter(Container focusCycleRoot,
                                           Component aComponent)
        {
            int idx = (order.indexOf(aComponent) + 1) % order.size();
            return order.get(idx);
        }

        public Component getComponentBefore(Container focusCycleRoot,
                                            Component aComponent)
        {
            int idx = order.indexOf(aComponent) - 1;
            if (idx < 0) {
                idx = order.size() - 1;
            }
            return order.get(idx);
        }

        public Component getDefaultComponent(Container focusCycleRoot) {
            return order.get(0);
        }

        public Component getLastComponent(Container focusCycleRoot) {
            return order.lastElement();
        }

        public Component getFirstComponent(Container focusCycleRoot) {
            return order.get(0);
        }
    }
}
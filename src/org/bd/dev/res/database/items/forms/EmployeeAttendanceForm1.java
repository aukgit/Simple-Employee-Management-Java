/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EmployeeAttendanceForm.java
 *
 * Created on Dec 26, 2011, 11:50:59 PM
 */
package org.bd.dev.res.database.items.forms;

import java.awt.EventQueue;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;



import javax.swing.*;
import java.awt.Component;
import org.bd.dev.res.database.items.Employee;
import org.bd.dev.restaurantmanagement.mainpackage.QueryTypes;
import org.bd.dev.restaurantmanagement.mainpackage.SearchForm;
import org.eclipse.persistence.config.QueryType;

/**
 *
 * @author Alim
 */
public class EmployeeAttendanceForm1 extends CommonJPanel {

    public EmployeeAttendanceForm1() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }


        EmployeeIDCombo.setRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Employee) {
                    Employee mec = (Employee) value;
                    setText(mec.getEmployeeName());
                }
                return this;
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(org.bd.dev.restaurantmanagement.mainpackage.RestaurantManagementApp.class).getContext().getResourceMap(EmployeeAttendanceForm1.class);
        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory(resourceMap.getString("entityManager.persistenceUnit")).createEntityManager(); // NOI18N
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery(resourceMap.getString("query.query")); // NOI18N
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        employeeQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM Employee e");
        employeeList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : employeeQuery.getResultList();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        attendanceIdLabel = new javax.swing.JLabel();
        employeeIdLabel = new javax.swing.JLabel();
        workingHoursLabel = new javax.swing.JLabel();
        workingDateLabel = new javax.swing.JLabel();
        shouldStartLabel = new javax.swing.JLabel();
        shouldEndLabel = new javax.swing.JLabel();
        loginTimeLabel = new javax.swing.JLabel();
        logoutTimeLabel = new javax.swing.JLabel();
        attendanceIdField = new javax.swing.JTextField();
        workingHoursField = new javax.swing.JTextField();
        workingDateField = new javax.swing.JTextField();
        shouldStartField = new javax.swing.JTextField();
        shouldEndField = new javax.swing.JTextField();
        loginTimeField = new javax.swing.JTextField();
        logoutTimeField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        EmployeeIDCombo = new javax.swing.JComboBox();
        newButton1 = new javax.swing.JButton();
        EmployeeSearchTextbOx = new javax.swing.JTextField();
        attendanceIdLabel1 = new javax.swing.JLabel();
        employeeIDLabel = new javax.swing.JLabel();
        EmployeIDSearchInGrid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        FormListener formListener = new FormListener();

        setName("Form"); // NOI18N

        masterScrollPane.setName("masterScrollPane"); // NOI18N

        masterTable.setName("masterTable"); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${attendanceId}"));
        columnBinding.setColumnName("Attendance Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employeeId.employeeName}"));
        columnBinding.setColumnName("Employee Id.employee Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${workingHours}"));
        columnBinding.setColumnName("Working Hours");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${workingDate}"));
        columnBinding.setColumnName("Working Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${shouldStart}"));
        columnBinding.setColumnName("Should Start");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${shouldEnd}"));
        columnBinding.setColumnName("Should End");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${loginTime}"));
        columnBinding.setColumnName("Login Time");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${logoutTime}"));
        columnBinding.setColumnName("Logout Time");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);
        masterTable.getColumnModel().getColumn(0).setMinWidth(80);
        masterTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        masterTable.getColumnModel().getColumn(0).setMaxWidth(80);
        masterTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("masterTable.columnModel.title0")); // NOI18N
        masterTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        masterTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("masterTable.columnModel.title1")); // NOI18N
        masterTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("masterTable.columnModel.title2")); // NOI18N
        masterTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("masterTable.columnModel.title3")); // NOI18N
        masterTable.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("masterTable.columnModel.title4")); // NOI18N
        masterTable.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("masterTable.columnModel.title5")); // NOI18N
        masterTable.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("masterTable.columnModel.title6")); // NOI18N
        masterTable.getColumnModel().getColumn(7).setHeaderValue(resourceMap.getString("masterTable.columnModel.title7")); // NOI18N

        attendanceIdLabel.setText(resourceMap.getString("attendanceIdLabel.text")); // NOI18N
        attendanceIdLabel.setName("attendanceIdLabel"); // NOI18N

        employeeIdLabel.setText(resourceMap.getString("employeeIdLabel.text")); // NOI18N
        employeeIdLabel.setName("employeeIdLabel"); // NOI18N

        workingHoursLabel.setText(resourceMap.getString("workingHoursLabel.text")); // NOI18N
        workingHoursLabel.setName("workingHoursLabel"); // NOI18N

        workingDateLabel.setText(resourceMap.getString("workingDateLabel.text")); // NOI18N
        workingDateLabel.setName("workingDateLabel"); // NOI18N

        shouldStartLabel.setText(resourceMap.getString("shouldStartLabel.text")); // NOI18N
        shouldStartLabel.setName("shouldStartLabel"); // NOI18N

        shouldEndLabel.setText(resourceMap.getString("shouldEndLabel.text")); // NOI18N
        shouldEndLabel.setName("shouldEndLabel"); // NOI18N

        loginTimeLabel.setText(resourceMap.getString("loginTimeLabel.text")); // NOI18N
        loginTimeLabel.setName("loginTimeLabel"); // NOI18N

        logoutTimeLabel.setText(resourceMap.getString("logoutTimeLabel.text")); // NOI18N
        logoutTimeLabel.setName("logoutTimeLabel"); // NOI18N

        attendanceIdField.setEditable(false);
        attendanceIdField.setName("attendanceIdField"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.attendanceId}"), attendanceIdField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), attendanceIdField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        workingHoursField.setName("workingHoursField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.workingHours}"), workingHoursField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), workingHoursField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        workingDateField.setName("workingDateField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.workingDate}"), workingDateField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), workingDateField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        shouldStartField.setName("shouldStartField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.shouldStart}"), shouldStartField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), shouldStartField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        shouldEndField.setName("shouldEndField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.shouldEnd}"), shouldEndField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), shouldEndField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        loginTimeField.setName("loginTimeField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.loginTime}"), loginTimeField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), loginTimeField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        logoutTimeField.setName("logoutTimeField"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.logoutTime}"), logoutTimeField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), logoutTimeField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.setText(resourceMap.getString("saveButton.text")); // NOI18N
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(formListener);

        refreshButton.setText(resourceMap.getString("refreshButton.text")); // NOI18N
        refreshButton.setName("refreshButton"); // NOI18N
        refreshButton.addActionListener(formListener);

        newButton.setText(resourceMap.getString("newButton.text")); // NOI18N
        newButton.setName("newButton"); // NOI18N
        newButton.addActionListener(formListener);

        deleteButton.setText(resourceMap.getString("deleteButton.text")); // NOI18N
        deleteButton.setName("deleteButton"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        EmployeeIDCombo.setName("EmployeeIDCombo"); // NOI18N

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, employeeList, EmployeeIDCombo);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.employeeId}"), EmployeeIDCombo, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(org.bd.dev.restaurantmanagement.mainpackage.RestaurantManagementApp.class).getContext().getActionMap(EmployeeAttendanceForm1.class, this);
        newButton1.setAction(actionMap.get("ShowEmployeeDetails")); // NOI18N
        newButton1.setText(resourceMap.getString("newButton1.text")); // NOI18N
        newButton1.setName("newButton1"); // NOI18N
        newButton1.addActionListener(formListener);

        EmployeeSearchTextbOx.setText(resourceMap.getString("EmployeeSearchTextbOx.text")); // NOI18N
        EmployeeSearchTextbOx.setName("EmployeeSearchTextbOx"); // NOI18N
        EmployeeSearchTextbOx.addFocusListener(formListener);
        EmployeeSearchTextbOx.addKeyListener(formListener);

        attendanceIdLabel1.setText(resourceMap.getString("attendanceIdLabel1.text")); // NOI18N
        attendanceIdLabel1.setName("attendanceIdLabel1"); // NOI18N

        employeeIDLabel.setName("employeeIDLabel"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.employeeId.employeeId}"), employeeIDLabel, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        EmployeIDSearchInGrid.setText(resourceMap.getString("EmployeIDSearchInGrid.text")); // NOI18N
        EmployeIDSearchInGrid.setName("EmployeIDSearchInGrid"); // NOI18N
        EmployeIDSearchInGrid.addKeyListener(formListener);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attendanceIdLabel)
                            .addComponent(employeeIdLabel)
                            .addComponent(workingHoursLabel)
                            .addComponent(workingDateLabel)
                            .addComponent(shouldStartLabel)
                            .addComponent(shouldEndLabel)
                            .addComponent(loginTimeLabel)
                            .addComponent(logoutTimeLabel)
                            .addComponent(attendanceIdLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(employeeIDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                                .addComponent(newButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton))
                            .addComponent(EmployeeSearchTextbOx, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(attendanceIdField, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(workingHoursField, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(workingDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(shouldStartField, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(shouldEndField, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(loginTimeField, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(logoutTimeField, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                            .addComponent(EmployeeIDCombo, 0, 688, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EmployeIDSearchInGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployeIDSearchInGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attendanceIdLabel)
                    .addComponent(attendanceIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployeeSearchTextbOx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attendanceIdLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIdLabel)
                    .addComponent(EmployeeIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workingHoursLabel)
                    .addComponent(workingHoursField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workingDateLabel)
                    .addComponent(workingDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shouldStartLabel)
                    .addComponent(shouldStartField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shouldEndLabel)
                    .addComponent(shouldEndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginTimeLabel)
                    .addComponent(loginTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutTimeLabel)
                    .addComponent(logoutTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButton)
                        .addComponent(refreshButton)
                        .addComponent(deleteButton)
                        .addComponent(newButton)
                        .addComponent(newButton1))
                    .addComponent(employeeIDLabel))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.FocusListener, java.awt.event.KeyListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                EmployeeAttendanceForm1.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                EmployeeAttendanceForm1.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                EmployeeAttendanceForm1.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                EmployeeAttendanceForm1.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton1) {
                EmployeeAttendanceForm1.this.newButton1ActionPerformed(evt);
            }
        }

        public void focusGained(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == EmployeeSearchTextbOx) {
                EmployeeAttendanceForm1.this.EmployeeSearchTextbOxFocusGained(evt);
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == EmployeeSearchTextbOx) {
                EmployeeAttendanceForm1.this.EmployeeSearchTextbOxKeyTyped(evt);
            }
            else if (evt.getSource() == EmployeIDSearchInGrid) {
                EmployeeAttendanceForm1.this.EmployeIDSearchInGridKeyTyped(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<org.bd.dev.res.database.items.Attendance> toRemove = new ArrayList<org.bd.dev.res.database.items.Attendance>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            org.bd.dev.res.database.items.Attendance a = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(a);
            entityManager.remove(a);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        org.bd.dev.res.database.items.Attendance a = new org.bd.dev.res.database.items.Attendance();
        entityManager.persist(a);
        list.add(a);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<org.bd.dev.res.database.items.Attendance> merged = new ArrayList<org.bd.dev.res.database.items.Attendance>(list.size());
            for (org.bd.dev.res.database.items.Attendance a : list) {
                merged.add(entityManager.merge(a));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void newButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newButton1ActionPerformed

    private void EmployeeSearchTextbOxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmployeeSearchTextbOxKeyTyped
        // TODO add your handling code here:
        SearchForm sf = loader.hiddenSearch("Employee", entityManager,employeeList, employeeQuery);
        sf.setHiddenSearch(EmployeeSearchTextbOx.getText(),1,QueryTypes.WORD_BASE_SEARCH);
    }//GEN-LAST:event_EmployeeSearchTextbOxKeyTyped

    private void EmployeeSearchTextbOxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmployeeSearchTextbOxFocusGained
        // TODO add your handling code here:
        if(EmployeeSearchTextbOx.getText().equals("Search Employee....")){
            EmployeeSearchTextbOx.setText("");
        }
    }//GEN-LAST:event_EmployeeSearchTextbOxFocusGained

    private void EmployeIDSearchInGridKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmployeIDSearchInGridKeyTyped
        // TODO add your handling code here:
        SearchForm sf = loader.hiddenSearch("attendance", entityManager,list, query);
        sf.setHiddenSearch(EmployeIDSearchInGrid.getText(),1,QueryTypes.EXACT);
    }//GEN-LAST:event_EmployeIDSearchInGridKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField EmployeIDSearchInGrid;
    public javax.swing.JComboBox EmployeeIDCombo;
    public javax.swing.JTextField EmployeeSearchTextbOx;
    public javax.swing.JTextField attendanceIdField;
    public javax.swing.JLabel attendanceIdLabel;
    public javax.swing.JLabel attendanceIdLabel1;
    private javax.swing.JButton deleteButton;
    public javax.swing.JLabel employeeIDLabel;
    public javax.swing.JLabel employeeIdLabel;
    public java.util.List<org.bd.dev.res.database.items.Employee> employeeList;
    public javax.persistence.Query employeeQuery;
    private javax.persistence.EntityManager entityManager;
    public javax.swing.JLabel jLabel1;
    private java.util.List<org.bd.dev.res.database.items.Attendance> list;
    public javax.swing.JTextField loginTimeField;
    public javax.swing.JLabel loginTimeLabel;
    public javax.swing.JTextField logoutTimeField;
    public javax.swing.JLabel logoutTimeLabel;
    public javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JButton newButton1;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    public javax.swing.JTextField shouldEndField;
    public javax.swing.JLabel shouldEndLabel;
    public javax.swing.JTextField shouldStartField;
    public javax.swing.JLabel shouldStartLabel;
    public javax.swing.JTextField workingDateField;
    public javax.swing.JLabel workingDateLabel;
    public javax.swing.JTextField workingHoursField;
    public javax.swing.JLabel workingHoursLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(EmployeeAttendanceForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeAttendanceForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeAttendanceForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeAttendanceForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new EmployeeAttendanceForm1());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    @org.jdesktop.application.Action
    public void ShowEmployeeDetails() {
        if (employeeIDLabel.getText().equals("") == false) {
            EmployeeForm emp = new EmployeeForm();
            emp.showSingleEmployee(employeeIDLabel.getText());
        } else {
            System.out.println("No Employee Id is Valid.");
        }


    }
}

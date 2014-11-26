/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CommonJPanel.java
 *
 * Created on Dec 21, 2011, 2:04:50 PM
 */
package org.bd.dev.res.database.items.forms;

import org.bd.dev.restaurantmanagement.mainpackage.DatabaseFormCommonTasksList;
import org.bd.dev.restaurantmanagement.mainpackage.ISoftwareInformation;


/**
 *
 * @author Alim
 */
public class CommonJPanel extends javax.swing.JPanel implements DatabaseFormCommonTasksList, ISoftwareInformation {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("Form"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public boolean Save() {
        throw new UnsupportedOperationException("Not supported yet. Must Implement it in the Current Database Form.");
    }

    public boolean AddNewToMaster() {
        throw new UnsupportedOperationException("Not supported yet. Must Implement it in the Current Database Form.");
    }

    public boolean AddNewToDetails() {
        throw new UnsupportedOperationException("Not supported yet. Must Implement it in the Current Database Form.");
    }

    public boolean Delete() {
        throw new UnsupportedOperationException("Not supported yet. Must Implement it in the Current Database Form.");
    }

    public boolean DeleteMaster() {
        throw new UnsupportedOperationException("Not supported yet. Must Implement it in the Current Database Form.");
    }

    public boolean DeleteDetails() {
        throw new UnsupportedOperationException("Not supported yet. Must Implement it in the Current Database Form.");
    }

    public void Refresh() {
        throw new UnsupportedOperationException("Not supported yet. Must Implement it in the Current Database Form.");
    }

    public void Close() {
        throw new UnsupportedOperationException("Not supported yet. Must Implement it in the Current Database Form.");
    }

    public void SearchMasterShow() {
        throw new UnsupportedOperationException("Not supported yet. Must Implement it in the Current Database Form.");
    }

    public void SearchDetailShow() {
        throw new UnsupportedOperationException("Not supported yet. Must Implement it in the Current Database Form.");
    }
}

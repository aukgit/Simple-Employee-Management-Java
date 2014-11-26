/*------------------------------------------------
 *------------------------------------------------
 * ||id     		:   112 0821 042
 * |name   		:   Alim Ul Karim
 * |email  		:   alim.karim.nsu@gmail.com
 * |course 		:   CSE 115.2 
 * |blog   		:   http://bit.ly/auk-blog
 * |linkedin            :   http://linkd.in/alim-ul-karim
 *------------------------------------------------
 *------------------------------------------------
 */
package org.bd.dev.restaurantmanagement.mainpackage;

/**
 *
 * @author Alim
 */
public interface DatabaseFormCommonTasksList {

    public boolean Save();

    public boolean AddNewToMaster();

    public boolean AddNewToDetails();

    public boolean DeleteMaster();

    public boolean DeleteDetails();

    public void SearchMasterShow();

    public void SearchDetailShow();

    public void Refresh();

    public void Close();
    //events
    /*
    public void newButtonActionPerformed(java.awt.event.ActionEvent evt);
    
    public void newDetailButtonActionPerformed(java.awt.event.ActionEvent evt);
    
    public void deleteDetailButtonActionPerformed(java.awt.event.ActionEvent evt);
    
    public void deleteButtonActionPerformed(java.awt.event.ActionEvent evt);
    
    public void saveButtonActionPerformed(java.awt.event.ActionEvent evt);
    
    public void refreshButtonActionPerformed(java.awt.event.ActionEvent evt);
     * 
     */
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bd.dev.res.database.items;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alim
 */
@Entity
@Table(name = "admin", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByAdmin", query = "SELECT a FROM Admin a WHERE a.admin = :admin"),
    @NamedQuery(name = "Admin.findByAdminName", query = "SELECT a FROM Admin a WHERE a.adminName = :adminName"),
    @NamedQuery(name = "Admin.findByPassword", query = "SELECT a FROM Admin a WHERE a.password = :password"),
    @NamedQuery(name = "Admin.findByPasswordHint", query = "SELECT a FROM Admin a WHERE a.passwordHint = :passwordHint")})
public class Admin implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "admin", nullable = false, length = 20)
    private String admin;
    @Column(name = "admin_name", length = 80)
    private String adminName;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Column(name = "password_hint", length = 40)
    private String passwordHint;

    public Admin() {
    }

    public Admin(String admin) {
        this.admin = admin;
    }

    public Admin(String admin, String password) {
        this.admin = admin;
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        String oldAdmin = this.admin;
        this.admin = admin;
        changeSupport.firePropertyChange("admin", oldAdmin, admin);
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        String oldAdminName = this.adminName;
        this.adminName = adminName;
        changeSupport.firePropertyChange("adminName", oldAdminName, adminName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        String oldPasswordHint = this.passwordHint;
        this.passwordHint = passwordHint;
        changeSupport.firePropertyChange("passwordHint", oldPasswordHint, passwordHint);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admin != null ? admin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.admin == null && other.admin != null) || (this.admin != null && !this.admin.equals(other.admin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.Admin[ admin=" + admin + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

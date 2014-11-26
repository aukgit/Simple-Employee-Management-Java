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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "employee", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId"),
    @NamedQuery(name = "Employee.findByEmployeeName", query = "SELECT e FROM Employee e WHERE e.employeeName = :employeeName"),
    @NamedQuery(name = "Employee.findByStartWorkingDate", query = "SELECT e FROM Employee e WHERE e.startWorkingDate = :startWorkingDate"),
    @NamedQuery(name = "Employee.findByResignDate", query = "SELECT e FROM Employee e WHERE e.resignDate = :resignDate"),
    @NamedQuery(name = "Employee.findByOnDuty", query = "SELECT e FROM Employee e WHERE e.onDuty = :onDuty"),
    @NamedQuery(name = "Employee.findByExceptionalWorkingHour", query = "SELECT e FROM Employee e WHERE e.exceptionalWorkingHour = :exceptionalWorkingHour")})
public class Employee implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;
    @Column(name = "employee_name", length = 120)
    private String employeeName;
    @Column(name = "start_working_date")
    private String startWorkingDate;
    @Column(name = "resign_date")
    private String resignDate;
    @Column(name = "on_duty")
    private Boolean onDuty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "exceptional_working_hour", precision = 22)
    private Double exceptionalWorkingHour;
    @JoinColumn(name = "employee_category_id", referencedColumnName = "employee_category_id")
    @ManyToOne
    private EmployeeCategory employeeCategoryId;

    public Employee() {
    }

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        Integer oldEmployeeId = this.employeeId;
        this.employeeId = employeeId;
        changeSupport.firePropertyChange("employeeId", oldEmployeeId, employeeId);
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        String oldEmployeeName = this.employeeName;
        this.employeeName = employeeName;
        changeSupport.firePropertyChange("employeeName", oldEmployeeName, employeeName);
    }

    public String getStartWorkingDate() {
        return startWorkingDate;
    }

    public void setStartWorkingDate(String startWorkingDate) {
        String oldStartWorkingDate = this.startWorkingDate;
        this.startWorkingDate = startWorkingDate;
        changeSupport.firePropertyChange("startWorkingDate", oldStartWorkingDate, startWorkingDate);
    }

    public String getResignDate() {
        return resignDate;
    }

    public void setResignDate(String resignDate) {
        String oldResignDate = this.resignDate;
        this.resignDate = resignDate;
        changeSupport.firePropertyChange("resignDate", oldResignDate, resignDate);
    }

    public Boolean getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(Boolean onDuty) {
        Boolean oldOnDuty = this.onDuty;
        this.onDuty = onDuty;
        changeSupport.firePropertyChange("onDuty", oldOnDuty, onDuty);
    }

    public Double getExceptionalWorkingHour() {
        return exceptionalWorkingHour;
    }

    public void setExceptionalWorkingHour(Double exceptionalWorkingHour) {
        Double oldExceptionalWorkingHour = this.exceptionalWorkingHour;
        this.exceptionalWorkingHour = exceptionalWorkingHour;
        changeSupport.firePropertyChange("exceptionalWorkingHour", oldExceptionalWorkingHour, exceptionalWorkingHour);
    }

    public EmployeeCategory getEmployeeCategoryId() {
        return employeeCategoryId;
    }

    public void setEmployeeCategoryId(EmployeeCategory employeeCategoryId) {
        EmployeeCategory oldEmployeeCategoryId = this.employeeCategoryId;
        this.employeeCategoryId = employeeCategoryId;
        changeSupport.firePropertyChange("employeeCategoryId", oldEmployeeCategoryId, employeeCategoryId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.Employee[ employeeId=" + employeeId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

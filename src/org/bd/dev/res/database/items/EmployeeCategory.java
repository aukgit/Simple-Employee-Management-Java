/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bd.dev.res.database.items;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alim
 */
@Entity
@Table(name = "employee_category", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeCategory.findAll", query = "SELECT e FROM EmployeeCategory e"),
    @NamedQuery(name = "EmployeeCategory.findByEmployeeCategoryId", query = "SELECT e FROM EmployeeCategory e WHERE e.employeeCategoryId = :employeeCategoryId"),
    @NamedQuery(name = "EmployeeCategory.findByEmployeeCategoryName", query = "SELECT e FROM EmployeeCategory e WHERE e.employeeCategoryName = :employeeCategoryName"),
    @NamedQuery(name = "EmployeeCategory.findBySalary", query = "SELECT e FROM EmployeeCategory e WHERE e.salary = :salary"),
    @NamedQuery(name = "EmployeeCategory.findByWorkingHours", query = "SELECT e FROM EmployeeCategory e WHERE e.workingHours = :workingHours"),
    @NamedQuery(name = "EmployeeCategory.findByWeekend", query = "SELECT e FROM EmployeeCategory e WHERE e.weekend = :weekend")})
public class EmployeeCategory implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employee_category_id", nullable = false)
    private Integer employeeCategoryId;
    @Column(name = "employee_category_name", length = 200)
    private String employeeCategoryName;
    @Column(name = "salary")
    private Long salary;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "working_hours", precision = 22)
    private Double workingHours;
    @Column(name = "weekend")
    private Integer weekend;
    @OneToMany(mappedBy = "employeeCategoryId")
    private Collection<Employee> employeeCollection;

    public EmployeeCategory() {
    }

    public EmployeeCategory(Integer employeeCategoryId) {
        this.employeeCategoryId = employeeCategoryId;
    }

    public Integer getEmployeeCategoryId() {
        return employeeCategoryId;
    }

    public void setEmployeeCategoryId(Integer employeeCategoryId) {
        Integer oldEmployeeCategoryId = this.employeeCategoryId;
        this.employeeCategoryId = employeeCategoryId;
        changeSupport.firePropertyChange("employeeCategoryId", oldEmployeeCategoryId, employeeCategoryId);
    }

    public String getEmployeeCategoryName() {
        return employeeCategoryName;
    }

    public void setEmployeeCategoryName(String employeeCategoryName) {
        String oldEmployeeCategoryName = this.employeeCategoryName;
        this.employeeCategoryName = employeeCategoryName;
        changeSupport.firePropertyChange("employeeCategoryName", oldEmployeeCategoryName, employeeCategoryName);
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        Long oldSalary = this.salary;
        this.salary = salary;
        changeSupport.firePropertyChange("salary", oldSalary, salary);
    }

    public Double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Double workingHours) {
        Double oldWorkingHours = this.workingHours;
        this.workingHours = workingHours;
        changeSupport.firePropertyChange("workingHours", oldWorkingHours, workingHours);
    }

    public Integer getWeekend() {
        return weekend;
    }

    public void setWeekend(Integer weekend) {
        Integer oldWeekend = this.weekend;
        this.weekend = weekend;
        changeSupport.firePropertyChange("weekend", oldWeekend, weekend);
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeCategoryId != null ? employeeCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeCategory)) {
            return false;
        }
        EmployeeCategory other = (EmployeeCategory) object;
        if ((this.employeeCategoryId == null && other.employeeCategoryId != null) || (this.employeeCategoryId != null && !this.employeeCategoryId.equals(other.employeeCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.EmployeeCategory[ employeeCategoryId=" + employeeCategoryId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

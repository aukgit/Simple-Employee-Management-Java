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
@Table(name = "payroll", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payroll.findAll", query = "SELECT p FROM Payroll p"),
    @NamedQuery(name = "Payroll.findByPayrollId", query = "SELECT p FROM Payroll p WHERE p.payrollId = :payrollId"),
    @NamedQuery(name = "Payroll.findByPaymentAmount", query = "SELECT p FROM Payroll p WHERE p.paymentAmount = :paymentAmount"),
    @NamedQuery(name = "Payroll.findByPaidAmount", query = "SELECT p FROM Payroll p WHERE p.paidAmount = :paidAmount"),
    @NamedQuery(name = "Payroll.findByReduceAmount", query = "SELECT p FROM Payroll p WHERE p.reduceAmount = :reduceAmount"),
    @NamedQuery(name = "Payroll.findByBonusAmount", query = "SELECT p FROM Payroll p WHERE p.bonusAmount = :bonusAmount"),
    @NamedQuery(name = "Payroll.findByPaymentDate", query = "SELECT p FROM Payroll p WHERE p.paymentDate = :paymentDate"),
    @NamedQuery(name = "Payroll.findByDateForPayingMonth", query = "SELECT p FROM Payroll p WHERE p.dateForPayingMonth = :dateForPayingMonth"),
    @NamedQuery(name = "Payroll.findByTotalAbsense", query = "SELECT p FROM Payroll p WHERE p.totalAbsense = :totalAbsense"),
    @NamedQuery(name = "Payroll.findByTotalLates", query = "SELECT p FROM Payroll p WHERE p.totalLates = :totalLates"),
    @NamedQuery(name = "Payroll.findByIsAdvance", query = "SELECT p FROM Payroll p WHERE p.isAdvance = :isAdvance"),
    @NamedQuery(name = "Payroll.findByComments", query = "SELECT p FROM Payroll p WHERE p.comments = :comments")})
public class Payroll implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payroll_id", nullable = false)
    private Long payrollId;
    @Column(name = "payment_amount")
    private Long paymentAmount;
    @Column(name = "paid_amount")
    private Long paidAmount;
    @Column(name = "reduce_amount")
    private Long reduceAmount;
    @Column(name = "bonus_amount")
    private Long bonusAmount;
    @Column(name = "payment_date")    
    private String paymentDate;
    @Column(name = "date_for_paying_month")    
    private String dateForPayingMonth;
    @Column(name = "total_absense")
    private Integer totalAbsense;
    @Column(name = "total_lates")
    private Integer totalLates;
    @Column(name = "is_advance")
    private Boolean isAdvance;
    @Column(name = "comments", length = 400)
    private String comments;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employee employeeId;

    public Payroll() {
    }

    public Payroll(Long payrollId) {
        this.payrollId = payrollId;
    }

    public Long getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(Long payrollId) {
        Long oldPayrollId = this.payrollId;
        this.payrollId = payrollId;
        changeSupport.firePropertyChange("payrollId", oldPayrollId, payrollId);
    }

    public Long getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Long paymentAmount) {
        Long oldPaymentAmount = this.paymentAmount;
        this.paymentAmount = paymentAmount;
        changeSupport.firePropertyChange("paymentAmount", oldPaymentAmount, paymentAmount);
    }

    public Long getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Long paidAmount) {
        Long oldPaidAmount = this.paidAmount;
        this.paidAmount = paidAmount;
        changeSupport.firePropertyChange("paidAmount", oldPaidAmount, paidAmount);
    }

    public Long getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(Long reduceAmount) {
        Long oldReduceAmount = this.reduceAmount;
        this.reduceAmount = reduceAmount;
        changeSupport.firePropertyChange("reduceAmount", oldReduceAmount, reduceAmount);
    }

    public Long getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(Long bonusAmount) {
        Long oldBonusAmount = this.bonusAmount;
        this.bonusAmount = bonusAmount;
        changeSupport.firePropertyChange("bonusAmount", oldBonusAmount, bonusAmount);
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        String oldPaymentDate = this.paymentDate;
        this.paymentDate = paymentDate;
        changeSupport.firePropertyChange("paymentDate", oldPaymentDate, paymentDate);
    }

    public String getDateForPayingMonth() {
        return dateForPayingMonth;
    }

    public void setDateForPayingMonth(String dateForPayingMonth) {
        String oldDateForPayingMonth = this.dateForPayingMonth;
        this.dateForPayingMonth = dateForPayingMonth;
        changeSupport.firePropertyChange("dateForPayingMonth", oldDateForPayingMonth, dateForPayingMonth);
    }

    public Integer getTotalAbsense() {
        return totalAbsense;
    }

    public void setTotalAbsense(Integer totalAbsense) {
        Integer oldTotalAbsense = this.totalAbsense;
        this.totalAbsense = totalAbsense;
        changeSupport.firePropertyChange("totalAbsense", oldTotalAbsense, totalAbsense);
    }

    public Integer getTotalLates() {
        return totalLates;
    }

    public void setTotalLates(Integer totalLates) {
        Integer oldTotalLates = this.totalLates;
        this.totalLates = totalLates;
        changeSupport.firePropertyChange("totalLates", oldTotalLates, totalLates);
    }

    public Boolean getIsAdvance() {
        return isAdvance;
    }

    public void setIsAdvance(Boolean isAdvance) {
        Boolean oldIsAdvance = this.isAdvance;
        this.isAdvance = isAdvance;
        changeSupport.firePropertyChange("isAdvance", oldIsAdvance, isAdvance);
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        String oldComments = this.comments;
        this.comments = comments;
        changeSupport.firePropertyChange("comments", oldComments, comments);
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        Employee oldEmployeeId = this.employeeId;
        this.employeeId = employeeId;
        changeSupport.firePropertyChange("employeeId", oldEmployeeId, employeeId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payrollId != null ? payrollId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payroll)) {
            return false;
        }
        Payroll other = (Payroll) object;
        if ((this.payrollId == null && other.payrollId != null) || (this.payrollId != null && !this.payrollId.equals(other.payrollId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.Payroll[ payrollId=" + payrollId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

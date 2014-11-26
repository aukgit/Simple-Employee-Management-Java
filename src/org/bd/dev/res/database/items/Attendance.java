/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bd.dev.res.database.items;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "attendance", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a"),
    @NamedQuery(name = "Attendance.findByAttendanceId", query = "SELECT a FROM Attendance a WHERE a.attendanceId = :attendanceId"),
    @NamedQuery(name = "Attendance.findByWorkingHours", query = "SELECT a FROM Attendance a WHERE a.workingHours = :workingHours"),
    @NamedQuery(name = "Attendance.findByWorkingDate", query = "SELECT a FROM Attendance a WHERE a.workingDate = :workingDate"),
    @NamedQuery(name = "Attendance.findByShouldStart", query = "SELECT a FROM Attendance a WHERE a.shouldStart = :shouldStart"),
    @NamedQuery(name = "Attendance.findByShouldEnd", query = "SELECT a FROM Attendance a WHERE a.shouldEnd = :shouldEnd"),
    @NamedQuery(name = "Attendance.findByLoginTime", query = "SELECT a FROM Attendance a WHERE a.loginTime = :loginTime"),
    @NamedQuery(name = "Attendance.findByLogoutTime", query = "SELECT a FROM Attendance a WHERE a.logoutTime = :logoutTime")})
public class Attendance implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attendance_id", nullable = false)
    private Long attendanceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "working_hours", precision = 22)
    private Double workingHours;
    @Column(name = "working_date")    
    private String workingDate;
    @Column(name = "should_start")    
    private String shouldStart;
    @Column(name = "should_end")    
    private String shouldEnd;
    @Column(name = "login_time")    
    private String loginTime;
    @Column(name = "logout_time")    
    private String logoutTime;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employee employeeId;

    public Attendance() {
    }

    public Attendance(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        Long oldAttendanceId = this.attendanceId;
        this.attendanceId = attendanceId;
        changeSupport.firePropertyChange("attendanceId", oldAttendanceId, attendanceId);
    }

    public Double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Double workingHours) {
        Double oldWorkingHours = this.workingHours;
        this.workingHours = workingHours;
        changeSupport.firePropertyChange("workingHours", oldWorkingHours, workingHours);
    }

    public String getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(String workingDate) {
        String oldWorkingDate = this.workingDate;
        this.workingDate = workingDate;
        changeSupport.firePropertyChange("workingDate", oldWorkingDate, workingDate);
    }

    public String getShouldStart() {
        return shouldStart;
    }

    public void setShouldStart(String shouldStart) {
        String oldShouldStart = this.shouldStart;
        this.shouldStart = shouldStart;
        changeSupport.firePropertyChange("shouldStart", oldShouldStart, shouldStart);
    }

    public String getShouldEnd() {
        return shouldEnd;
    }

    public void setShouldEnd(String shouldEnd) {
        String oldShouldEnd = this.shouldEnd;
        this.shouldEnd = shouldEnd;
        changeSupport.firePropertyChange("shouldEnd", oldShouldEnd, shouldEnd);
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        String oldLoginTime = this.loginTime;
        this.loginTime = loginTime;
        changeSupport.firePropertyChange("loginTime", oldLoginTime, loginTime);
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        String oldLogoutTime = this.logoutTime;
        this.logoutTime = logoutTime;
        changeSupport.firePropertyChange("logoutTime", oldLogoutTime, logoutTime);
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
        hash += (attendanceId != null ? attendanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.attendanceId == null && other.attendanceId != null) || (this.attendanceId != null && !this.attendanceId.equals(other.attendanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.Attendance[ attendanceId=" + attendanceId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

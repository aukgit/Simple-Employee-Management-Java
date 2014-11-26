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
@Table(name = "restaurant_table", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RestaurantTable.findAll", query = "SELECT r FROM RestaurantTable r"),
    @NamedQuery(name = "RestaurantTable.findByRestaurantTableId", query = "SELECT r FROM RestaurantTable r WHERE r.restaurantTableId = :restaurantTableId"),
    @NamedQuery(name = "RestaurantTable.findByIsReserved", query = "SELECT r FROM RestaurantTable r WHERE r.isReserved = :isReserved")})
public class RestaurantTable implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "restaurant_table_id", nullable = false)
    private Integer restaurantTableId;
    @Column(name = "is_reserved")
    private Boolean isReserved;

    public RestaurantTable() {
    }

    public RestaurantTable(Integer restaurantTableId) {
        this.restaurantTableId = restaurantTableId;
    }

    public Integer getRestaurantTableId() {
        return restaurantTableId;
    }

    public void setRestaurantTableId(Integer restaurantTableId) {
        Integer oldRestaurantTableId = this.restaurantTableId;
        this.restaurantTableId = restaurantTableId;
        changeSupport.firePropertyChange("restaurantTableId", oldRestaurantTableId, restaurantTableId);
    }

    public Boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(Boolean isReserved) {
        Boolean oldIsReserved = this.isReserved;
        this.isReserved = isReserved;
        changeSupport.firePropertyChange("isReserved", oldIsReserved, isReserved);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (restaurantTableId != null ? restaurantTableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RestaurantTable)) {
            return false;
        }
        RestaurantTable other = (RestaurantTable) object;
        if ((this.restaurantTableId == null && other.restaurantTableId != null) || (this.restaurantTableId != null && !this.restaurantTableId.equals(other.restaurantTableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.RestaurantTable[ restaurantTableId=" + restaurantTableId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

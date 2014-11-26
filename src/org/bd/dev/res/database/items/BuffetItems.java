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
@Table(name = "buffet_items", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuffetItems.findAll", query = "SELECT b FROM BuffetItems b"),
    @NamedQuery(name = "BuffetItems.findByBuffetItemsId", query = "SELECT b FROM BuffetItems b WHERE b.buffetItemsId = :buffetItemsId"),
    @NamedQuery(name = "BuffetItems.findByItemName", query = "SELECT b FROM BuffetItems b WHERE b.itemName = :itemName"),
    @NamedQuery(name = "BuffetItems.findByImageExist", query = "SELECT b FROM BuffetItems b WHERE b.imageExist = :imageExist")})
public class BuffetItems implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "buffet_items_id", nullable = false)
    private Integer buffetItemsId;
    @Column(name = "item_name", length = 250)
    private String itemName;
    @Column(name = "image_exist")
    private Boolean imageExist;
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    @ManyToOne
    private Food foodId;

    public BuffetItems() {
    }

    public BuffetItems(Integer buffetItemsId) {
        this.buffetItemsId = buffetItemsId;
    }

    public Integer getBuffetItemsId() {
        return buffetItemsId;
    }

    public void setBuffetItemsId(Integer buffetItemsId) {
        Integer oldBuffetItemsId = this.buffetItemsId;
        this.buffetItemsId = buffetItemsId;
        changeSupport.firePropertyChange("buffetItemsId", oldBuffetItemsId, buffetItemsId);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        String oldItemName = this.itemName;
        this.itemName = itemName;
        changeSupport.firePropertyChange("itemName", oldItemName, itemName);
    }

    public Boolean getImageExist() {
        return imageExist;
    }

    public void setImageExist(Boolean imageExist) {
        Boolean oldImageExist = this.imageExist;
        this.imageExist = imageExist;
        changeSupport.firePropertyChange("imageExist", oldImageExist, imageExist);
    }

    public Food getFoodId() {
        return foodId;
    }

    public void setFoodId(Food foodId) {
        Food oldFoodId = this.foodId;
        this.foodId = foodId;
        changeSupport.firePropertyChange("foodId", oldFoodId, foodId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buffetItemsId != null ? buffetItemsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuffetItems)) {
            return false;
        }
        BuffetItems other = (BuffetItems) object;
        if ((this.buffetItemsId == null && other.buffetItemsId != null) || (this.buffetItemsId != null && !this.buffetItemsId.equals(other.buffetItemsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.BuffetItems[ buffetItemsId=" + buffetItemsId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

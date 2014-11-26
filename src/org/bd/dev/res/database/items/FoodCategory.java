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
@Table(name = "food_category", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodCategory.findAll", query = "SELECT f FROM FoodCategory f"),
    @NamedQuery(name = "FoodCategory.findByFoodCategoryId", query = "SELECT f FROM FoodCategory f WHERE f.foodCategoryId = :foodCategoryId"),
    @NamedQuery(name = "FoodCategory.findByFoodCategoryName", query = "SELECT f FROM FoodCategory f WHERE f.foodCategoryName = :foodCategoryName")})
public class FoodCategory implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "food_category_id", nullable = false)
    private Integer foodCategoryId;
    @Column(name = "food_category_name", length = 50)
    private String foodCategoryName;
    @OneToMany(mappedBy = "foodCategoryId")
    private Collection<Food> foodCollection;

    public FoodCategory() {
    }

    public FoodCategory(Integer foodCategoryId) {
        this.foodCategoryId = foodCategoryId;
    }

    public Integer getFoodCategoryId() {
        return foodCategoryId;
    }

    public void setFoodCategoryId(Integer foodCategoryId) {
        Integer oldFoodCategoryId = this.foodCategoryId;
        this.foodCategoryId = foodCategoryId;
        changeSupport.firePropertyChange("foodCategoryId", oldFoodCategoryId, foodCategoryId);
    }

    public String getFoodCategoryName() {
        return foodCategoryName;
    }

    public void setFoodCategoryName(String foodCategoryName) {
        String oldFoodCategoryName = this.foodCategoryName;
        this.foodCategoryName = foodCategoryName;
        changeSupport.firePropertyChange("foodCategoryName", oldFoodCategoryName, foodCategoryName);
    }

    @XmlTransient
    public Collection<Food> getFoodCollection() {
        return foodCollection;
    }

    public void setFoodCollection(Collection<Food> foodCollection) {
        this.foodCollection = foodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodCategoryId != null ? foodCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodCategory)) {
            return false;
        }
        FoodCategory other = (FoodCategory) object;
        if ((this.foodCategoryId == null && other.foodCategoryId != null) || (this.foodCategoryId != null && !this.foodCategoryId.equals(other.foodCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.FoodCategory[ foodCategoryId=" + foodCategoryId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "food", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f"),
    @NamedQuery(name = "Food.findByFoodId", query = "SELECT f FROM Food f WHERE f.foodId = :foodId"),
    @NamedQuery(name = "Food.findByFoodName", query = "SELECT f FROM Food f WHERE f.foodName = :foodName"),
    @NamedQuery(name = "Food.findByFoodShortName", query = "SELECT f FROM Food f WHERE f.foodShortName = :foodShortName"),
    @NamedQuery(name = "Food.findByMakingCost", query = "SELECT f FROM Food f WHERE f.makingCost = :makingCost"),
    @NamedQuery(name = "Food.findBySellingCost", query = "SELECT f FROM Food f WHERE f.sellingCost = :sellingCost")})
public class Food implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "food_id", nullable = false)
    private Long foodId;
    @Column(name = "food_name", length = 200)
    private String foodName;
    @Column(name = "food_short_name", length = 10)
    private String foodShortName;
    @Basic(optional = false)
    @Column(name = "making_cost", nullable = false)
    private long makingCost;
    @Basic(optional = false)
    @Column(name = "selling_cost", nullable = false)
    private long sellingCost;
    @OneToMany(mappedBy = "foodId")
    private Collection<StockFood> stockFoodCollection;
    @JoinColumn(name = "food_category_id", referencedColumnName = "food_category_id")
    @ManyToOne
    private FoodCategory foodCategoryId;
    @OneToMany(mappedBy = "foodId")
    private Collection<BuffetItems> buffetItemsCollection;

    public Food() {
    }

    public Food(Long foodId) {
        this.foodId = foodId;
    }

    public Food(Long foodId, long makingCost, long sellingCost) {
        this.foodId = foodId;
        this.makingCost = makingCost;
        this.sellingCost = sellingCost;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        Long oldFoodId = this.foodId;
        this.foodId = foodId;
        changeSupport.firePropertyChange("foodId", oldFoodId, foodId);
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        String oldFoodName = this.foodName;
        this.foodName = foodName;
        changeSupport.firePropertyChange("foodName", oldFoodName, foodName);
    }

    public String getFoodShortName() {
        return foodShortName;
    }

    public void setFoodShortName(String foodShortName) {
        String oldFoodShortName = this.foodShortName;
        this.foodShortName = foodShortName;
        changeSupport.firePropertyChange("foodShortName", oldFoodShortName, foodShortName);
    }

    public long getMakingCost() {
        return makingCost;
    }

    public void setMakingCost(long makingCost) {
        long oldMakingCost = this.makingCost;
        this.makingCost = makingCost;
        changeSupport.firePropertyChange("makingCost", oldMakingCost, makingCost);
    }

    public long getSellingCost() {
        return sellingCost;
    }

    public void setSellingCost(long sellingCost) {
        long oldSellingCost = this.sellingCost;
        this.sellingCost = sellingCost;
        changeSupport.firePropertyChange("sellingCost", oldSellingCost, sellingCost);
    }

    @XmlTransient
    public Collection<StockFood> getStockFoodCollection() {
        return stockFoodCollection;
    }

    public void setStockFoodCollection(Collection<StockFood> stockFoodCollection) {
        this.stockFoodCollection = stockFoodCollection;
    }

    public FoodCategory getFoodCategoryId() {
        return foodCategoryId;
    }

    public void setFoodCategoryId(FoodCategory foodCategoryId) {
        FoodCategory oldFoodCategoryId = this.foodCategoryId;
        this.foodCategoryId = foodCategoryId;
        changeSupport.firePropertyChange("foodCategoryId", oldFoodCategoryId, foodCategoryId);
    }

    @XmlTransient
    public Collection<BuffetItems> getBuffetItemsCollection() {
        return buffetItemsCollection;
    }

    public void setBuffetItemsCollection(Collection<BuffetItems> buffetItemsCollection) {
        this.buffetItemsCollection = buffetItemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodId != null ? foodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.foodId == null && other.foodId != null) || (this.foodId != null && !this.foodId.equals(other.foodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.Food[ foodId=" + foodId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

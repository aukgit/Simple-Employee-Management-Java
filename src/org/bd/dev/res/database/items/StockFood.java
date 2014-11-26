/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bd.dev.res.database.items;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alim
 */
@Entity
@Table(name = "stock_food", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockFood.findAll", query = "SELECT s FROM StockFood s"),
    @NamedQuery(name = "StockFood.findByStockFoodId", query = "SELECT s FROM StockFood s WHERE s.stockFoodId = :stockFoodId"),
    @NamedQuery(name = "StockFood.findByFoodName", query = "SELECT s FROM StockFood s WHERE s.foodName = :foodName"),
    @NamedQuery(name = "StockFood.findByStockAmount", query = "SELECT s FROM StockFood s WHERE s.stockAmount = :stockAmount"),
    @NamedQuery(name = "StockFood.findByPerSellingCost", query = "SELECT s FROM StockFood s WHERE s.perSellingCost = :perSellingCost")})
public class StockFood implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stock_food_id", nullable = false)
    private Long stockFoodId;
    @Column(name = "food_name", length = 200)
    private String foodName;
    @Column(name = "stock_amount")
    private Integer stockAmount;
    @Column(name = "per_selling_cost")
    private Long perSellingCost;
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    @ManyToOne
    private Food foodId;

    public StockFood() {
    }

    public StockFood(Long stockFoodId) {
        this.stockFoodId = stockFoodId;
    }

    public Long getStockFoodId() {
        return stockFoodId;
    }

    public void setStockFoodId(Long stockFoodId) {
        this.stockFoodId = stockFoodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Long getPerSellingCost() {
        return perSellingCost;
    }

    public void setPerSellingCost(Long perSellingCost) {
        this.perSellingCost = perSellingCost;
    }

    public Food getFoodId() {
        return foodId;
    }

    public void setFoodId(Food foodId) {
        this.foodId = foodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockFoodId != null ? stockFoodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockFood)) {
            return false;
        }
        StockFood other = (StockFood) object;
        if ((this.stockFoodId == null && other.stockFoodId != null) || (this.stockFoodId != null && !this.stockFoodId.equals(other.stockFoodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.StockFood[ stockFoodId=" + stockFoodId + " ]";
    }
    
}

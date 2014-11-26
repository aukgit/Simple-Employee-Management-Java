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
@Table(name = "invoice_items", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceItems.findAll", query = "SELECT i FROM InvoiceItems i"),
    @NamedQuery(name = "InvoiceItems.findByInvoiceItemsId", query = "SELECT i FROM InvoiceItems i WHERE i.invoiceItemsId = :invoiceItemsId"),
    @NamedQuery(name = "InvoiceItems.findByFoodName", query = "SELECT i FROM InvoiceItems i WHERE i.foodName = :foodName"),
    @NamedQuery(name = "InvoiceItems.findByFoodCategoryId", query = "SELECT i FROM InvoiceItems i WHERE i.foodCategoryId = :foodCategoryId"),
    @NamedQuery(name = "InvoiceItems.findBySellingPrice", query = "SELECT i FROM InvoiceItems i WHERE i.sellingPrice = :sellingPrice"),
    @NamedQuery(name = "InvoiceItems.findByMakingPrice", query = "SELECT i FROM InvoiceItems i WHERE i.makingPrice = :makingPrice")})
public class InvoiceItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_items_id", nullable = false)
    private Long invoiceItemsId;
    @Column(name = "food_name", length = 200)
    private String foodName;
    @Column(name = "food_category_id")
    private Integer foodCategoryId;
    @Column(name = "selling_price")
    private Long sellingPrice;
    @Column(name = "making_price")
    private Long makingPrice;
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id", nullable = false)
    @ManyToOne(optional = false)
    private Invoice invoiceId;

    public InvoiceItems() {
    }

    public InvoiceItems(Long invoiceItemsId) {
        this.invoiceItemsId = invoiceItemsId;
    }

    public Long getInvoiceItemsId() {
        return invoiceItemsId;
    }

    public void setInvoiceItemsId(Long invoiceItemsId) {
        this.invoiceItemsId = invoiceItemsId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getFoodCategoryId() {
        return foodCategoryId;
    }

    public void setFoodCategoryId(Integer foodCategoryId) {
        this.foodCategoryId = foodCategoryId;
    }

    public Long getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Long sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Long getMakingPrice() {
        return makingPrice;
    }

    public void setMakingPrice(Long makingPrice) {
        this.makingPrice = makingPrice;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceItemsId != null ? invoiceItemsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceItems)) {
            return false;
        }
        InvoiceItems other = (InvoiceItems) object;
        if ((this.invoiceItemsId == null && other.invoiceItemsId != null) || (this.invoiceItemsId != null && !this.invoiceItemsId.equals(other.invoiceItemsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.InvoiceItems[ invoiceItemsId=" + invoiceItemsId + " ]";
    }
    
}

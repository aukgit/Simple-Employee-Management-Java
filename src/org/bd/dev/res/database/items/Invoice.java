/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bd.dev.res.database.items;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alim
 */
@Entity
@Table(name = "invoice", catalog = "restaurantmanagement", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByInvoiceId", query = "SELECT i FROM Invoice i WHERE i.invoiceId = :invoiceId"),
    @NamedQuery(name = "Invoice.findByInvoiceName", query = "SELECT i FROM Invoice i WHERE i.invoiceName = :invoiceName"),
    @NamedQuery(name = "Invoice.findByInvoiceTable", query = "SELECT i FROM Invoice i WHERE i.invoiceTable = :invoiceTable"),
    @NamedQuery(name = "Invoice.findByDated", query = "SELECT i FROM Invoice i WHERE i.dated = :dated"),
    @NamedQuery(name = "Invoice.findByItemsBuy", query = "SELECT i FROM Invoice i WHERE i.itemsBuy = :itemsBuy"),
    @NamedQuery(name = "Invoice.findByPaymentAmount", query = "SELECT i FROM Invoice i WHERE i.paymentAmount = :paymentAmount"),
    @NamedQuery(name = "Invoice.findByDueAmount", query = "SELECT i FROM Invoice i WHERE i.dueAmount = :dueAmount"),
    @NamedQuery(name = "Invoice.findByDisountAmount", query = "SELECT i FROM Invoice i WHERE i.disountAmount = :disountAmount"),
    @NamedQuery(name = "Invoice.findByDiscount", query = "SELECT i FROM Invoice i WHERE i.discount = :discount"),
    @NamedQuery(name = "Invoice.findByPaidAmount", query = "SELECT i FROM Invoice i WHERE i.paidAmount = :paidAmount"),
    @NamedQuery(name = "Invoice.findByComments", query = "SELECT i FROM Invoice i WHERE i.comments = :comments")})
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_id", nullable = false)
    private Long invoiceId;
    @Column(name = "invoice_name", length = 80)
    private String invoiceName;
    @Column(name = "invoice_table")
    private Integer invoiceTable;
    @Basic(optional = false)
    @Column(name = "dated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dated;
    @Column(name = "items_buy")
    private Integer itemsBuy;
    @Column(name = "payment_amount")
    private Long paymentAmount;
    @Column(name = "due_amount")
    private Long dueAmount;
    @Column(name = "disount_amount")
    private Long disountAmount;
    @Column(name = "discount", length = 20)
    private String discount;
    @Basic(optional = false)
    @Column(name = "paid_amount", nullable = false)
    private long paidAmount;
    @Column(name = "comments", length = 1000)
    private String comments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceId")
    private Collection<InvoiceItems> invoiceItemsCollection;

    public Invoice() {
    }

    public Invoice(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Invoice(Long invoiceId, Date dated, long paidAmount) {
        this.invoiceId = invoiceId;
        this.dated = dated;
        this.paidAmount = paidAmount;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public Integer getInvoiceTable() {
        return invoiceTable;
    }

    public void setInvoiceTable(Integer invoiceTable) {
        this.invoiceTable = invoiceTable;
    }

    public Date getDated() {
        return dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
    }

    public Integer getItemsBuy() {
        return itemsBuy;
    }

    public void setItemsBuy(Integer itemsBuy) {
        this.itemsBuy = itemsBuy;
    }

    public Long getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Long getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Long dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Long getDisountAmount() {
        return disountAmount;
    }

    public void setDisountAmount(Long disountAmount) {
        this.disountAmount = disountAmount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public long getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(long paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @XmlTransient
    public Collection<InvoiceItems> getInvoiceItemsCollection() {
        return invoiceItemsCollection;
    }

    public void setInvoiceItemsCollection(Collection<InvoiceItems> invoiceItemsCollection) {
        this.invoiceItemsCollection = invoiceItemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.bd.dev.res.database.items.Invoice[ invoiceId=" + invoiceId + " ]";
    }
    
}

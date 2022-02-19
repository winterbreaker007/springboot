package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 3/24/2021.
 */
@Entity
@Table(name = "tblInvoiceLines")
public class InvoiceLines {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "invoice_lines_id")
  private String id;

  @Column(name = "invoice_parent_service_list_id")
  private String parentServiceListId;

  @Column(name = "invoice_parent_invoice_id")
  private String parentInvoiceId;

  @Column(name = "invoice_lines_description")
  private String description;

  @Column(name = "invoice_lines_sku")
  private String sku;

  @Column(name = "invoice_lines_rate")
  private Double rate;

  @Column(name = "invoice_lines_qty")
  private Double quantity;

  @Column(name = "invoice_lines_lineitem_notes")
  private String lineItemNotes;

  @Column(name = "invoice_lines_room")
  private String room;

  @Column(name = "invoice_lines_taxable_amount")
  private Double taxableAmount;

  @Column(name = "invoice_lines_sales_tax")
  private Double salesTax;

  @Column(name = "invoice_lines_list_order")
  private String listOrder;

  @Column(name = "invoice_lines_date_of_work")
  private LocalDateTime dateOfWork;

  @Column(name = "invoice_lines_visit")
  private String visit;

  @Column(name = "invoice_lines_total_amount")
  private Double totalAmount;

  @Column(name = "invoice_lines_custom_rate")
  private Boolean customRate;

  @Column(name = "invoice_lines_invoice_saved_by")
  private String invoiceSavedBy;

  @Column(name = "invoice_lines_invoice_date_saved")
  private LocalDateTime invoiceDateSaved;

  @Column(name = "invoice_lines_uom")
  private String uom;

  @Column(name = "invoice_lines_print_note")
  private Boolean printNote;

  @Column(name = "invoice_lines_plaintext_notes")
  private String plainTextNotes;

  @Column(name = "invoice_lines_hours_of_work")
  private Integer hoursOfWork;

  @Column(name = "invoice_lines_support_note_id")
  private String supportNoteId;

  @Column(name = "invoice_lines_service_name")
  private String serviceName;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getParentServiceListId() {
    return parentServiceListId;
  }

  public void setParentServiceListId(String parentServiceListId) {
    this.parentServiceListId = parentServiceListId;
  }

  public String getParentInvoiceId() {
    return parentInvoiceId;
  }

  public void setParentInvoiceId(String parentInvoiceId) {
    this.parentInvoiceId = parentInvoiceId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public Double getRate() {
    return rate;
  }

  public void setRate(Double rate) {
    this.rate = rate;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public String getLineItemNotes() {
    return lineItemNotes;
  }

  public void setLineItemNotes(String lineItemNotes) {
    this.lineItemNotes = lineItemNotes;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public Double getTaxableAmount() {
    return taxableAmount;
  }

  public void setTaxableAmount(Double taxableAmount) {
    this.taxableAmount = taxableAmount;
  }

  public Double getSalesTax() {
    return salesTax;
  }

  public void setSalesTax(Double salesTax) {
    this.salesTax = salesTax;
  }

  public String getListOrder() {
    return listOrder;
  }

  public void setListOrder(String listOrder) {
    this.listOrder = listOrder;
  }

  public LocalDateTime getDateOfWork() {
    return dateOfWork;
  }

  public void setDateOfWork(LocalDateTime dateOfWork) {
    this.dateOfWork = dateOfWork;
  }

  public String getVisit() {
    return visit;
  }

  public void setVisit(String visit) {
    this.visit = visit;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Boolean getCustomRate() {
    return customRate;
  }

  public void setCustomRate(Boolean customRate) {
    this.customRate = customRate;
  }

  public String getInvoiceSavedBy() {
    return invoiceSavedBy;
  }

  public void setInvoiceSavedBy(String invoiceSavedBy) {
    this.invoiceSavedBy = invoiceSavedBy;
  }

  public LocalDateTime getInvoiceDateSaved() {
    return invoiceDateSaved;
  }

  public void setInvoiceDateSaved(LocalDateTime invoiceDateSaved) {
    this.invoiceDateSaved = invoiceDateSaved;
  }

  public String getUom() {
    return uom;
  }

  public void setUom(String uom) {
    this.uom = uom;
  }

  public Boolean getPrintNote() {
    return printNote;
  }

  public void setPrintNote(Boolean printNote) {
    this.printNote = printNote;
  }

  public String getPlainTextNotes() {
    return plainTextNotes;
  }

  public void setPlainTextNotes(String plainTextNotes) {
    this.plainTextNotes = plainTextNotes;
  }

  public Integer getHoursOfWork() {
    return hoursOfWork;
  }

  public void setHoursOfWork(Integer hoursOfWork) {
    this.hoursOfWork = hoursOfWork;
  }

  public String getSupportNoteId() {
    return supportNoteId;
  }

  public void setSupportNoteId(String supportNoteId) {
    this.supportNoteId = supportNoteId;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("parentServiceListId", parentServiceListId)
        .append("parentInvoiceId", parentInvoiceId)
        .append("description", description)
        .append("sku", sku)
        .append("rate", rate)
        .append("quantity", quantity)
        .append("lineItemNotes", lineItemNotes)
        .append("room", room)
        .append("taxableAmount", taxableAmount)
        .append("salesTax", salesTax)
        .append("listOrder", listOrder)
        .append("dateOfWork", dateOfWork)
        .append("visit", visit)
        .append("totalAmount", totalAmount)
        .append("customRate", customRate)
        .append("invoiceSavedBy", invoiceSavedBy)
        .append("invoiceDateSaved", invoiceDateSaved)
        .append("uom", uom)
        .append("printNote", printNote)
        .append("plainTextNotes", plainTextNotes)
        .append("hoursOfWork", hoursOfWork)
        .append("supportNoteId", supportNoteId)
        .append("serviceName", serviceName)
        .toString();
  }
}

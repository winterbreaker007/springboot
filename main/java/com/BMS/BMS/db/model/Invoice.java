package com.blackwater.blackwaterbillingmanagementsystem.db.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by samgi on 3/5/2021.
 */
@Entity
@Table(name = "tblInvoices")
public class Invoice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "invoice_id")
  private String id;

  @Column(name = "invoice_parent_job_id")
  private String parentJobId;

  @Column(name = "invoice_saved_by")
  private String savedBy;

  @Column(name = "invoice_date_saved")
  private LocalDateTime dateSaved;

  @Column(name = "invoice_type")
  private Integer type;

  @Column(name = "invoice_number")
  private BigInteger number;

  @Column(name = "invoice_header")
  private Integer header;

  @Column(name = "invoice_prepared_for")
  private String preparedFor;

  @Column(name = "invoice_grand_total")
  private Double grandTotal;

  @Column(name = "invoice_bill_to")
  private String billTo;

  @Column(name = "invoice_date_exported_to_qb")
  private LocalDateTime dateExportedToQB;

  @Column(name = "invoice_date_imported_from_qb")
  private LocalDateTime dateImportedFromQB;

  @Column(name = "invoice_overhead")
  private Double overhead;

  @Column(name = "invoice_profit")
  private Double profit;

  @Column(name = "invoice_drawing")
  private String drawing;

  @Column(name = "invoice_price_trade_name")
  private Integer priceTradeName;

  @Column(name = "invoice_price_list_version")
  private String priceListVersion;

  @Column(name = "invoice_carrier_invoiced_total_amount")
  private Double carrierInvoiced;

  @Column(name = "invoice_carrier_settled_total_amount")
  private Double carrierSettled;

  @Column(name = "invoice_carrier_issued_to_contractor_total_amount")
  private Double carrierIssuedContractor;

  @Column(name = "invoice_carrier_issued_to_client_total_amount")
  private Double carrierIssuedClient;

  @Column(name = "invoice_carrier_total_payment_received_by_contractor")
  private Double carrierReceived;

  @Column(name = "invoice_carrier_balance_due_to_contractor")
  private Double carrierDue;

  @Column(name = "invoice_client_invoiced_total_amount")
  private Double clientInvoiced;

  @Column(name = "invoice_client_deductible_due_to_contractor")
  private Double clientDeductible;

  @Column(name = "invoice_client_total_payment_received_by_contractor")
  private Double clientReceived;

  @Column(name = "invoice_client_balance_due_to_contractor")
  private Double clientDue;

  @Column(name = "invoice_client_late_payment")
  private Double clientLatePayment;

  @Column(name = "invoice_qb_invoice_list_id")
  private String qbInvoiceListID;

  @Column(name = "invoice_qb_customer_list_id")
  private String qbInvoiceCustomerListID;

  @Column(name = "invoice_qb_refnumber")
  private String qbInvoiceRefNum;

  @Column(name = "invoice_qb_date_created")
  private LocalDateTime qbInvoiceDateCreated;

  @Column(name = "invoice_qb_date_modified")
  private LocalDateTime qbInvoiceDateModified;

  @Column(name = "invoice_qb_invoice_txnid")
  private String qbInvoiceTxnID;

  @Column(name = "invoice_sales_tax")
  private Double invoiceSalesTax;

  @Column(name = "invoice_qb_invoice_total_amount")
  private Double qbTotal;



  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getParentJobId() {
    return parentJobId;
  }

  public void setParentJobId(String parentJobId) {
    this.parentJobId = parentJobId;
  }

  public String getSavedBy() {
    return savedBy;
  }

  public void setSavedBy(String savedBy) {
    this.savedBy = savedBy;
  }

  public LocalDateTime getDateSaved() {
    return dateSaved;
  }

  public void setDateSaved(LocalDateTime dateSaved) {
    this.dateSaved = dateSaved;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public BigInteger getNumber() {
    return number;
  }

  public void setNumber(BigInteger number) {
    this.number = number;
  }

  public Integer getHeader() {
    return header;
  }

  public void setHeader(Integer header) {
    this.header = header;
  }

  public String getPreparedFor() {
    return preparedFor;
  }

  public void setPreparedFor(String preparedFor) {
    this.preparedFor = preparedFor;
  }

  public Double getGrandTotal() {
    return grandTotal;
  }

  public void setGrandTotal(Double grandTotal) {
    this.grandTotal = grandTotal;
  }

  public String getBillTo() {
    return billTo;
  }

  public void setBillTo(String billTo) {
    this.billTo = billTo;
  }

  public LocalDateTime getDateExportedToQB() {
    return dateExportedToQB;
  }

  public void setDateExportedToQB(LocalDateTime dateExportedToQB) {
    this.dateExportedToQB = dateExportedToQB;
  }

  public LocalDateTime getDateImportedFromQB() {
    return dateImportedFromQB;
  }

  public void setDateImportedFromQB(LocalDateTime dateImportedFromQB) {
    this.dateImportedFromQB = dateImportedFromQB;
  }

  public Double getOverhead() {
    return overhead;
  }

  public void setOverhead(Double overhead) {
    this.overhead = overhead;
  }

  public Double getProfit() {
    return profit;
  }

  public void setProfit(Double profit) {
    this.profit = profit;
  }

  public String getDrawing() {
    return drawing;
  }

  public void setDrawing(String drawing) {
    this.drawing = drawing;
  }

  public Integer getPriceTradeName() {
    return priceTradeName;
  }

  public void setPriceTradeName(Integer priceTradeName) {
    this.priceTradeName = priceTradeName;
  }

  public String getPriceListVersion() {
    return priceListVersion;
  }

  public void setPriceListVersion(String priceListVersion) {
    this.priceListVersion = priceListVersion;
  }

  public Double getCarrierInvoiced() {
    return carrierInvoiced;
  }

  public void setCarrierInvoiced(Double carrierInvoiced) {
    this.carrierInvoiced = carrierInvoiced;
  }

  public Double getCarrierSettled() {
    return carrierSettled;
  }

  public void setCarrierSettled(Double carrierSettled) {
    this.carrierSettled = carrierSettled;
  }

  public Double getCarrierIssuedContractor() {
    return carrierIssuedContractor;
  }

  public void setCarrierIssuedContractor(Double carrierIssuedContractor) {
    this.carrierIssuedContractor = carrierIssuedContractor;
  }

  public Double getCarrierIssuedClient() {
    return carrierIssuedClient;
  }

  public void setCarrierIssuedClient(Double carrierIssuedClient) {
    this.carrierIssuedClient = carrierIssuedClient;
  }

  public Double getCarrierReceived() {
    return carrierReceived;
  }

  public void setCarrierReceived(Double carrierReceived) {
    this.carrierReceived = carrierReceived;
  }

  public Double getCarrierDue() {
    return carrierDue;
  }

  public void setCarrierDue(Double carrierDue) {
    this.carrierDue = carrierDue;
  }

  public Double getClientInvoiced() {
    return clientInvoiced;
  }

  public void setClientInvoiced(Double clientInvoiced) {
    this.clientInvoiced = clientInvoiced;
  }

  public Double getClientDeductible() {
    return clientDeductible;
  }

  public void setClientDeductible(Double clientDeductible) {
    this.clientDeductible = clientDeductible;
  }

  public Double getClientReceived() {
    return clientReceived;
  }

  public void setClientReceived(Double clientReceived) {
    this.clientReceived = clientReceived;
  }

  public Double getClientDue() {
    return clientDue;
  }

  public void setClientDue(Double clientDue) {
    this.clientDue = clientDue;
  }

  public Double getClientLatePayment() {
    return clientLatePayment;
  }

  public void setClientLatePayment(Double clientLatePayment) {
    this.clientLatePayment = clientLatePayment;
  }

  public String getQbInvoiceListID() {
    return qbInvoiceListID;
  }

  public void setQbInvoiceListID(String qbInvoiceListID) {
    this.qbInvoiceListID = qbInvoiceListID;
  }

  public String getQbInvoiceCustomerListID() {
    return qbInvoiceCustomerListID;
  }

  public void setQbInvoiceCustomerListID(String qbInvoiceCustomerListID) {
    this.qbInvoiceCustomerListID = qbInvoiceCustomerListID;
  }

  public String getQbInvoiceRefNum() {
    return qbInvoiceRefNum;
  }

  public void setQbInvoiceRefNum(String qbInvoiceRefNum) {
    this.qbInvoiceRefNum = qbInvoiceRefNum;
  }

  public LocalDateTime getQbInvoiceDateCreated() {
    return qbInvoiceDateCreated;
  }

  public void setQbInvoiceDateCreated(LocalDateTime qbInvoiceDateCreated) {
    this.qbInvoiceDateCreated = qbInvoiceDateCreated;
  }

  public LocalDateTime getQbInvoiceDateModified() {
    return qbInvoiceDateModified;
  }

  public void setQbInvoiceDateModified(LocalDateTime qbInvoiceDateModified) {
    this.qbInvoiceDateModified = qbInvoiceDateModified;
  }

  public String getQbInvoiceTxnID() {
    return qbInvoiceTxnID;
  }

  public void setQbInvoiceTxnID(String qbInvoiceTxnID) {
    this.qbInvoiceTxnID = qbInvoiceTxnID;
  }

  public Double getInvoiceSalesTax() {
    return invoiceSalesTax;
  }

  public void setInvoiceSalesTax(Double invoiceSalesTax) {
    this.invoiceSalesTax = invoiceSalesTax;
  }

  public Double getQbTotal() {
    return qbTotal;
  }

  public void setQbTotal(Double qbTotal) {
    this.qbTotal = qbTotal;
  }

  @Override
  public String toString() {
    return "Invoice{" +
            "id='" + id + '\'' +
            ", parentJobId='" + parentJobId + '\'' +
            ", savedBy='" + savedBy + '\'' +
            ", dateSaved=" + dateSaved +
            ", type=" + type +
            ", number=" + number +
            ", header=" + header +
            ", preparedFor='" + preparedFor + '\'' +
            ", grandTotal=" + grandTotal +
            ", billTo='" + billTo + '\'' +
            ", dateExportedToQB=" + dateExportedToQB +
            ", dateImportedFromQB=" + dateImportedFromQB +
            ", overhead=" + overhead +
            ", profit=" + profit +
            ", drawing='" + drawing + '\'' +
            ", priceTradeName=" + priceTradeName +
            ", priceListVersion='" + priceListVersion + '\'' +
            ", carrierInvoiced=" + carrierInvoiced +
            ", carrierSettled=" + carrierSettled +
            ", carrierIssuedContractor=" + carrierIssuedContractor +
            ", carrierIssuedClient=" + carrierIssuedClient +
            ", carrierReceived=" + carrierReceived +
            ", carrierDue=" + carrierDue +
            ", clientInvoiced=" + clientInvoiced +
            ", clientDeductible=" + clientDeductible +
            ", clientReceived=" + clientReceived +
            ", clientDue=" + clientDue +
            ", clientLatePayment=" + clientLatePayment +
            ", qbInvoiceListID='" + qbInvoiceListID + '\'' +
            ", qbInvoiceCustomerListID=" + qbInvoiceCustomerListID +
            ", qbInvoiceRefNum='" + qbInvoiceRefNum + '\'' +
            ", qbInvoiceDateCreated=" + qbInvoiceDateCreated +
            ", qbInvoiceDateModified=" + qbInvoiceDateModified +
            ", qbInvoiceTxnID='" + qbInvoiceTxnID + '\'' +
            ", invoiceSalesTax=" + invoiceSalesTax +
            ", qbTotal=" + qbTotal +
            '}';
  }
}

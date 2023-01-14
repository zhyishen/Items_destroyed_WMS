package com.safetychina.items_destroyed_wms.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "non_confidential_documents_entity")
public class NonConfidentialDocument {

    public NonConfidentialDocument() {
    }

    public NonConfidentialDocument(String department, String detail, Integer quantity, String transferor, String recipient, Date receiveDate) {
        this.department = department;
        this.detail = detail;
        this.quantity = quantity;
        this.transferor = transferor;
        this.recipient = recipient;
        this.receiveDate = receiveDate;
    }

    @Id
    @SequenceGenerator(
            name = "non_confidential_documents",
            sequenceName = "non_confidential_documents",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "non_confidential_documents",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String department;
    private String detail;
    private Integer quantity;
    private String transferor;
    private String recipient;
    private Date receiveDate;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTransferor() {
        return transferor;
    }

    public void setTransferor(String transferor) {
        this.transferor = transferor;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NonConfidentialDocument that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "NonConfidentialDocument{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", detail='" + detail + '\'' +
                ", quantity=" + quantity +
                ", transferor='" + transferor + '\'' +
                ", recipient='" + recipient + '\'' +
                ", receiveDate=" + receiveDate +
                '}';
    }
}
package com.safetychina.items_destroyed_wms.entity;

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
    private Long id;//非涉密文档实体序号
    private String department;//移交单位
    private String detail;//内容（明细）
    private Integer quantity;//数量（单位公斤）
    private String transferor;//移交人
    private String recipient;//接收人
    private Date receiveDate;//接收日期


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
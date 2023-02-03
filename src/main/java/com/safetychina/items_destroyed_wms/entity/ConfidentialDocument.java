package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;



@Entity
@Table(name = "confidential_documents_entity")
public class ConfidentialDocument {
    @Id
    @SequenceGenerator(
            name = "confidential_documents_generator",
            sequenceName = "confidential_documents_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confidential_documents_generator"
    )
    private Long id;//实体ID
    private String documentID;//保密文档编号
    private String title;//保密文档标题
    private Integer quantity;//保密文档数量（单位份数）
    private String secretLevel;//保密级别
    private String sendDepartment;//移交部门名称
    private String receiveDepartment;//接收部门名称
    private String recipient;//接收人
    private String transferor;//移交人
    private Date receiveDate;//接收日期

    public ConfidentialDocument() {
    }

    public ConfidentialDocument(String documentID,
                                String title,
                                Integer quantity,
                                String secretLevel,
                                String sendDepartment,
                                String receiveDepartment,
                                String recipient,
                                String transferor,
                                Date receiveDate) {
        this.documentID = documentID;
        this.title = title;
        this.quantity = quantity;
        this.secretLevel = secretLevel;
        this.sendDepartment = sendDepartment;
        this.receiveDepartment = receiveDepartment;
        this.recipient = recipient;
        this.transferor = transferor;
        this.receiveDate = receiveDate;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(String secretLevel) {
        this.secretLevel = secretLevel;
    }

    public String getSendDepartment() {
        return sendDepartment;
    }

    public void setSendDepartment(String sendDepartment) {
        this.sendDepartment = sendDepartment;
    }

    public String getReceiveDepartment() {
        return receiveDepartment;
    }

    public void setReceiveDepartment(String receiveDepartment) {
        this.receiveDepartment = receiveDepartment;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTransferor() {
        return transferor;
    }

    public void setTransferor(String transferor) {
        this.transferor = transferor;
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
        if (!(o instanceof ConfidentialDocument that)) return false;
        return getId().equals(that.getId()) && getDocumentID().equals(that.getDocumentID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDocumentID());
    }

    @Override
    public String toString() {
        return "ConfidentialDocument{" +
                "id=" + id +
                ", documentID='" + documentID + '\'' +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", secretLevel='" + secretLevel + '\'' +
                ", sendDepartment='" + sendDepartment + '\'' +
                ", receiveDepartment='" + receiveDepartment + '\'' +
                ", approveSignature='" + recipient + '\'' +
                ", transferSignature='" + transferor + '\'' +
                ", receiveDate=" + receiveDate +
                '}';
    }
}
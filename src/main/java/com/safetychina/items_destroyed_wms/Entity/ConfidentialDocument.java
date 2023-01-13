package com.safetychina.items_destroyed_wms.Entity;

import jakarta.persistence.*;

import java.util.Date;

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
    private Long id;
    private String documentID;
    private String title;
    private Integer quantity;
    private String secretLevel;
    private String sendDepartment;
    private String receiveDepartment;
    private String approveSignature;
    private String transferSignature;
    private Date receiveDate;

    public ConfidentialDocument() {
    }

    public ConfidentialDocument(String documentID,
                                String title,
                                Integer quantity,
                                String secretLevel,
                                String sendDepartment,
                                String receiveDepartment,
                                String approveSignature,
                                String transferSignature,
                                Date receiveDate) {
        this.documentID = documentID;
        this.title = title;
        this.quantity = quantity;
        this.secretLevel = secretLevel;
        this.sendDepartment = sendDepartment;
        this.receiveDepartment = receiveDepartment;
        this.approveSignature = approveSignature;
        this.transferSignature = transferSignature;
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

    public String getApproveSignature() {
        return approveSignature;
    }

    public void setApproveSignature(String approveSignature) {
        this.approveSignature = approveSignature;
    }

    public String getTransferSignature() {
        return transferSignature;
    }

    public void setTransferSignature(String transferSignature) {
        this.transferSignature = transferSignature;
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
}
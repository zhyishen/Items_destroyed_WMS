package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "electronics_entity")
public class Electronic {

    @Id
    @SequenceGenerator(name = "electronics_generator",
            sequenceName = "electronics_generator",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "electronics_generator")
    private Long id;
    private String equipmentName;
    private String type;
    private String secretLevel;
    private Integer quantity;
    private String departmentOfUse;
    private String personOfUse;
    private Date receiveDate;
    private String transferor;
    private String recipient;




    public Electronic() {
    }



    public Electronic(String equipmentName,
                      String type,
                      String secretLevel,
                      Integer quantity,
                      String departmentOfUse,
                      String personOfUse,
                      Date receiveDate,
                      String transferor,
                      String recipient) {
        this.equipmentName = equipmentName;
        this.type = type;
        this.secretLevel = secretLevel;
        this.quantity = quantity;
        this.departmentOfUse = departmentOfUse;
        this.personOfUse = personOfUse;
        this.receiveDate = receiveDate;
        this.transferor = transferor;
        this.recipient = recipient;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(String secretLevel) {
        this.secretLevel = secretLevel;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDepartmentOfUse() {
        return departmentOfUse;
    }

    public void setDepartmentOfUse(String departmentOfUse) {
        this.departmentOfUse = departmentOfUse;
    }

    public String getPersonOfUse() {
        return personOfUse;
    }

    public void setPersonOfUse(String personOfUse) {
        this.personOfUse = personOfUse;
    }

    public Long getId() {
        return id;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronic that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                ", type='" + type + '\'' +
                ", secretLevel='" + secretLevel + '\'' +
                ", quantity=" + quantity +
                ", departmentOfUse='" + departmentOfUse + '\'' +
                ", personOfUse='" + personOfUse + '\'' +
                ", receiveDate=" + receiveDate +
                ", transferor='" + transferor + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }
}
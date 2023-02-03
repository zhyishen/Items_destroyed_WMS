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
    private Long id;//电子类实体ID
    private String equipmentName;//设备名称
    private String type;//设备类型
    private String secretLevel;//保密级别
    private Integer quantity;//设备数量
    private String sendDepartment;//移交部门
    private String personOfUse;//使用责任人
    private Date receiveDate;//入库时间
    private String transferor;//移交人
    private String recipient;//接收人
    private String notes;//备注




    public Electronic() {
    }



    public Electronic(String equipmentName,
                      String type,
                      String secretLevel,
                      Integer quantity,
                      String sendDepartment,
                      String personOfUse,
                      Date receiveDate,
                      String transferor,
                      String recipient,
                      String notes) {
        this.equipmentName = equipmentName;
        this.type = type;
        this.secretLevel = secretLevel;
        this.quantity = quantity;
        this.sendDepartment = sendDepartment;
        this.personOfUse = personOfUse;
        this.receiveDate = receiveDate;
        this.transferor = transferor;
        this.recipient = recipient;
        this.notes = notes;
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

    public String getSendDepartment() {
        return sendDepartment;
    }

    public void setSendDepartment(String sendDepartment) {
        this.sendDepartment = sendDepartment;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
                ", sendDepartment='" + sendDepartment + '\'' +
                ", personOfUse='" + personOfUse + '\'' +
                ", receiveDate=" + receiveDate +
                ", transferor='" + transferor + '\'' +
                ", recipient='" + recipient + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
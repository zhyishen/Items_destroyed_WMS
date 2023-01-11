package com.safetychina.items_destroyed_wms.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "electronics_entity")
public class ElectronicsEntity {

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

    public ElectronicsEntity() {
    }

    public ElectronicsEntity(String equipmentName,
                             String type,
                             String secretLevel,
                             Integer quantity,
                             String departmentOfUse,
                             String personOfUse) {
        this.equipmentName = equipmentName;
        this.type = type;
        this.secretLevel = secretLevel;
        this.quantity = quantity;
        this.departmentOfUse = departmentOfUse;
        this.personOfUse = personOfUse;
    }

    @Override
    public String toString() {
        return "ElectronicsEntity{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                ", type='" + type + '\'' +
                ", secretLevel='" + secretLevel + '\'' +
                ", quantity=" + quantity +
                ", departmentOfUse='" + departmentOfUse + '\'' +
                ", personOfUse='" + personOfUse + '\'' +
                '}';
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


}
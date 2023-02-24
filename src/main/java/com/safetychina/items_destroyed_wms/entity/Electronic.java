package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "electronics_entity")
@Data
@NoArgsConstructor
public class Electronic {

    @Id
    @SequenceGenerator(name = "electronics_generator",
            sequenceName = "electronics_generator",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "electronics_generator")
    @Setter(AccessLevel.NONE)
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

    public Electronic(String equipmentName, String type, String secretLevel, Integer quantity, String sendDepartment, String personOfUse, Date receiveDate, String transferor, String recipient, String notes) {
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
}
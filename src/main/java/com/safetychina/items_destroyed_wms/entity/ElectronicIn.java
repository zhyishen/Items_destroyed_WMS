package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "electronics_entity_in")
@Data
@NoArgsConstructor
public class ElectronicIn {

    @Id
    @SequenceGenerator(name = "input_electronics_generator",
            sequenceName = "input_electronics_generator",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "input_electronics_generator")
    @Setter(AccessLevel.NONE)
    private Long id;//电子类实体ID

    @NotNull(message = "设备名称不能为空")
    private String equipmentName;//设备名称
    @NotNull(message = "设备类型不能为空")
    private String type;//设备类型
    @NotNull(message = "保密级别不能为空")
    private String secretLevel;//保密级别

    @Min(value = 0, message = "设备数量不能为空")
    private Integer quantity;//设备数量
    @ManyToOne
    @NotNull(message = "移交部门不能为空")
    private Department sendDepartment;//移交部门
    @NotNull(message = "使用责任人不能为空")
    private String personOfUse;//使用责任人
    @NotNull(message = "入库时间不能为空")
    private Date receiveDate;//入库时间
    @NotNull(message = "接收人不能为空")
    private String recipient;//接收人
    private String notes;//备注

    public ElectronicIn(String equipmentName, String type, String secretLevel, Integer quantity, Department sendDepartment, String personOfUse, Date receiveDate, String recipient, String notes) {
        this.equipmentName = equipmentName;
        this.type = type;
        this.secretLevel = secretLevel;
        this.quantity = quantity;
        this.sendDepartment = sendDepartment;
        this.personOfUse = personOfUse;
        this.receiveDate = receiveDate;
        this.recipient = recipient;
        this.notes = notes;
    }
}
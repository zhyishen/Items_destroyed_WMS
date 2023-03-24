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
@Table(name = "electronics_entity_out")
@Data
@NoArgsConstructor
public class ElectronicOut {


    @Id
    @SequenceGenerator(name = "output_electronic_generator",
            sequenceName = "output_electronic_generator",
            allocationSize = 1)
    @GeneratedValue(generator = "output_electronic_generator",
            strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "设备类型不能为空")
    private String type;//设备类型
    @NotNull(message = "保密级别不能为空")
    private String secretLevel;//保密级别
    @Min(value = 0, message = "设备数量不能为空")
    private Integer quantity;//设备数量
    @ManyToOne
    @NotNull(message = "接收部门不能为空")
    private Department receiveDepartment;//接收部门
    @NotNull(message = "出库时间不能为空")
    private Date sendDate;//出库时间
    @NotNull(message = "移交人不能为空")
    private String transferor;//移交人

    public ElectronicOut(String type, String secretLevel, Integer quantity, Department receiveDepartment, Date sendDate, String transferor, String recipient) {
        this.type = type;
        this.secretLevel = secretLevel;
        this.quantity = quantity;
        this.receiveDepartment = receiveDepartment;
        this.sendDate = sendDate;
        this.transferor = transferor;
    }
}

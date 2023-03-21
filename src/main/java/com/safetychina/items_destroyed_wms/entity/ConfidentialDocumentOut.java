package com.safetychina.items_destroyed_wms.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "confidential_documents_entity_out")
@Data
@NoArgsConstructor
public class ConfidentialDocumentOut {

    @Id
    @SequenceGenerator(name = "output_confidential_documents_generator",
            sequenceName = "output_confidential_documents_generator",
            allocationSize = 1)
    @GeneratedValue(generator = "output_confidential_documents_generator",
            strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "涉密文档数量不能为空")
    @Min(value = 0,message = "涉密文档数量不为负数")
    private Integer quantity;//涉密文档数量（单位份数）
    @NotEmpty(message = "涉密级别不能为空")
    private String secretLevel;//涉密级别
    @NotEmpty(message = "移交部门不能为空")
    private String sendDepartment;//移交部门名称
    @NotEmpty(message = "接收部门不能为空")
    private String receiveDepartment;//接收部门名称
    @NotEmpty(message = "接收人不能为空")
    private String recipient;//接收人
    @NotEmpty(message = "移交人不能为空")
    private String transferor;//移交人
    @NotNull(message = "接收日期不能为空")
    private Date sendDate;//移交日期

    public ConfidentialDocumentOut(Integer quantity, String secretLevel, String sendDepartment, String receiveDepartment, String recipient, String transferor, Date sendDate) {
        this.quantity = quantity;
        this.secretLevel = secretLevel;
        this.sendDepartment = sendDepartment;
        this.receiveDepartment = receiveDepartment;
        this.recipient = recipient;
        this.transferor = transferor;
        this.sendDate = sendDate;
    }
}

package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;


@Entity
@Table(name = "confidential_documents_entity_in")
@Data
@NoArgsConstructor
public class ConfidentialDocumentIn {
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
    @Setter(AccessLevel.NONE)
    private Long id;//实体ID

    @Column(unique = true)
    @NotNull(message = "涉密文档编号不能为空")
    private String documentID;//涉密文档编号
    @NotNull(message = "涉密文档标题不能为空")
    private String title;//涉密文档标题
    @NotNull(message = "涉密文档数量不能为空")
    @Min(value = 0,message = "涉密文档数量不为负数")
    private Integer quantity;//涉密文档数量（单位份数）
    @NotNull(message = "涉密级别不能为空")
    private String secretLevel;//涉密级别
    @NotNull(message = "移交部门不能为空")
    private String sendDepartment;//移交部门名称
    @NotNull(message = "接收部门不能为空")
    private String receiveDepartment;//接收部门名称
    @NotNull(message = "接收人不能为空")
    private String recipient;//接收人
    @NotNull(message = "移交人不能为空")
    private String transferor;//移交人
    @NotNull(message = "接收日期不能为空")
    private Date receiveDate;//接收日期

    public ConfidentialDocumentIn(String documentID, String title, Integer quantity, String secretLevel, String sendDepartment, String receiveDepartment, String recipient, String transferor, Date receiveDate) {
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
}
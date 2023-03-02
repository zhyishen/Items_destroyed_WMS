package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;



@Entity
@Table(name = "confidential_documents_entity")
@Data
@NoArgsConstructor
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
    @Setter(AccessLevel.NONE)
    private Long id;//实体ID

    @Column(unique = true)
    private String documentID;//保密文档编号
    private String title;//保密文档标题
    private Integer quantity;//保密文档数量（单位份数）
    private String secretLevel;//保密级别
    private String sendDepartment;//移交部门名称
    private String receiveDepartment;//接收部门名称
    private String recipient;//接收人
    private String transferor;//移交人
    private Date receiveDate;//接收日期

    public ConfidentialDocument(String documentID, String title, Integer quantity, String secretLevel, String sendDepartment, String receiveDepartment, String recipient, String transferor, Date receiveDate) {
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
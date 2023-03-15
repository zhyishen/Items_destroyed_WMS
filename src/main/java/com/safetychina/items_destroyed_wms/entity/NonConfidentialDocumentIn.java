package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "non_confidential_documents_entity_in")
@Data
@NoArgsConstructor
public class NonConfidentialDocumentIn {


    public NonConfidentialDocumentIn(String department, String detail, Integer quantity, String transferor, String recipient, Date receiveDate) {
        this.department = department;
        this.detail = detail;
        this.quantity = quantity;
        this.transferor = transferor;
        this.recipient = recipient;
        this.receiveDate = receiveDate;
    }

    @Id
    @SequenceGenerator(
            name = "non_confidential_documents",
            sequenceName = "non_confidential_documents",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "non_confidential_documents",
            strategy = GenerationType.SEQUENCE
    )
    @Setter(AccessLevel.NONE)
    private Long id;//非涉密文档实体序号
    private String department;//移交单位
    private String detail;//内容（明细）
    private Integer quantity;//数量（单位公斤）
    private String transferor;//移交人
    private String recipient;//接收人
    private Date receiveDate;//接收日期

}
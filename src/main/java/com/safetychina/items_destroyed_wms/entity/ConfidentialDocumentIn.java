package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
            name = "input_confidential_documents_generator",
            sequenceName = "input_confidential_documents_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "input_confidential_documents_generator"
    )
    @Setter(AccessLevel.NONE)
    private Long id;//实体ID

    @Column(unique = true)
    @NotEmpty(message = "涉密文档编号不能为空")
    private String documentID;//涉密文档编号
    @NotEmpty(message = "涉密文档标题不能为空")
    private String title;//涉密文档标题
    @NotNull(message = "涉密文档数量不能为空")
    @Min(value = 0,message = "涉密文档数量不为负数")
    private Integer quantity;//涉密文档数量（单位份数）
    @NotEmpty(message = "涉密级别不能为空")
    private String secretLevel;//涉密级别

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "companyId")
    @NotNull(message = "移交部门不能为空")
    private Company sendCompany;

    @NotEmpty(message = "接收人不能为空")
    private String recipient;//接收人

    @NotNull(message = "接收日期不能为空")
    private Date receiveDate;//接收日期

    public ConfidentialDocumentIn(String documentID, String title, Integer quantity, String secretLevel, Company sendCompany, String recipient, Date receiveDate) {
        this.documentID = documentID;
        this.title = title;
        this.quantity = quantity;
        this.secretLevel = secretLevel;
        this.sendCompany = sendCompany;
        this.recipient = recipient;
        this.receiveDate = receiveDate;
    }
}
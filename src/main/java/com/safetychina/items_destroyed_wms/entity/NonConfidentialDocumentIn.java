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
@Table(name = "non_confidential_documents_entity_in")
@Data
@NoArgsConstructor
public class NonConfidentialDocumentIn {


    public NonConfidentialDocumentIn(String department, String detail, Double quantity, String transferor, String recipient, Date receiveDate) {
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
    @NotNull(message = "移交单位不能为空")
    private String department;//移交单位
    @NotNull(message = "内容不能为空")
    private String detail;//内容（明细）
    @NotNull(message = "数量不能为空")
    @Min(value = 0, message = "数量")
    private Double quantity;//数量（单位公斤）
    @NotNull(message = "移交人不能为空")
    private String transferor;//移交人
    @NotNull(message = "接收人不能为空")
    private String recipient;//接收人
    @NotNull(message = "接收日期不能为空")
    private Date receiveDate;//接收日期

}
package com.safetychina.items_destroyed_wms.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "non_confidential_documents_entity_out")
@Data
@NoArgsConstructor
@Getter
@Setter
public class NonConfidentialDocumentOut {

    @Id
    @SequenceGenerator(name = "output_non_confidential_documents_generator",
            sequenceName = "output_non_confidential_documents_generator",
            allocationSize = 1)
    @GeneratedValue(generator = "output_non_confidential_documents_generator",
            strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "移交单位不能为空")
    private String department;//移交单位
    @NotNull(message = "数量不能为空")
    @Min(value = 0, message = "数量不为负数")
    private Double quantity;//数量（单位公斤）
    @NotNull(message = "移交人不能为空")
    private String transferor;//移交人
    @NotNull(message = "接收人不能为空")
    private String recipient;//接收人
    @NotNull(message = "移交日期不能为空")
    private Date sendDate;//移交日期

    public NonConfidentialDocumentOut(String department, Double quantity, String transferor, String recipient, Date sendDate) {
        this.department = department;
        this.quantity = quantity;
        this.transferor = transferor;
        this.recipient = recipient;
        this.sendDate = sendDate;
    }
}

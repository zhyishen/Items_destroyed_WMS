package com.safetychina.items_destroyed_wms.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "non_confidential_documents_entity")
public class NonConfidentialDocument {
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
    private Long id;
    private String department;
    private String detail;
    private Integer quantity;
    private String transferor;
    private String recipient;
    private Date receiveDate;
}
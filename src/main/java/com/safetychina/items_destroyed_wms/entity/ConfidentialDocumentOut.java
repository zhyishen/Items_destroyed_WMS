package com.safetychina.items_destroyed_wms.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}

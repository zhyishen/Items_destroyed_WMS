package com.safetychina.items_destroyed_wms.entity;


import jakarta.persistence.*;
import lombok.*;

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
}

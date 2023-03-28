package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "electronics_type")
public class ElectronicType {
    @Id
    @Setter(AccessLevel.NONE)
    @SequenceGenerator(name = "electronics_type_generator",
            sequenceName = "electronics_type_generator",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "electronics_type_generator")
    private Long id;
    @Column(unique = true)
    @NotNull
    private String typeName;
}

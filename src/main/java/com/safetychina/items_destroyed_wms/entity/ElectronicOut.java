package com.safetychina.items_destroyed_wms.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "electronics_entity_out")
@Data
@NoArgsConstructor
public class ElectronicOut {


    @Id
    @SequenceGenerator(name = "output_electronic_generator",
            sequenceName = "output_electronic_generator",
            allocationSize = 1)
    @GeneratedValue(generator = "output_electronic_generator",
            strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;

}

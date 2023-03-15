package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
@Table(name = "company_out")
public class CompanyOut {

    @Id
    @SequenceGenerator(name = "company_out_generator",
            sequenceName = "company_out_generator",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "company_out_generator")
    @Setter(AccessLevel.NONE)
    private Long id;
}
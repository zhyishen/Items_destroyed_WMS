package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "company_in")
@Data
public class CompanyIn {

    @Id
    @SequenceGenerator(name = "company_in_generator",
            sequenceName = "company_in_generator",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "company_in_generator")
    @Setter(AccessLevel.NONE)
    private Long id;
}
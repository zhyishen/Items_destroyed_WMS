package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
public class Company {

    @Id
    @SequenceGenerator(name = "company_generator",
            sequenceName = "company_generator",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "company_generator")
    @Setter(AccessLevel.NONE)
    private Long companyId;
    @NotNull(message = "部门名称不能为空")
    private String companyName;
    @NotNull(message = "联系人不能为空")
    private String person;
    @NotNull(message = "部门类型不能为空")
    private String type;

    public Company(String companyName, String person, String type) {
        this.companyName = companyName;
        this.person = person;
        this.type = type;
    }
}
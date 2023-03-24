package com.safetychina.items_destroyed_wms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
public class Department {

    @Id
    @SequenceGenerator(name = "department_generator",
            sequenceName = "department_generator",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "department_generator")
    @Setter(AccessLevel.NONE)
    private Long departmentId;
    @NotNull(message = "部门名称不能为空")
    private String departmentName;
    @NotNull(message = "联系人不能为空")
    private String contact;
    @NotNull(message = "部门类型不能为空")
    private String type;

    public Department(String departmentName, String contact, String type) {
        this.departmentName = departmentName;
        this.contact = contact;
        this.type = type;
    }
}
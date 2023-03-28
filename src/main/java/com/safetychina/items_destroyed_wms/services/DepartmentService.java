package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    void addDepartment(Department department);

    Department getDepartment(Long id);

    List<Department> getDepartments();

    List<Department> getSendDepartments();

    List<Department> getReceiveDepartments();

    void deleteDepartment(Long id);

    Department updateDepartment(Department newDepartment, Long id);
}

package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByType(String type);

}
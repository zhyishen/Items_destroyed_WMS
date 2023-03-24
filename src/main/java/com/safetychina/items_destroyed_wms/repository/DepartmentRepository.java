package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
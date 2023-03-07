package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.Electronic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ElectronicRepository extends JpaRepository<Electronic, Long> {
    @Query("select distinct type FROM Electronic")
    List<String> getAllType();

    @Query("select distinct sendDepartment FROM Electronic")
    List<String> getAllDepartment();
}
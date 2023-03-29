package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectronicTypeRepository extends JpaRepository<Equipment, Long> {
}
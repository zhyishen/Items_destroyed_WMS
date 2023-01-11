package com.safetychina.items_destroyed_wms.Repository;

import com.safetychina.items_destroyed_wms.Entity.ElectronicsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectronicsRepository<, ID> extends JpaRepository<ElectronicsEntity, ID> {
}
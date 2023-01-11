package com.safetychina.items_destroyed_wms.Repository;

import com.safetychina.items_destroyed_wms.Entity.ConfidentialDocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfidentialDocumentsRepository<, ID> extends JpaRepository<ConfidentialDocumentsEntity, ID> {
}
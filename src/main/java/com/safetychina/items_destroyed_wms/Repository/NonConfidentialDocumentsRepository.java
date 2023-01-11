package com.safetychina.items_destroyed_wms.Repository;

import com.safetychina.items_destroyed_wms.Entity.NonConfidentialDocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonConfidentialDocumentsRepository<, ID> extends JpaRepository<NonConfidentialDocumentsEntity, ID> {
}
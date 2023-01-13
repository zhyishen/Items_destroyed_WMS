package com.safetychina.items_destroyed_wms.Repository;

import com.safetychina.items_destroyed_wms.Entity.NonConfidentialDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonConfidentialDocumentRepository extends JpaRepository<NonConfidentialDocument, Long> {
}
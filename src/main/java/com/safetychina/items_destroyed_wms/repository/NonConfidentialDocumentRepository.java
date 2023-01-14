package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonConfidentialDocumentRepository extends JpaRepository<NonConfidentialDocument, Long> {
}
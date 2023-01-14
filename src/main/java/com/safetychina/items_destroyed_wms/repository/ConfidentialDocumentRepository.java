package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.ConfidentialDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfidentialDocumentRepository extends JpaRepository<ConfidentialDocument, Long> {
}
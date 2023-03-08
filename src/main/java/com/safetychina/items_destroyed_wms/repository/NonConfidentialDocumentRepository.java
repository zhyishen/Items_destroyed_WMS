package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NonConfidentialDocumentRepository extends JpaRepository<NonConfidentialDocument, Long> {

    @Query("select distinct n.department FROM NonConfidentialDocument n")
    List<String> getAllDepartment();

    @Query("select distinct n.recipient FROM NonConfidentialDocument n")
    List<String> getAllRecipient();

    @Query("select distinct n.transferor FROM NonConfidentialDocument n")
    List<String> getAllTransferor();
}
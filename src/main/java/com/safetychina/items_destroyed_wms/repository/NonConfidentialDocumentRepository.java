package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NonConfidentialDocumentRepository extends JpaRepository<NonConfidentialDocumentIn, Long> {

    @Query("select distinct n.department FROM NonConfidentialDocumentIn n")
    List<String> getAllDepartment();

    @Query("select distinct n.recipient FROM NonConfidentialDocumentIn n")
    List<String> getAllRecipient();

    @Query("select distinct n.transferor FROM NonConfidentialDocumentIn n")
    List<String> getAllTransferor();
}
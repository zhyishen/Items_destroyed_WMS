package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NonConfidentialDocumentInRepository extends JpaRepository<NonConfidentialDocumentIn, Long> {


    @Query("select distinct n.recipient FROM NonConfidentialDocumentIn n")
    List<String> getAllRecipient();

}
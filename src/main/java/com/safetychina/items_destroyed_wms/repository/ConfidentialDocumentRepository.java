package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.ConfidentialDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConfidentialDocumentRepository extends JpaRepository<ConfidentialDocument, Long> {

    @Query("select distinct c.receiveDepartment FROM ConfidentialDocument c")
    List<String> getAllReceiveDepartment();

    @Query("select distinct c.sendDepartment FROM ConfidentialDocument c")
    List<String> getAllSendDepartment();

    @Query("select distinct c.recipient FROM ConfidentialDocument c")
    List<String> getAllRecipient();

    @Query("select distinct c.transferor FROM ConfidentialDocument c")
    List<String> getAllTransferor();
}
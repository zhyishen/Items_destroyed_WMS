package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.ConfidentialDocumentIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConfidentialDocumentInRepository extends JpaRepository<ConfidentialDocumentIn, Long> {

    @Query("select distinct c.receiveDepartment FROM ConfidentialDocumentIn c")
    List<String> getAllReceiveDepartment();

    @Query("select distinct c.sendDepartment FROM ConfidentialDocumentIn c")
    List<String> getAllSendDepartment();

    @Query("select distinct c.recipient FROM ConfidentialDocumentIn c")
    List<String> getAllRecipient();

    @Query("select distinct c.transferor FROM ConfidentialDocumentIn c")
    List<String> getAllTransferor();
}
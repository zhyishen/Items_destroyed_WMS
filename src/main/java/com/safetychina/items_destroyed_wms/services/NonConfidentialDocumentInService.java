package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentIn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NonConfidentialDocumentInService {
    List<NonConfidentialDocumentIn> getNonConfidentialDocuments();
    void addNonConfidentialDocument(NonConfidentialDocumentIn nonConfidentialDocumentIn);
    NonConfidentialDocumentIn putNonConfidentialDocument(NonConfidentialDocumentIn newNonConfidentialDocumentIn, Long id);
    void deleteNonConfidentialDocument(Long id);
    NonConfidentialDocumentIn getNonConfidentialDocument(Long id);
    String getNonConfidentialDocumentDepartments();
    String getNonConfidentialDocumentRecipients();
    String getNonConfidentialDocumentTransferors();
}

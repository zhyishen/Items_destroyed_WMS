package com.safetychina.items_destroyed_wms.Services;


import com.safetychina.items_destroyed_wms.Entity.NonConfidentialDocument;
import com.safetychina.items_destroyed_wms.Repository.NonConfidentialDocumentRepository;
import org.springframework.stereotype.Service;

@Service

public class NonConfidentialDocumentServices {
    private final NonConfidentialDocumentRepository nonConfidentialDocumentRepository;

    public NonConfidentialDocumentServices(NonConfidentialDocumentRepository nonConfidentialDocumentRepository) {
        this.nonConfidentialDocumentRepository = nonConfidentialDocumentRepository;
    }

    public List<NonConfidentialDocument> getNonConfidentialDocuments(){


    }


    public void addNonConfidentialDocuments(NonConfidentialDocument nonConfidentialDocuments){
        nonConfidentialDocumentRepository.save(nonConfidentialDocuments);
    }
    
    public void putNonConfidentialDocuments




}

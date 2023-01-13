package com.safetychina.items_destroyed_wms.Services;


import com.safetychina.items_destroyed_wms.Entity.NonConfidentialDocument;
import com.safetychina.items_destroyed_wms.Repository.NonConfidentialDocumentRepository;
import org.springframework.stereotype.Service;

@Service

public class NonConfidentialDocumentService {
    private final NonConfidentialDocumentRepository nonConfidentialDocumentRepository;

    public NonConfidentialDocumentService(NonConfidentialDocumentRepository nonConfidentialDocumentRepository) {
        this.nonConfidentialDocumentRepository = nonConfidentialDocumentRepository;
    }

    public List<NonConfidentialDocument> getNonConfidentialDocuments(){


    }


    public void addNonConfidentialDocument(NonConfidentialDocument nonConfidentialDocument){
        nonConfidentialDocumentRepository.save(nonConfidentialDocument);
    }
    
    public void putNonConfidentialDocument(NonConfidentialDocument nonConfidentialDocument){
        nonConfidentialDocumentRepository.update(nonConfidentialDocument);
    }

    public void deleteNon




}

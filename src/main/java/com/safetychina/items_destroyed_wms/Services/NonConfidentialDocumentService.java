package com.safetychina.items_destroyed_wms.Services;


import com.safetychina.items_destroyed_wms.Entity.NonConfidentialDocument;
import com.safetychina.items_destroyed_wms.Repository.NonConfidentialDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonConfidentialDocumentService {
    private final NonConfidentialDocumentRepository nonConfidentialDocumentRepository;

    public NonConfidentialDocumentService(NonConfidentialDocumentRepository nonConfidentialDocumentRepository) {
        this.nonConfidentialDocumentRepository = nonConfidentialDocumentRepository;
    }

    public List<NonConfidentialDocument> getNonConfidentialDocuments(){
        return nonConfidentialDocumentRepository.findAll();

    }


    public void addNonConfidentialDocument(NonConfidentialDocument nonConfidentialDocument){
        nonConfidentialDocumentRepository.save(nonConfidentialDocument);
    }
    
    public void putNonConfidentialDocument(NonConfidentialDocument nonConfidentialDocument){
        nonConfidentialDocumentRepository.update(nonConfidentialDocument);
    }

    public void deleteNonConfidentialDocument(NonConfidentialDocument nonConfidentialDocument){
        nonConfidentialDocumentRepository.delete(nonConfidentialDocument);
    }




}

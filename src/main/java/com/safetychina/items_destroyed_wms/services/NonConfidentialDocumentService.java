package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocument;
import com.safetychina.items_destroyed_wms.exception.NonConfidentialDocumentNotFoundException;
import com.safetychina.items_destroyed_wms.repository.NonConfidentialDocumentRepository;
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
    
    public NonConfidentialDocument putNonConfidentialDocument(NonConfidentialDocument newNonConfidentialDocument, Long id){
        return nonConfidentialDocumentRepository.findById(id)
                .map(nonConfidentialDocument ->{
                    nonConfidentialDocument.setDepartment(newNonConfidentialDocument.getDepartment());
                    nonConfidentialDocument.setQuantity(newNonConfidentialDocument.getQuantity());
                    nonConfidentialDocument.setDetail(newNonConfidentialDocument.getDetail());
                    nonConfidentialDocument.setReceiveDate(newNonConfidentialDocument.getReceiveDate());
                    nonConfidentialDocument.setRecipient(newNonConfidentialDocument.getRecipient());
                    nonConfidentialDocument.setTransferor(newNonConfidentialDocument.getTransferor());
                    return nonConfidentialDocumentRepository.save(nonConfidentialDocument);
                } )
                .orElseThrow(()->new NonConfidentialDocumentNotFoundException(id));
    }

    public void deleteNonConfidentialDocument(Long id){
        nonConfidentialDocumentRepository.deleteById(id);
    }

    public NonConfidentialDocument getNonConfidentialDocument(Long id){
        return nonConfidentialDocumentRepository.findById(id)
                .orElseThrow(()->new NonConfidentialDocumentNotFoundException(id));
    }






}

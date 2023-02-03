package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.entity.ConfidentialDocument;
import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocument;
import com.safetychina.items_destroyed_wms.exception.ConfidentialDocumentNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ConfidentialDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfidentialDocumentService {

    private  final ConfidentialDocumentRepository confidentialDocumentRepository;

    public ConfidentialDocumentService(ConfidentialDocumentRepository confidentialDocumentRepository) {
        this.confidentialDocumentRepository = confidentialDocumentRepository;
    }

    public List<ConfidentialDocument> getConfidentialDocuments(){ return  confidentialDocumentRepository.findAll();}

    public void addConfidentialDocument(ConfidentialDocument confidentialDocument){
        confidentialDocumentRepository.save(confidentialDocument);
    }


    public ConfidentialDocument putConfidentialDocument(ConfidentialDocument newConfidentialDocument, Long id){
        return confidentialDocumentRepository.findById(id)
                .map(confidentialDocument -> {
                    confidentialDocument.setDocumentID(newConfidentialDocument.getDocumentID());
                    confidentialDocument.setTitle(newConfidentialDocument.getTitle());
                    confidentialDocument.setQuantity(newConfidentialDocument.getQuantity());
                    confidentialDocument.setSecretLevel(newConfidentialDocument.getSecretLevel());
                    confidentialDocument.setSendDepartment(newConfidentialDocument.getSendDepartment());
                    confidentialDocument.setReceiveDepartment(newConfidentialDocument.getReceiveDepartment());
                    confidentialDocument.setRecipient(newConfidentialDocument.getRecipient());
                    confidentialDocument.setTransferor(newConfidentialDocument.getTransferor());
                    confidentialDocument.setReceiveDate(newConfidentialDocument.getReceiveDate());
                    return confidentialDocumentRepository.save(confidentialDocument);
                })
                .orElseThrow(()->new ConfidentialDocumentNotFoundException(id));
    }


    public void deleteConfidentialDocument(Long id){confidentialDocumentRepository.deleteById(id);}

    public ConfidentialDocument getConfidentialDocument(Long id){
        return confidentialDocumentRepository.findById(id)
                .orElseThrow(()-> new ConfidentialDocumentNotFoundException(id));
    }



    public void addNonConfidentialDocuments(NonConfidentialDocument c){

    }

}

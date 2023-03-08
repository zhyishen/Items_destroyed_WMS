package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.Utils.StringToJsonUtil;
import com.safetychina.items_destroyed_wms.entity.ConfidentialDocument;
import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocument;
import com.safetychina.items_destroyed_wms.exception.ConfidentialDocumentNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ConfidentialDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfidentialDocumentService {

    private  final ConfidentialDocumentRepository confidentialDocumentRepository;
    private  final StringToJsonUtil stringToJsonUtil;

    public ConfidentialDocumentService(ConfidentialDocumentRepository confidentialDocumentRepository, StringToJsonUtil stringToJsonUtil) {
        this.confidentialDocumentRepository = confidentialDocumentRepository;
        this.stringToJsonUtil = stringToJsonUtil;
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


    public String getConfidentialDocumentReceiveDepartments(){
        List<String> receiveDepartments = confidentialDocumentRepository.getAllReceiveDepartment();
        return stringToJsonUtil.stringToJsonString(receiveDepartments);
    }

    public String getConfidentialDocumentRecipients(){
        List<String> recipients = confidentialDocumentRepository.getAllRecipient();
        return stringToJsonUtil.stringToJsonString(recipients);
    }

    public String getConfidentialDocumentSendDepartments(){
        List<String> sendDepartments = confidentialDocumentRepository.getAllSendDepartment();
        return stringToJsonUtil.stringToJsonString(sendDepartments);
    }

    public String getConfidentialDocumentTransferors(){
        List<String> transferors = confidentialDocumentRepository.getAllTransferor();
        return stringToJsonUtil.stringToJsonString(transferors);
    }

}

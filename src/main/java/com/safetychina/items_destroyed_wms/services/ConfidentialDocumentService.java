package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.Utils.StringToJsonUtil;
import com.safetychina.items_destroyed_wms.entity.ConfidentialDocumentIn;
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

    public List<ConfidentialDocumentIn> getConfidentialDocuments(){ return  confidentialDocumentRepository.findAll();}

    public void addConfidentialDocument(ConfidentialDocumentIn confidentialDocumentIn){
        confidentialDocumentRepository.save(confidentialDocumentIn);
    }


    public ConfidentialDocumentIn putConfidentialDocument(ConfidentialDocumentIn newConfidentialDocumentIn, Long id){
        return confidentialDocumentRepository.findById(id)
                .map(confidentialDocumentIn -> {
                    confidentialDocumentIn.setDocumentID(newConfidentialDocumentIn.getDocumentID());
                    confidentialDocumentIn.setTitle(newConfidentialDocumentIn.getTitle());
                    confidentialDocumentIn.setQuantity(newConfidentialDocumentIn.getQuantity());
                    confidentialDocumentIn.setSecretLevel(newConfidentialDocumentIn.getSecretLevel());
                    confidentialDocumentIn.setSendDepartment(newConfidentialDocumentIn.getSendDepartment());
                    confidentialDocumentIn.setReceiveDepartment(newConfidentialDocumentIn.getReceiveDepartment());
                    confidentialDocumentIn.setRecipient(newConfidentialDocumentIn.getRecipient());
                    confidentialDocumentIn.setTransferor(newConfidentialDocumentIn.getTransferor());
                    confidentialDocumentIn.setReceiveDate(newConfidentialDocumentIn.getReceiveDate());
                    return confidentialDocumentRepository.save(confidentialDocumentIn);
                })
                .orElseThrow(()->new ConfidentialDocumentNotFoundException(id));
    }


    public void deleteConfidentialDocument(Long id){confidentialDocumentRepository.deleteById(id);}

    public ConfidentialDocumentIn getConfidentialDocument(Long id){
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

package com.safetychina.items_destroyed_wms.services.impl;


import com.safetychina.items_destroyed_wms.Utils.StringToJsonUtil;
import com.safetychina.items_destroyed_wms.entity.ConfidentialDocumentIn;
import com.safetychina.items_destroyed_wms.exception.ConfidentialDocumentInNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ConfidentialDocumentInRepository;
import com.safetychina.items_destroyed_wms.services.ConfidentialDocumentInService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfidentialDocumentInServiceImpl implements ConfidentialDocumentInService {

    private  final ConfidentialDocumentInRepository confidentialDocumentInRepository;
    private  final StringToJsonUtil stringToJsonUtil;


    public ConfidentialDocumentInServiceImpl(ConfidentialDocumentInRepository confidentialDocumentInRepository, StringToJsonUtil stringToJsonUtil) {
        this.confidentialDocumentInRepository = confidentialDocumentInRepository;
        this.stringToJsonUtil = stringToJsonUtil;
    }

    @Override
    public List<ConfidentialDocumentIn> getConfidentialDocuments(){ return  confidentialDocumentInRepository.findAll();}

    @Override
    public void addConfidentialDocument(ConfidentialDocumentIn confidentialDocumentIn){
        confidentialDocumentInRepository.save(confidentialDocumentIn);
    }

    @Override
    public ConfidentialDocumentIn putConfidentialDocument(ConfidentialDocumentIn newConfidentialDocumentIn, Long id){
        return confidentialDocumentInRepository.findById(id)
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
                    return confidentialDocumentInRepository.save(confidentialDocumentIn);
                })
                .orElseThrow(()->new ConfidentialDocumentInNotFoundException(id));
    }

    @Override
    public void deleteConfidentialDocument(Long id){
        confidentialDocumentInRepository.deleteById(id);}

    @Override
    public ConfidentialDocumentIn getConfidentialDocument(Long id){
        return confidentialDocumentInRepository.findById(id)
                .orElseThrow(()-> new ConfidentialDocumentInNotFoundException(id));
    }

    @Override
    public String getConfidentialDocumentReceiveDepartments(){
        List<String> receiveDepartments = confidentialDocumentInRepository.getAllReceiveDepartment();
        return stringToJsonUtil.stringToJsonString(receiveDepartments);
    }
    @Override
    public String getConfidentialDocumentRecipients(){
        List<String> recipients = confidentialDocumentInRepository.getAllRecipient();
        return stringToJsonUtil.stringToJsonString(recipients);
    }
    @Override
    public String getConfidentialDocumentSendDepartments(){
        List<String> sendDepartments = confidentialDocumentInRepository.getAllSendDepartment();
        return stringToJsonUtil.stringToJsonString(sendDepartments);
    }
    @Override
    public String getConfidentialDocumentTransferors(){
        List<String> transferors = confidentialDocumentInRepository.getAllTransferor();
        return stringToJsonUtil.stringToJsonString(transferors);
    }

}

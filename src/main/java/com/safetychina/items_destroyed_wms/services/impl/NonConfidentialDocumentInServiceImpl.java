package com.safetychina.items_destroyed_wms.services.impl;


import com.safetychina.items_destroyed_wms.Utils.StringToJsonUtil;
import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentIn;
import com.safetychina.items_destroyed_wms.exception.NonConfidentialDocumentNotFoundException;
import com.safetychina.items_destroyed_wms.repository.NonConfidentialDocumentInRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonConfidentialDocumentInServiceImpl {
    private final NonConfidentialDocumentInRepository nonConfidentialDocumentInRepository;
    private final StringToJsonUtil stringToJsonUtil;

    public NonConfidentialDocumentInServiceImpl(NonConfidentialDocumentInRepository nonConfidentialDocumentInRepository, StringToJsonUtil stringToJsonUtil) {
        this.nonConfidentialDocumentInRepository = nonConfidentialDocumentInRepository;
        this.stringToJsonUtil = stringToJsonUtil;
    }

    public List<NonConfidentialDocumentIn> getNonConfidentialDocuments(){
        return nonConfidentialDocumentInRepository.findAll();

    }


    public void addNonConfidentialDocument(NonConfidentialDocumentIn nonConfidentialDocumentIn){
        nonConfidentialDocumentInRepository.save(nonConfidentialDocumentIn);
    }
    
    public NonConfidentialDocumentIn putNonConfidentialDocument(NonConfidentialDocumentIn newNonConfidentialDocumentIn, Long id){
        return nonConfidentialDocumentInRepository.findById(id)
                .map(nonConfidentialDocumentIn ->{
                    nonConfidentialDocumentIn.setDepartment(newNonConfidentialDocumentIn.getDepartment());
                    nonConfidentialDocumentIn.setQuantity(newNonConfidentialDocumentIn.getQuantity());
                    nonConfidentialDocumentIn.setDetail(newNonConfidentialDocumentIn.getDetail());
                    nonConfidentialDocumentIn.setReceiveDate(newNonConfidentialDocumentIn.getReceiveDate());
                    nonConfidentialDocumentIn.setRecipient(newNonConfidentialDocumentIn.getRecipient());
                    nonConfidentialDocumentIn.setTransferor(newNonConfidentialDocumentIn.getTransferor());
                    return nonConfidentialDocumentInRepository.save(nonConfidentialDocumentIn);
                } )
                .orElseThrow(()->new NonConfidentialDocumentNotFoundException(id));
    }

    public void deleteNonConfidentialDocument(Long id){
        nonConfidentialDocumentInRepository.deleteById(id);
    }

    public NonConfidentialDocumentIn getNonConfidentialDocument(Long id){
        return nonConfidentialDocumentInRepository.findById(id)
                .orElseThrow(()->new NonConfidentialDocumentNotFoundException(id));
    }

    public String getNonConfidentialDocumentDepartments(){
        List<String> departments = nonConfidentialDocumentInRepository.getAllDepartment();
        return stringToJsonUtil.stringToJsonString(departments);
    }

    public String getNonConfidentialDocumentRecipients(){
        List<String> recipients = nonConfidentialDocumentInRepository.getAllRecipient();
        return stringToJsonUtil.stringToJsonString(recipients);
    }

    public String getNonConfidentialDocumentTransferors(){
        List<String> transferors = nonConfidentialDocumentInRepository.getAllTransferor();
        return stringToJsonUtil.stringToJsonString(transferors);
    }


}

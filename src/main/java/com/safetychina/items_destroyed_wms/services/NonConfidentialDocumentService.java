package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.Utils.StringToJsonUtil;
import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentIn;
import com.safetychina.items_destroyed_wms.exception.NonConfidentialDocumentNotFoundException;
import com.safetychina.items_destroyed_wms.repository.NonConfidentialDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonConfidentialDocumentService {
    private final NonConfidentialDocumentRepository nonConfidentialDocumentRepository;
    private final StringToJsonUtil stringToJsonUtil;

    public NonConfidentialDocumentService(NonConfidentialDocumentRepository nonConfidentialDocumentRepository, StringToJsonUtil stringToJsonUtil) {
        this.nonConfidentialDocumentRepository = nonConfidentialDocumentRepository;
        this.stringToJsonUtil = stringToJsonUtil;
    }

    public List<NonConfidentialDocumentIn> getNonConfidentialDocuments(){
        return nonConfidentialDocumentRepository.findAll();

    }


    public void addNonConfidentialDocument(NonConfidentialDocumentIn nonConfidentialDocumentIn){
        nonConfidentialDocumentRepository.save(nonConfidentialDocumentIn);
    }
    
    public NonConfidentialDocumentIn putNonConfidentialDocument(NonConfidentialDocumentIn newNonConfidentialDocumentIn, Long id){
        return nonConfidentialDocumentRepository.findById(id)
                .map(nonConfidentialDocumentIn ->{
                    nonConfidentialDocumentIn.setDepartment(newNonConfidentialDocumentIn.getDepartment());
                    nonConfidentialDocumentIn.setQuantity(newNonConfidentialDocumentIn.getQuantity());
                    nonConfidentialDocumentIn.setDetail(newNonConfidentialDocumentIn.getDetail());
                    nonConfidentialDocumentIn.setReceiveDate(newNonConfidentialDocumentIn.getReceiveDate());
                    nonConfidentialDocumentIn.setRecipient(newNonConfidentialDocumentIn.getRecipient());
                    nonConfidentialDocumentIn.setTransferor(newNonConfidentialDocumentIn.getTransferor());
                    return nonConfidentialDocumentRepository.save(nonConfidentialDocumentIn);
                } )
                .orElseThrow(()->new NonConfidentialDocumentNotFoundException(id));
    }

    public void deleteNonConfidentialDocument(Long id){
        nonConfidentialDocumentRepository.deleteById(id);
    }

    public NonConfidentialDocumentIn getNonConfidentialDocument(Long id){
        return nonConfidentialDocumentRepository.findById(id)
                .orElseThrow(()->new NonConfidentialDocumentNotFoundException(id));
    }

    public String getNonConfidentialDocumentDepartments(){
        List<String> departments = nonConfidentialDocumentRepository.getAllDepartment();
        return stringToJsonUtil.stringToJsonString(departments);
    }

    public String getNonConfidentialDocumentRecipients(){
        List<String> recipients = nonConfidentialDocumentRepository.getAllRecipient();
        return stringToJsonUtil.stringToJsonString(recipients);
    }

    public String getNonConfidentialDocumentTransferors(){
        List<String> transferors = nonConfidentialDocumentRepository.getAllTransferor();
        return stringToJsonUtil.stringToJsonString(transferors);
    }


}

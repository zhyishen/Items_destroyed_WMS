package com.safetychina.items_destroyed_wms.services.impl;

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentOut;
import com.safetychina.items_destroyed_wms.exception.NonConfidentialDocumentOutNotFoundException;
import com.safetychina.items_destroyed_wms.repository.NonConfidentialDocumentOutRepository;
import com.safetychina.items_destroyed_wms.services.NonConfidentialDocumentOutService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NonConfidentialDocumentOutServiceImpl implements NonConfidentialDocumentOutService {
    private final NonConfidentialDocumentOutRepository nonConfidentialDocumentOutRepository;

    public NonConfidentialDocumentOutServiceImpl(NonConfidentialDocumentOutRepository nonConfidentialDocumentOutRepository) {
        this.nonConfidentialDocumentOutRepository = nonConfidentialDocumentOutRepository;
    }

    @Override
    public List<NonConfidentialDocumentOut> getNonConfidentialDocuments() {
        return nonConfidentialDocumentOutRepository.findAll();
    }

    @Override
    public void addNonConfidentialDocument(NonConfidentialDocumentOut nonConfidentialDocumentOut) {
        nonConfidentialDocumentOutRepository.save(nonConfidentialDocumentOut);
    }

    @Override
    public NonConfidentialDocumentOut putNonConfidentialDocument(NonConfidentialDocumentOut newNonConfidentialDocumentOut, Long id) {
        return nonConfidentialDocumentOutRepository.findById(id).map(nonConfidentialDocumentOut -> {
            nonConfidentialDocumentOut.setQuantity(nonConfidentialDocumentOut.getQuantity());
            nonConfidentialDocumentOut.setTransferor(newNonConfidentialDocumentOut.getTransferor());
            nonConfidentialDocumentOut.setReceiveDepartment(newNonConfidentialDocumentOut.getReceiveDepartment());
            nonConfidentialDocumentOut.setSendDate(newNonConfidentialDocumentOut.getSendDate());
            return nonConfidentialDocumentOutRepository.save(nonConfidentialDocumentOut);
        }).orElseThrow(()->new NonConfidentialDocumentOutNotFoundException(id));
    }

    @Override
    public void deleteNonConfidentialDocument(Long id) {
        nonConfidentialDocumentOutRepository.deleteById(id);
    }

    @Override
    public NonConfidentialDocumentOut getNonConfidentialDocument(Long id) {
        return nonConfidentialDocumentOutRepository.findById(id).
                orElseThrow(()->new NonConfidentialDocumentOutNotFoundException(id));
    }
}

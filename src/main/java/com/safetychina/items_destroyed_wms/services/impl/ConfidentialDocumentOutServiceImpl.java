package com.safetychina.items_destroyed_wms.services.impl;

import com.safetychina.items_destroyed_wms.entity.ConfidentialDocumentOut;
import com.safetychina.items_destroyed_wms.exception.ConfidentialDocumentOutNotFoundException;
import com.safetychina.items_destroyed_wms.repository.ConfidentialDocumentOutRepository;
import com.safetychina.items_destroyed_wms.services.ConfidentialDocumentOutService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfidentialDocumentOutServiceImpl implements ConfidentialDocumentOutService {

    private final ConfidentialDocumentOutRepository confidentialDocumentOutRepository;

    public ConfidentialDocumentOutServiceImpl(ConfidentialDocumentOutRepository confidentialDocumentOutRepository) {
        this.confidentialDocumentOutRepository = confidentialDocumentOutRepository;
    }

    @Override
    public List<ConfidentialDocumentOut> getConfidentialDocumentsOut() {
        return confidentialDocumentOutRepository.findAll();
    }

    @Override
    public void addConfidentialDocumentOut(ConfidentialDocumentOut confidentialDocumentOut) {
        confidentialDocumentOutRepository.save(confidentialDocumentOut);
    }

    @Override
    public ConfidentialDocumentOut putConfidentialDocumentOut(ConfidentialDocumentOut newConfidentialDocumentOut, Long id) {
        return confidentialDocumentOutRepository.findById(id).map(confidentialDocumentOut -> {
            confidentialDocumentOut.setQuantity(newConfidentialDocumentOut.getQuantity());
            confidentialDocumentOut.setTransferor(newConfidentialDocumentOut.getTransferor());
            confidentialDocumentOut.setSecretLevel(newConfidentialDocumentOut.getSecretLevel());
            confidentialDocumentOut.setReceiveDepartment(newConfidentialDocumentOut.getReceiveDepartment());
            confidentialDocumentOut.setSendDate(newConfidentialDocumentOut.getSendDate());
            return confidentialDocumentOutRepository.save(confidentialDocumentOut);
        }).orElseThrow(()->new ConfidentialDocumentOutNotFoundException(id));
    }

    @Override
    public void deleteConfidentialDocumentOut(Long id) {
        confidentialDocumentOutRepository.deleteById(id);
    }

    @Override
    public ConfidentialDocumentOut getConfidentialDocumentOut(Long id) {
        return confidentialDocumentOutRepository.findById(id)
                .orElseThrow(()->new ConfidentialDocumentOutNotFoundException(id));
    }
}

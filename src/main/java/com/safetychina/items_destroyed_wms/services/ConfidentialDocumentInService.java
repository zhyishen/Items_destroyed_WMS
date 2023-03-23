package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.entity.ConfidentialDocumentIn;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ConfidentialDocumentInService {


    List<ConfidentialDocumentIn> getConfidentialDocuments();
    void addConfidentialDocument(ConfidentialDocumentIn confidentialDocumentIn);

    ConfidentialDocumentIn putConfidentialDocument(ConfidentialDocumentIn newConfidentialDocumentIn, Long id);

    void deleteConfidentialDocument(Long id);

    ConfidentialDocumentIn getConfidentialDocument(Long id);


    public String getConfidentialDocumentRecipients();

}

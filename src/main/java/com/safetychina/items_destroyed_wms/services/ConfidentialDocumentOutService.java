package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.entity.ConfidentialDocumentOut;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ConfidentialDocumentOutService {
    List<ConfidentialDocumentOut> getConfidentialDocumentsOut();
    void addConfidentialDocumentOut(ConfidentialDocumentOut confidentialDocumentOut);

    ConfidentialDocumentOut putConfidentialDocumentOut(ConfidentialDocumentOut newConfidentialDocumentOut, Long id);

    void deleteConfidentialDocumentOut(Long id);

    ConfidentialDocumentOut getConfidentialDocumentOut(Long id);
}

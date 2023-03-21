package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentOut;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NonConfidentialDocumentOutService {
    List<NonConfidentialDocumentOut> getNonConfidentialDocuments();
    void addNonConfidentialDocument(NonConfidentialDocumentOut nonConfidentialDocumentOut);
    NonConfidentialDocumentOut putNonConfidentialDocument(NonConfidentialDocumentOut newNonConfidentialDocumentOut, Long id);
    void deleteNonConfidentialDocument(Long id);
    NonConfidentialDocumentOut getNonConfidentialDocument(Long id);
}

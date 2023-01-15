package com.safetychina.items_destroyed_wms.controller;


import com.safetychina.items_destroyed_wms.entity.ConfidentialDocument;
import com.safetychina.items_destroyed_wms.services.ConfidentialDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ConfidentialDocuments")
public class ConfidentialDocumentController {

    private final ConfidentialDocumentService confidentialDocumentService;

    @Autowired
    public ConfidentialDocumentController(ConfidentialDocumentService confidentialDocumentService) {
        this.confidentialDocumentService = confidentialDocumentService;
    }

    @PostMapping
    public void addConfidentialDocuments(ConfidentialDocument confidentialDocument){

    }

    @DeleteMapping
    public void deleteConfidentialDocuments(ConfidentialDocument confidentialDocument){

    }


    @PutMapping
    public void putConfidentialDocuments(ConfidentialDocument confidentialDocument){

    }

    @GetMapping
    public void getConfidentialDocuments(){


    }
}

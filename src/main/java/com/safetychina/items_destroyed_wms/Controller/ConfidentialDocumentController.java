package com.safetychina.items_destroyed_wms.Controller;


import com.safetychina.items_destroyed_wms.Entity.ConfidentialDocument;
import com.safetychina.items_destroyed_wms.Services.ConfidentialDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ConfidentialDocumentController {

    private final ConfidentialDocumentService confidentialDocumentService;

    @Autowired
    public ConfidentialDocumentController(ConfidentialDocumentService confidentialDocumentService) {
        this.confidentialDocumentService = confidentialDocumentService;
    }

    @PostMapping
    public void addConfidentialDocuments(ConfidentialDocument c){

    }

    @DeleteMapping
    public void deleteConfidentialDocuments(ConfidentialDocument c){

    }


    @PutMapping
    public void putConfidentialDocuments(ConfidentialDocument c){

    }

    @GetMapping
    public void getConfidentialDocuments(){


    }
}

package com.safetychina.items_destroyed_wms.Controller;


import com.safetychina.items_destroyed_wms.Entity.NonConfidentialDocument;
import com.safetychina.items_destroyed_wms.Services.NonConfidentialDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/NonConfidentialDocuments")
public class NonConfidentialDocumentController {
    private NonConfidentialDocumentService nonConfidentialDocumentService;

    @Autowired
    public NonConfidentialDocumentController(NonConfidentialDocumentService nonConfidentialDocumentService) {
        this.nonConfidentialDocumentService = nonConfidentialDocumentService;
    }

    @PostMapping
    public void addNonConfidentialDocuments(NonConfidentialDocument c){
        nonConfidentialDocumentService.addNonConfidentialDocuments(NonConfidentialDocument c);

    }

    @DeleteMapping
    public void deleteNonConfidentialDocuments(NonConfidentialDocument c){

    }


    @PutMapping
    public void putNonConfidentialDocuments(NonConfidentialDocument nonConfidentialDocument){
        nonConfidentialDocumentService.putNonConfidentialDocument(nonConfidentialDocument);
    }

    @GetMapping
    public List<NonConfidentialDocument> getNonConfidentialDocuments(){
        return nonConfidentialDocumentService.getNonConfidentialDocument();

    }
    
}

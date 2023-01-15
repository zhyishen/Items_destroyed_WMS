package com.safetychina.items_destroyed_wms.controller;

/**
 * @author zhyishen
 * @version 1.0
 */

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocument;
import com.safetychina.items_destroyed_wms.services.NonConfidentialDocumentService;
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
    public void addNonConfidentialDocuments(@RequestBody NonConfidentialDocument nonConfidentialDocument){
        nonConfidentialDocumentService.addNonConfidentialDocument(nonConfidentialDocument);

    }

    @DeleteMapping("/NonConfidentialDocuments/{id}")
    public void deleteNonConfidentialDocuments(@PathVariable Long id){
        nonConfidentialDocumentService.deleteNonConfidentialDocument(id);
    }


    @PutMapping("/NonConfidentialDocuments/{id}")
    public NonConfidentialDocument putNonConfidentialDocument(@RequestBody NonConfidentialDocument nonConfidentialDocument, @PathVariable Long id){
        return nonConfidentialDocumentService.putNonConfidentialDocument(nonConfidentialDocument,id);
    }

    @GetMapping
    public List<NonConfidentialDocument> getNonConfidentialDocuments(){
        return nonConfidentialDocumentService.getNonConfidentialDocuments();

    }

    @GetMapping("/NonConfidentialDocuments/{id}")
    NonConfidentialDocument getNonConfidentialDocument(@PathVariable Long id){
        return nonConfidentialDocumentService.getNonConfidentialDocument(id);
    }
    
}

package com.safetychina.items_destroyed_wms.controller;

/**
 * @author zhyishen
 * @version 1.0
 */

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocument;
import com.safetychina.items_destroyed_wms.services.NonConfidentialDocumentService;
import jdk.swing.interop.SwingInterOpUtils;
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

    @DeleteMapping("/{id}")
    public void deleteNonConfidentialDocuments(@PathVariable("id") Long id){
        nonConfidentialDocumentService.deleteNonConfidentialDocument(id);
    }


    @PutMapping("/{id}")
    public NonConfidentialDocument putNonConfidentialDocument(@RequestBody NonConfidentialDocument nonConfidentialDocument, @PathVariable("id") Long id){
        return nonConfidentialDocumentService.putNonConfidentialDocument(nonConfidentialDocument,id);
    }

    @GetMapping
    public List<NonConfidentialDocument> getNonConfidentialDocuments(){
        return nonConfidentialDocumentService.getNonConfidentialDocuments();

    }

    @GetMapping("/{id}")
    public NonConfidentialDocument getNonConfidentialDocument(@PathVariable("id") Long id){
        return nonConfidentialDocumentService.getNonConfidentialDocument(id);
    }
    
}

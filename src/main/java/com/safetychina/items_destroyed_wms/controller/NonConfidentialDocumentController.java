package com.safetychina.items_destroyed_wms.controller;

/**
 * @author zhyishen
 * @version 1.0
 */

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentIn;
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
    public void addNonConfidentialDocuments(@RequestBody NonConfidentialDocumentIn nonConfidentialDocumentIn){
        nonConfidentialDocumentService.addNonConfidentialDocument(nonConfidentialDocumentIn);

    }

    @DeleteMapping("/{id}")
    public void deleteNonConfidentialDocuments(@PathVariable("id") Long id){
        nonConfidentialDocumentService.deleteNonConfidentialDocument(id);
    }


    @PutMapping("/{id}")
    public NonConfidentialDocumentIn putNonConfidentialDocument(@RequestBody NonConfidentialDocumentIn nonConfidentialDocumentIn, @PathVariable("id") Long id){
        return nonConfidentialDocumentService.putNonConfidentialDocument(nonConfidentialDocumentIn,id);
    }

    @GetMapping
    public List<NonConfidentialDocumentIn> getNonConfidentialDocuments(){
        return nonConfidentialDocumentService.getNonConfidentialDocuments();

    }

    @GetMapping("/{id}")
    public NonConfidentialDocumentIn getNonConfidentialDocument(@PathVariable("id") Long id){
        return nonConfidentialDocumentService.getNonConfidentialDocument(id);
    }

    @GetMapping("/departments")
    public String getConfidentialDocumentDepartments(){
        return nonConfidentialDocumentService.getNonConfidentialDocumentDepartments();
    }

    @GetMapping("/recipients")
    public String getConfidentialDocumentRecipients(){
        return nonConfidentialDocumentService.getNonConfidentialDocumentRecipients();
    }

    @GetMapping("/transferors")
    public String getConfidentialDocumentTransferors(){
        return nonConfidentialDocumentService.getNonConfidentialDocumentTransferors();
    }
}

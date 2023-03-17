package com.safetychina.items_destroyed_wms.controller;

/**
 * @author zhyishen
 * @version 1.0
 */

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentIn;
import com.safetychina.items_destroyed_wms.services.impl.NonConfidentialDocumentInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/NonConfidentialDocuments")
public class NonConfidentialDocumentInController {
    private NonConfidentialDocumentInService nonConfidentialDocumentInService;

    @Autowired
    public NonConfidentialDocumentInController(NonConfidentialDocumentInService nonConfidentialDocumentInService) {
        this.nonConfidentialDocumentInService = nonConfidentialDocumentInService;
    }


    @PostMapping
    public void addNonConfidentialDocuments(@RequestBody NonConfidentialDocumentIn nonConfidentialDocumentIn){
        nonConfidentialDocumentInService.addNonConfidentialDocument(nonConfidentialDocumentIn);

    }

    @DeleteMapping("/{id}")
    public void deleteNonConfidentialDocuments(@PathVariable("id") Long id){
        nonConfidentialDocumentInService.deleteNonConfidentialDocument(id);
    }


    @PutMapping("/{id}")
    public NonConfidentialDocumentIn putNonConfidentialDocument(@RequestBody NonConfidentialDocumentIn nonConfidentialDocumentIn, @PathVariable("id") Long id){
        return nonConfidentialDocumentInService.putNonConfidentialDocument(nonConfidentialDocumentIn,id);
    }

    @GetMapping
    public List<NonConfidentialDocumentIn> getNonConfidentialDocuments(){
        return nonConfidentialDocumentInService.getNonConfidentialDocuments();

    }

    @GetMapping("/{id}")
    public NonConfidentialDocumentIn getNonConfidentialDocument(@PathVariable("id") Long id){
        return nonConfidentialDocumentInService.getNonConfidentialDocument(id);
    }

    @GetMapping("/departments")
    public String getConfidentialDocumentDepartments(){
        return nonConfidentialDocumentInService.getNonConfidentialDocumentDepartments();
    }

    @GetMapping("/recipients")
    public String getConfidentialDocumentRecipients(){
        return nonConfidentialDocumentInService.getNonConfidentialDocumentRecipients();
    }

    @GetMapping("/transferors")
    public String getConfidentialDocumentTransferors(){
        return nonConfidentialDocumentInService.getNonConfidentialDocumentTransferors();
    }
}

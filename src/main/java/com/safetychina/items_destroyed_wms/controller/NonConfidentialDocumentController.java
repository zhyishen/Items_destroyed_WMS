package com.safetychina.items_destroyed_wms.controller;

/**
 * @author zhyishen
 * @version 1.0
 */

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentIn;
import com.safetychina.items_destroyed_wms.services.impl.NonConfidentialDocumentInServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/NonConfidentialDocuments")
public class NonConfidentialDocumentController {
    private NonConfidentialDocumentInServiceImpl nonConfidentialDocumentInServiceImpl;

    @Autowired
    public NonConfidentialDocumentController(NonConfidentialDocumentInServiceImpl nonConfidentialDocumentInServiceImpl) {
        this.nonConfidentialDocumentInServiceImpl = nonConfidentialDocumentInServiceImpl;
    }


    @PostMapping
    public void addNonConfidentialDocuments(@RequestBody NonConfidentialDocumentIn nonConfidentialDocumentIn){
        nonConfidentialDocumentInServiceImpl.addNonConfidentialDocument(nonConfidentialDocumentIn);

    }

    @DeleteMapping("/{id}")
    public void deleteNonConfidentialDocuments(@PathVariable("id") Long id){
        nonConfidentialDocumentInServiceImpl.deleteNonConfidentialDocument(id);
    }


    @PutMapping("/{id}")
    public NonConfidentialDocumentIn putNonConfidentialDocument(@RequestBody NonConfidentialDocumentIn nonConfidentialDocumentIn, @PathVariable("id") Long id){
        return nonConfidentialDocumentInServiceImpl.putNonConfidentialDocument(nonConfidentialDocumentIn,id);
    }

    @GetMapping
    public List<NonConfidentialDocumentIn> getNonConfidentialDocuments(){
        return nonConfidentialDocumentInServiceImpl.getNonConfidentialDocuments();

    }

    @GetMapping("/{id}")
    public NonConfidentialDocumentIn getNonConfidentialDocument(@PathVariable("id") Long id){
        return nonConfidentialDocumentInServiceImpl.getNonConfidentialDocument(id);
    }

    @GetMapping("/departments")
    public String getConfidentialDocumentDepartments(){
        return nonConfidentialDocumentInServiceImpl.getNonConfidentialDocumentDepartments();
    }

    @GetMapping("/recipients")
    public String getConfidentialDocumentRecipients(){
        return nonConfidentialDocumentInServiceImpl.getNonConfidentialDocumentRecipients();
    }

    @GetMapping("/transferors")
    public String getConfidentialDocumentTransferors(){
        return nonConfidentialDocumentInServiceImpl.getNonConfidentialDocumentTransferors();
    }
}

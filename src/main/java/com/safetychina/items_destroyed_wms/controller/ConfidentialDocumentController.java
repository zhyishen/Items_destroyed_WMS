package com.safetychina.items_destroyed_wms.controller;


import com.safetychina.items_destroyed_wms.entity.ConfidentialDocument;
import com.safetychina.items_destroyed_wms.services.ConfidentialDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ConfidentialDocuments")
public class ConfidentialDocumentController {

    private final ConfidentialDocumentService confidentialDocumentService;

    @Autowired
    public ConfidentialDocumentController(ConfidentialDocumentService confidentialDocumentService) {
        this.confidentialDocumentService = confidentialDocumentService;
    }

    /**
     * 增加保密文件项目
     *
     * @param newConfidentialDocument 新保密文件实体
     */
    @PostMapping
    public void addConfidentialDocuments(@RequestBody ConfidentialDocument newConfidentialDocument){
        confidentialDocumentService.addConfidentialDocument(newConfidentialDocument);
    }

    @DeleteMapping("/{id}")
    public void deleteConfidentialDocuments(@PathVariable Long id){
        confidentialDocumentService.deleteConfidentialDocument(id);
    }


    @PutMapping("/{id}")
    public ConfidentialDocument putConfidentialDocuments(@RequestBody ConfidentialDocument confidentialDocument, @PathVariable Long id){
        return confidentialDocumentService.putConfidentialDocument(confidentialDocument, id);
    }

    @GetMapping
    public List<ConfidentialDocument> getConfidentialDocuments(){
        return confidentialDocumentService.getConfidentialDocuments();
    }

    @GetMapping("/{id}")
    public ConfidentialDocument getConfidentialDocument(@PathVariable Long id){
        return confidentialDocumentService.getConfidentialDocument(id);
    }
}

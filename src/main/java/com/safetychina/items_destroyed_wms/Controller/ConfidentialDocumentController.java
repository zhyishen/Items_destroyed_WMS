package com.safetychina.items_destroyed_wms.Controller;


import com.safetychina.items_destroyed_wms.Entity.ConfidentialDocument;
import com.safetychina.items_destroyed_wms.Services.ConfidentialDocumentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ConfidentialDocumentController {

    private final ConfidentialDocumentServices confidentialDocumentServices;

    @Autowired
    public ConfidentialDocumentController(ConfidentialDocumentServices confidentialDocumentServices) {
        this.confidentialDocumentServices = confidentialDocumentServices;
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

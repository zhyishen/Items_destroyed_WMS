package com.safetychina.items_destroyed_wms.Controller;


import com.safetychina.items_destroyed_wms.Entity.NonConfidentialDocument;
import com.safetychina.items_destroyed_wms.Services.NonConfidentialDocumentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/NonConfidentialDocuments")
public class NonConfidentialDocumentController {
    private NonConfidentialDocumentServices nonConfidentialDocumentServices;

    @Autowired
    public NonConfidentialDocumentController(NonConfidentialDocumentServices nonConfidentialDocumentServices) {
        this.nonConfidentialDocumentServices = nonConfidentialDocumentServices;
    }

    @PostMapping
    public void addNonConfidentialDocuments(NonConfidentialDocument c){
        nonConfidentialDocumentServices.addNonConfidentialDocuments(NonConfidentialDocument c);

    }

    @DeleteMapping
    public void deleteNonConfidentialDocuments(NonConfidentialDocument c){

    }


    @PutMapping
    public void putNonConfidentialDocuments(NonConfidentialDocument c){

    }

    @GetMapping
    public List<NonConfidentialDocument> getNonConfidentialDocuments(){
        return nonConfidentialDocumentServices.getNonConfidentialDocuments();

    }
    
}

package com.safetychina.items_destroyed_wms.Controller;


import com.safetychina.items_destroyed_wms.Services.NonConfidentialDocumentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NonConfidentialDocumentsController {
    private NonConfidentialDocumentsServices nonConfidentialDocumentsServices;

    @Autowired
    public NonConfidentialDocumentsController(NonConfidentialDocumentsServices nonConfidentialDocumentsServices) {
        this.nonConfidentialDocumentsServices = nonConfidentialDocumentsServices;
    }

    
}

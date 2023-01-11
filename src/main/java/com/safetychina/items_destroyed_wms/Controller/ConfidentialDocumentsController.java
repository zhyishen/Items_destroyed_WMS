package com.safetychina.items_destroyed_wms.Controller;


import com.safetychina.items_destroyed_wms.Services.ConfidentialDocumentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ConfidentialDocumentsController {

    private final ConfidentialDocumentsServices confidentialDocumentsServices;

    @Autowired
    public ConfidentialDocumentsController(ConfidentialDocumentsServices confidentialDocumentsServices) {
        this.confidentialDocumentsServices = confidentialDocumentsServices;
    }
}

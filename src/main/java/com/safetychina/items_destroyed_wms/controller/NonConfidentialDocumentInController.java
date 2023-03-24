package com.safetychina.items_destroyed_wms.controller;

/**
 * @author zhyishen
 * @version 1.0
 */

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentIn;
import com.safetychina.items_destroyed_wms.services.NonConfidentialDocumentInService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/NonConfidentialDocumentIns")
public class NonConfidentialDocumentInController {
    private final NonConfidentialDocumentInService nonConfidentialDocumentInService;

    @Autowired
    public NonConfidentialDocumentInController(NonConfidentialDocumentInService nonConfidentialDocumentInService) {
        this.nonConfidentialDocumentInService = nonConfidentialDocumentInService;
    }


    @PostMapping
    public void addNonConfidentialDocuments(@Validated @RequestBody NonConfidentialDocumentIn nonConfidentialDocumentIn){
        nonConfidentialDocumentInService.addNonConfidentialDocument(nonConfidentialDocumentIn);

    }

    @DeleteMapping("/{id}")
    public void deleteNonConfidentialDocuments(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        nonConfidentialDocumentInService.deleteNonConfidentialDocument(Long.parseLong(id));
    }


    @PutMapping("/{id}")
    public NonConfidentialDocumentIn putNonConfidentialDocument(@Validated @RequestBody NonConfidentialDocumentIn nonConfidentialDocumentIn, @PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return nonConfidentialDocumentInService.putNonConfidentialDocument(nonConfidentialDocumentIn,Long.parseLong(id));
    }

    @GetMapping
    public List<NonConfidentialDocumentIn> getNonConfidentialDocuments(){
        return nonConfidentialDocumentInService.getNonConfidentialDocuments();

    }

    @GetMapping("/{id}")
    public NonConfidentialDocumentIn getNonConfidentialDocument(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return nonConfidentialDocumentInService.getNonConfidentialDocument(Long.parseLong(id));
    }


    @GetMapping("/recipients")
    public String getConfidentialDocumentRecipients(){
        return nonConfidentialDocumentInService.getNonConfidentialDocumentRecipients();
    }

}

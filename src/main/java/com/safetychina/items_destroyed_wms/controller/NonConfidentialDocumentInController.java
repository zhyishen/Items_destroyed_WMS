package com.safetychina.items_destroyed_wms.controller;

/**
 * @author zhyishen
 * @version 1.0
 */

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentIn;
import com.safetychina.items_destroyed_wms.services.impl.NonConfidentialDocumentInServiceImpl;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/NonConfidentialDocumentIns")
public class NonConfidentialDocumentInController {
    private NonConfidentialDocumentInServiceImpl nonConfidentialDocumentInServiceImpl;

    @Autowired
    public NonConfidentialDocumentInController(NonConfidentialDocumentInServiceImpl nonConfidentialDocumentInServiceImpl) {
        this.nonConfidentialDocumentInServiceImpl = nonConfidentialDocumentInServiceImpl;
    }


    @PostMapping
    public void addNonConfidentialDocuments(@Validated @RequestBody NonConfidentialDocumentIn nonConfidentialDocumentIn){
        nonConfidentialDocumentInServiceImpl.addNonConfidentialDocument(nonConfidentialDocumentIn);

    }

    @DeleteMapping("/{id}")
    public void deleteNonConfidentialDocuments(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        nonConfidentialDocumentInServiceImpl.deleteNonConfidentialDocument(Long.parseLong(id));
    }


    @PutMapping("/{id}")
    public NonConfidentialDocumentIn putNonConfidentialDocument(@Validated @RequestBody NonConfidentialDocumentIn nonConfidentialDocumentIn, @PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return nonConfidentialDocumentInServiceImpl.putNonConfidentialDocument(nonConfidentialDocumentIn,Long.parseLong(id));
    }

    @GetMapping
    public List<NonConfidentialDocumentIn> getNonConfidentialDocuments(){
        return nonConfidentialDocumentInServiceImpl.getNonConfidentialDocuments();

    }

    @GetMapping("/{id}")
    public NonConfidentialDocumentIn getNonConfidentialDocument(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return nonConfidentialDocumentInServiceImpl.getNonConfidentialDocument(Long.parseLong(id));
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

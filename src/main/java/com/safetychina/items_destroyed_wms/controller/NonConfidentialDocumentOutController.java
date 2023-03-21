package com.safetychina.items_destroyed_wms.controller;

import com.safetychina.items_destroyed_wms.entity.NonConfidentialDocumentOut;
import com.safetychina.items_destroyed_wms.services.NonConfidentialDocumentOutService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NonConfidentialDocumentOuts")
public class NonConfidentialDocumentOutController {
    private final NonConfidentialDocumentOutService nonConfidentialDocumentOutService;
    @Autowired
    public NonConfidentialDocumentOutController(NonConfidentialDocumentOutService nonConfidentialDocumentOutService) {
        this.nonConfidentialDocumentOutService = nonConfidentialDocumentOutService;
    }

    @PostMapping
    public void addNonConfidentialDocumentOut(@Validated @RequestBody NonConfidentialDocumentOut nonConfidentialDocumentOut){
        nonConfidentialDocumentOutService.addNonConfidentialDocument(nonConfidentialDocumentOut);
    }

    @DeleteMapping("{id}")
    public void deleteNonConfidentialDocumentOut(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        nonConfidentialDocumentOutService.deleteNonConfidentialDocument(Long.parseLong(id));
    }

    @PutMapping("{id}")
    public NonConfidentialDocumentOut putNonConfidentialDocumentOut(@Validated @RequestBody NonConfidentialDocumentOut nonConfidentialDocumentOut,@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return nonConfidentialDocumentOutService.putNonConfidentialDocument(nonConfidentialDocumentOut,Long.parseLong(id));
    }

    @GetMapping
    public List<NonConfidentialDocumentOut> getNonConfidentialDocumentOuts(){
        return nonConfidentialDocumentOutService.getNonConfidentialDocuments();
    }

    @GetMapping("{id}")
    public NonConfidentialDocumentOut getNonConfidentialDocumentOut(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return nonConfidentialDocumentOutService.getNonConfidentialDocument(Long.parseLong(id));
    }

}

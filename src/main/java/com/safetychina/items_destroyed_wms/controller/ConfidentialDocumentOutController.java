package com.safetychina.items_destroyed_wms.controller;

import com.safetychina.items_destroyed_wms.entity.ConfidentialDocumentOut;
import com.safetychina.items_destroyed_wms.services.ConfidentialDocumentOutService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ConfidentialDocumentOuts")
public class ConfidentialDocumentOutController {
    private final ConfidentialDocumentOutService confidentialDocumentOutService;
    @Autowired
    public ConfidentialDocumentOutController(ConfidentialDocumentOutService confidentialDocumentOutService) {
        this.confidentialDocumentOutService = confidentialDocumentOutService;
    }

    @PostMapping
    public void addConfidentialDocumentOut(@Validated @RequestBody ConfidentialDocumentOut confidentialDocumentOut){
        confidentialDocumentOutService.addConfidentialDocumentOut(confidentialDocumentOut);
    }

    @DeleteMapping("{id}")
    public void deleteConfidentialDocumentOut(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        confidentialDocumentOutService.deleteConfidentialDocumentOut(Long.parseLong(id));
    }

    @PutMapping("{id}")
    public ConfidentialDocumentOut putConfidentialDocumentOut(@Validated @RequestBody ConfidentialDocumentOut confidentialDocumentOut,@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return confidentialDocumentOutService.putConfidentialDocumentOut(confidentialDocumentOut,Long.parseLong(id));
    }

    @GetMapping
    public List<ConfidentialDocumentOut> getConfidentialDocumentOuts(){
        return confidentialDocumentOutService.getConfidentialDocumentsOut();
    }

    @GetMapping("{id}")
    public ConfidentialDocumentOut getConfidentialDocumentOut(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return confidentialDocumentOutService.getConfidentialDocumentOut(Long.parseLong(id));
    }
}

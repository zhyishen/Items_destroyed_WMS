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

    /**
     *
     * @param id 从链接参数中提取id作为传入参数
     */
    @DeleteMapping("/{id}")
    public void deleteConfidentialDocuments(@PathVariable Long id){
        confidentialDocumentService.deleteConfidentialDocument(id);
    }

    /**
     *
     * @param confidentialDocument 新保密文件实体替换原有实体
     * @param id 从链接参数中提取id作为传入参数
     * @return 更改过后的新保密文件实体
     */
    @PutMapping("/{id}")
    public ConfidentialDocument putConfidentialDocuments(@RequestBody ConfidentialDocument confidentialDocument, @PathVariable Long id){
        return confidentialDocumentService.putConfidentialDocument(confidentialDocument, id);
    }

    /**
     *
     * @return 所有保密文件实体
     */
    @GetMapping
    public List<ConfidentialDocument> getConfidentialDocuments(){
        return confidentialDocumentService.getConfidentialDocuments();
    }


    /**
     *
     * @param id 从链接参数中提取id作为传入参数
     * @return 根据id找到的保密文件实体
     */
    @GetMapping("/{id}")
    public ConfidentialDocument getConfidentialDocument(@PathVariable Long id){
        return confidentialDocumentService.getConfidentialDocument(id);
    }
}

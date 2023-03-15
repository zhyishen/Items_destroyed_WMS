package com.safetychina.items_destroyed_wms.controller;


import com.safetychina.items_destroyed_wms.entity.ConfidentialDocumentIn;
import com.safetychina.items_destroyed_wms.services.impl.ConfidentialDocumentInServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ConfidentialDocuments")
public class ConfidentialDocumentController {

    private final ConfidentialDocumentInServiceImpl confidentialDocumentInServiceImpl;

    @Autowired
    public ConfidentialDocumentController(ConfidentialDocumentInServiceImpl confidentialDocumentInServiceImpl) {
        this.confidentialDocumentInServiceImpl = confidentialDocumentInServiceImpl;
    }

    /**
     * 增加保密文件项目
     *
     * @param newConfidentialDocumentIn 新保密文件实体
     */
    @PostMapping
    public void addConfidentialDocuments(@RequestBody ConfidentialDocumentIn newConfidentialDocumentIn){
        confidentialDocumentInServiceImpl.addConfidentialDocument(newConfidentialDocumentIn);
    }

    /**
     *
     * @param id 从链接参数中提取id作为传入参数
     */
    @DeleteMapping("/{id}")
    public void deleteConfidentialDocuments(@PathVariable Long id){
        confidentialDocumentInServiceImpl.deleteConfidentialDocument(id);
    }

    /**
     *
     * @param confidentialDocumentIn 新保密文件实体替换原有实体
     * @param id 从链接参数中提取id作为传入参数
     * @return 更改过后的新保密文件实体
     */
    @PutMapping("/{id}")
    public ConfidentialDocumentIn putConfidentialDocuments(@RequestBody ConfidentialDocumentIn confidentialDocumentIn, @PathVariable Long id){
        return confidentialDocumentInServiceImpl.putConfidentialDocument(confidentialDocumentIn, id);
    }

    /**
     *
     * @return 所有保密文件实体
     */
    @GetMapping
    public List<ConfidentialDocumentIn> getConfidentialDocuments(){
        return confidentialDocumentInServiceImpl.getConfidentialDocuments();
    }


    /**
     *
     * @param id 从链接参数中提取id作为传入参数
     * @return 根据id找到的保密文件实体
     */
    @GetMapping("/{id}")
    public ConfidentialDocumentIn getConfidentialDocument(@PathVariable Long id){
        return confidentialDocumentInServiceImpl.getConfidentialDocument(id);
    }

    @GetMapping("/receiveDepartments")
    public String getConfidentialDocumentReceiveDepartments(){
        return confidentialDocumentInServiceImpl.getConfidentialDocumentReceiveDepartments();
    }

    @GetMapping("/recipients")
    public String getConfidentialDocumentRecipients(){
        return confidentialDocumentInServiceImpl.getConfidentialDocumentRecipients();
    }

    @GetMapping("/transferors")
    public String getConfidentialDocumentTransferors(){
        return confidentialDocumentInServiceImpl.getConfidentialDocumentTransferors();
    }

    @GetMapping("/sendDepartments")
    public String getConfidentialDocumentSendDepartments(){
        return confidentialDocumentInServiceImpl.getConfidentialDocumentSendDepartments();
    }

}

package com.safetychina.items_destroyed_wms.controller;


import com.safetychina.items_destroyed_wms.entity.ConfidentialDocumentIn;
import com.safetychina.items_destroyed_wms.services.impl.ConfidentialDocumentInService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ConfidentialDocumentsIn")
@Validated
public class ConfidentialDocumentInController {

    private final ConfidentialDocumentInService confidentialDocumentInService;

    @Autowired
    public ConfidentialDocumentInController(ConfidentialDocumentInService confidentialDocumentInService) {
        this.confidentialDocumentInService = confidentialDocumentInService;
    }

    /**
     * 增加保密文件项目
     *
     * @param newConfidentialDocumentIn 新保密文件实体
     */
    @PostMapping
    public void addConfidentialDocuments(@Validated @RequestBody ConfidentialDocumentIn newConfidentialDocumentIn){
        confidentialDocumentInService.addConfidentialDocument(newConfidentialDocumentIn);
    }

    /**
     *
     * @param id 从链接参数中提取id作为传入参数
     */
    @DeleteMapping("/{id}")
    public void deleteConfidentialDocuments(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") Long id){
        confidentialDocumentInService.deleteConfidentialDocument(id);
    }

    /**
     *
     * @param confidentialDocumentIn 新保密文件实体替换原有实体
     * @param id 从链接参数中提取id作为传入参数
     * @return 更改过后的新保密文件实体
     */
    @PutMapping("/{id}")
    public ConfidentialDocumentIn putConfidentialDocuments(@RequestBody ConfidentialDocumentIn confidentialDocumentIn, @PathVariable(name = "id") @Pattern(regexp = "[0-9]", message = "输入id格式错误") Long id){
        return confidentialDocumentInService.putConfidentialDocument(confidentialDocumentIn, id);
    }

    /**
     *
     * @return 所有保密文件实体
     */
    @GetMapping
    public List<ConfidentialDocumentIn> getConfidentialDocuments(){
        return confidentialDocumentInService.getConfidentialDocuments();
    }


    /**
     *
     * @param id 从链接参数中提取id作为传入参数
     * @return 根据id找到的保密文件实体
     */
    @GetMapping("/{id}")
    public ConfidentialDocumentIn getConfidentialDocument(@PathVariable(name = "id") Long id){
        return confidentialDocumentInService.getConfidentialDocument(id);
    }

    @GetMapping("/receiveDepartments")
    public String getConfidentialDocumentReceiveDepartments(){
        return confidentialDocumentInService.getConfidentialDocumentReceiveDepartments();
    }

    @GetMapping("/recipients")
    public String getConfidentialDocumentRecipients(){
        return confidentialDocumentInService.getConfidentialDocumentRecipients();
    }

    @GetMapping("/transferors")
    public String getConfidentialDocumentTransferors(){
        return confidentialDocumentInService.getConfidentialDocumentTransferors();
    }

    @GetMapping("/sendDepartments")
    public String getConfidentialDocumentSendDepartments(){
        return confidentialDocumentInService.getConfidentialDocumentSendDepartments();
    }

}

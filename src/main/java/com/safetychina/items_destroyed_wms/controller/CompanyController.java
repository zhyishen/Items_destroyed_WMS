package com.safetychina.items_destroyed_wms.controller;

import com.safetychina.items_destroyed_wms.entity.Company;
import com.safetychina.items_destroyed_wms.services.CompanyService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Companies")
@Validated
public class CompanyController {

    private final CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping
    public void postCompany(@Validated @RequestBody Company company){
        companyService.addCompany(company);
    }
    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }
    @GetMapping("/{id}")
    public Company getCompany(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return companyService.getCompany(Long.parseLong(id));
    }
    @PutMapping("/{id}")
    public Company putCompany(@Validated @RequestBody Company company, @PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return companyService.updateCompany(company,Long.parseLong(id));
    }
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        companyService.deleteCompany(Long.parseLong(id));
    }
}

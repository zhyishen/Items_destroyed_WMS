package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    void addCompany(Company company);

    Company getCompany(Long id);

    List<Company> getCompanies();

    void deleteCompany(Long id);

    Company updateCompany(Company newCompany, Long id);
}

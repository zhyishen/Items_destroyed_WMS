package com.safetychina.items_destroyed_wms.services.impl;

import com.safetychina.items_destroyed_wms.entity.Company;
import com.safetychina.items_destroyed_wms.exception.CompanyNotFoundException;
import com.safetychina.items_destroyed_wms.repository.CompanyRepository;
import com.safetychina.items_destroyed_wms.services.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(()-> new CompanyNotFoundException(id));
    }

    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company updateCompany(Company newCompany, Long id) {
        return companyRepository.findById(id).map(company -> {
            company.setCompanyName(newCompany.getCompanyName());
            company.setPerson(newCompany.getPerson());
            company.setType(newCompany.getType());
            return companyRepository.save(company);
        }).orElseThrow(()-> new CompanyNotFoundException(id));
    }
}

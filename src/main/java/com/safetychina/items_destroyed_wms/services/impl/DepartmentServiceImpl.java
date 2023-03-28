package com.safetychina.items_destroyed_wms.services.impl;

import com.safetychina.items_destroyed_wms.entity.Department;
import com.safetychina.items_destroyed_wms.exception.DepartmentNotFoundException;
import com.safetychina.items_destroyed_wms.repository.DepartmentRepository;
import com.safetychina.items_destroyed_wms.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(()-> new DepartmentNotFoundException(id));
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getSendDepartments() {
        return departmentRepository.findByType("移交单位");
    }

    @Override
    public List<Department> getReceiveDepartments() {
        return departmentRepository.findByType("接收单位");
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Department newDepartment, Long id) {
        return departmentRepository.findById(id).map(company -> {
            company.setDepartmentName(newDepartment.getDepartmentName());
            company.setContact(newDepartment.getContact());
            company.setType(newDepartment.getType());
            return departmentRepository.save(company);
        }).orElseThrow(()-> new DepartmentNotFoundException(id));
    }
}

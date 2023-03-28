package com.safetychina.items_destroyed_wms.controller;

import com.safetychina.items_destroyed_wms.entity.Department;
import com.safetychina.items_destroyed_wms.services.DepartmentService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Departments")
@Validated
public class DepartmentController {

    private final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping
    public void postDepartment(@Validated @RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @GetMapping
    public List<Department> getDepartments(){ return departmentService.getDepartments();}

    @GetMapping("/SendDepartment")
    public List<Department> getSendDepartments(){
        return departmentService.getSendDepartments();
    }

    @GetMapping("/ReceiveDepartment")
    public List<Department> getReceiveDepartments(){
        return departmentService.getReceiveDepartments();
    }
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return departmentService.getDepartment(Long.parseLong(id));
    }
    @PutMapping("/{id}")
    public Department putDepartment(@Validated @RequestBody Department department, @PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return departmentService.updateDepartment(department,Long.parseLong(id));
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        departmentService.deleteDepartment(Long.parseLong(id));
    }
}

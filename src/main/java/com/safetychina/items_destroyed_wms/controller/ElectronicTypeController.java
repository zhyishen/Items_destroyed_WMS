package com.safetychina.items_destroyed_wms.controller;

import com.safetychina.items_destroyed_wms.entity.Equipment;
import com.safetychina.items_destroyed_wms.services.ElectronicTypeService;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ElectronicTypes")
public class ElectronicTypeController {
    private final ElectronicTypeService electronicTypeService;


    public ElectronicTypeController(ElectronicTypeService electronicTypeService) {
        this.electronicTypeService = electronicTypeService;
    }

    @GetMapping
    public List<Equipment> getElectronicTypes(){
        return electronicTypeService.getElectronicTypes();
    }

    @PostMapping
    public void addElectronicType(@Validated @RequestBody Equipment equipment){
        electronicTypeService.addElectronicType(equipment);
    }

    @DeleteMapping("{id}")
    public void deleteElectronicType(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        electronicTypeService.deleteElectronicType(Long.parseLong(id));
    }

    @PutMapping("{id}")
    public Equipment putElectronicType(@Validated @RequestBody Equipment equipment, @PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return electronicTypeService.putElectronicType(equipment, Long.parseLong(id));
    }
}

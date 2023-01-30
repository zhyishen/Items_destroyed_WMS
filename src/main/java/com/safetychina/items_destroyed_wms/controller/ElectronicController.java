package com.safetychina.items_destroyed_wms.controller;


import com.safetychina.items_destroyed_wms.entity.Electronic;
import com.safetychina.items_destroyed_wms.services.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Electronics")
public class ElectronicController {

    private final ElectronicService electronicService;

    @Autowired
    public ElectronicController(ElectronicService electronicService) {
        this.electronicService = electronicService;
    }

    @PostMapping
    public void addElectronics(@RequestBody Electronic electronic){
        electronicService.addElectronic(electronic);
    }

    @DeleteMapping("{id}")
    public void deleteElectronics(@PathVariable Long id){
        electronicService.deleteElectronic(id);
    }


    @PutMapping("{id}")
    public Electronic putElectronics(@RequestBody Electronic electronic, @PathVariable Long id){
        return electronicService.putElectronic(electronic,id);
    }

    @GetMapping
    public List<Electronic> getElectronics(){
        return electronicService.getElectronics();
    }

    @GetMapping("{id}")
    public Electronic getElectronic(@PathVariable Long id){
        return electronicService.getElectronic(id);
    }
}

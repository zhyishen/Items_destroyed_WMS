package com.safetychina.items_destroyed_wms.controller;


import com.safetychina.items_destroyed_wms.entity.ElectronicIn;
import com.safetychina.items_destroyed_wms.services.impl.ElectronicInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Electronics")
public class ElectronicInController {

    private final ElectronicInService electronicInService;

    @Autowired
    public ElectronicInController(ElectronicInService electronicInService) {
        this.electronicInService = electronicInService;
    }

    @PostMapping
    public void addElectronics(@RequestBody ElectronicIn electronicIn){
        electronicInService.addElectronic(electronicIn);
    }

    @DeleteMapping("{id}")
    public void deleteElectronics(@PathVariable Long id){
        electronicInService.deleteElectronic(id);
    }


    @PutMapping("{id}")
    public ElectronicIn putElectronics(@RequestBody ElectronicIn electronicIn, @PathVariable Long id){
        return electronicInService.putElectronic(electronicIn,id);
    }

    @GetMapping
    public List<ElectronicIn> getElectronics(){
        return electronicInService.getElectronics();
    }

    @GetMapping("{id}")
    public ElectronicIn getElectronic(@PathVariable Long id){
        return electronicInService.getElectronic(id);
    }

    @GetMapping("/types")
    public String getElectronicTypes(){
        return electronicInService.getElectronicTypes();
    }

    @GetMapping("/sendDepartments")
    public String getElectronicSendDepartments(){return electronicInService.getElectronicSendDepartments();}

    @GetMapping("/recipients")
    public String getElectronicRecipients(){
        return electronicInService.getElectronicRecipients();
    }

    @GetMapping("/transferors")
    public String getElectronicTransferors(){
        return electronicInService.getElectronicTransferors();
    }

    @GetMapping("/personOfUses")
    public String getElectronicPersonOfUses(){
        return electronicInService.getElectronicPersonOfUses();
    }
}

package com.safetychina.items_destroyed_wms.controller;


import com.safetychina.items_destroyed_wms.entity.ElectronicIn;
import com.safetychina.items_destroyed_wms.services.impl.ElectronicInServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Electronics")
public class ElectronicController {

    private final ElectronicInServiceImpl electronicInServiceImpl;

    @Autowired
    public ElectronicController(ElectronicInServiceImpl electronicInServiceImpl) {
        this.electronicInServiceImpl = electronicInServiceImpl;
    }

    @PostMapping
    public void addElectronics(@RequestBody ElectronicIn electronicIn){
        electronicInServiceImpl.addElectronic(electronicIn);
    }

    @DeleteMapping("{id}")
    public void deleteElectronics(@PathVariable Long id){
        electronicInServiceImpl.deleteElectronic(id);
    }


    @PutMapping("{id}")
    public ElectronicIn putElectronics(@RequestBody ElectronicIn electronicIn, @PathVariable Long id){
        return electronicInServiceImpl.putElectronic(electronicIn,id);
    }

    @GetMapping
    public List<ElectronicIn> getElectronics(){
        return electronicInServiceImpl.getElectronics();
    }

    @GetMapping("{id}")
    public ElectronicIn getElectronic(@PathVariable Long id){
        return electronicInServiceImpl.getElectronic(id);
    }

    @GetMapping("/types")
    public String getElectronicTypes(){
        return electronicInServiceImpl.getElectronicTypes();
    }

    @GetMapping("/sendDepartments")
    public String getElectronicSendDepartments(){return electronicInServiceImpl.getElectronicSendDepartments();}

    @GetMapping("/recipients")
    public String getElectronicRecipients(){
        return electronicInServiceImpl.getElectronicRecipients();
    }

    @GetMapping("/transferors")
    public String getElectronicTransferors(){
        return electronicInServiceImpl.getElectronicTransferors();
    }

    @GetMapping("/personOfUses")
    public String getElectronicPersonOfUses(){
        return electronicInServiceImpl.getElectronicPersonOfUses();
    }
}

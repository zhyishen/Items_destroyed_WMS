package com.safetychina.items_destroyed_wms.controller;


import com.safetychina.items_destroyed_wms.entity.ElectronicIn;
import com.safetychina.items_destroyed_wms.services.ElectronicInService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ElectronicIns")
public class ElectronicInController {

    private final ElectronicInService electronicInService;
    @Autowired
    public ElectronicInController(ElectronicInService electronicInService) {
        this.electronicInService = electronicInService;
    }


    @PostMapping
    public void addElectronicIn(@Validated @RequestBody ElectronicIn electronicIn){
        electronicInService.addElectronic(electronicIn);
    }

    @DeleteMapping("{id}")
    public void deleteElectronicIn(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        electronicInService.deleteElectronic(Long.parseLong(id));
    }


    @PutMapping("{id}")
    public ElectronicIn putElectronics(@Validated @RequestBody ElectronicIn electronicIn, @PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return electronicInService.putElectronic(electronicIn,Long.parseLong(id));
    }

    @GetMapping
    public List<ElectronicIn> getElectronics(){
        return electronicInService.getElectronics();
    }

    @GetMapping("{id}")
    public ElectronicIn getElectronic(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return electronicInService.getElectronic(Long.parseLong(id));
    }


    @GetMapping("/recipients")
    public String getElectronicRecipients(){
        return electronicInService.getElectronicRecipients();
    }


    @GetMapping("/personOfUses")
    public String getElectronicPersonOfUses(){
        return electronicInService.getElectronicPersonOfUses();
    }
}

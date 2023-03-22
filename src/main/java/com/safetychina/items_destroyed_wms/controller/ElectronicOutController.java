package com.safetychina.items_destroyed_wms.controller;

import com.safetychina.items_destroyed_wms.entity.ElectronicOut;
import com.safetychina.items_destroyed_wms.services.ElectronicOutService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ElectronicOuts")
public class ElectronicOutController {
    private final ElectronicOutService electronicOutService;
    @Autowired
    public ElectronicOutController(ElectronicOutService electronicOutService) {
        this.electronicOutService = electronicOutService;
    }
    @PostMapping
    public void addElectronicOut(@Validated @RequestBody ElectronicOut electronicOut){
        electronicOutService.addElectronicOut(electronicOut);
    }

    @DeleteMapping("{id}")
    public void deleteElectronicOut(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        electronicOutService.deleteElectronicOut(Long.parseLong(id));
    }

    @PutMapping("{id}")
    public ElectronicOut putElectronicOut(@Validated @RequestBody ElectronicOut electronicOut, @PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return electronicOutService.putElectronicOut(electronicOut,Long.parseLong(id));
    }

    @GetMapping
    public List<ElectronicOut> getElectronicOuts(){
        return electronicOutService.getElectronicOuts();
    }

    @GetMapping("{id}")
    public ElectronicOut getElectronicOut(@PathVariable(name = "id") @Pattern(regexp = "^[0-9]*$", message = "输入id格式错误") String id){
        return electronicOutService.getElectronicOut(Long.parseLong(id));
    }
}

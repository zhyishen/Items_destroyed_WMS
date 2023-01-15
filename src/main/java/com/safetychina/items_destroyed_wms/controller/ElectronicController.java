package com.safetychina.items_destroyed_wms.controller;


import com.safetychina.items_destroyed_wms.entity.Electronic;
import com.safetychina.items_destroyed_wms.services.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Electronics")
public class ElectronicController {

    private final ElectronicService electronicService;

    @Autowired
    public ElectronicController(ElectronicService electronicService) {
        this.electronicService = electronicService;
    }

    @PostMapping
    public void addElectronics(Electronic electronic){

    }

    @DeleteMapping
    public void deleteElectronics(Electronic electronic){

    }


    @PutMapping
    public void putElectronics(Electronic electronic){

    }

    @GetMapping
    public void getElectronics(){


    }
}

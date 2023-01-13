package com.safetychina.items_destroyed_wms.Controller;


import com.safetychina.items_destroyed_wms.Entity.Electronic;
import com.safetychina.items_destroyed_wms.Services.ElectronicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ElectronicController {

    private final ElectronicServices electronicServices;

    @Autowired
    public ElectronicController(ElectronicServices electronicServices) {
        this.electronicServices = electronicServices;
    }

    @PostMapping
    public void addElectronics(Electronic c){

    }

    @DeleteMapping
    public void deleteElectronics(Electronic c){

    }


    @PutMapping
    public void putElectronics(Electronic c){

    }

    @GetMapping
    public void getElectronics(){


    }
}

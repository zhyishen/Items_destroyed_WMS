package com.safetychina.items_destroyed_wms.Controller;


import com.safetychina.items_destroyed_wms.Services.ElectronicsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ElectronicsController {

    private final ElectronicsServices electronicsServices;

    @Autowired
    public ElectronicsController(ElectronicsServices electronicsServices) {
        this.electronicsServices = electronicsServices;
    }
}

package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.services.impl.ElectronicInService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ElectronicInServiceTest {

    @Autowired
    ElectronicInService electronicInService;

    @Test
    void getElectronicJsonString() {
        String types = electronicInService.getElectronicTypes();
        System.out.println(types);
    }
}
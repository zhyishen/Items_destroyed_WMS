package com.safetychina.items_destroyed_wms.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Type;
import java.util.List;


@SpringBootTest
class ElectronicInServiceTest {

    @Autowired
    ElectronicService electronicService;

    @Test
    void getElectronicJsonString() {
        String types = electronicService.getElectronicTypes();
        System.out.println(types);
    }
}
package com.safetychina.items_destroyed_wms.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ElectronicServiceTest {

    @Autowired
    ElectronicService electronicService;

    @Test
    void getElectronicJsonString() {
        String json = electronicService.getElectronicJsonString();
        System.out.println(json);
    }
}
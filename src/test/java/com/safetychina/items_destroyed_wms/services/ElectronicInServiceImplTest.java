package com.safetychina.items_destroyed_wms.services;

import com.safetychina.items_destroyed_wms.services.impl.ElectronicInServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ElectronicInServiceImplTest {

    @Autowired
    ElectronicInServiceImpl electronicInServiceImpl;

    @Test
    void getElectronicJsonString() {
        String types = electronicInServiceImpl.getElectronicTypes();
        System.out.println(types);
    }
}
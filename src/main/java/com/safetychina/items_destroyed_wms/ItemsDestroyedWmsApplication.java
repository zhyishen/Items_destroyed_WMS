package com.safetychina.items_destroyed_wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class ItemsDestroyedWmsApplication {

    public static void main(String[] args) {

        SpringApplication.run(ItemsDestroyedWmsApplication.class, args);

    }

}

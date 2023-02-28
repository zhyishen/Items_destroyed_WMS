package com.safetychina.items_destroyed_wms.controller;

import com.safetychina.items_destroyed_wms.entity.User;
import com.safetychina.items_destroyed_wms.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public User Login(@RequestBody User user){

        return user;
    }
}

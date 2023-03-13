package com.safetychina.items_destroyed_wms.controller;

import com.safetychina.items_destroyed_wms.Utils.TokenUtils;
import com.safetychina.items_destroyed_wms.entity.User;
import com.safetychina.items_destroyed_wms.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;
    }


    public final String username = "admin";
    public final String password = "123123";
    @PostMapping("/login")
    public User Login(@RequestBody User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
            TokenUtils tokenUtils = new TokenUtils();
            tokenUtils.createToken(user);
        }
        return user;
    }

    @PostMapping("/register")
    public void Register(@RequestBody User user){

    }
}

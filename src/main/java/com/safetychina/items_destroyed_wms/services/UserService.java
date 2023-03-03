package com.safetychina.items_destroyed_wms.services;


import com.safetychina.items_destroyed_wms.entity.User;
import com.safetychina.items_destroyed_wms.repository.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;



    public User findUserByName(String name){
        return userRepository.findByUsername(name);
    }
}


package com.safetychina.items_destroyed_wms.services.impl;


import com.safetychina.items_destroyed_wms.entity.User;
import com.safetychina.items_destroyed_wms.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private UserRepository userRepository;



    public User findUserByName(String name){
        return userRepository.findByUsername(name);
    }


    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user, Long id){
        userRepository.findById(id);
    }
}


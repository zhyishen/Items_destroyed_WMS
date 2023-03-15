package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

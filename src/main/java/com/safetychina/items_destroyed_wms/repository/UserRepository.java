package com.safetychina.items_destroyed_wms.repository;

import com.safetychina.items_destroyed_wms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

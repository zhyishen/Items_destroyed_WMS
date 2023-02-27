package com.safetychina.items_destroyed_wms.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "user_entity")
@Data
@AllArgsConstructor
public class User {

    @Id
    private Long uid;

    @NonNull
    private String username;

    @NonNull
    private String password;


}

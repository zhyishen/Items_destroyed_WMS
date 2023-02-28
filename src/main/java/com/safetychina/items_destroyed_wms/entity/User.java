package com.safetychina.items_destroyed_wms.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_entity")
@Data
@NoArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "users_generator",
    sequenceName = "users_generator",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "users_generator")
//    @Setter(AccessLevel.NONE)
    private Long uid;

    @NonNull
    private String username;

    @NonNull
    private String password;

    private String token;

    public User(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long uid, @NonNull String username, @NonNull String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }
}

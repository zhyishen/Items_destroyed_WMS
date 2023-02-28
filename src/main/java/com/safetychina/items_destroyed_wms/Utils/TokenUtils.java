package com.safetychina.items_destroyed_wms.Utils;



import com.google.gson.Gson;
import com.safetychina.items_destroyed_wms.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.gson.io.GsonSerializer;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

    public User createToken(User user){
        JwtBuilder jwtBuilder = Jwts.builder().setId(String.valueOf(user.getUid()))
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .serializeToJsonWith(new GsonSerializer<>(new Gson()))
                .signWith(SignatureAlgorithm.HS256, user.getPassword());

        user.setToken(jwtBuilder.compact());
        System.out.println(user.getToken());
        return user;
    }

    public void getParseToken(User user){
        String token = user.getToken();
        System.out.println(user.getToken());
        //解析Token，生成Claims对象，Token中存放的用户信息解析到了claims对象中
        Claims claims = Jwts.parser().setSigningKey("cereshuzhitingnizhenbangcereshuzhitingnizhenbang").parseClaimsJws(token).getBody();
        System.out.println("id:" + claims.getId());
        System.out.println("subject:" + claims.getSubject());
        System.out.println("IssuedAt:" + claims.getIssuedAt());
    }

}

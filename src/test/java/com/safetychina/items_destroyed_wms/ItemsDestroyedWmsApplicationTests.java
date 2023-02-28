package com.safetychina.items_destroyed_wms;

import com.safetychina.items_destroyed_wms.Utils.TokenUtils;
import com.safetychina.items_destroyed_wms.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class ItemsDestroyedWmsApplicationTests {

    @Test
    void contextLoads() {
        User user = new User(123L,"abc","cereshuzhitingnizhenbangcereshuzhitingnizhenbang");
        TokenUtils tokenUtils = new TokenUtils();
        user = tokenUtils.createToken(user);
        System.out.println(user.getToken());
        tokenUtils.getParseToken(user);
    }



}

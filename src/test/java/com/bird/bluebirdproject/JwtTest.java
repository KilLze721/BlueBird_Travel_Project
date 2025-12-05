package com.bird.bluebirdproject;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGenerateJwt(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","admin");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,"SVRIRUlNQQ==")
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }
}

package com.jd.logistics.cloud.data.commons.helper;

import com.jd.logistics.cloud.data.domain.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/15 16:55
 */
@Service
public class JwtHelper {
    private static final String secret = "jd_logistics_cloud_dashboard";

    // expired in 30 min
    private static Date generateExpirationDate() {
        Date now = new Date();
        Date expiredTime = new Date(now.getTime() + 30 * 60 * 1000);
        return expiredTime;
    }

    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            claims = null;
        }
        return claims;
    }

    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public static UserRole getUserRolesFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        if (claims != null) {
            UserRole userRole = new UserRole();
            userRole.setUsername(claims.get("username", String.class));
            userRole.setRoles(claims.get("roles", ArrayList.class));
            return userRole;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        JwtHelper t = new JwtHelper();
        Map<String, Object> claims = new HashMap();
        claims.put("username", "admin");
        claims.put("password", "admin");
        String token = t.generateToken(claims);
        System.out.println(token);
        System.out.println(t.getClaimsFromToken(token));
    }
}

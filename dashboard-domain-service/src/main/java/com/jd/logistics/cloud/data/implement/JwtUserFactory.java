package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.domain.JwtUser;
import com.jd.logistics.cloud.data.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/15 17:34
 */
public class JwtUserFactory {
    private static final List<String> roles = new ArrayList<>();
    public JwtUserFactory() {
    }

    public static JwtUser create(String username) {
        return new JwtUser(
                username,
                null,
                mapToGrantedAuthorities(roles)
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}

package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.UserRole;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/16 9:09
 */
public interface AuthService {
    String getToken(Map params);

    UserRole getUserRolesFromToken(String token);
}

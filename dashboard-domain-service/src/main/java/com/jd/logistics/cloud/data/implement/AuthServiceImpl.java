package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.helper.JwtHelper;
import com.jd.logistics.cloud.data.domain.UserRole;
import com.jd.logistics.cloud.data.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/16 9:09
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String getToken(Map params) {
        return JwtHelper.generateToken(params);
    }

    @Override
    public UserRole getUserRolesFromToken(String token) {
        return JwtHelper.getUserRolesFromToken(token);
    }
}

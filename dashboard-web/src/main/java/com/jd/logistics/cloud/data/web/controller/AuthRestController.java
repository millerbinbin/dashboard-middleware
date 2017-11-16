package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.commons.validation.Errors;
import com.jd.logistics.cloud.data.domain.AuthToken;
import com.jd.logistics.cloud.data.domain.User;
import com.jd.logistics.cloud.data.domain.UserRole;
import com.jd.logistics.cloud.data.service.AuthService;
import com.jd.logistics.cloud.data.service.UserService;
import com.jd.logistics.cloud.data.web.api.AuthApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/15 18:15
 */
@RestController
public class AuthRestController implements AuthApi {
    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<?> getToken(@Valid @RequestBody User user) {
        Errors.Builder errorsBuilder = new Errors.Builder();
        String username = user.getUsername();
        if (!userService.checkUser(username)) {
            errorsBuilder.addFieldError("username", "账户不存在，请重新输入！");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.OK);
        }
        if (!userService.checkPwd(username, user.getPassword())) {
            errorsBuilder.addFieldError("password", "密码不正确！");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.OK);
        }
        String[] userRoles = userService.getRolesByUsername(username);
        Map<String, Object> params = new HashMap<>();
        params.put("username", user.getUsername());
        params.put("roles", userRoles);
        AuthToken authToken = new AuthToken();
        authToken.setToken(authService.getToken(params));
        return new ResponseEntity<>(authToken, HttpStatus.OK);
    }

    @Override
    public UserRole getUserRoles(@Valid @RequestBody AuthToken authToken) {
        String token = authToken.getToken();
        return authService.getUserRolesFromToken(token);
    }
}
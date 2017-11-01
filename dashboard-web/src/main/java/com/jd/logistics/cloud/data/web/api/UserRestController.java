package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.commons.validation.Errors;
import com.jd.logistics.cloud.data.domain.User;
import com.jd.logistics.cloud.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 9:14
 */
@RestController
public class UserRestController implements UserApi {
    @Autowired
    UserService userService;
    @Override
    public ResponseEntity<?> login(@RequestBody User user) {
        Errors.Builder errorsBuilder = new Errors.Builder();
        if(!userService.checkUser(user.getUsername())) {
            errorsBuilder.addFieldError("username", "账户不存在，请重新输入！");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.OK);
        }
        if(!userService.checkPwd(user.getUsername(), user.getPassword())) {
            errorsBuilder.addFieldError("password", "密码不正确！");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public User user(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }
}

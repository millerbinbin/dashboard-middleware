package com.fresh.hydra.man.web.user.api;

import com.fresh.commons.data.page.Page;
import com.fresh.commons.data.page.PageRequest;
import com.fresh.commons.data.validation.Errors;
import com.fresh.hydra.center.biz.user.domain.UserQuery;
import com.fresh.hydra.center.biz.user.service.UserService;
import com.google.common.base.Strings;
import com.fresh.hydra.center.biz.user.domain.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户API控制器
 * Created by yanhua on 2017/1/5.
 */
//@RestController
@RequestMapping(value="/api/users")
public class UserRestController implements UserApi{

    @Autowired
    UserService userService;

    @Override
    public Page<User> list(@ModelAttribute UserQuery query, @ModelAttribute PageRequest pageRequest) {
        return userService.findUserPage(query, pageRequest);
    }

    @Override
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @Override
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Errors.Builder errorsBuilder = new Errors.Builder();

        if(user.getId() == null) {
            errorsBuilder.addFieldError("id", "ID不能为空");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.BAD_REQUEST);
        }

        if(Strings.isNullOrEmpty(user.getName())) {
            errorsBuilder.addFieldError("name", "名称不能为空");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.BAD_REQUEST);
        }

        try {
            userService.updateUser(user);
        }catch (UserService.DuplicateUsernameException e) {
            errorsBuilder.addFieldError("name", "名称重复了");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        Errors.Builder errorsBuilder = new Errors.Builder();
        try{
            userService.deleteUser(id);
        }catch (Exception e ){
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addUser(@RequestBody User user) {
        Errors.Builder errorsBuilder = new Errors.Builder();

        if(Strings.isNullOrEmpty(user.getName())) {
            errorsBuilder.addFieldError("name", "名称不能为空");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.BAD_REQUEST);
        }

        try {
            userService.addUser(user);
        }catch (UserService.DuplicateUsernameException e) {
            errorsBuilder.addFieldError("name", "名称重复了");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

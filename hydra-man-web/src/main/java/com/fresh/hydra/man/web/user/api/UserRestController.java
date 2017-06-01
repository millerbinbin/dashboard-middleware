package com.fresh.hydra.man.web.user.api;

import com.fresh.commons.data.page.Page;
import com.fresh.commons.data.page.PageRequest;
import com.fresh.commons.data.validation.Errors;
import com.fresh.hydra.center.biz.user.domain.UserQuery;
import com.fresh.hydra.center.biz.user.service.UserService;
import com.google.common.base.Strings;
import com.fresh.hydra.center.biz.user.domain.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 用户API控制器
 * Created by yanhua on 2017/1/5.
 */
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    UserService userService;


    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @GetMapping("")
    //@Authorization("some_auth_code")
    public Page<User> list(@ModelAttribute UserQuery query, @ModelAttribute PageRequest pageRequest){
       return userService.findUserPage(query, pageRequest);
    }

    @ApiOperation(value="通过ID获取用户", notes="通过ID获取用户")
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id")  Long id) {
        //TODO 考虑查询不到是否返回404
        return userService.getUserById(id);
    }

    @ApiOperation(value="更新一个用户信息", notes="更新一个用户信息")
    @PutMapping("")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "bad request", response = Errors.class)})
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


    @ApiOperation(value="删除一个用户", notes="删除一个用户")
    @DeleteMapping("/{id}")
    public void deleteUser( @PathVariable("id")   Long id) {
        userService.deleteUser(id);
    }

}

package com.fresh.hydra.man.web.user.api;

import com.fresh.commons.data.page.Page;
import com.fresh.commons.data.page.PageRequest;
import com.fresh.commons.data.validation.Errors;
import com.fresh.hydra.center.biz.user.domain.User;
import com.fresh.hydra.center.biz.user.domain.UserQuery;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/12 9:55
 */
@Api(value = "user", description = "the user API")
@RequestMapping(value="/api/users")
public interface UserApi {
    @ApiOperation(value="获取用户列表", notes="获取用户列表", response = User.class, responseContainer = "List", tags={ "user", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = User.class, responseContainer = "List")})
    @RequestMapping(value = "",
            produces = { "application/xml", "application/json" },
            method = RequestMethod.GET)
    Page<User> list(@ModelAttribute UserQuery query, @ModelAttribute PageRequest pageRequest);

    @ApiOperation(value="通过ID获取用户", notes="通过ID获取用户", response = User.class, tags={ "user", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = User.class),
            @ApiResponse(code = 400, message = "Invalid id value", response = Void.class),
            @ApiResponse(code = 404, message = "User not found", response = Void.class)})
    @RequestMapping(value = "/{id}",
            produces = { "application/xml", "application/json" },
            method = RequestMethod.GET)
    User getUser(@PathVariable("id") Long id);

    @ApiOperation(value="更新一个用户信息", notes="更新一个用户信息", response = Void.class, tags={ "user", })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied", response = Errors.class),
            @ApiResponse(code = 404, message = "User not found", response = Void.class),
            @ApiResponse(code = 405, message = "Validation exception", response = Errors.class) })

    @RequestMapping(value = "",
            produces = { "application/xml", "application/json" },
            consumes = { "application/json", "application/xml" },
            method = RequestMethod.PUT)
    ResponseEntity<?> updateUser(@ApiParam(value = "User that needs to be added" ,required=true )  @Valid @RequestBody User user);

    @ApiOperation(value="删除一个用户", notes="删除一个用户", response = Void.class, tags={ "user", })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
            @ApiResponse(code = 404, message = "User not found", response = Void.class) })

    @RequestMapping(value = "/{id}",
            produces = { "application/xml", "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<?> deleteUser(@ApiParam(value = "User id to delete",required=true ) @PathVariable("id")  Long id);

    @ApiOperation(value="新增一个用户", notes="新增一个用户", response = Void.class, tags={ "user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Validation exception", response = Errors.class)})

    @RequestMapping(value = "",
            produces = { "application/xml", "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<?> addUser(@ApiParam(value = "User that needs to be added" ,required=true )  @Valid @RequestBody User user);
}

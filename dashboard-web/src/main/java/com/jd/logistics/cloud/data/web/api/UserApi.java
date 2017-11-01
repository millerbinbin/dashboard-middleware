package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.domain.User;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 9:14
 */
@RequestMapping(value="/api/user")
public interface UserApi {
    @RequestMapping(value = "/login",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<?> login(@Valid @RequestBody User user);

    @RequestMapping(value = "/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    User user(@PathVariable("id") long id);
}

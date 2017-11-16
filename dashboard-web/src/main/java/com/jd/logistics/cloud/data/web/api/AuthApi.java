package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.domain.AuthToken;
import com.jd.logistics.cloud.data.domain.User;
import com.jd.logistics.cloud.data.domain.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/15 18:15
 */
@RequestMapping(value = "/auth")
public interface AuthApi {
    @RequestMapping(value = "/token",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<?> getToken(@Valid @RequestBody User user);

    @RequestMapping(value = "/roles",
            produces = {"application/json"},
            method = RequestMethod.POST)
    UserRole getUserRoles(@Valid @RequestBody AuthToken authToken);
}

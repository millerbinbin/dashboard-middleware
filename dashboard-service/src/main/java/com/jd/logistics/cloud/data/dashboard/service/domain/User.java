package com.jd.logistics.cloud.data.dashboard.service.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 * Created by yanhua on 2017/1/5.
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 3619539590826838447L;
    @ApiModelProperty(value = "", required = true)
    private String username;
    @ApiModelProperty(value = "", required = true)
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

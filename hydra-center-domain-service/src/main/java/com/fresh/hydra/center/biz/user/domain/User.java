package com.fresh.hydra.center.biz.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 * Created by yanhua on 2017/1/5.
 */
@Data
public class User implements Serializable{
    private static final long serialVersionUID = 3619539590826838447L;
    @ApiModelProperty(value = "")
    private Long id;
    @ApiModelProperty(value = "", required = true)
    private String name;
    @ApiModelProperty(value = "", required = true)
    private String password;
    @ApiModelProperty(value = "")
    private Integer age;
    @ApiModelProperty(value = "")
    private String addr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
}

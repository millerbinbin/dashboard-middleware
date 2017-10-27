package com.fresh.hydra.center.biz.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by yanhua on 2017/2/3.
 */
@Data
public class UserQuery implements Serializable{
    private static final long serialVersionUID = -100957121415841691L;
    @ApiModelProperty(value = "")
    private String name;
    @ApiModelProperty(value = "")
    private String addr;
    @ApiModelProperty(value = "")
    private Integer age;
}

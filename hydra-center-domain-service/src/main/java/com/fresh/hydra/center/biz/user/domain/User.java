package com.fresh.hydra.center.biz.user.domain;

import lombok.Data;

/**
 * 用户
 * Created by yanhua on 2017/1/5.
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String addr;
}

package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/16 9:47
 */
@Data
public class AuthToken implements Serializable {
    private static final long serialVersionUID = -8929555440395946568L;
    private String token;

//    public AuthToken(String token) {
//        this.token = token;
//    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}

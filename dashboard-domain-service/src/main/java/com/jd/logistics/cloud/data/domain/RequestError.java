package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/27 22:05
 */
@Data
public class RequestError implements Serializable{
    private static final long serialVersionUID = 8461895866350501937L;
    private String msg;

    public RequestError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
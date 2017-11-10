package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/10 10:10
 */
@Data
public class Description implements Serializable {
    private static final long serialVersionUID = -8617270101773389965L;
    private String name;
    private String text;

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}

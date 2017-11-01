package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/6 10:40
 */
@Data
public class ValueModel implements Serializable {
    private static final long serialVersionUID = 5265311276161051035L;
    private String name;
    private String sql;

    public String getName() {
        return name;
    }

    public String getSql() {
        return sql;
    }
}

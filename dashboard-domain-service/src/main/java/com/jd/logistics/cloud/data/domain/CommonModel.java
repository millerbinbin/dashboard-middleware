package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/15 13:43
 */
@Data
public class CommonModel implements Serializable {
    private static final long serialVersionUID = -729921063811389375L;
    private String name;
    private String sql;

    public String getName() {
        return name;
    }

    public String getSql() {
        return sql;
    }
}

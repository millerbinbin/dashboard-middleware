package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 14:38
 */
@Data
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 8657041672009519925L;
    private long id;
    private String warehouseName;
}

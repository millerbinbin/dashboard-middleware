package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 15:39
 */
@Data
public class DimQuery implements Serializable {
    private static final long serialVersionUID = -946299281247438489L;
    private String funcName;
    private String warehouse;
    private String dateCycle;
    private String dateStart;
    private String dateEnd;
}

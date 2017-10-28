package com.jd.logistics.cloud.data.dashboard.service.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/23 14:43
 */
@Data
public class Stat implements Serializable {
    private static final long serialVersionUID = -1820765009638095624L;
    @ApiModelProperty(name = "日期", value = "日期")
    private String D1;
    @ApiModelProperty(name = "统计1")
    private double C1;
    @ApiModelProperty(name = "统计2")
    private double C2;
    @ApiModelProperty(name = "统计3")
    private double C3;
    @ApiModelProperty(name = "统计4")
    private double C4;

    public Stat(String d1, double c1, double c2, double c3, double c4) {
        D1 = d1;
        C1 = c1;
        C2 = c2;
        C3 = c3;
        C4 = c4;
    }

    public String getD1() {
        return D1;
    }

    public double getC1() {
        return C1;
    }

    public double getC2() {
        return C2;
    }

    public double getC3() {
        return C3;
    }

    public double getC4() {
        return C4;
    }
}

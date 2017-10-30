package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/30 14:00
 */
@Data
public class BoxRes implements Serializable{
    private static final long serialVersionUID = -4464992698082552989L;
    private String funcName;
    private String funcValue;
    private String f1Name;
    private double f1Value;
    private String f2Name;
    private double f2Value;

    public BoxRes(String funcName, String funcValue, String f1Name, double f1Value, String f2Name, double f2Value) {
        this.funcName = funcName;
        this.funcValue = funcValue;
        this.f1Name = f1Name;
        this.f1Value = f1Value;
        this.f2Name = f2Name;
        this.f2Value = f2Value;
    }
}

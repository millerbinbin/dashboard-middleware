package com.jd.logistics.cloud.data.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/30 14:01
 */
public class ChartRes implements Serializable{
    private static final long serialVersionUID = 2435137108243857196L;
    private String funcName;
    private String funcValue;
    private String f1Name;
    private double f1Value;
    private String f2Name;
    private double f2Value;
    private List<String> periods;
    private String c1Name;
    private List<Double> c1Value;
    private String c2Name;
    private List<Double> c2Value;

    public String getFuncName() {
        return funcName;
    }

    public String getFuncValue() {
        return funcValue;
    }

    public String getF1Name() {
        return f1Name;
    }

    public double getF1Value() {
        return f1Value;
    }

    public String getF2Name() {
        return f2Name;
    }

    public double getF2Value() {
        return f2Value;
    }

    public List<String> getPeriods() {
        return periods;
    }

    public void setPeriods(List<String> periods) {
        this.periods = periods;
    }

    public void setC1Value(List<Double> c1Value) {
        this.c1Value = c1Value;
    }

    public void setC2Value(List<Double> c2Value) {
        this.c2Value = c2Value;
    }



    public List<Double> getC1Value() {
        return c1Value;
    }



    public List<Double> getC2Value() {
        return c2Value;
    }

    public String getC1Name() {
        return c1Name;
    }

    public String getC2Name() {
        return c2Name;
    }

    public ChartRes(String funcName, String funcValue, String f1Name, double f1Value, String f2Name, double f2Value, String c1Name, String c2Name) {
        this.funcName = funcName;
        this.funcValue = funcValue;
        this.f1Name = f1Name;
        this.f1Value = f1Value;
        this.f2Name = f2Name;
        this.f2Value = f2Value;
        this.c1Name = c1Name;
        this.c2Name = c2Name;
    }
}

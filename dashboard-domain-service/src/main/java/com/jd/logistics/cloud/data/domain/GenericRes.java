package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 15:50
 */
@Data
public class GenericRes implements Serializable{
    private static final long serialVersionUID = 1902248647108008231L;
    private String funcName;
    private double funcValue;
    private String funcFormatValue;
    private String idxName1;
    private double idxValue1;
    private String idxName2;
    private double idxValue2;
    private String idxName3;
    private double idxValue3;
    private String idxName4;
    private double idxValue4;
    private String statDate;
    private List<String> p;
    private List<Double> v1;
    private List<Double> v2;
    public String getFuncFormatValue() {
        DecimalFormat df = new DecimalFormat("###,##0");
        DecimalFormat df2 = new DecimalFormat("###,##0.00");
        double tmp = funcValue;
        if (tmp / 100000 >=1)
            funcFormatValue = df.format(tmp/1000) + "K";
        else if ((tmp * 10) % 10 == 0) // integer
            funcFormatValue = df.format(tmp);
        else if (tmp <= 1 ) // 百分比
            funcFormatValue = df2.format(tmp * 100) + "%";
        else funcFormatValue = df2.format(tmp);
        return funcFormatValue;
    }

    public double getFuncValue() {
        return funcValue;
    }

    public String getStatDate() {
        return statDate;
    }

    public void setP(List<String> p) {
        this.p = p;
    }

    public void setV1(List<Double> v1) {
        this.v1 = v1;
    }

    public void setV2(List<Double> v2) {
        this.v2 = v2;
    }
}

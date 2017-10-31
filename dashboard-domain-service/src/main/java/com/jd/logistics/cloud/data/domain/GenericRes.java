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
    private String funcValue;
    private String idxName1;
    private double idxValue1;
    private String idxName2;
    private double idxValue2;
    private String idxName3;
    private double idxValue3;
    private String idxName4;
    private double idxValue4;
    private String statDate;

    public String getFuncValue() {
        DecimalFormat df = new DecimalFormat("###,##0");
        DecimalFormat df2 = new DecimalFormat("###,##0.00");
        double tmp = Double.parseDouble(funcValue);
        if (tmp / 100000 >=1)
            funcValue = df.format(tmp/1000) + "K";
        else if ((tmp * 10) % 10 == 0) // integer
            funcValue = df.format(tmp);
        else if (tmp <= 1 ) // 百分比
            funcValue = df2.format(tmp * 100) + "%";
        else funcValue = df2.format(tmp);
        return funcValue;
    }
}

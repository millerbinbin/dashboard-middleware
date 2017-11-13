package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by GIN on 2017/10/30.
 */
@Data
public class Metric implements Serializable {
    private static final long serialVersionUID = -3908221732001318230L;

    private String id;
    private String metricName;
    private int metricType; // BOX(0), CHART(1), FREE(2);
    private int seq;

    public String getId() {
        return id;
    }

    public String getMetricName() {
        return metricName;
    }

    public int getMetricType() {
        return metricType;
    }

    public int getSeq() {
        return seq;
    }

}

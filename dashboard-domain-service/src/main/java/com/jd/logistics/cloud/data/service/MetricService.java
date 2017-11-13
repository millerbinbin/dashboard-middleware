package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.Metric;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 10:17
 */
public interface MetricService {
    List<Metric> getMetricsByType(int type);

    List<Metric> getAllMetrics();

    void updateMetric(Metric metric);

    String getMetricNameById(String metricId);
}

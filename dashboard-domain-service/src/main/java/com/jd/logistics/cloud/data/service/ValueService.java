package com.jd.logistics.cloud.data.service;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:22
 */
public interface ValueService {
    Map getMetricValue(String metricId, String dateCycle, Map<String, String> params);
}

package com.jd.logistics.cloud.data.service;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/15 13:46
 */
public interface GridService {
    Map getMetricGrid(String metricId, String dateCycle, Map<String, String> params);
}

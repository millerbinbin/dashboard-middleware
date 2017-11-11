package com.jd.logistics.cloud.data.service;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:22
 */
public interface ChartService {
    Map getFuncCharts(String funcId);

    Map getFuncChartByDateCycle(String funcId, String dateCycle);

    String getFuncChartOptionByDateCycle(String funcId, String dateCycle);
}

package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.service.ChartService;
import com.jd.logistics.cloud.data.web.api.ChartApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:25
 */
@RestController
public class ChartRestController implements ChartApi {
    @Autowired
    ChartService chartService;

    @Override
    public Map getMetricChart(@RequestParam("metric") String metricId,
                              @RequestParam("cycle") String dateCycle,
                              @RequestParam("warehouse") String warehouse,
                              @RequestParam("sysdate") String sysdate) {
        Map<String, String> map = new HashMap<>();
        map.put("warehouse", warehouse);
        map.put("sysdate", sysdate);
        return chartService.getMetricChart(metricId, dateCycle, map);
    }

    @Override
    public String getMetricChartOption(@RequestParam("metric") String metricId,
                                       @RequestParam("cycle") String dateCycle) {
        return chartService.getMetricChartOption(metricId, dateCycle);
    }
}

package com.jd.logistics.cloud.data.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:18
 */
@RequestMapping(value = "/api")
public interface ChartApi {
    @RequestMapping(value = "/chart",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Map getMetricChart(@RequestParam("metric") String metricId,
                       @RequestParam("cycle") String dateCycle,
                       @RequestParam("warehouse") String warehouse,
                       @RequestParam("sysdate") String sysdate);

    @RequestMapping(value = "/chartOption",
            produces = {"application/json"},
            method = RequestMethod.GET)
    String getMetricChartOption(@RequestParam("metric") String metricId,
                                @RequestParam("cycle") String dateCycle);
}
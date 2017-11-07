package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.service.ChartService;
import com.jd.logistics.cloud.data.web.api.ChartApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public Map getFuncChart(@PathVariable("funcName") String funcName) {
        return chartService.getFuncChart(funcName);
    }

    @Override
    public String getFuncChartOption(@PathVariable("funcName") String funcName, @PathVariable("chartName") String chartName) {
        return chartService.getFuncChartOption(funcName, chartName);
    }
}

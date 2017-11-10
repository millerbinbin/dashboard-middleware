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
    public Map getFuncChart(@PathVariable("funcId") String funcId) {
        return chartService.getFuncChart(funcId);
    }

    @Override
    public String getFuncChartOption(@PathVariable("funcId") String funcId, @PathVariable("chartId") String chartId) {
        return chartService.getFuncChartOption(funcId, chartId);
    }
}

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
    public Map getFuncCharts(@PathVariable("funcId") String funcId) {
        return chartService.getFuncCharts(funcId);
    }

    @Override
    public Map getFuncChartByDateCycle(@PathVariable("funcId")String funcId, @PathVariable("dateCycle")String dateCycle) {
        return chartService.getFuncChartByDateCycle(funcId, dateCycle);
    }

    @Override
    public String getFuncChartOptionByDateCycle(@PathVariable("funcId") String funcId, @PathVariable("dateCycle") String dateCycle) {
        return chartService.getFuncChartOptionByDateCycle(funcId, dateCycle);
    }
}

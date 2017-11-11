package com.jd.logistics.cloud.data.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:18
 */
@RequestMapping(value = "/api")
public interface ChartApi {
    @RequestMapping(value = "/chart/{funcId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Map getFuncCharts(@PathVariable("funcId") String funcId);

    @RequestMapping(value = "/chart/{funcId}/{dateCycle}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Map getFuncChartByDateCycle(@PathVariable("funcId") String funcId, @PathVariable("dateCycle") String dateCycle);

    @RequestMapping(value = "/chartOption/{funcId}/{dateCycle}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    String getFuncChartOptionByDateCycle(@PathVariable("funcId") String funcId, @PathVariable("dateCycle") String dateCycle);
}
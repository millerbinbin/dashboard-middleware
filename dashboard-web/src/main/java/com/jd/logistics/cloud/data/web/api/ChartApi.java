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
    Map getFuncChart(@PathVariable("funcId") String funcId);

    @RequestMapping(value = "/chartOption/{funcId}/{chartId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    String getFuncChartOption(@PathVariable("funcId") String funcId, @PathVariable("chartId") String chartId);
}
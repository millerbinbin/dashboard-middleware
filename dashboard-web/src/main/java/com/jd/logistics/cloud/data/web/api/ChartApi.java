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
    @RequestMapping(value = "/chart/{funcName}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Map getFuncChart(@PathVariable("funcName") String funcName);

    @RequestMapping(value = "/chartOption/{funcName}/{chartName}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    String getFuncChartOption(@PathVariable("funcName") String funcName, @PathVariable("chartName") String chartName);
}
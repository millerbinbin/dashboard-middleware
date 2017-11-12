package com.jd.logistics.cloud.data.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    Map getFuncChartByDateCycle(@PathVariable("funcId") String funcId,
                                       @PathVariable(value="dateCycle")String dateCycle,
                                       @RequestParam(value="warehouse")String warehouse,
                                       @RequestParam(value="sysdate")String sysdate,
                                       HttpServletRequest request);

    @RequestMapping(value = "/chartOption/{funcId}/{dateCycle}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    String getFuncChartOptionByDateCycle(@PathVariable("funcId") String funcId, @PathVariable("dateCycle") String dateCycle);
}
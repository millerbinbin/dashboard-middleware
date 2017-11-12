package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.service.ChartService;
import com.jd.logistics.cloud.data.web.api.ChartApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    public Map getFuncCharts(@PathVariable("funcId") String funcId) {
        return chartService.getFuncCharts(funcId);
    }

    @Override
    public Map getFuncChartByDateCycle(@PathVariable("funcId") String funcId,
                                       @PathVariable(value="dateCycle")String dateCycle,
                                       @RequestParam(value="warehouse")String warehouse,
                                       @RequestParam(value="sysdate")String sysdate,
                                       HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("warehouse", request.getParameter("warehouse"));
        map.put("sysdate", request.getParameter("sysdate"));
        return chartService.getFuncChartByDateCycle(funcId, dateCycle, map);
    }

    @Override
    public String getFuncChartOptionByDateCycle(@PathVariable("funcId")String funcId, @PathVariable("dateCycle")String dateCycle) {
        return chartService.getFuncChartOptionByDateCycle(funcId, dateCycle);
    }
}

package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.service.GridService;
import com.jd.logistics.cloud.data.service.ValueService;
import com.jd.logistics.cloud.data.web.api.GridApi;
import com.jd.logistics.cloud.data.web.api.ValueApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:21
 */
@RestController
public class GridRestController implements GridApi {
    @Autowired
    GridService gridService;

    @Override
    public Map getFuncGrid(@RequestParam("metric") String metricId,
                            @RequestParam(value = "cycle") String dateCycle,
                            @RequestParam(value = "sysdate") String sysdate) {
        Map<String, String> map = new HashMap<>();
        map.put("sysdate", sysdate);
        return gridService.getMetricGrid(metricId, dateCycle, map);
    }
}

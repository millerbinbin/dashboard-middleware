package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.service.ValueService;
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
public class ValueRestController implements ValueApi {
    @Autowired
    ValueService valueService;

    @Override
    public Map getFuncValue(@RequestParam("metric") String metricId,
                            @RequestParam(value = "cycle") String dateCycle,
                            @RequestParam(value = "warehouse") String warehouse,
                            @RequestParam(value = "sysdate") String sysdate) {
        Map<String, String> map = new HashMap<>();
        map.put("warehouse", warehouse);
        map.put("sysdate", sysdate);
        return valueService.getMetricValue(metricId, dateCycle, map);
    }
}

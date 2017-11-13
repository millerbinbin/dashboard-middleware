package com.jd.logistics.cloud.data.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:19
 */
@RequestMapping(value = "/api/value")
public interface ValueApi {
    @RequestMapping(value = "",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Map getFuncValue(@RequestParam("metric") String metricId,
                     @RequestParam("cycle") String dateCycle,
                     @RequestParam(value = "warehouse") String warehouse,
                     @RequestParam(value = "sysdate") String sysdate);
}

package com.jd.logistics.cloud.data.web.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/13 12:42
 */
@RequestMapping(value = "/api")
@PreAuthorize("hasRole('GUEST')")
public interface DefinitionApi {
    @RequestMapping(value = "/def/{metricId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Map getMetricDef(@PathVariable("metricId") String metricId);

    @RequestMapping(value = "/def",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Map> getDef();
}

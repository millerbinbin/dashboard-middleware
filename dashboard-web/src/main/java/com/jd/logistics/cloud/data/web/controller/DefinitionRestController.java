package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.domain.Metric;
import com.jd.logistics.cloud.data.service.DefService;
import com.jd.logistics.cloud.data.service.MetricService;
import com.jd.logistics.cloud.data.web.api.DefinitionApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/13 12:45
 */
@RestController
public class DefinitionRestController implements DefinitionApi {
    @Autowired
    DefService defService;
    @Autowired
    MetricService metricService;

    @Override
    public Map getMetricDef(@PathVariable("metricId") String metricId) {
        return defService.getMetricDef(metricId);
    }

    @Override
    public List<Map> getDef() {
        List<Map> res = new ArrayList<>();
        for (Metric metric : metricService.getAllMetrics()) {
            res.add(defService.getMetricDef(metric.getId()));
        }
        return res;
    }
}

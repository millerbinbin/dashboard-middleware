package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.domain.Metric;
import com.jd.logistics.cloud.data.service.MetricService;
import com.jd.logistics.cloud.data.service.ModelService;
import com.jd.logistics.cloud.data.web.api.ModelApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:27
 */
@RestController
public class ModelRestController implements ModelApi {
    @Autowired
    ModelService modelService;
    @Autowired
    MetricService metricService;

    @Override
    public List<Map> getModels() {
        List<Map> res = new ArrayList<>();
        for (Metric metric : metricService.getAllMetrics()) {
            res.add(modelService.getModel(metric.getId(), metric.getMetricName()));
        }
        return res;
    }
}

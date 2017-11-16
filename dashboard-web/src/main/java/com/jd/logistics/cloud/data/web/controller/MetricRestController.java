package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.domain.Metric;
import com.jd.logistics.cloud.data.service.MetricService;
import com.jd.logistics.cloud.data.web.api.MetricApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 10:16
 */
@RestController
public class MetricRestController implements MetricApi {
    @Autowired
    MetricService metricService;

    @Override
    public List<Metric> getMetricsByType(@PathVariable("type") int type) {
        return metricService.getMetricsByType(type);
    }

    @Override
    public List<Metric> getAllMetrics() {
        return metricService.getAllMetrics();
    }

    @Override
    public ResponseEntity updateMetric(@Valid @RequestBody List<Metric> metrics) {
        for (Metric metric : metrics) {
            metricService.updateMetric(metric);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.domain.Metric;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 10:14
 */
@RequestMapping(value = "/api/metric")
public interface MetricApi {

    @RequestMapping(value = "/{type}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Metric> getMetricsByType(@PathVariable("type") int type);

    @RequestMapping(value = "",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Metric> getAllMetrics();

    @RequestMapping(value = "",
            produces = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity updateMetric(@Valid @RequestBody List<Metric> functionList);
}

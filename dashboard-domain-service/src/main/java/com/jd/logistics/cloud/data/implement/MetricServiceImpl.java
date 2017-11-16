package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.domain.Metric;
import com.jd.logistics.cloud.data.repository.MetricRepository;
import com.jd.logistics.cloud.data.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 10:17
 */
@Service
public class MetricServiceImpl implements MetricService {
    @Autowired
    MetricRepository metricRepository;

    @Override
    public List<Metric> getMetricsByType(int type) {
        return metricRepository.getByType(type);
    }

    @Override
    public List<Metric> getAllMetrics() {
        return metricRepository.getAll();
    }

    @Override
    public void updateMetric(Metric metric) {
        metricRepository.update(metric);
    }

    @Override
    public String getMetricNameById(String metricId) {
        return metricRepository.getMetricNameById(metricId);
    }
}

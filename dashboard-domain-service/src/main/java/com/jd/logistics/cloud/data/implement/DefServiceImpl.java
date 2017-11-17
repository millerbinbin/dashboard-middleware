package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.helper.ModelHelper;
import com.jd.logistics.cloud.data.service.DefService;
import com.jd.logistics.cloud.data.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/13 15:21
 */
@Service
public class DefServiceImpl implements DefService {
    @Autowired
    MetricService metricService;

    @Override
    public Map getMetricDef(String metricId) {
        Map res = ModelHelper.getDesc(metricId);
        res.put("id", metricId);
        res.put("name", metricService.getMetricNameById(metricId));
        return res;
    }
}

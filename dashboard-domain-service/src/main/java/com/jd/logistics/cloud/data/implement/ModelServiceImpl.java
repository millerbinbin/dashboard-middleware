package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.Constants;
import com.jd.logistics.cloud.data.commons.helper.ModelHelper;
import com.jd.logistics.cloud.data.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:35
 */
@Service
public class ModelServiceImpl implements ModelService {
    private static final String chartTemplate = getMetricChartFormat();
    private static final String numberTemplate = getMetricValueFormat();

    private static String getMetricChartFormat() {
        return ModelHelper.getStringFromResourcePath(Constants.TEMPLATE_PARENT_FOLDER +
                "/" + Constants.CHART_TEMPLATE_FILE);
    }

    private static String getMetricValueFormat() {
        return ModelHelper.getStringFromResourcePath(Constants.TEMPLATE_PARENT_FOLDER +
                "/" + Constants.VALUE_TEMPLATE_FILE);
    }

    @Override
    public Map getModel(String metricId, String metricName) {
        Map res = new HashMap<>();
        res.put("id", metricId);
        res.put("name", metricName);
        res.put("chartTemplate", chartTemplate);
        res.put("numberTemplate", numberTemplate);
        return res;
    }
}

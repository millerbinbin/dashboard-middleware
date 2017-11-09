package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.Constants;
import com.jd.logistics.cloud.data.commons.Helper;
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
    private String getFuncChartFormat(String funcName) {
        return Helper.getStringFromResourcePath(Constants.TEMPLATE_PARENT_FOLDER + "/" +
                funcName + "/" + Constants.CHART_TEMPLATE_SUFFIX);
    }

    private String getFuncValueFormat(String funcName) {
        return Helper.getStringFromResourcePath(Constants.TEMPLATE_PARENT_FOLDER + "/" +
                funcName + "/" + Constants.VALUE_TEMPLATE_SUFFIX);
    }

    @Override
    public Map getFuncModel(String funcName) {
        String chartTemplate = getFuncChartFormat(funcName);
        String numberTemplate = getFuncValueFormat(funcName);
        Map res = new HashMap<>();
        res.put("name", funcName);
        res.put("chartTemplate", chartTemplate);
        res.put("numberTemplate", numberTemplate);
        return res;
    }
}

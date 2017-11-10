package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.Constants;
import com.jd.logistics.cloud.data.commons.Helper;
import com.jd.logistics.cloud.data.service.FuncService;
import com.jd.logistics.cloud.data.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    FuncService funcService;
    private String getFuncChartFormat(String funcName) {
        return Helper.getStringFromResourcePath(Constants.TEMPLATE_PARENT_FOLDER + "/" +
                funcName + "/" + Constants.CHART_TEMPLATE_SUFFIX);
    }

    private String getFuncValueFormat(String funcName) {
        return Helper.getStringFromResourcePath(Constants.TEMPLATE_PARENT_FOLDER + "/" +
                funcName + "/" + Constants.VALUE_TEMPLATE_SUFFIX);
    }

    @Override
    public Map getFuncModel(String funcId) {
        String chartTemplate = getFuncChartFormat(funcId);
        String numberTemplate = getFuncValueFormat(funcId);
        Map res = new HashMap<>();
        res.put("id", funcId);
        res.put("name", funcService.getFuncNameById(funcId));
        res.put("chartTemplate", chartTemplate);
        res.put("numberTemplate", numberTemplate);
        return res;
    }

    @Override
    public Map getFuncDesc(String funcId) {
        Map res = Helper.getDesc(funcId);
        res.put("id", funcId);
        res.put("name", funcService.getFuncNameById(funcId));
        return res;
    }
}

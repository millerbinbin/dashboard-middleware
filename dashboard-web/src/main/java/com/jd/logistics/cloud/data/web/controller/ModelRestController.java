package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.domain.Function;
import com.jd.logistics.cloud.data.service.FuncService;
import com.jd.logistics.cloud.data.service.ModelService;
import com.jd.logistics.cloud.data.web.api.ModelApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    FuncService funcService;
    @Override
    public Map getFuncModel(@PathVariable("funcId") String funcId) {
        return modelService.getFuncModel(funcId);
    }

    @Override
    public List<Map> getModels() {
        List<Map> res = new ArrayList<>();
        for(Function function: funcService.getAllFunc()){
            res.add(modelService.getFuncModel(function.getId()));
        }
        return res;
    }

    @Override
    public List<Map> getDesc() {
        List<Map> res = new ArrayList<>();
        for(Function function: funcService.getAllFunc()){
            res.add(modelService.getFuncDesc(function.getId()));
        }
        return res;
    }
}

package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    public Map getFuncModel(@PathVariable("funcName") String funcName) {
        return modelService.getFuncModel(funcName);
    }
}

package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.service.ValueService;
import com.jd.logistics.cloud.data.web.api.ValueApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:21
 */
@RestController
public class ValueRestController implements ValueApi {
    @Autowired
    ValueService valueService;

    @Override
    public Map getFuncValues(@PathVariable("funcName") String funcName) {
        return valueService.getFuncValues(funcName);
    }
}

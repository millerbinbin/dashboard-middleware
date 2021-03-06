package com.jd.logistics.cloud.data.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:18
 */
@RequestMapping(value = "/api")
public interface ModelApi {
    @RequestMapping(value = "/models",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Map> getModels();
}

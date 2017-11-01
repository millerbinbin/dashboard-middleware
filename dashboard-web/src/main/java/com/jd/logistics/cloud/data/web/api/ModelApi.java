package com.jd.logistics.cloud.data.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:18
 */
@RequestMapping(value = "/api/model")
public interface ModelApi {
    @RequestMapping(value = "/{funcName}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Map getFuncModel(@PathVariable("funcName") String funcName);

}

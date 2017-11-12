package com.jd.logistics.cloud.data.web.controller;

import com.jd.logistics.cloud.data.service.ValueService;
import com.jd.logistics.cloud.data.web.api.ValueApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    public Map getFuncValues(@PathVariable("funcId") String funcId) {
        return valueService.getFuncValues(funcId);
    }

    @Override
    public Map getFuncValuesByDateCycle(@PathVariable("funcId") String funcId,
                                 @PathVariable(value="dateCycle")String dateCycle,
                                 @RequestParam(value="warehouse")String warehouse,
                                 @RequestParam(value="sysdate")String sysdate,
                                 HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("warehouse", request.getParameter("warehouse"));
        map.put("sysdate", request.getParameter("sysdate"));
        return valueService.getFuncValuesByDateCycle(funcId, dateCycle, map);
    }
}

package com.jd.logistics.cloud.data.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:19
 */
@RequestMapping(value = "/api/value")
public interface ValueApi {
    @RequestMapping(value = "/{funcId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Map getFuncValues(@PathVariable("funcId") String funcId);

    @RequestMapping(value = "/{funcId}/{dateCycle}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Map getFuncValuesByDateCycle(@PathVariable("funcId") String funcId,
                                 @PathVariable(value="dateCycle")String dateCycle,
                                 @RequestParam(value="warehouse")String warehouse,
                                 @RequestParam(value="sysdate")String sysdate,
                                 HttpServletRequest request);
}

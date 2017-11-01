package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.domain.DateCycle;
import com.jd.logistics.cloud.data.domain.Warehouse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 14:41
 */
@RequestMapping(value="/api/dim")
public interface DimApi {

    @RequestMapping(value = "/warehouse",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Warehouse> getWarehouses();

    @RequestMapping(value = "/datecycle",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<DateCycle> getDateCycles();

}

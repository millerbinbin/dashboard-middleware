package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.domain.DateCycle;
import com.jd.logistics.cloud.data.domain.Warehouse;
import com.jd.logistics.cloud.data.service.DimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 14:43
 */
@RestController
public class DimRestController implements DimApi {
    @Autowired
    DimService dimService;

    @Override
    public List<Warehouse> getWarehouses() {
        return dimService.getWarehouses();
    }

    @Override
    public List<DateCycle> getDateCycles() {
        return dimService.getDateCycles();
    }
}

package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.domain.Dim;
import com.jd.logistics.cloud.data.domain.GenericRes;
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
public class DimRestController implements DimApi{
    @Autowired
    DimService dimService;
    @Override
    public List<Dim> getWarehouses() {
        return dimService.getWarehouses();
    }

    @Override
    public List<Dim> getDateCycles() {
        return dimService.getDateCycles();
    }
}

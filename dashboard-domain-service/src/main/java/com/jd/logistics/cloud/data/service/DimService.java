package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.DateCycle;
import com.jd.logistics.cloud.data.domain.Warehouse;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 14:39
 */
public interface DimService {
    List<Warehouse> getWarehouses();

    List<DateCycle> getDateCycles();

}

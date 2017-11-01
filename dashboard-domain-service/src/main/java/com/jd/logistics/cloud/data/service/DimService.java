package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.Dim;
import com.jd.logistics.cloud.data.domain.DimQuery;
import com.jd.logistics.cloud.data.domain.GenericRes;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 14:39
 */
public interface DimService {
    List<Dim> getWarehouses();

    List<Dim> getDateCycles();

}

package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.DateCycle;
import com.jd.logistics.cloud.data.domain.Warehouse;
import com.jd.logistics.cloud.data.repository.DimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 14:40
 */
@Service
public class DimServiceImpl implements DimService {
    @Autowired
    DimRepository dimRepository;

    @Override
    public List<Warehouse> getWarehouses() {
        return dimRepository.getWarehouses();
    }

    @Override
    public List<DateCycle> getDateCycles() {
        return dimRepository.getDateCycles();
    }

}

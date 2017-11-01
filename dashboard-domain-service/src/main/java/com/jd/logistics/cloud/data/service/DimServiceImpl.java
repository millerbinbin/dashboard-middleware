package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.Dim;
import com.jd.logistics.cloud.data.domain.DimQuery;
import com.jd.logistics.cloud.data.domain.GenericRes;
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
    public List<Dim> getWarehouses() {
        return dimRepository.getWarehouses();
    }

    @Override
    public List<Dim> getDateCycles() {
        return dimRepository.getDateCycles();
    }

}

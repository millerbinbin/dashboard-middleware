package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.Function;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 10:17
 */
public interface FuncService {
    List<Function> getFuncByType(int type);
    List<Function> getAllFunc();
    void updateFuncType(Function func);
}

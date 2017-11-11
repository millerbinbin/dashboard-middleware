package com.jd.logistics.cloud.data.service;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:22
 */
public interface ValueService {
    Map getFuncValues(String funcId);

    Map getFuncValuesByDateCycle (String fucId, String dateCycle);
}

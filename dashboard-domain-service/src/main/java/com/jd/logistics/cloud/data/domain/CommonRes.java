package com.jd.logistics.cloud.data.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/2 11:21
 */
public class CommonRes implements Serializable {
    private static final long serialVersionUID = 2211076189595925918L;
    private Map<String, List<Object>> arrayResult = new HashMap<>();
    private Map<String, Object> singleResult = new HashMap<>();

    public void addItem(String key, Object value) {
        if (arrayResult.get(key) == null) {
            List<Object> i = new ArrayList<>();
            i.add(value);
            arrayResult.put(key, i);
        } else {
            List<Object> i = arrayResult.get(key);
            i.add(value);
        }
    }

    public void putItem(String key, Object value) {
        singleResult.put(key, value);
    }

    public Map<String, List<Object>> getArrayResult() {
        return arrayResult;
    }

    public Map<String, Object> getSingleResult() {
        return singleResult;
    }
}

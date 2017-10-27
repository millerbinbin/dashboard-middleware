package com.fresh.hydra.center.biz.user.domain;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/24 17:55
 */
public class Value{
    private Object[] value = new Object[2];

    public Value(Object[] value) {
        this.value = value;
    }
    public Value(String date, double C1) {
        value[0] = date;
        value[1] = C1;
    }

    public Object[] getValue() {
        return value;
    }
}

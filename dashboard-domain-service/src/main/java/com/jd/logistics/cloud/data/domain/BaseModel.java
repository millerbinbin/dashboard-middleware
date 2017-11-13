package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/6 10:39
 */
@Data
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 7593767886021869685L;
    private String id;
    private String name;
    private List<ChartModel> charts;
    private List<ValueModel> values;
    private List<Def> def;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ChartModel> getCharts() {
        return charts;
    }

    public List<ValueModel> getValues() {
        return values;
    }

    public List<Def> getDef() {
        return def;
    }
}

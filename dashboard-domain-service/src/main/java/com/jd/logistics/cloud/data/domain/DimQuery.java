package com.jd.logistics.cloud.data.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 15:39
 */
@Data
public class DimQuery implements Serializable {
    private static final long serialVersionUID = -946299281247438489L;
    private String funcName;
    private List<String> funcNameList;
    private String warehouse;
    private String dateCycle;
    private String statDate;
    private String dateStart;
    private String dateEnd;

    public String getWarehouse() {
        return warehouse;
    }

    public String getDateCycle() {
        return dateCycle;
    }

    public String getStatDate() {
        return statDate;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public List<String> getFuncNameList() {
        return funcNameList;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public void setDateCycle(String dateCycle) {
        this.dateCycle = dateCycle;
    }

    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}

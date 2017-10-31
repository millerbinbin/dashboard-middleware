package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.commons.page.Page;
import com.jd.logistics.cloud.data.commons.page.PageRequest;
import com.jd.logistics.cloud.data.domain.*;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/23 14:46
 */
public interface StatService {
    Page<Stat> findStats(StatQuery query, PageRequest pageRequest);

    List<Col> getCols();

    List<String> getCategories();

    double[] getRow(String date);

    List<String> getPeriods();

    List<Double> getColumn(String c1);

    List<List<Double>> getColumns();

    List<BoxRes> getBoxes();

    List<ChartRes> getCharts();

    List<GenericRes> getRes(DimQuery query);
}

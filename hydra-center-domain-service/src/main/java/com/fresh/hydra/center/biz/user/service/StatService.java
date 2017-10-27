package com.fresh.hydra.center.biz.user.service;

import com.fresh.commons.data.page.Page;
import com.fresh.commons.data.page.PageRequest;
import com.fresh.hydra.center.biz.user.domain.*;

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
}

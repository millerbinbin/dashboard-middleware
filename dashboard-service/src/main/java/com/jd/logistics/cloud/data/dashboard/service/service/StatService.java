package com.jd.logistics.cloud.data.dashboard.service.service;

import com.jd.logistics.cloud.data.dashboard.commons.page.Page;
import com.jd.logistics.cloud.data.dashboard.commons.page.PageRequest;
import com.jd.logistics.cloud.data.dashboard.service.domain.Col;
import com.jd.logistics.cloud.data.dashboard.service.domain.Stat;
import com.jd.logistics.cloud.data.dashboard.service.domain.StatQuery;
import com.jd.logistics.cloud.data.dashboard.service.domain.User;

import java.util.List;

/**
 * Created by GIN on 2017/10/28.
 */
public interface StatService {
    Page<Stat> findStats(StatQuery query, PageRequest pageRequest);

    List<Col> getCols();

    List<String> getCategories();

    double[] getRow(String date);

    List<String> getPeriods();

    List<Double> getColumn(String c1);

    List<List<Double>> getColumns();

    User getUser(long id);
}

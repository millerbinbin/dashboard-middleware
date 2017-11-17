package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.helper.ModelHelper;
import com.jd.logistics.cloud.data.commons.helper.RowSetHelper;
import com.jd.logistics.cloud.data.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:26
 */
@Service
public class ChartServiceImpl implements ChartService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Map getMetricChart(String metricId, String dateCycle, Map<String, String> params) {
        String sql = ModelHelper.getMetricChartSql(metricId, dateCycle);
        for (Map.Entry<String, String> p : params.entrySet()) {
            sql = sql.replace(String.format("#{{%s}}", p.getKey()), p.getValue());
        }
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        return RowSetHelper.RowSet2ArrayRes(rowSet);
    }

    @Override
    public String getMetricChartOption(String metricId, String dateCycle) {
        return ModelHelper.getMetricChartOption(metricId, dateCycle);
    }
}

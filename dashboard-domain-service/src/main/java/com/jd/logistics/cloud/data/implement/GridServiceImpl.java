package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.helper.ModelHelper;
import com.jd.logistics.cloud.data.commons.helper.RowSetHelper;
import com.jd.logistics.cloud.data.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/15 13:46
 */
@Service
public class GridServiceImpl implements GridService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Map getMetricGrid(String metricId, String dateCycle, Map<String, String> params) {
        String sql = ModelHelper.getMetricGridSql(metricId, dateCycle);
        for (Map.Entry<String, String> p : params.entrySet()) {
            sql = sql.replace(String.format("#{{%s}}", p.getKey()), p.getValue());
        }
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        return RowSetHelper.RowSet2HeaderAndRes(rowSet);
    }
}

package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.helper.ModelHelper;
import com.jd.logistics.cloud.data.commons.helper.RowSetHelper;
import com.jd.logistics.cloud.data.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:22
 */
@Service
public class ValueServiceImpl implements ValueService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Map getMetricValue(String metricId, String dateCycle, Map<String, String> params) {
        String sql = ModelHelper.getMetricValueSql(metricId, dateCycle);
        for (Map.Entry<String, String> p : params.entrySet()) {
            sql = sql.replace(String.format("#{{%s}}", p.getKey()), p.getValue());
        }
        Map res = new HashMap<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        res.put("value", RowSetHelper.RowSet2SingleRes(rowSet));
        return res;
    }
}

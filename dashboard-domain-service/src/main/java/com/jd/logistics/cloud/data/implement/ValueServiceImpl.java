package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.Helper;
import com.jd.logistics.cloud.data.commons.ShowType;
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
    public Map getFuncValues(String funcId) {
        Map<String, String> sqlList = Helper.getFuncSqlByType(funcId, ShowType.VALUE);
        Map res = new HashMap<>();
        for (Map.Entry<String, String> e : sqlList.entrySet()) {
            String sql = e.getValue();
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            res.put(e.getKey(), Helper.RowSet2SingleRes(rowSet));
        }
        return res;
    }

    @Override
    public Map getFuncValuesByDateCycle(String funcId, String dateCycle) {
        Map<String, String> sqlList = Helper.getFuncSqlByType(funcId, ShowType.VALUE);
        String sql = sqlList.get(dateCycle);
        Map res = new HashMap<>();
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        res.put("value", Helper.RowSet2SingleRes(rowSet));
        return res;
    }
}

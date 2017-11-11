package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.commons.Constants;
import com.jd.logistics.cloud.data.commons.Helper;
import com.jd.logistics.cloud.data.commons.ShowType;
import com.jd.logistics.cloud.data.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public Map getFuncCharts(String funcId) {
        Map<String, String> sqlList = Helper.getFuncSqlByType(funcId, ShowType.CHART);
        Map res = new HashMap<>();
        for (Map.Entry<String, String> e : sqlList.entrySet()) {
            String sql = e.getValue();
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            res.put(e.getKey(), Helper.RowSet2ArrayRes(rowSet));
        }
        return res;
    }

    @Override
    public Map getFuncChartByDateCycle(String funcId, String dateCycle) {
        Map<String, String> sqlList = Helper.getFuncSqlByType(funcId, ShowType.CHART);
        String sql = sqlList.get(dateCycle);
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        return Helper.RowSet2ArrayRes(rowSet);
    }

    @Override
    public String getFuncChartOptionByDateCycle(String funcId, String dateCycle) {
        return Helper.getStringFromResourcePath(Constants.TEMPLATE_PARENT_FOLDER + "/" +
                funcId + "/" + dateCycle + Constants.CHART_OPTION_SUFFIX);
    }
}

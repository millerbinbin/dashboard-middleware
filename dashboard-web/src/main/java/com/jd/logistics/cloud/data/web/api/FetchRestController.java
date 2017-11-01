package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.domain.CommonRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/2 10:38
 */
@RestController
public class FetchRestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/api/charts/{chart}", produces = {"application/json"}, method = RequestMethod.GET)
    public Map getChart(@PathVariable("chart") String chart) throws IOException {
        String sql = "select stat_date, cast(max(func_value)as signed) as func_value " +
                "from T_RESULT where func_name='接收订单量' and warehouse_name='全部仓库' and date_cycle='日维度' " +
                "group by stat_date order by stat_date";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        SqlRowSetMetaData metaData = rowSet.getMetaData();
        String[] colNames = metaData.getColumnNames();
        CommonRes cr = new CommonRes();
        while (rowSet.next()) {
            for (String col : colNames) {
                String c = col.toLowerCase();
                cr.addItem(c, rowSet.getObject(col));
            }
        }
        Map res = new HashMap<>();
        res.put(chart, cr);
        return res;
    }
}

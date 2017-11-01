package com.jd.logistics.cloud.data.service;

import com.alibaba.fastjson.JSON;
import com.jd.logistics.cloud.data.domain.BaseModel;
import com.jd.logistics.cloud.data.domain.ChartModel;
import com.jd.logistics.cloud.data.domain.CommonRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    private Map<String, String> getChartSql(String funcName) {
        String json = StringUtils.getStringFromResourcePath(Constant.TEMPLATE_PARENT_FOLDER + "/" +
                funcName + "/" + Constant.TEMPLATE_MODEL_FILE);
        BaseModel bm = JSON.parseObject(json, BaseModel.class);
        System.out.println(bm.getName());
        Map<String, String> sqlList = new HashMap<>();
        for (ChartModel model : bm.getCharts()) {
            sqlList.put(model.getName(), StringUtils.getStringFromResourcePath(Constant.TEMPLATE_PARENT_FOLDER + "/" +
                    funcName + "/" + model.getSql()));
        }
        return sqlList;
    }

    private Map<String, List<Object>> RowSet2ArrayRes(SqlRowSet rowSet) {
        SqlRowSetMetaData metaData = rowSet.getMetaData();
        String[] colNames = metaData.getColumnNames();
        CommonRes cr = new CommonRes();
        while (rowSet.next()) {
            for (String col : colNames) {
                String c = col.toLowerCase();
                cr.addItem(c, rowSet.getObject(col));
            }
        }
        return cr.getArrayResult();
    }

    @Override
    public Map getFuncChart(String funcName) {
        Map<String, String> sqlList = getChartSql(funcName);
        Map res = new HashMap<>();
        for (Map.Entry<String, String> e : sqlList.entrySet()) {
            String sql = e.getValue();
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            res.put(e.getKey(), RowSet2ArrayRes(rowSet));
        }
        return res;
    }

    @Override
    public String getFuncChartOption(String funcName, String chartId) {
        return StringUtils.getStringFromResourcePath(Constant.TEMPLATE_PARENT_FOLDER + "/" +
                funcName + "/" + chartId + Constant.CHART_OPTION_SUFFIX);
    }
}

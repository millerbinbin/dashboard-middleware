package com.jd.logistics.cloud.data.service;

import com.alibaba.fastjson.JSON;
import com.jd.logistics.cloud.data.domain.BaseModel;
import com.jd.logistics.cloud.data.domain.CommonRes;
import com.jd.logistics.cloud.data.domain.ValueModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
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

    private Map<String, String> getValueSql(String funcName) {
        String json = StringUtils.getStringFromResourcePath(Constant.TEMPLATE_PARENT_FOLDER + "/" +
                funcName + "/" + Constant.TEMPLATE_MODEL_FILE);
        BaseModel bm = JSON.parseObject(json, BaseModel.class);
        System.out.println(bm.getName());
        Map<String, String> sqlList = new HashMap<>();
        for (ValueModel model : bm.getValues()) {
            sqlList.put(model.getName(), StringUtils.getStringFromResourcePath(Constant.TEMPLATE_PARENT_FOLDER + "/" +
                    funcName + "/" + model.getSql()));
        }
        return sqlList;
    }

    private Map<String, Object> RowSet2SingleRes(SqlRowSet rowSet) {
        SqlRowSetMetaData metaData = rowSet.getMetaData();
        String[] colNames = metaData.getColumnNames();
        CommonRes cr = new CommonRes();
        rowSet.next();
        for (String col : colNames) {
            String c = col.toLowerCase();
            cr.putItem(c, rowSet.getObject(col));
        }
        return cr.getSingleResult();
    }

    @Override
    public Map getFuncValues(String funcName) {
        Map<String, String> sqlList = getValueSql(funcName);
        Map res = new HashMap<>();
        for (Map.Entry<String, String> e : sqlList.entrySet()) {
            String sql = e.getValue();
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            res.put(e.getKey(), RowSet2SingleRes(rowSet));
        }
        return res;
    }
}

package com.jd.logistics.cloud.data.commons;

import com.alibaba.fastjson.JSON;
import com.google.common.io.Resources;
import com.jd.logistics.cloud.data.domain.BaseModel;
import com.jd.logistics.cloud.data.domain.ChartModel;
import com.jd.logistics.cloud.data.domain.CommonRes;
import com.jd.logistics.cloud.data.domain.ValueModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:28
 */
public class Helper {
    @NotNull
    public static String InputStream2String(InputStream in) {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        try {
            for (int n; (n = in.read(b)) != -1; ) {
                out.append(new String(b, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    @NotNull
    public static String getStringFromResourcePath(String filePath) {
        InputStream in = null;
        try {
            in = Resources.getResource(filePath).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Helper.InputStream2String(in);
    }

    public static Map<String, String> getFuncSqlByType(String funcName, ShowType type) {
        String json = Helper.getStringFromResourcePath(Constants.TEMPLATE_PARENT_FOLDER + "/" +
                funcName + "/" + Constants.TEMPLATE_MODEL_FILE);
        BaseModel bm = JSON.parseObject(json, BaseModel.class);
        Map<String, String> sqlList = new HashMap<>();
        if (type == ShowType.CHART) {
            for (ChartModel model : bm.getCharts()) {
                sqlList.put(model.getName(), Helper.getStringFromResourcePath(Constants.TEMPLATE_PARENT_FOLDER + "/" +
                        funcName + "/" + model.getSql()));
            }
        } else if (type == ShowType.VALUE) {
            for (ValueModel model : bm.getValues()) {
                sqlList.put(model.getName(), Helper.getStringFromResourcePath(Constants.TEMPLATE_PARENT_FOLDER + "/" +
                        funcName + "/" + model.getSql()));
            }
        }
        return sqlList;
    }

    public static Map<String, List<Object>> RowSet2ArrayRes(SqlRowSet rowSet) {
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


    public static Map<String, Object> RowSet2SingleRes(SqlRowSet rowSet) {
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
}

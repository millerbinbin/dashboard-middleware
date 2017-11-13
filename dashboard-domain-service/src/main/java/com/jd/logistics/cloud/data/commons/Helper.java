package com.jd.logistics.cloud.data.commons;

import com.alibaba.fastjson.JSON;
import com.google.common.io.Resources;
import com.jd.logistics.cloud.data.domain.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
        return InputStream2String(in);
    }

    public static BaseModel getBaseModel(String metricId) {
        String json = getStringFromResourcePath(Constants.CONFIG_PARENT_FOLDER + "/" +
                metricId + "/" + Constants.CONFIG_MODEL_FILE);
        BaseModel bm = JSON.parseObject(json, BaseModel.class);
        return bm;
    }

    public static Map<String, String> getDesc(String metricId) {
        BaseModel model = getBaseModel(metricId);
        Map<String, String> defList = new HashMap<>();
        for (Def def : model.getDef()) {
            defList.put(def.getName(), def.getText());
        }
        return defList;
    }

    public static List<ChartModel> getChartModels(String metricId) {
        BaseModel model = getBaseModel(metricId);
        return model.getCharts();
    }

    @Nullable
    public static ChartModel getChartModelByDateCycle(String metricId, String dateCycle) {
        BaseModel model = getBaseModel(metricId);
        for (ChartModel m : model.getCharts()) {
            if (m.getName().equals(dateCycle))
                return m;
        }
        return null;
    }

    public static List<ValueModel> getValueModels(String metricId) {
        BaseModel model = getBaseModel(metricId);
        return model.getValues();
    }

    @Nullable
    public static ValueModel getValueModelByDateCycle(String metricId, String dateCycle) {
        BaseModel model = getBaseModel(metricId);
        for (ValueModel m : model.getValues()) {
            if (m.getName().equals(dateCycle))
                return m;
        }
        return null;
    }

    @NotNull
    public static String getMetricChartSql(String metricId, String dateCycle) {
        ChartModel model = getChartModelByDateCycle(metricId, dateCycle);
        return getStringFromResourcePath(Constants.CONFIG_PARENT_FOLDER + "/" +
                metricId + "/" + model.getSql());
    }

    @NotNull
    public static String getMetricValueSql(String metricId, String dateCycle) {
        ValueModel model = getValueModelByDateCycle(metricId, dateCycle);
        return getStringFromResourcePath(Constants.CONFIG_PARENT_FOLDER + "/" +
                metricId + "/" + model.getSql());
    }

    public static String getMetricChartOption(String metricId, String dateCycle) {
        return getStringFromResourcePath(Constants.CONFIG_PARENT_FOLDER + "/" +
                metricId + "/" + dateCycle + Constants.CHART_OPTION_SUFFIX);
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

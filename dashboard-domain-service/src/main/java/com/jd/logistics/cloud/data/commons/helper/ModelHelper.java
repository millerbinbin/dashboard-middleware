package com.jd.logistics.cloud.data.commons.helper;

import com.alibaba.fastjson.JSON;
import com.google.common.io.Resources;
import com.jd.logistics.cloud.data.commons.Constants;
import com.jd.logistics.cloud.data.domain.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:28
 */
public class ModelHelper {
    private static ConcurrentHashMap<String, String> resourceContent = new ConcurrentHashMap<>();

    @NotNull
    private static String InputStream2String(InputStream in) {
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
    private static String getStringFromResourcePath(String filePath) {
        InputStream in = null;
        try {
            in = Resources.getResource(filePath).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return InputStream2String(in);
    }

    @Nullable
    private static String getContentFromCache (String key) {
        if (resourceContent.get(key) != null) {
            return resourceContent.get(key).toString();
        }
        return null;
    }

    private static void saveContentToCache (String key, String content) {
        resourceContent.put(key, content);
    }

    public static BaseModel getBaseModel(String metricId) {
        String content;
        String key = "BaseModel" + metricId;
        if (getContentFromCache(key) == null){
            content = getStringFromResourcePath(Constants.CONFIG_PARENT_FOLDER + "/" +
                    metricId + "/" + Constants.CONFIG_MODEL_FILE);
            saveContentToCache(key, content);
        } else {
            content = getContentFromCache(key).toString();
        }
        BaseModel bm = JSON.parseObject(content, BaseModel.class);
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

    public static List<GridModel> getGridModels(String metricId) {
        BaseModel model = getBaseModel(metricId);
        return model.getGrids();
    }

    @Nullable
    public static GridModel getGridModelByDateCycle(String metricId, String dateCycle) {
        BaseModel model = getBaseModel(metricId);
        for (GridModel m : model.getGrids()) {
            if (m.getName().equals(dateCycle))
                return m;
        }
        return null;
    }

    @NotNull
    public static String getMetricChartSql(String metricId, String dateCycle) {
        ChartModel model = getChartModelByDateCycle(metricId, dateCycle);
        String key = "MetricChartSql" + metricId + dateCycle;
        String content;
        if (getContentFromCache(key) == null) {
            content = getStringFromResourcePath(Constants.CONFIG_PARENT_FOLDER + "/" +
                    metricId + "/" + model.getSql());
            saveContentToCache(key, content);
        } else {
            content = getContentFromCache(key).toString();
        }
        return content;
    }

    @NotNull
    public static String getMetricValueSql(String metricId, String dateCycle) {
        ValueModel model = getValueModelByDateCycle(metricId, dateCycle);
        return getStringFromResourcePath(Constants.CONFIG_PARENT_FOLDER + "/" +
                metricId + "/" + model.getSql());
    }

    @NotNull
    public static String getMetricGridSql(String metricId, String dateCycle) {
        GridModel model = getGridModelByDateCycle(metricId, dateCycle);
        return getStringFromResourcePath(Constants.CONFIG_PARENT_FOLDER + "/" +
                metricId + "/" + model.getSql());
    }

    public static String getMetricChartOption(String metricId, String dateCycle) {
        return getStringFromResourcePath(Constants.CONFIG_PARENT_FOLDER + "/" +
                metricId + "/" + dateCycle + Constants.CHART_OPTION_SUFFIX);
    }
}

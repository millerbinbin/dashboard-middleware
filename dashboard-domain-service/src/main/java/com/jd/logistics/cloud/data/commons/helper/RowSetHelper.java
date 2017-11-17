package com.jd.logistics.cloud.data.commons.helper;

import com.jd.logistics.cloud.data.domain.CommonRes;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/17 9:57
 */
public class RowSetHelper {
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

    public static Map<String, List<Object>> RowSet2HeaderAndRes(SqlRowSet rowSet) {
        SqlRowSetMetaData metaData = rowSet.getMetaData();
        String[] colNames = metaData.getColumnNames();
        Map resMap = new HashMap();
        List<String> headers = new ArrayList<>();
        for (int i = 1; i <= colNames.length; i++) {
            headers.add("c" + i + "," + metaData.getColumnLabel(i));
        }
        resMap.put("headers", headers);

        List<Map<String, Object>> itemList = new ArrayList<>();
        while (rowSet.next()) {
            Map<String, Object> tmp = new HashMap<>();
            for (int i = 1; i <= colNames.length; i++) {
                tmp.put("c" + i, rowSet.getObject(i));
            }
            itemList.add(tmp);
        }
        resMap.put("items", itemList);

        return resMap;
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

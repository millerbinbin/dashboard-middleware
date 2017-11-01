package com.jd.logistics.cloud.data.service;

import com.google.common.io.Resources;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/11/7 9:28
 */
public class StringUtils {
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

    public static String getStringFromResourcePath(String filePath) {
        InputStream in = null;
        try {
            in = Resources.getResource(filePath).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.InputStream2String(in);
    }
}

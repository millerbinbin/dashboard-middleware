package com.jd.logistics.cloud.data.dashboard.service.service;

import com.jd.logistics.cloud.data.dashboard.service.domain.Stat;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by GIN on 2017/10/28.
 */
public class GenStatService {
    private final static int rec_num = 32;
    private final static Random r = new Random(rec_num);
    public static List<Stat> statList = new ArrayList<>();

    static {
        gen(rec_num);
    }

    private static void gen(int num) {
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        for (int i = 0; i < num; i++) {
            date.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
            String tmp_date = new SimpleDateFormat("YYYY-MM-dd").format(date.getTime());
            statList.add(new Stat(tmp_date, r.nextInt(20), 20 + r.nextInt(50), 50 + r.nextInt(100), 100 + r.nextInt(200)));
        }
    }

    public static List<Stat> getStatList(int limit, int offset) {
        List<Stat> tmpList = new ArrayList<>();
        for (int i = offset; i < offset + limit; i++) {
            if (i > count - 1) break;
            tmpList.add(statList.get(i));
        }
        return tmpList;
    }

    public static int count = statList.size();
}

package com.jd.logistics.cloud.data.service;

import com.jd.logistics.cloud.data.domain.Function;
import com.jd.logistics.cloud.data.domain.Stat;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/24 8:51
 */
public class GenStatService {
    private final static int rec_num = 32;
    private final static Random r = new Random(rec_num);
    public static List<Stat> statList = new ArrayList<>();
    public static List<Function> functionList = new ArrayList<>();
    static {
        gen(rec_num);
    }
    private static void gen(int num){
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        String[] functions = {"接收订单量",
                "Sku准确率",
                "调拨入库单数",
                "发出订单量",
                "在库Sku",
                "人效-DO",
                "成本效率","测试1","测试2"};
        for (int i = 0; i < num; i++) {
            date.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
            String tmp_date = new SimpleDateFormat("YYYY-MM-dd").format(date.getTime());
            statList.add(new Stat(tmp_date, r.nextInt(20), 20+r.nextInt(50), 50+r.nextInt(100), 100+r.nextInt(200)));
        }
        for(String function : functions) {
            int index = r.nextInt(3);
            functionList.add(new Function(function, Function.FuncType.getFuncType(index)));
        }
    }

    public static List<Stat> getStatList(int limit, int offset){
        List<Stat> tmpList = new ArrayList<>();
        for (int i = offset; i < offset + limit; i++) {
            if (i > count - 1) break;
            tmpList.add(statList.get(i));
        }
        return tmpList;
    }

    public static List<Function> getFunctionList(){
        return functionList;
    }

    public static int count = statList.size();
}

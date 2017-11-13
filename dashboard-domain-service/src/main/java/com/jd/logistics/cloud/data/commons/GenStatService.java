package com.jd.logistics.cloud.data.commons;

import com.jd.logistics.cloud.data.domain.Metric;

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
    public static List<Metric> functionList = new ArrayList<>();

    static {
        // gen(rec_num);
    }

    private static void gen(int num) {
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());
        String[] functions = {
                "接收订单量",
                "Sku准确率",
                "调拨入库单数",
                "发出订单量",
                "在库Sku",
                "人效-DO",
                "成本效率"
        };
        String[] warehouses = {
                "全部仓库",
                "上海1仓",
                "上海2仓",
                "上海3仓"
        };
        Map<String, String[]> dateCycleIndexMap = new HashMap<>();
        dateCycleIndexMap.put("日维度", new String[]{"昨日全天", "上周同日", "日环比", "周同比"});
        dateCycleIndexMap.put("周维度", new String[]{"整周数据", "去年同周", "周环比", "年同比"});
        dateCycleIndexMap.put("月维度", new String[]{"整月数据", "去年同月", "月环比", "年同比"});
//        for (int i = 0; i < num; i++) {
//            date.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
//            String tmp_date = new SimpleDateFormat("YYYY-MM-dd").format(date.getTime());
//            statList.add(new Stat(tmp_date, r.nextInt(20), 20+r.nextInt(50), 50+r.nextInt(100), 100+r.nextInt(200)));
//        }
        for (int i = 0; i < 20; i++) {
            date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
            String tmp_date = new SimpleDateFormat("YYYY/MM/dd").format(date.getTime());
            for (String function : functions) {
                for (String warehouse : warehouses) {
                    for (Map.Entry<String, String[]> item : dateCycleIndexMap.entrySet()) {
                        int idx = 0;
                        double funcValue;
                        if (function.equalsIgnoreCase("Sku准确率") ||
                                function.equalsIgnoreCase("人效-DO") ||
                                function.equalsIgnoreCase("成本效率"))
                            funcValue = (double) ((int) ((r.nextDouble() + 1) * 50)) / 100;
                        else
                            funcValue = 20000 + r.nextInt(3000) - 1500;
                        for (String index : item.getValue()) {
                            double indexValue;
                            if (idx <= 1) indexValue = funcValue * (r.nextDouble() + 0.45);
                            else indexValue = (double) ((int) ((r.nextDouble() - 0.25) * 1000)) / 100;
                            System.out.println(function + ',' + warehouse + ',' + item.getKey() + ',' + tmp_date + ',' + funcValue + ',' + index + ',' + indexValue);
                            idx++;
                        }
                    }
                }
            }
        }


    }


    public static List<Metric> getFunctionList() {
        return functionList;
    }


    public static void main(String[] args) {
        GenStatService gs = new GenStatService();
    }
}

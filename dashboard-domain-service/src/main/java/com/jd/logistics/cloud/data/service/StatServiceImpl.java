package com.jd.logistics.cloud.data.service;



import com.jd.logistics.cloud.data.commons.page.Page;
import com.jd.logistics.cloud.data.commons.page.PageRequest;
import com.jd.logistics.cloud.data.domain.*;
import com.jd.logistics.cloud.data.repository.UserRepository;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/23 14:47
 */
@Service
public class StatServiceImpl implements StatService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Page<Stat> findStats(StatQuery query, PageRequest pageRequest) {
        List<Stat> statList = GenStatService.getStatList(pageRequest.getPageSize(), (int) pageRequest.getOffset());
        Page<Stat> statPage =  new Page<>();
        statPage.setPage(pageRequest.getPage());
        statPage.setSize(pageRequest.getPageSize());
        statPage.setTotalElements(GenStatService.count);
        statPage.setContent(statList);
        return statPage;
    }

    @Override
    public List<Col> getCols() {
        List<Col> cols = new ArrayList<>();
        for(Field f : Stat.class.getDeclaredFields()){
            if (null != f.getAnnotation(ApiModelProperty.class)){
                cols.add(new Col(f.getName().toLowerCase(),f.getAnnotation(ApiModelProperty.class).name()));
            }
        };
        return cols;
    }

    @Override
    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        for(Field f : Stat.class.getDeclaredFields()){
            if (null != f.getAnnotation(ApiModelProperty.class) && f.getAnnotation(ApiModelProperty.class).value().equals("")){
                categories.add(f.getAnnotation(ApiModelProperty.class).name());
            }
        };
        return categories;
    }

    @Override
    public double[] getRow(String date) {
        double[] d = new double[4];
        for (int i = 0; i < GenStatService.statList.size(); i++) {
            Stat tmp = GenStatService.statList.get(i);
            if (date.equalsIgnoreCase(tmp.getD1())){
                d[0] = tmp.getC1();
                d[1] = tmp.getC2();
                d[2] = tmp.getC3();
                d[3] = tmp.getC4();
                return d;
            }
        }
        return null;
    }

    @Override
    public List<String> getPeriods() {
        List<String> tmp = new ArrayList();
        for (int i = 0; i < GenStatService.statList.size(); i++) {
            Stat s = GenStatService.statList.get(i);
            tmp.add(s.getD1());
        }
        return tmp;
    }

    @Override
    public List<Double> getColumn(String c1) {
        List<Double> tmp = new ArrayList();
        for (int i = 0; i < GenStatService.statList.size(); i++) {
            Stat s = GenStatService.statList.get(i);
            if ("1".equalsIgnoreCase(c1)) tmp.add(s.getC1());
            else if ("2".equalsIgnoreCase(c1)) tmp.add(s.getC2());
            else if ("3".equalsIgnoreCase(c1)) tmp.add(s.getC3());
            else if ("4".equalsIgnoreCase(c1)) tmp.add(s.getC4());
        }
        return tmp;
    }

    @Override
    public List<List<Double>> getColumns() {
        List<List<Double>> tmp = new ArrayList();
        List<Double> t1 = new ArrayList();
        List<Double> t2 = new ArrayList();
        List<Double> t3 = new ArrayList();
        List<Double> t4 = new ArrayList();
        for (int i = 0; i < GenStatService.statList.size(); i++) {
            Stat s = GenStatService.statList.get(i);
            t1.add(s.getC1());
            t2.add(s.getC2());
            t3.add(s.getC3());
            t4.add(s.getC4());
        }
        tmp.add(t1);
        tmp.add(t2);
        tmp.add(t3);
        tmp.add(t4);
        return tmp;
    }

    @Override
    public User getUser(long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<BoxRes> getBoxes() {
        List<BoxRes> tmp = new ArrayList<>();
        BoxRes b1 = new BoxRes("接收订单量", "519,245", "日环比", 3.2, "周环比", 7.1);
        BoxRes b2 = new BoxRes("SKU准确率", "58.21%", "日环比", 1.9, "周环比", -1.2);
        BoxRes b3 = new BoxRes("调拨入库单数", "2,245", "日环比", 0.0, "周环比", 10.1);
        tmp.add(b1);tmp.add(b2);tmp.add(b3);
        return tmp;
    }

    @Override
    public List<ChartRes> getCharts() {
        List<ChartRes> tmp = new ArrayList<>();
        ChartRes b1 = new ChartRes("人效-DO", "5234", "日环比", 8.2, "周环比", 17.1, "2017/10/11", "2017/11/11");
        b1.setPeriods(getPeriods());
        b1.setC1Value(getColumn("1"));
        b1.setC2Value(getColumn("2"));
        ChartRes b2 = new ChartRes("出库单数", "4,245", "日环比", 6.2, "周环比", -1.1,"2017/10/11","2017/11/11");
        b2.setPeriods(getPeriods());
        b2.setC1Value(getColumn("3"));
        b2.setC2Value(getColumn("4"));
        tmp.add(b1);tmp.add(b2);
        return tmp;
    }

    public static void main(String[] args) {
        StatServiceImpl ss = new StatServiceImpl();
        System.out.println(ss.getPeriods());
        System.out.println(ss.getCharts().get(0));
        //System.out.println(GenStatService.statList);
    }
}

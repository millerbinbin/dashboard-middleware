package com.jd.logistics.cloud.data.dashboard.service.service;

import com.jd.logistics.cloud.data.dashboard.commons.page.Page;
import com.jd.logistics.cloud.data.dashboard.commons.page.PageRequest;
import com.jd.logistics.cloud.data.dashboard.service.domain.Col;
import com.jd.logistics.cloud.data.dashboard.service.domain.Stat;
import com.jd.logistics.cloud.data.dashboard.service.domain.StatQuery;
import com.jd.logistics.cloud.data.dashboard.service.domain.User;
import com.jd.logistics.cloud.data.dashboard.service.repository.UserRepository;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GIN on 2017/10/28.
 */
@Service
public class StatServiceImpl implements StatService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Page<Stat> findStats(StatQuery query, PageRequest pageRequest) {
        List<Stat> statList = GenStatService.getStatList(pageRequest.getPageSize(), (int) pageRequest.getOffset());
        Page<Stat> statPage = new Page<>();
        statPage.setPage(pageRequest.getPage());
        statPage.setSize(pageRequest.getPageSize());
        statPage.setTotalElements(GenStatService.count);
        statPage.setContent(statList);
        return statPage;
    }

    @Override
    public List<Col> getCols() {
        List<Col> cols = new ArrayList<>();
        for (Field f : Stat.class.getDeclaredFields()) {
            if (null != f.getAnnotation(ApiModelProperty.class)) {
                cols.add(new Col(f.getName().toLowerCase(), f.getAnnotation(ApiModelProperty.class).name()));
            }
        }
        ;
        return cols;
    }

    @Override
    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        for (Field f : Stat.class.getDeclaredFields()) {
            if (null != f.getAnnotation(ApiModelProperty.class) && f.getAnnotation(ApiModelProperty.class).value().equals("")) {
                categories.add(f.getAnnotation(ApiModelProperty.class).name());
            }
        }
        ;
        return categories;
    }

    @Override
    public double[] getRow(String date) {
        double[] d = new double[4];
        for (int i = 0; i < GenStatService.statList.size(); i++) {
            Stat tmp = GenStatService.statList.get(i);
            if (date.equalsIgnoreCase(tmp.getD1())) {
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
        return null;
    }

//    public static void main(String[] args) {
//        StatServiceImpl ss = new StatServiceImpl();
//        System.out.println(ss.getPeriods());
//        System.out.println(ss.getColumn("c1"));
//        System.out.println(ss.getColumns());
//        System.out.println(GenStatService.statList);
//    }
}

package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.commons.page.Page;
import com.jd.logistics.cloud.data.commons.page.PageRequest;
import com.jd.logistics.cloud.data.commons.validation.Errors;
import com.jd.logistics.cloud.data.domain.*;
import com.jd.logistics.cloud.data.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/23 15:08
 */
@RestController
public class StatRestController implements StatApi {
    @Autowired
    StatService statService;
    @Override
    public Page<Stat> list(@ModelAttribute StatQuery query, @ModelAttribute PageRequest pageRequest) {
        return statService.findStats(query, pageRequest);
    }

    @Override
    public List<Col> cols() {
        return statService.getCols();
    }

    @Override
    public List<String> categories() {
        return statService.getCategories();
    }

    @Override
    public double[] row(@PathVariable("date") String date) {
        return statService.getRow(date);
    }

    @Override
    public List<String> periods() {
        return statService.getPeriods();
    }

    @Override
    public List<Double> c(@PathVariable("c") String c) {
        return statService.getColumn(c);
    }

    @Override
    public List<List<Double>> cAll() {
        return statService.getColumns();
    }

    @Override
    public ResponseEntity<?> login(@RequestBody User user) {
        Errors.Builder errorsBuilder = new Errors.Builder();
        if(!"admin".equalsIgnoreCase(user.getUsername())) {
            errorsBuilder.addFieldError("username", "用户名不存在！");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.OK);
        }
        if(!"admin".equalsIgnoreCase(user.getPassword())) {
            errorsBuilder.addFieldError("password", "密码不正确！");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public User user(@PathVariable("id") long id) {
        return statService.getUser(id);
    }

    @Override
    public List<BoxRes> getBoxes() {
        return statService.getBoxes();
    }

    @Override
    public List<ChartRes> getCharts() {
        return statService.getCharts();
    }

    @Override
    public List<Function> getFunction(@PathVariable("type") String type) {
        return statService.getFunctions(type);
    }

}

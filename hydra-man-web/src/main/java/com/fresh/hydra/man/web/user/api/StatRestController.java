package com.fresh.hydra.man.web.user.api;

import com.fresh.commons.data.page.Page;
import com.fresh.commons.data.page.PageRequest;
import com.fresh.commons.data.validation.Errors;
import com.fresh.hydra.center.biz.user.domain.*;
import com.fresh.hydra.center.biz.user.service.StatService;
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
public class StatRestController implements StatApi{
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
        if(!"admin".equalsIgnoreCase(user.getPassword())) {
            errorsBuilder.addFieldError("password", "密码错误");
            return new ResponseEntity<>(errorsBuilder.build(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
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
    public List<BoxRes> getBoxes() {
        return statService.getBoxes();
    }

    @Override
    public List<ChartRes> getCharts() {
        return statService.getCharts();
    }

    @Override
    public List<GenericRes> getBoxRes (@RequestBody DimQuery query) {
        return statService.getBoxRes(query);
    }

    @Override
    public List<GenericRes> getChartRes(@RequestBody DimQuery query) {
        return statService.getChartRes(query);
    }
}

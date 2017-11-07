package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.commons.page.Page;
import com.jd.logistics.cloud.data.commons.page.PageRequest;
import com.jd.logistics.cloud.data.domain.*;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/12 9:55
 */
@Api(value = "order stats", description = "the order API")
@RequestMapping(value = "/api/stat")
public interface StatApi {
    @RequestMapping(value = "",
            produces = {"application/json"},
            method = RequestMethod.GET)
    Page<Stat> list(@ModelAttribute StatQuery query, @ModelAttribute PageRequest pageRequest);

    @RequestMapping(value = "/cols",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Col> cols();

    @RequestMapping(value = "/categories",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<String> categories();

    @RequestMapping(value = "/date/{date}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    double[] row(@PathVariable("date") String date);

    @RequestMapping(value = "/periods",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<String> periods();

    @RequestMapping(value = "/c/{c}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Double> c(@PathVariable("c") String c);

    @RequestMapping(value = "/c",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<List<Double>> cAll();

    @RequestMapping(value = "/res/box",
            produces = {"application/json"},
            method = RequestMethod.POST)
    List<GenericRes> getBoxRes(@Valid @RequestBody DimQuery query);

    @RequestMapping(value = "/res/chart",
            produces = {"application/json"},
            method = RequestMethod.POST)
    List<GenericRes> getChartRes(@Valid @RequestBody DimQuery query);

}

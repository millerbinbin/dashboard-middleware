package com.jd.logistics.cloud.data.dashboard.web.api;

import com.jd.logistics.cloud.data.dashboard.commons.page.Page;
import com.jd.logistics.cloud.data.dashboard.commons.page.PageRequest;
import com.jd.logistics.cloud.data.dashboard.service.domain.Col;
import com.jd.logistics.cloud.data.dashboard.service.domain.Stat;
import com.jd.logistics.cloud.data.dashboard.service.domain.StatQuery;
import com.jd.logistics.cloud.data.dashboard.service.domain.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/12 9:55
 */
@Api(value = "stats", description = "the stats API")
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

    @RequestMapping(value = "/login",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<?> login(@Valid @RequestBody User user);

    @RequestMapping(value = "/user/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    User user(@PathVariable("id") long id);
}

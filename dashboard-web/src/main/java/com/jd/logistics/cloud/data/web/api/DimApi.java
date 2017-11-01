package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.domain.Dim;
import com.jd.logistics.cloud.data.domain.Function;
import com.jd.logistics.cloud.data.domain.GenericRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 14:41
 */
@RequestMapping(value="/api/dim")
public interface DimApi {

    @RequestMapping(value = "/warehouse",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Dim> getWarehouses();

    @RequestMapping(value = "/datecycle",
            produces = {"application/json"},
            method = RequestMethod.GET)
    List<Dim> getDateCycles();

}

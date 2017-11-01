package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.domain.Function;
import com.jd.logistics.cloud.data.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 10:14
 */
@RequestMapping(value="/api/func")
public interface FuncApi {

    @RequestMapping(value = "/{type}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    List<Function> getFuncByType(@PathVariable("type") int type);

    @RequestMapping(value = "",
            produces = { "application/json" },
            method = RequestMethod.GET)
    List<Function> getFunc();

    @RequestMapping(value = "",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity updateFuncType(@Valid @RequestBody List<Function> functionList);
}

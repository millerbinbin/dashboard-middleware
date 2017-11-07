package com.jd.logistics.cloud.data.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/24 16:51
 */
@ControllerAdvice(basePackages = {"com.fresh.hydra.man.web"})
public class JSONPController extends AbstractJsonpResponseBodyAdvice {
    public JSONPController() {
        super("callback", "jsonp");
    }
}

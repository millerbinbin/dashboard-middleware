package com.jd.logistics.cloud.data.dashboard.web.conf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/23 15:08
 */
@Controller
public class IndexViewController {

    @RequestMapping(value = "/doc")
    public String doc() {
        return "redirect:swagger-ui.html";
    }
}
